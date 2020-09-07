package com.example.appac1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun ratingCalc(componente: View) {
        result.text = ""
        val userName = user_name.text.toString()
        val userYards = user_yards.text.toString()
        val userTDs = user_td.text.toString()
        val userComp = user_comp.text.toString()
        val userInt = user_int.text.toString()
        val userAtt = user_att.text.toString()

        if (userName.isNullOrBlank() || userYards.isNullOrBlank() || userTDs.isNullOrBlank() ||
            userComp.isNullOrBlank() || userInt.isNullOrBlank() || userAtt.isNullOrBlank()) {
            Toast.makeText(this, "Campo obrigatório vazio", Toast.LENGTH_SHORT).show()
        }else {

            if (userComp.toDouble() > userAtt.toDouble()){
                Toast.makeText(this, "Não é possível ter mais passes completos do que tentados", Toast.LENGTH_SHORT).show()
            }else {
                val calcResult =
                    ((8.4 * userYards.toDouble()) + (330 * userTDs.toDouble()) + (100 * userComp.toDouble()) - (200 * userInt.toDouble())) / userAtt.toDouble()

                if (calcResult > 500) {
                    result.text = "Olá ${userName}, seu rating foi ${calcResult}, você é uma lenda"
                    result.setTextColor(Color.BLUE)
                } else if (calcResult > 0) {
                    result.text =
                        "Olá ${userName}, seu rating foi ${calcResult}, você foi muito bem"
                    result.setTextColor(Color.GREEN)
                } else if (calcResult < -200) {
                    result.text =
                        "Olá ${userName}, seu rating foi ${calcResult}, você precisa treinar muito"
                    result.setTextColor(Color.RED)
                } else if (calcResult < 0) {
                    result.text =
                        "Olá ${userName}, seu rating foi ${calcResult}, você precisa treinar agora"
                    result.setTextColor(Color.YELLOW)
                } else {
                    result.text =
                        "Olá ${userName}, seu rating foi ${calcResult}, você precisa treinar"
                    result.setTextColor(Color.GRAY)
                }
            }
        }
    }
}