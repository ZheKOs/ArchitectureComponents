package com.github.zhekos.architecturecomponents

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val liveData: LiveData<String> = DataController.instance.getData()

        liveData.observe(this, Observer<String>{
            textview.text = it
        })
        DataController.instance.setData("First String")

    }
}
