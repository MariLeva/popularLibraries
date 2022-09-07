package ru.geekbrains.mvp.jpgToPng

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import io.reactivex.rxjava3.core.Single
import kotlinx.parcelize.Parcelize

class FileRepositoryImpl: FileRepository {
    private var fileImage = FileImage("")

    override fun setFile(fileName: String){
        fileImage.fileName = fileName
    }

    override fun getFile(): String {
        return fileImage.fileName
    }
}

@Parcelize
data class FileImage(
    var fileName: String
) : Parcelable

interface FileRepository {
    fun getFile(): String
    fun setFile(fileName: String)
}