package com.dependencyinjection.edudev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.dependencyinjection.edudev.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var mainBinding : ActivityMainBinding


    // field injection
//    @Inject
//    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainBinding.setLifecycleOwner(this)
      /*  mainBinding.maintest?.setOnClickListener {
            mainBinding.maintest.setText("${someClass.doAThing()}\n and \n ${someClass.doSomeOtherThing()}")
        }
        */
    }

    @AndroidEntryPoint
    class MyFragment: Fragment(){

        @Inject
        lateinit var someClass: SomeClass


    }


//    @Singleton// fyn when we inject in activity
    @FragmentScoped // fyn whene we use fragment and dont use in activity
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