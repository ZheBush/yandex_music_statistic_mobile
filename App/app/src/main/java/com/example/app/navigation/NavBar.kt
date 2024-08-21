package com.example.app.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.app.R
import com.example.app.ui.theme.Black
import com.example.app.ui.theme.LightGray
import com.example.app.ui.theme.Orange

@Composable
fun NavBar(navController: NavController) {
    NavigationBar(
        containerColor = Black,
        contentColor = Orange,
        modifier = Modifier
            .statusBarsPadding()
            .height(50.dp)
    ) {
        val backStack by navController.currentBackStackEntryAsState()
        val currentRoute = backStack?.destination?.route
        NavBarItems.BarItems.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    } },
                icon = {
//                    Icon(
//                        imageVector = navItem.image,
//                        contentDescription = navItem.title)
                       },
                label = {
                    Text(
                        text = navItem.title,
                        fontSize = 18.sp,
                        color = LightGray
                    )
                }
            )
        }
    }
}

@Composable
fun UserBar() {
    Row(
        modifier = Modifier
            .background(color = Black)
            .fillMaxWidth()
            .statusBarsPadding()
    ) {
    }
}

@Preview(showSystemUi = true)
@Composable
fun NavBarPreview() {
    val navController = rememberNavController()
    NavBar(navController)
}