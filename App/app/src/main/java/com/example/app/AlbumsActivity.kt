package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.app.ui.theme.AlmostBlack
import com.example.app.ui.theme.DarkGray
import com.example.app.ui.theme.Orange

class AlbumsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Albums()
        }
    }
}

@Composable
fun Albums() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AlmostBlack),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Albums", fontSize = 24.sp, color = Orange)
    }
}

@Preview(showBackground = true)
@Composable
fun AlbumsPreview() {
    Albums()
}