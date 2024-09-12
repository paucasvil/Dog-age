package com.example.p4_21130850

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p4_21130850.ui.theme.P421130850Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            P421130850Theme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White) ) { innerPadding ->
                    GreetingImage(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingImage(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.dog)
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        TextFieldWithInputType(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(
                    bottom = 50.dp,
                    top = 50.dp
                )
        )

        SimpleButton(
            modifier = Modifier
                .size(220.dp, 100.dp)
        )
    }
}


@Composable
fun TextFieldWithInputType(modifier: Modifier = Modifier) {
    var age by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = age,
        modifier = modifier,
        label = { Text(text = "Enter Your Age") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = {
            age = it
        }
    )
}

@Composable
fun SimpleButton(modifier: Modifier = Modifier) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(Color.Blue),
        modifier = modifier
    ) {
        Text(
            text = "Calculate dog age",
            fontSize = 20.sp,

        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    P421130850Theme {
        GreetingImage()
    }
}