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
                presenter.counterClick(R.id.btnNum1)
            }
            btnNum2.setOnClickListener {
                presenter.counterClick(R.id.btnNum2)
            }
            btnNum3.setOnClickListener {
                presenter.counterClick(R.id.btnNum3)
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun setButtonText(index: Int, text: String) {
        with(binding) {
            when (index) {
                0 -> tvText1.text = text
                1 -> tvText2.text = text
                2 -> tvText3.text = text
            }
        }
    }
}