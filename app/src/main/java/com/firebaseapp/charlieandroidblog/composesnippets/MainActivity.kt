package com.firebaseapp.charlieandroidblog.composesnippets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.firebaseapp.charlieandroidblog.composesnippets.Utils.LCOGetter
import com.firebaseapp.charlieandroidblog.composesnippets.ui.UI
import com.firebaseapp.charlieandroidblog.composesnippets.ui.theme.ComposeSnippetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LCOGetter.init(this)
        setContent {
            //Greeting()
            init()
//            ComposeSnippetsTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
        }
    }
}

@Composable
fun init(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "screen_inicio"){
        composable("screen_inicio"){ UI().initScreen(navController) }
        composable("buttons_example"){ UI().buttonsExamples(navController) }
        composable("edittext_example"){ UI().edittextExample(navController) }
        composable("image_example"){ UI().imageExample(navController) }
        composable("column_example"){ UI().columnExample(navController) }
        composable("row_example"){ UI().rowExample(navController) }
        composable("appbar_example"){ UI().appbarExample(navController) }
        composable("lazycolumn_example"){ UI().lazycolumnExample(navController) }
        composable("dialog_example"){ UI().dialogboxExample(navController) }
        composable("scaffold_example"){ UI().scaffoldExample(navController) }
        composable("animation1_example"){ UI().animation1Example(navController) }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    TopAppBar(title = {
        Row { Text("Text1")
            Text("-")
            Text("Text2")
        }
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TopAppBar(title = {
        Row { Text("Text1")
            Text("-")
            Text("Text2")
        }
    },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "...."
            )
        }

    )
}