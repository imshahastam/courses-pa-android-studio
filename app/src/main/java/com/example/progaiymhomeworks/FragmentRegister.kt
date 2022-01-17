package com.example.progaiymhomeworks

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.addTextChangedListener
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

    lateinit var btnSighin: AppCompatButton

    private val pref get() = Injector.pref

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonsClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSighin = view.findViewById(R.id.sighinBtn)
        email = view.findViewById(R.id.email)
        password = view.findViewById(R.id.password)

        passwordInputLayout = view.findViewById(R.id.passwordInputLayout)
        emailInputLayout = view.findViewById(R.id.emailInputLayout)

        email.addTextChangedListener(sTextWatcher)
        password.addTextChangedListener(sTextWatcher)

        btnSighin.setOnClickListener {
            isEmptyCheckEmail()
            isEmptyCheckPswrd()

            pref.saveEmail(email.text.toString())
            pref.savePassword(password.text.toString())

            listener.login()
        }


    }

    private val sTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {
            btnSighin.isEnabled = email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()
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
}