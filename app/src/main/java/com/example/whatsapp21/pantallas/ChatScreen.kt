package com.example.whatsapp21.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.whatsapp21.Mensaje
import com.example.whatsapp21.R

@Composable
fun ChatScreen(navController: NavController, texto: String?) {
    ChatBody(navController, texto)
}

@Composable
fun ChatBody(navController: NavController, texto: String?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ChatMenu { navController.popBackStack() }
        Chat(texto)
    }
}

@Composable
fun ChatMenu(back: () -> Unit) {
    Row(
        Modifier
            .background(color = colorResource(R.color.green_whatsapp))
            .fillMaxWidth()
    ) {
        Box(Modifier.clickable(true, onClick = back)) {
            Icon(
                Icons.Rounded.ArrowBack,
                tint = Color.White,
                contentDescription = "Back"
            )
        }
    }
}

@Composable
fun Chat(texto: String?) {
    Column(
        Modifier
            .background(color = colorResource(R.color.chat))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Column(horizontalAlignment = Alignment.End) {
            texto?.let {
                Text(it, modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .border(2.dp, color = colorResource(R.color.chat), RoundedCornerShape(16.dp))
                    .padding(4.dp)
                    .background(color = colorResource(R.color.msg_background)))
            }
        }
        Row(verticalAlignment = Alignment.Bottom) {
            TextField(
                value = TextFieldValue(""),
                onValueChange = { },
                label = { Text("") },
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .border(2.dp, Color.Gray, RoundedCornerShape(16.dp))
                    .padding(4.dp)
            )
            Button(onClick = {}) {
                Icon(
                    Icons.Rounded.PlayArrow,
                    contentDescription = "send"
                )
            }
        }
    }
}

