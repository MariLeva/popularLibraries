package ru.geekbrains.mvp

class CountersModel {
    private val counters = mutableListOf(0, 0, 0)

    fun getCurrent(index: Int): Int {
        return counters[index]
    }

    fun next(index: Int): Int{
        val newIndex = counters[index]++
        return newIndex
    }

    fun set(index: Int, value: Int){
        counters[index] = value
    }
}