package com.example.progaiymhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

class FragmentRegister : Fragment(R.layout.fragment_register) {

    private lateinit var listener: OnButtonsClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonsClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogin = view.findViewById<AppCompatButton>(R.id.loginBtn)
        val email = view.findViewById<AppCompatEditText>(R.id.email)
        val password = view.findViewById<AppCompatEditText>(R.id.password)

        btnLogin.setOnClickListener {

            if(email.text.toString() == "shaha.stam@gmail.com" && password.text.toString() == "parol01") {
                listener.login()
            } else if(email.text!!.isEmpty() || password.text!!.isEmpty()) {
                Toast.makeText(requireContext(), "Введите данные!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(requireContext(), "Неверный пароль или логин", Toast.LENGTH_LONG).show()
            }
        }
    }
}