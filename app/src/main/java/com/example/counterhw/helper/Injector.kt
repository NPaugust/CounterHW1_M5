package com.example.counterhw.helper

import com.example.counterhw.model.CounterModel
import com.example.counterhw.presenter.Presenter

class Injector {
    companion object {
        fun getModel() : CounterModel {
            return CounterModel()

        }
        fun getPresenter(): Presenter{
            return Presenter()

        }
    }
}