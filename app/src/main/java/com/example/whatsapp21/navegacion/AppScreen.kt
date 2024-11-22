package com.example.whatsapp21.navegacion

sealed class AppScreen(val route:String) {
    object IndexScreen: AppScreen("IndexScreen")
    object ChatScreen: AppScreen("ChatScreen")
}