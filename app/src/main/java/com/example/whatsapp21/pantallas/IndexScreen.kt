package com.example.navegacion.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.whatsapp21.Mensaje
import com.example.whatsapp21.R
import com.example.whatsapp21.navegacion.AppScreen

private val messages: List<Mensaje> = listOf(
    Mensaje("Raul", "Apruebame"),
    Mensaje("Nicolas", "Apruebame"),
    Mensaje("Luis", "Apruebame"),
    Mensaje("Daniel", "Apruebame"),
    Mensaje("Julio", "Apruebame"),
    Mensaje("Daniel", "Apruebame"),
    Mensaje("Manuel Jose", "Apruebame"),
    Mensaje("Julio", "Apruebame"),
    Mensaje("Daniel", "Apruebame"),
)

@Composable
fun IndexScreen(navController: NavController) {
    IndexBody(navController)
}

@Composable
fun IndexBody(navController: NavController) {
    val texto = "texto"
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Menu()
        LazyColumn {
            items(messages.size) { i ->
                Contacts(
                    { navController.navigate(route = AppScreen.ChatScreen.route + "/${messages[i].msg}")  }, messages[i]
                )
            }
        }
    }
}

@Composable
fun Menu() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = colorResource(id = R.color.green_whatsapp))
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(), Arrangement.Center
        ) {
            Row {
                Box(
                    Modifier
                        .padding(start = 20.dp)
                        .weight(3F)
                ) {
                    Text(
                        stringResource(R.string.app_name),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(Modifier.weight(1f), Arrangement.SpaceAround) {
                    Image(
                        painter = painterResource(id = R.drawable.photo_camera),
                        contentDescription = null
                    )
                    Icon(
                        Icons.Rounded.Search,
                        contentDescription = stringResource(id = R.string.app_name),
                        tint = Color.White
                    )
                    Image(
                        painter = painterResource(id = R.drawable.more_vert),
                        contentDescription = stringResource(id = R.string.app_name)
                    )
                }
            }
        }
    }
}

@Composable
fun Contacts(function: () -> Unit, mensaje: Mensaje) {
    Row(
        Modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.chat))
            .clickable(true, onClick = function), verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            Icons.Rounded.AccountCircle, contentDescription = null, Modifier.size(50.dp)
        )
        Column { MisTextos(mensaje = mensaje) }
    }
}

@Composable
fun MisTextos(mensaje: Mensaje) {
    Text(mensaje.nombre)
    Spacer(Modifier.size(10.dp))
    Text(mensaje.msg, fontSize = 10.sp)
}