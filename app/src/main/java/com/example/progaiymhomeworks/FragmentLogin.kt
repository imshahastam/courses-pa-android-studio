package com.example.progaiymhomeworks

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class FragmentLogin : Fragment(R.layout.fragment_login) {

    lateinit var listener: OnButtonsClick

    private val pref get() = Injector.pref

    private lateinit var logEmailInputLayout: TextInputLayout
    private lateinit var logPasswordInputLayout: TextInputLayout

    private lateinit var logEmail: TextInputEditText
    private lateinit var logPassword: TextInputEditText

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonsClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val prefEmail = pref.getEmail("EMAIL_KEY")
        val prefPswrd = pref.getPassword("PSWRD_KEY")

        val btnLogin = view.findViewById<AppCompatButton>(R.id.loginBtn)

        btnLogin.setOnClickListener {
            if (prefEmail.isNotEmpty() && prefPswrd.isNotEmpty()) {
                if (prefEmail == logEmail.text.toString() && prefPswrd == logPassword.text.toString()) {
                    listener.login()
                } else {
                    Toast.makeText(requireContext(), "Такого пользователя нет", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(requireContext(), "Null", Toast.LENGTH_SHORT).show()
            }
        }
    }
}