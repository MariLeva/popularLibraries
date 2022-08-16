package ru.geekbrains.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import ru.geekbrains.mvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    private val presenter = MainPresenter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnNum1.setOnClickListener {
                presenter.counterClickButton1()
            }
            btnNum2.setOnClickListener {
                presenter.counterClickButton2()
            }
            btnNum3.setOnClickListener {
                presenter.counterClickButton3()
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun setButton1Text(text: String) {
        binding.tvText1.text = text
    }

    override fun setButton2Text(text: String) {
        binding.tvText2.text = text
    }

    override fun setButton3Text(text: String) {
        binding.tvText3.text = text
    }
}