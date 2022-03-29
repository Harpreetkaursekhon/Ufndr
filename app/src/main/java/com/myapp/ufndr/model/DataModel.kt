package com.myapp.ufndr.model

sealed class DataModel {
    data class NotificationTypeOne(
        val name:String, val message: String,
        val image:Int
    ):DataModel()
    data class NotificationTypeTwo(
        val name:String, val message: String,
        val image:Int
    ):DataModel()
}