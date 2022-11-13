package com.example.counterhw

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.counterhw.databinding.ActivityMainBinding
import com.example.counterhw.helper.Injector

import com.example.counterhw.presenter.Presenter
import com.example.counterhw.view.CounterView

class MainActivity : AppCompatActivity(),CounterView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = Injector.getPresenter()
        presenter.attachView(this)
        initClickers()
    }

    private fun initClickers() {
        with(binding){
            incrementBtn.setOnClickListener {
                presenter.increment()
            }
            decrementBtn.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun showNewCount(count: Int) {
        binding.resultTv.text = count.toString()
    }

    override fun showToast() {
        this.showToast("Поздравляю!")
    }


    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    override fun standardColor() {
        binding.resultTv.setTextColor(getColor(R.color.black))
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    override fun textColor() {
        binding.resultTv.setTextColor(getColor(R.color.green))
    }
}