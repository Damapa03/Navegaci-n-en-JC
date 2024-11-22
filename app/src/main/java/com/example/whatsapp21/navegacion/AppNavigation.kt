package com.example.whatsapp21.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navegacion.pantallas.IndexScreen
import com.example.whatsapp21.pantallas.ChatScreen

@Composable
fun AppNavigation(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.IndexScreen.route, modifier = modifier) {
        composable(AppScreen.IndexScreen.route) {
            IndexScreen(navController)
        }
        composable(
            AppScreen.ChatScreen.route + "/{text}",
            arguments = listOf(navArgument(name = "text") {
                type = NavType.StringType
            })
        ) {
            ChatScreen(navController, it.arguments?.getString("text"))
        }
    }

}
@Preview
@Composable
fun AppPreview(){
    val modifier: Modifier = Modifier
    AppNavigation(modifier)
}