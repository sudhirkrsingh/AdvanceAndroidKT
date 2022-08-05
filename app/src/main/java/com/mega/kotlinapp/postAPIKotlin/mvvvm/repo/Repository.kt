package com.mega.kotlinapp.postAPIKotlin.mvvvm.repo

import com.mega.kotlinapp.postAPIKotlin.mvvvm.network.GetCards

class Repository(private val cards: GetCards) {
    fun getAllCards() = cards.getData()
}