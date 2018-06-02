package com.github.zhekos.architecturecomponents

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

class DataController private constructor() {
    init {

    }

    private object Holder {
        val INSTANCE: DataController = DataController()
    }

    companion object {
        val instance: DataController by lazy { Holder.INSTANCE }
    }

    private val liveData: MutableLiveData<String> = MutableLiveData()

    fun getData(): LiveData<String> {
        return liveData
    }

    fun setData(str: String) {
        liveData.value = str
    }

}