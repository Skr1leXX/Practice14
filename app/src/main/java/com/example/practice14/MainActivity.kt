package com.example.yourapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.practice14.R

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailEditText = findViewById(R.id.emailEditText)
        nameEditText = findViewById(R.id.nameEditText)
        ageEditText = findViewById(R.id.ageEditText)
        submitButton = findViewById(R.id.submitButton)
        resultTextView = findViewById(R.id.resultTextView)

        submitButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString()


            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("email", email)
                putExtra("name", name)
                putExtra("age", age)
            }
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {

            val updatedEmail = data?.getStringExtra("updatedEmail")
            val updatedName = data?.getStringExtra("updatedName")
            val updatedAge = data?.getStringExtra("updatedAge")


            resultTextView.text = "Измененные данные:\nEmail*: $updatedEmail\nИмя*: $updatedName\nВозраст*: $updatedAge"
        }
    }
}