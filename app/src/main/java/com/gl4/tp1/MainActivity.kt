package com.gl4.tp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.gl4.tp1.CommandePizza.CommanderPizza

class MainActivity : AppCompatActivity() {

    lateinit var txtEmail : EditText
    lateinit var  txtpwd : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtEmail = findViewById(R.id.editTextEmail)
        //var email = txtEmail.text.toString()

        txtpwd = findViewById(R.id.editTextPassword)
        //var pwd = txtpwd.text.toString()


    }

    fun login(view: View) {
        var email = txtEmail.text.toString()
        var pwd = txtpwd.text.toString()

        /*Exercice1*/
        if(email == "gl4@insat.tn" && pwd =="insat2022"){
            Toast.makeText(this,"bon couple login,mot de passe",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this," pas bon couple login,mot de passe",Toast.LENGTH_SHORT).show()
        }
        /*Exercice2*/

        val intent = Intent(view.context,WelcomeActivity::class.java)
        intent.putExtra("email",email)
        startActivity(intent)


    }
    /*Exercice3*/
    fun goTo3(view: View) {
        val intent3 = Intent(this, ImagePicker::class.java )
        startActivity(intent3)
    }

    fun goTo4(view: View) {
        val intent4 = Intent(this, CommanderPizza::class.java)
        startActivity(intent4)
    }
}