package com.dependencyinjection.edudev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dependencyinjection.edudev.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var mainBinding : ActivityMainBinding


    // field injection
    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainBinding.setLifecycleOwner(this)
        mainBinding.maintest?.setOnClickListener {
            mainBinding.maintest.setText("${someClass.doAThing()}\n and \n ${someClass.doSomeOtherThing()}")
        }
        
    }


    class SomeClass
    @Inject
    constructor(val someOtherClass: SomeOtherClass){
        fun doAThing():String{
            var data = "Hi Ms. Laxmi kant pal "
            return "data is $data"
        }

        fun doSomeOtherThing():String{
            return someOtherClass.doSomeOtherThing()
        }

    }

    class SomeOtherClass
    @Inject
    constructor(){
        fun doSomeOtherThing():String{
            return "Another from"
        }
    }

}