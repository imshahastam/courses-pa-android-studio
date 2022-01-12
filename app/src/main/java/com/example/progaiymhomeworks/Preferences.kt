package com.example.progaiymhomeworks

import android.content.Context
import android.content.SharedPreferences

interface Preferences {

    fun saveEmail(email: String)
    fun savePassword(password: String)

    fun getEmail(email: String): String
    fun getPassword(password: String): String
}

class PreferencesImpl(context: Context) : Preferences {

    private val pref = context.getSharedPreferences("MyAppPref", Context.MODE_PRIVATE)

    override fun saveEmail(email: String) {
        pref.edit().apply() {
            putString(EMAIL_KEY, email)
        }.apply()
    }

    override fun savePassword(password: String) {
        pref.edit().apply() {
            putString(PSWRD_KEY, password)
        }.apply()
    }

    override fun getEmail(email: String): String {
        return pref.getString(EMAIL_KEY, "") ?: ""
    }

    override fun getPassword(password: String): String {
        return pref.getString(PSWRD_KEY, "") ?: ""
    }

    companion object {
        const val EMAIL_KEY = "EMAIL_KEY"
        const val PSWRD_KEY = "PSWRD_KEY"
    }
}