package ru.geekbrains.mvp.jpgToPng

import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.provider.MediaStore
import androidx.core.net.toUri
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Single
import moxy.MvpPresenter
import ru.geekbrains.mvp.core.nav.UsersScreen
import java.io.File
import java.io.FileOutputStream

class FilePresenter(
    private val repository: FileRepository,
    private val context: Context,
    private val screen: UsersScreen,
    private val router: Router
) : MvpPresenter<FileView>() {

    fun onLoadingFile(name: String) {
        viewState.showLoading()
        repository.setFile(name)
        viewState.loadingFile()
        viewState.hideLoading()
    }

    fun getFile(): String {
        return repository.getFile()
    }

    fun onJpgToPng(bitmap: Bitmap) {
        val file = File.createTempFile("imagePNG", ".png")
        val fos = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.PNG,100,fos)
        MediaStore.Images.Media.insertImage(context.contentResolver, file.path, file.name, file.name)
        fos.close()
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

}