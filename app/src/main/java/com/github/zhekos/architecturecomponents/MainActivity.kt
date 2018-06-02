package com.github.zhekos.architecturecomponents

import android.arch.lifecycle.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val mediatorLiveData = MediatorLiveData<String>()

    private val liveData1: MutableLiveData<String> = MutableLiveData()
    private val liveData2: MutableLiveData<String> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediatorLiveDataInit()

    }

    override fun onStart() {
        super.onStart()
        liveData1.value = "1"
        liveData2.value = "a"
        liveData2.value = "finish"
        liveData1.value = "2"
        liveData2.value = "b"
        liveData1.value = "3"
        liveData2.value = "c"
    }

    private fun mediatorLiveDataInit(){
        mediatorLiveData.addSource(liveData1, {
            mediatorLiveData.value = it
        })
        mediatorLiveData.addSource(liveData2, {
            if("finish".equals(it,true)){
                mediatorLiveData.removeSource(liveData2)
                return@addSource
            }
            mediatorLiveData.value = it
        })

        mediatorLiveData.observe(this, Observer {
            Log.d("onChanged", it)
        })
    }
}
