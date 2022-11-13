package com.example.counterhw.presenter

import com.example.counterhw.helper.Injector
import com.example.counterhw.view.CounterView

class Presenter {

    private val model = Injector.getModel()
    lateinit var view: CounterView

    fun increment() {
        model.increment()
        view.showNewCount((model.getCount()))
        when {
            model.getCount() == 10 -> {
                view.showToast()
            }
            model.getCount() == 15 -> {
                view.textColor()
            }
            model.getCount() != 15 -> {
                view.standardColor()
            }
        }
    }    fun decrement() {
        model.decrement()
        view.showNewCount(model.getCount())
        when {
            model.getCount() == 10 -> {
                view.showToast()
            }
            model.getCount() == 15 -> {
                view.textColor()
            }
            model.getCount() != 15 -> {
                view.standardColor()
            }
        }

    }
            fun attachView(view: CounterView) {
                this.view = view
            }

        }


