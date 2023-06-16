package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
//                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = getString(R.string.happy_birthday_text),
                        sender = getString(R.string.sender),
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
        modifier = modifier
            .padding(8.dp)
//            .background(Color.Green)
    ) {
        Text(
            text = message,
            fontSize = 72.sp,
            lineHeight = 76.sp,
            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .background(Color.Red)
        )
        Text(
            text = buildString {
                append(stringResource(R.string.from))
                append(sender)
            },
            fontSize = 28.sp,
            lineHeight = 32.sp,
//            textAlign = TextAlign.Center,               // Center text method 1
//            textAlign = TextAlign.End,                  // Aligns Text in box
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)    // Center text method 2
//                .fillMaxWidth()                         // Center text method 1
//                .align(alignment = Alignment.End)       // Aligns Box relative to parent
//                .background(Color.Blue)
            /*
            Method 1 sets the text container to be max width and centers the text inside the
            container.
            Method 2 centers the text container in the column.
             */
        )
    }
}

/**
 * Android composable to place an image in a box and then invoke GreetingText()
 *
 * @param message greeting message to be passed to GreetingText()
 * @param sender name of person sending the message
 * @param modifier modifiers to pass to the composable
 */
@Composable
fun GreetingImage(message: String, sender: String, modifier: Modifier = Modifier) {
    val backgroundImage = painterResource(R.drawable.androidparty)
    Box {
        Image(
            painter = backgroundImage,
            contentDescription = stringResource(R.string.bg_img_description),
            contentScale = ContentScale.Crop,
            alpha = 0.5f,
        )
        GreetingText(
            message = message,
            sender = sender,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(
    showBackground = false,
    showSystemUi = true,
    name = "My Preview",
)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage(message = "Happy Birthday Sam!", sender = "Emma")
//        GreetingText("Happy Birthday Sam!", "Emma Stone",)
//        GreetingText(LoremIpsum(1000).values.joinToString(), "")
    }
}