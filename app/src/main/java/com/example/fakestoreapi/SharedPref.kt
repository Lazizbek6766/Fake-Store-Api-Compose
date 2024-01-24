package com.example.fakestoreapi

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPref @Inject constructor(@ApplicationContext context: Context){

    private var mySharedPref: SharedPreferences =
        context.getSharedPreferences("filename", Context.MODE_PRIVATE)

    var token: String
        get() = mySharedPref.getString("token", "")!!
        set(value) {
            mySharedPref.edit().putString("token", value).apply()
        }
}