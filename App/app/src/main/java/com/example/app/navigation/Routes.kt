package com.example.app.navigation

sealed class Routes(val route: String) {
    data object Artists: Routes("artists")
    data object Albums: Routes("albums")
}
