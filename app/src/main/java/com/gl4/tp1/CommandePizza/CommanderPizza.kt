package com.gl4.tp1.CommandePizza

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.gl4.tp1.R

class CommanderPizza : AppCompatActivity() {

    lateinit var Nom : EditText
    lateinit var Prénom : EditText
    lateinit var Adresse : EditText
    lateinit var TailleSpinner: Spinner
    lateinit var CheckFrom : CheckBox
    lateinit var CheckSauce : CheckBox
    lateinit var CheckThon : CheckBox
    lateinit var CheckChamp : CheckBox


    var phoneNumber = "26200798"
    var emailVendeur = "vendeur@gmail.com"
    var isClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commander_pizza)

        Nom = findViewById(R.id.txtNom)
        Prénom = findViewById(R.id.txtPrénom)
        Adresse = findViewById(R.id.txtAdresse)
        TailleSpinner = findViewById(R.id.spinnerTaille)
        CheckFrom = findViewById(R.id.checkBoxFromage)
        CheckSauce = findViewById(R.id.checkBoxSauceTomate)
        CheckThon = findViewById(R.id.checkBoxThon)
        CheckChamp = findViewById(R.id.checkBoxChampignon)


        ArrayAdapter.createFromResource(
            this,
            R.array.tailles,
            android.R.layout.simple_spinner_item
        ).also { adapter->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            TailleSpinner.adapter = adapter
        }


    }

    fun Commander(view: View) {
        isClicked = true
        var ingre = ""
        if( CheckChamp.isChecked){
            ingre = ingre + "${CheckChamp.text.toString()} \n"
        }
        if( CheckFrom.isChecked){
            ingre = ingre + "${CheckFrom.text.toString()} \n"
        }
        if( CheckThon.isChecked){
            ingre = ingre + "${CheckThon.text.toString()} \n"
        }
        if( CheckSauce.isChecked){
            ingre = ingre + "${CheckSauce.text.toString()} \n"
        }

        var message = "le client ${Nom.text} ${Prénom.text} veut commander une Pizza ${TailleSpinner.getSelectedItem()} à l'adresse $Adresse \n" +
                "Les ingrédients choisis sont : " +
                ingre
        Toast.makeText(this, message,Toast.LENGTH_LONG).show()

        val shareIntent : Intent = Intent().apply {
            action = Intent.ACTION_SEND
            //to send as SMS
            putExtra("address" , "sms"+phoneNumber)
            //to send as Email
            setData(Uri.parse("mailto"))
            putExtra(Intent.EXTRA_EMAIL  , arrayOf(emailVendeur) )
            putExtra(Intent.EXTRA_TEXT, message)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent,null))

    }

    override fun onRestart() {
        super.onRestart()
        if(isClicked){
            val intent = Intent(this, SplashScreen::class.java)
            startActivity(intent)
        }

    }
}