package com.firebaseapp.charlieandroidblog.composesnippets.Utils

import androidx.lifecycle.LifecycleOwner

class LCOGetter {

    companion object{
        private lateinit var lifeCycleOwner:LifecycleOwner

        fun init(activity:LifecycleOwner){
            lifeCycleOwner = activity
        }

        fun getLifeCycleOwener()= lifeCycleOwner
    }
}