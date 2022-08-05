package com.mega.kotlinapp.postAPIKotlin.mvvvm.viewModel

import com.mega.kotlinapp.postAPIKotlin.mvvvm.model.ObservableModel

class GeneratingData {
    companion object {
        fun createTasksList(): List<ObservableModel>? {
            val tasks: MutableList<ObservableModel> = ArrayList()
            tasks.add(ObservableModel("Take out the trash", true, 3))
            tasks.add(ObservableModel("Walk the dog", false, 2))
            tasks.add(ObservableModel("Make my bed", true, 1))
            tasks.add(ObservableModel("Unload the dishwasher", false, 0))
            tasks.add(ObservableModel("Make dinner", true, 5))
            return tasks
        }
    }
}