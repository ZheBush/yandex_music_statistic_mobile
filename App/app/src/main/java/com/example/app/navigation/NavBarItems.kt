package com.example.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import com.example.app.Home
import com.example.app.R

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Artists",
            image = Icons.Default.Person,
            route = "artists"
        ),
        BarItem(
            title = "Albums",
            image = Icons.Default.MailOutline,
            route = "albums"
        )
    )
}