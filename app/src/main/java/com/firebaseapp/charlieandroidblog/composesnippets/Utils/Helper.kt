package com.firebaseapp.charlieandroidblog.composesnippets.Utils

import androidx.navigation.NavHostController

class Helper {

    companion object{

        fun navigateByIndex(nav: NavHostController, index:Int){
            when (index){
                0->nav.navigate("buttons_example")
                1->nav.navigate("edittext_example")
                2->nav.navigate("image_example")
                3->nav.navigate("column_example")
                4->nav.navigate("row_example")
                5->nav.navigate("appbar_example")
                6->nav.navigate("lazycolumn_example")
                7->nav.navigate("dialog_example")
                8->nav.navigate("scaffold_example")
                9->nav.navigate("animation1_example")

                else ->nav.navigate("buttons_example")
            }
        }
    }
}