package com.example.progaiymhomeworks

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class FragmentRegister : Fragment(R.layout.fragment_register) {

    private lateinit var listener: OnButtonsClick
    private lateinit var emailInputLayout: TextInputLayout
    private lateinit var passwordInputLayout: TextInputLayout
    private lateinit var email: TextInputEditText
    private lateinit var password: TextInputEditText

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonsClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogin = view.findViewById<AppCompatButton>(R.id.loginBtn)
        email = view.findViewById(R.id.email)
        password = view.findViewById(R.id.password)

        passwordInputLayout = view.findViewById(R.id.passwordInputLayout)
        emailInputLayout = view.findViewById(R.id.emailInputLayout)

        btnLogin.setOnClickListener {
            isEmptyCheckEmail()
            isEmptyCheckPswrd()

            if (correctEmail() && correctPswrd()) {
                listener.login()
            }
        }

    }

    private fun isEmptyCheckEmail() {
        val emailText = email.text
        if (emailText!!.isEmpty()) {
            emailInputLayout.error = "Введите данные!"
        }
    }

    private fun isEmptyCheckPswrd() {
        val pswrdText = password.text
        if (pswrdText!!.isEmpty()) {
            passwordInputLayout.error = "Введите данные!"
        }
    }

    private fun correctEmail() : Boolean {
        val emailText = email.text
        if (emailText.toString() == "sh.st@gmail.com") {
            return true
        } else
            emailInputLayout.error = "Неверный логин"
        return false
    }

    private fun correctPswrd() : Boolean {
        val pswrdText = password.text
        if (pswrdText.toString() == "p1") {
            return true
        } else
            passwordInputLayout.error = "Неверный пароль"
        return false
    }
}