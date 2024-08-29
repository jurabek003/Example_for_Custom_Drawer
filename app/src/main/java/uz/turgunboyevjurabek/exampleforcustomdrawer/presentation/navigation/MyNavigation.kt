package uz.turgunboyevjurabek.exampleforcustomdrawer.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.turgunboyevjurabek.exampleforcustomdrawer.presentation.screens.HomeScreen
import uz.turgunboyevjurabek.exampleforcustomdrawer.presentation.screens.ProfileScreen
import uz.turgunboyevjurabek.exampleforcustomdrawer.presentation.screens.StarsScreen

@Composable
fun MyNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            HomeScreen(navHostController = navController)
        }
        composable("Profile"){
            ProfileScreen(navHostController = navController)
        }
        composable("Star"){
            StarsScreen(navHostController = navController)
        }
    }
}