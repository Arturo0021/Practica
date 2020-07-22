package com.example.practicas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var editnumbercard : EditText
    private lateinit var textnumbercard : TextView
    private var message : String = ""
    private var charContinue : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editnumbercard = findViewById(R.id.editnumbercard)
        textnumbercard = findViewById(R.id.textnumbercard)

        editnumbercard.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(char: CharSequence?, charCount: Int, p2: Int, p3: Int) {
                textnumbercard.text = validator(char!!)
            }

        })
    }

    fun validator(charSequence: CharSequence) : String {

        val arrayChar = charSequence.withIndex()
        if(arrayChar.count() >= 0){

        }

        for((indice, valor) in arrayChar){

            if(indice == 0 && valor.equals('0')){
                charContinue = false
                message = "El primer digito no puede ser 0"
                textnumbercard.setTextColor(Color.RED)
                break
            } else if(!valor.isDigit()){
                charContinue = false
                message = "Solo de admiten numeros"
                textnumbercard.setTextColor(Color.RED)
                break
            } else if(indice == 15) {
                if(!esPar(valor.toInt())){
                    charContinue = false
                    message = "Transacción no realizada"
                    textnumbercard.setTextColor(Color.RED)
                } else {
                    message = "Transacción Correcta"
                    textnumbercard.setTextColor(Color.BLUE)
                }
            } else {
                message = ""
            }
        }

        Log.v("#Letter:", "${charContinue} - ${message}")

        return message
    }

    fun esPar(numero: Int): Boolean {
        return if (numero % 2 == 0) {
            true
        } else {
            false
        }
    }

}
