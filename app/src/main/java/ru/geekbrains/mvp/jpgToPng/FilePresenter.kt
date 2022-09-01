package ru.geekbrains.mvp.jpgToPng

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.core.net.toUri
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.mvp.core.nav.UsersScreen
import java.io.File
import java.io.FileOutputStream

class FilePresenter(
    private val repository: FileRepository,
    private val screen: UsersScreen,
    private val router: Router
) : MvpPresenter<FileView>() {

    fun onLoadingFile(name: String, path: String) {
        viewState.showLoading()
        repository.setFile(name, path)
        viewState.loadingFile()
        viewState.hideLoading()
    }

    fun getFile(): String {
        return repository.getFile()
    }

    fun onJpgToPng(bitmap: Bitmap) {

    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

}