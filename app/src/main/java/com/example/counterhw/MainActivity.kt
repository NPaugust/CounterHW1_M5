package com.example.counterhw

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.example.counterhw.databinding.ActivityMainBinding
import com.example.counterhw.helper.Injector
import com.example.counterhw.presenter.Presenter
import com.example.counterhw.view.CounterView
import com.google.android.material.internal.ContextUtils.getActivity

class MainActivity : AppCompatActivity(), CounterView {



    lateinit var binding: ActivityMainBinding
    private val presenter = Injector.getPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClickears()
    }

    private fun initClickears() {
        with(binding) {
            incrementBtn.setOnClickListener {
                presenter.increment()

                    decrementBtn.setOnClickListener {
                        presenter.decrement()
                    }

            }
        }




    }

    override fun showNewCount(count: Int) {
        binding.resultTv.text = count.toString()

    }

    override fun showToast() {
        Toast.makeText(this,"Поздравляю",Toast.LENGTH_LONG).show()
    }

}