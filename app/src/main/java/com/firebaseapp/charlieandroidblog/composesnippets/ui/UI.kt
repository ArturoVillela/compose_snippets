package com.firebaseapp.charlieandroidblog.composesnippets.ui

import android.animation.ObjectAnimator
import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.firebaseapp.charlieandroidblog.composesnippets.MainActivity
import com.firebaseapp.charlieandroidblog.composesnippets.R
import com.firebaseapp.charlieandroidblog.composesnippets.Utils.Colors
import com.firebaseapp.charlieandroidblog.composesnippets.Utils.Helper
import com.firebaseapp.charlieandroidblog.composesnippets.Utils.LCOGetter
import com.firebaseapp.charlieandroidblog.composesnippets.ViewModel.MyViewModel
import kotlin.math.roundToInt

class UI {

    @Composable
    fun initScreen(nav: NavHostController) {
        var list = ArrayList<String>()
        val vm: MyViewModel = viewModel()
        vm.start()
        vm.list.observe(LCOGetter.getLifeCycleOwener(), Observer {
            vm.list.value?.let {
                list = it
            }
        })

        Column(modifier = Modifier.fillMaxSize()) {
            getAppBar(nav, "Inicio")
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
            ) {
                LazyColumn {
                    items(list.size) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .padding(5.dp)
                        ) {
                            Button(
                                onClick = { Helper.navigateByIndex(nav, it) },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(list.get(it))
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun buttonsExamples(nav: NavHostController) {
        Column(modifier = Modifier.fillMaxSize()) {
            getAppBar(nav, "buttons  :) ")
            Column(modifier = Modifier.padding(10.dp)) {
                Button(onClick = { msg("btn 1 clicked") }) { Text("Simple button") }
                Button(
                    onClick = { msg("btn 2 clicked") },
                    contentPadding = ButtonDefaults.ButtonWithIconContentPadding
                ) {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Localized description",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Like")
                }

                Box(modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(brush = Colors.getBrushGradient())
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(30.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        msg("btn 3 clicked")
                    }
                ) {
                    var text = " box acting as button "
                    Text(
                        text,
                        color = Color.White, // Set text color to white
                        fontSize = 22.sp, // Optional: set font size
                        fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }

    @Composable
    fun edittextExample(nav: NavHostController) {
        var name = remember { mutableStateOf("") }
        Column(modifier = Modifier.fillMaxSize()) {
            getAppBar(nav, "EditText->TextField")
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                TextField(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    value = name.value,
                    onValueChange = {
                        name.value = it
                    },
                    label = { Text(text = "ejemplo nombre") }, // hint, texto inicial k desaparece o se pone como titulo arriba en letras chikitas
                    placeholder = { Text(text = "nombre") } //texto k aparece cuando empiezas a escribir
                )

            }
        }
    }

    @Composable
    fun imageExample(nav: NavHostController) {
        Column(modifier = Modifier.fillMaxSize()) {
            getAppBar(nav, "Image")
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.teemo),
                    contentDescription = "Background Image",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .padding(10.dp)
                        .clickable
                        {
                            msg("clicked on teemo!")
                        },
                )
            }
        }
    }

    @Composable
    fun columnExample(nav: NavHostController) {
        Column(modifier = Modifier.fillMaxSize()) {
            getAppBar(nav, "Columna")
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                for (i in 0..5) {
                    Image(
                        painter = painterResource(id = R.drawable.teemo),
                        contentDescription = "Background Image",
                        modifier = Modifier
                            .width(100.dp)
                            .height(100.dp)
                            .padding(10.dp)
                            .clickable
                            {
                                msg("clicked on teemo!")
                            },
                    )
                }
            }
        }
    }

    @Composable
    fun rowExample(nav: NavHostController) {
        Column(modifier = Modifier.fillMaxSize()) {
            getAppBar(nav, "Renglon")
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                for (i in 0..5) {
                    Image(
                        painter = painterResource(id = R.drawable.teemo),
                        contentDescription = "Background Image",
                        modifier = Modifier
                            .width(100.dp)
                            .height(100.dp)
                            .padding(10.dp)
                            .clickable
                            {
                                msg("clicked on teemo!")
                            },
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun appbarExample(nav: NavHostController) {
        //getAppBar(nav,"appbar")
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(title = {
                Row {
                    Text("Text1")
                    Text("-")
                    Text("Text2")
                }
            },
                navigationIcon = {
                    IconButton(onClick = {
                        Log.d("zzz", "menu button clicked in composables")
                        nav.navigate("screen_inicio")
                    }) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "...."
                        )
                    }
                })
        }
    }


    @Composable
    fun lazycolumnExample(nav: NavHostController) {
        Column(Modifier.fillMaxSize()) {
            getAppBar(nav, "lazy column")
            val list = listOf("uno", "dos", "tres", "4", "cinco", "6", "siete", "8")
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
            ) {
                items(list.size) {
                    Button(onClick = { msg("clicked on item index:$it") }) {
                        Text(list.get(it))
                    }
                }
            }
        }
    }

    @Composable
    fun dialogboxExample(nav: NavHostController) {
        Column(Modifier.fillMaxSize()) {
            var shouldShow1 = remember { mutableStateOf(false) }
            var shouldShow2 = remember { mutableStateOf(false) }
            getAppBar(nav, "lazy column")
            if (shouldShow1.value) {
                Dialog(onDismissRequest = { shouldShow1.value=false } ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(16.dp),
                        shape = RoundedCornerShape(16.dp),
                    ) {
                        Text(
                            text = "This is a minimal dialog",
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentSize(Alignment.Center),
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
            if (shouldShow2.value) {
                AlertDialog(
                    onDismissRequest = { shouldShow2.value = false },
                    title = { Text(text = "Alert Dialog") },
                    text = { Text(text = "Jetpack Compose Alert Dialog") },
                    confirmButton = {
                        Button(
                            onClick = { shouldShow2.value = false }
                        ) {
                            Text(text = "Confirm", color = Color.White)
                        }
                    }
                )
            }
            Button(onClick = {
                shouldShow1.value = !shouldShow1.value
            }, modifier = Modifier.fillMaxWidth()) {
                Text(" dialog 1")
            }
            Button(onClick = {
                shouldShow2.value = !shouldShow2.value
            }, modifier = Modifier.fillMaxWidth()) {
                Text(" dialog 2")
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun scaffoldExample(nav: NavHostController) {
        var presses = remember { mutableIntStateOf(0) }

        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onSecondary,
                    ),
                    title = {
                        Text("Scaffold ")
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            nav.navigate("screen_inicio")
                        }) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "...."
                            )
                        }
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onSecondary,
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Bottom app bar",
                    )
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { msg("clicked floating") }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button $presses times.
                """.trimIndent(),
                )
            }
        }
    }

    @Composable
    fun animation1Example(nav:NavHostController){

        var moved = remember { mutableStateOf(false) }

        val pxToMove = with(LocalDensity.current) {
            200.dp.toPx().roundToInt()
        }

        val offset = animateIntOffsetAsState(
            targetValue = if (moved.value) {
                IntOffset(pxToMove, pxToMove)
            } else {
                IntOffset.Zero
            },
            label = "offset"
        )

        Column (modifier = Modifier.fillMaxSize()) {
            getAppBar(nav,"animation move")
            Column (modifier = Modifier.fillMaxSize().padding(20.dp)) {
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    moved.value = !(moved.value)
                }) {
                    Text("Init Animation")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Box(modifier = Modifier
                    .offset{offset.value}
                    .clip(RoundedCornerShape(10.dp))
                    .background(brush = Colors.getBrushGradient())
                    .width(50.dp)
                    .padding(10.dp)
                    .height(50.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        msg("box clicked")
                    }
                ) {}

            }
        }

    }



    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun getAppBar(nav: NavHostController, title: String) {
        TopAppBar(
            title = { Text(title, maxLines = 1) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Colors.getColor(Colors.MyColor.azul),
                titleContentColor = Colors.getColor(Colors.MyColor.casi_blanco),
                navigationIconContentColor = Colors.getColor(Colors.MyColor.casi_negro),
                actionIconContentColor = Colors.getColor(Colors.MyColor.casi_negro)
            ),
            navigationIcon = {
                IconButton(onClick = {
                    Log.d("zzz", "menu button clicked in composables")
                    nav.navigate("screen_inicio")
                }) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "...."
                    )
                }
            }
        )
    }


    fun msg(cad: String) {
        Toast.makeText(
            LCOGetter.getLifeCycleOwener() as MainActivity,
            cad, Toast.LENGTH_SHORT
        ).show()
    }


}