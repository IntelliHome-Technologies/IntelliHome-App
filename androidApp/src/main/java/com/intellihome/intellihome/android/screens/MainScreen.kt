package com.intellihome.intellihome.android.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.intellihome.intellihome.android.R
import com.intellihome.intellihome.android.screens.home.DeviceScreen
import com.intellihome.intellihome.android.screens.home.HomeScreen
import com.intellihome.intellihome.android.screens.login.LoginScreen
import com.intellihome.intellihome.android.theme.IntelliHomeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    val title = when(currentDestination) {
                        "device/{id}/{name}" -> navBackStackEntry?.arguments?.getString("name") ?: "Device"
                        "login" -> "Login"
                        else -> "IntelliHome"
                    }
                    Text(title)
                },
                navigationIcon = {
                    if ((currentRoute != "home") or (currentRoute != "login")) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(painterResource(id= R.drawable.ic_arrow_back), contentDescription = "Back")
                        }
                    }
                }
            )
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "login",
            modifier = Modifier.padding(padding)
        ) {
            composable("login") {
                LoginScreen(navController = navController)
            }

            composable("home") {
                HomeScreen(navController = navController)
            }

            composable("device/{id}/{name}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")
                val name = backStackEntry.arguments?.getString("name")
                DeviceScreen(id=id!!, name=name!!)
            }
        }
    }
}
