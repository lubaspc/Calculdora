package com.ittoluca.lubinpc.calculdora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var tipo=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mas.setOnClickListener {
            operador.text="+"
            tipo=1
            operaciones()
        }
        menos.setOnClickListener {
            operador.text="-"
            tipo=2
            operaciones()
        }
        por.setOnClickListener {
            operador.text="X"
            tipo=3
            operaciones()
        }
        entre.setOnClickListener {
            operador.text="/"
            tipo=4
            operaciones()
        }

        igual.setOnClickListener {
            uno.setText(resultado.text.toString())
            dos.setText("")
            operaciones()
        }

        uno.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                operaciones()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })
        dos.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
               operaciones()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })
    }
    fun operaciones(){
        var unos:Double?=null
        var doss:Double?=null
        try {
            unos=uno.text.toString().toDouble()
            doss= dos.text.toString().toDouble()
            if (uno.text.isEmpty() || dos.text.isEmpty()){

            }else{
                when (tipo){
                    0->Toast.makeText(this@MainActivity,"Selecciona una operacion",Toast.LENGTH_LONG).show()
                    1-> resultado.text=""+(unos!! +doss!!)
                    2-> resultado.text=""+(unos!! -doss!!)
                    3-> resultado.text=""+(unos!! *doss!!)
                    4-> resultado.text=""+(unos!! /doss!!)
                }
            }
        }catch (e:Exception){

        }
    }
}
