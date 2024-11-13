package com.example.yourapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.practice14.R

class SecondActivity : AppCompatActivity() {

    private lateinit var emailEditTextSecond: EditText
    private lateinit var nameEditTextSecond: EditText
    private lateinit var ageEditTextSecond: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        emailEditTextSecond = findViewById(R.id.emailEditTextSecond)
        nameEditTextSecond = findViewById(R.id.nameEditTextSecond)
        ageEditTextSecond = findViewById(R.id.ageEditTextSecond)
        saveButton = findViewById(R.id.saveButton)


        val email = intent.getStringExtra("email")
        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")

        emailEditTextSecond.setText(email)
        nameEditTextSecond.setText(name)
        ageEditTextSecond.setText(age)


        saveButton.setOnClickListener {
            val updatedEmail = emailEditTextSecond.text.toString()
            val updatedName = nameEditTextSecond.text.toString()
            val updatedAge = ageEditTextSecond.text.toString()


            val resultIntent = intent.apply {
                putExtra("updatedEmail", updatedEmail)
                putExtra("updatedName", updatedName)
                putExtra("updatedAge", updatedAge)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}