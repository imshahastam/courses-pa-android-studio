package com.example.progaiymhomeworks

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

    lateinit var btnLogin: AppCompatButton

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonsClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val prefEmail = pref.getEmail("EMAIL_KEY")
        val prefPswrd = pref.getPassword("PSWRD_KEY")

        logEmail = view.findViewById(R.id.log_email)
        logPassword = view.findViewById(R.id.log_password)

        logEmailInputLayout = view.findViewById(R.id.log_emailInputLayout)
        logPasswordInputLayout = view.findViewById(R.id.log_passwordInputLayout)

        btnLogin = view.findViewById(R.id.loginBtn)

        logEmail.addTextChangedListener(logTextWatcher)
        logPassword.addTextChangedListener(logTextWatcher)

        btnLogin.setOnClickListener {
            if (prefEmail.isNotEmpty() && prefPswrd.isNotEmpty()) {

                isEmptyCheckEmail()
                isEmptyCheckPswrd()

                if (logEmail.text.toString() == prefEmail && logPassword.text.toString() == prefPswrd) {
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

    private val logTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {
            btnLogin.isEnabled = logEmail.text.toString().isNotEmpty() && logPassword.text.toString().isNotEmpty()
        }
    }

    private fun isEmptyCheckEmail() {
        val emailText = logEmail.text
        if (emailText!!.isEmpty()) {
            logEmailInputLayout.error = "Введите данные!"
        }
    }

    private fun isEmptyCheckPswrd() {
        val pswrdText = logPassword.text
        if (pswrdText!!.isEmpty()) {
            logPasswordInputLayout.error = "Введите данные!"
        }
    }
}