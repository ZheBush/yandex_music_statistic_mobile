package com.example.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app.ui.theme.AppTheme
import com.example.app.ui.theme.AlmostBlack
import com.example.app.ui.theme.DarkOrange
import com.example.app.ui.theme.Gray
import com.example.app.ui.theme.Orange

class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Auth()
        }
    }
}

@Composable
fun Auth() {

    AppTheme {
        val userToken = remember {
            mutableStateOf("")
        }
        val context = LocalContext.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = AlmostBlack),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = userToken.value,
                placeholder = {
                    Text(
                        "Token",
                        color = Gray)},
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Orange
                ),
                modifier = Modifier
                    .size(width = 260.dp, height = 55.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .border(
                        width = 2.dp,
                        color = Orange,
                        shape = RoundedCornerShape(30.dp)
                    ),
                onValueChange = {newText -> userToken.value = newText}
            )
            Button(
                onClick = {
                    context.startActivity(
                        Intent(context, HomeActivity::class.java)
                    )
                },
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = AlmostBlack,
                    containerColor = Orange
                ),
                modifier = Modifier
                    .padding(15.dp)
                    .size(width = 100.dp, height = 50.dp)
            ) {
                Text("Enter",
                    fontSize = 15.sp,
                    color = AlmostBlack)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 30.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextButton(
                onClick = { /*TODO*/ },
            ) {
                Text(
                    "Click here if you don't have a token",
                    fontSize = 15.sp,
                    color = DarkOrange
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AuthPreview() {
    Auth()
}