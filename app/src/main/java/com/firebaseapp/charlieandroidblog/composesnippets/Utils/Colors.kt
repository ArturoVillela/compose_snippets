package com.firebaseapp.charlieandroidblog.composesnippets.Utils

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

class Colors {

    enum class MyColor{
        azul, casi_blanco, gris, verde, morado, casi_negro
    }

    companion object{

        fun getColor(color:MyColor): Color {
            return when(color){
                MyColor.azul->Color(0xFF2C2C81)
                MyColor.gris->Color(0xFF9D9D9D)
                MyColor.verde->Color(0xFF4DA348)
                MyColor.casi_negro->Color(0xFF272727)
                MyColor.morado->Color(0xFF262350)
                MyColor.casi_blanco->Color(0xFFE0E0E0)
            }
        }

        fun getLightBlue()=Color(0xFF1C29F8)
        fun getColorRed1()=Color(0xFFB10202)

        fun getBrushGradient(): Brush {
            return Brush.horizontalGradient(
                colors = listOf(getLightBlue(),getColorRed1()),
                startX = 0.5f,
                endX = 1f
            )
        }
    }



}