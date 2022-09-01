package ru.geekbrains.mvp.jpgToPng

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toBitmap
import androidx.core.net.toUri
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.mvp.GeekBrainsApp
import ru.geekbrains.mvp.core.BackPressedListener
import ru.geekbrains.mvp.core.nav.UsersScreen
import ru.geekbrains.mvp.databinding.FragmentFileBinding


class FileFragment : MvpAppCompatFragment(), FileView, BackPressedListener {

    private lateinit var viewBinding: FragmentFileBinding

    private val presenter by moxyPresenter {
        FilePresenter(FileRepositoryImpl(), UsersScreen(), GeekBrainsApp.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentFileBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.buttonOpenFile.setOnClickListener {
            var intentImage = Intent(Intent.ACTION_GET_CONTENT)
            intentImage.type = "image/*"
            startActivityForResult(intentImage, 1)
        }
        viewBinding.buttonToPng.setOnClickListener {}
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.onLoadingFile(data?.data.toString(), data?.data?.path.toString())

        viewBinding.textName.text = data?.data?.path
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FileFragment()
    }

    override fun loadingFile() {
        presenter.getFile().apply {
            viewBinding.imageView.setImageURI(this.toUri())
        }
    }

    override fun showLoading() {
        viewBinding.loadingLayout.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        viewBinding.loadingLayout.visibility = View.GONE
    }

    override fun onBackPressed() =
        presenter.onBackPressed()
}