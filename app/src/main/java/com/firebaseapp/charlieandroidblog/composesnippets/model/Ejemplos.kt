package com.firebaseapp.charlieandroidblog.composesnippets.model

class Ejemplos {

    companion object{
        fun getEjemplos(): ArrayList<String>{
            val list = listOf("Button", "EditText", "Image", "Column",
                "Row", "AppBar", "LazyColumn","Dialog Box","Scaffold",
                "calendar", "Animation Move")

            return ArrayList(list)
        }
    }
}