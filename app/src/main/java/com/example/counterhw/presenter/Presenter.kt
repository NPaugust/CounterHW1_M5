package com.example.counterhw.presenter

import com.example.counterhw.helper.Injector
import com.example.counterhw.model.CounterModel
import com.example.counterhw.view.CounterView

class Presenter {

     private val model = Injector.getModel()
     lateinit var view: CounterView

    fun increment(){
        model.increment()
        view.showNewCount((model.count))
        view.showToast()
    }
    fun decrement(){
        model.decrement()
        view.showNewCount((model.count))
        view.showToast()

    }


    fun attachView(view:CounterView){
        this.view = view
    }

}