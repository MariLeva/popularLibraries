package ru.geekbrains.mvp.jpgToPng

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

class FileRepositoryImpl: FileRepository {
    private var fileImage = FileImage("","")

    override fun setFile(fileName: String, path: String){
        fileImage.fileName = fileName
        fileImage.path = path
    }

    override fun getFile(): String {
        return fileImage.fileName
    }

    override fun getFilePath(): String {
        return fileImage.path
    }
}

@Parcelize
data class FileImage(
    var fileName: String,
    var path: String
) : Parcelable

interface FileRepository {
    fun getFile(): String
    fun getFilePath(): String
    fun setFile(fileName: String, path: String)
}