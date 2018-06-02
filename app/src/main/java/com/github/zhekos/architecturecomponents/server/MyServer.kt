package com.github.zhekos.architecturecomponents.server

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent

class MyServer : LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun connect(){
        //...
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun disconnect(){
        //...
    }

}