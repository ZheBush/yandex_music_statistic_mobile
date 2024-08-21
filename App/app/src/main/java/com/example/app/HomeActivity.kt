package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app.navigation.BottomNavBar
import com.example.app.navigation.Routes
import com.example.app.ui.theme.AlmostBlack
import com.example.app.ui.theme.Black
import com.example.app.ui.theme.DarkGray
import com.example.app.ui.theme.Orange

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Home()
        }
    }
}

@Composable
fun Home() {
    val navController = rememberNavController()
    Column(
        modifier = Modifier
            .background(color = AlmostBlack)
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        NavHost(
            navController = navController,
            startDestination = Routes.Artists.route,
            modifier = Modifier
                .weight(1f)
        ) {
            composable(route = Routes.Artists.route) {
                Artists()
            }
            composable(route = Routes.Albums.route) {
                Albums()
            }
        }
        BottomNavBar(navController)
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomePreview() {
    Home()
}