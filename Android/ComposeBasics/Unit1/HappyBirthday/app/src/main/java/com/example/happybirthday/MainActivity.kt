package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingText(
                        message = "Salubrious Salutations",
                        sender = "The Lord High Commander",
                    )

                }
            }
        }
    }
}

/**
 * Android composable with two text elements in a column. Formats said elements for use in Birthday
 * Greeting
 *
 * @param message main message for the greeting
 * @param sender name of the person who is sending the greeting
 * @param modifier modifiers to pass to the composable
 */
@Composable
fun GreetingText(message: String, sender: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp).background(Color.Green),
    ) {
        Text(
            text = message,
            fontSize = 72.sp,
            lineHeight = 76.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Red)
        )
        Text(
            text = "From\n$sender",
            fontSize = 28.sp,
            lineHeight = 32.sp,
            textAlign = TextAlign.End,                  // Aligns Text in box
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
                .background(Color.Blue)                 // Aligns Box relative to parent
        )
    }
}



@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "My Preview",
    )
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {

        GreetingText("Happy Birthday Sam!", "Emma Stone",)
//        GreetingText(LoremIpsum(1000).values.joinToString(), "")
    }
}