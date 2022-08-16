package ru.geekbrains.mvp

class MainPresenter(private val view: MainView) {

    private val model = CountersModel()

    fun counterClick(id: Int){
        when(id){
            R.id.btnNum1 -> {
                val nextValue = model.next(0)
                view.setButtonText(0, nextValue.toString())
            }
            R.id.btnNum2 -> {
                val nextValue = model.next(1)
                view.setButtonText(1, nextValue.toString())
            }
            R.id.btnNum3 -> {
                val nextValue = model.next(2)
                view.setButtonText(2, nextValue.toString())
            }
        }
    }
}