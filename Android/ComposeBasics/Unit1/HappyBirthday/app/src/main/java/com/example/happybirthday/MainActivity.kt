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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

//region Main

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
                    Screen(
                        bgImg = painterResource(R.drawable.androidparty),
                        msg = stringResource(R.string.happy_birthday_text),
                        sender = stringResource(R.string.sender),
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

//endregion

//region Functions

/**
 * Manages display for entire screen
 *
 * @param bgImg image to display in the background
 * @param msg main message
 * @param sender name of sender
 * @param modifier universal modifiers to be applied to all elements
 */
@Composable
fun Screen(
    bgImg: Painter,
    msg: String,
    sender: String,
    modifier: Modifier = Modifier) {
    Box {
        BackgroundImage(img = bgImg )
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
        ) {
            MessageText(
                msg = msg,
                modifier = modifier
            )
            SenderText(
                sender = sender,
                modifier = modifier
            )
        }
    }
}

/**
 * Renderers the background image to fill the entire screen at half opacity
 *
 * @param img img to display
 * @param modifier modifier to apply to elements
 */
@Composable
fun BackgroundImage(img: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = img,
        contentDescription = stringResource(R.string.bg_img_description),
        contentScale = ContentScale.Crop,
        alpha = 0.5f,
        modifier = modifier
    )
}

/**
 * Renders message text to screen.
 *
 * Sets size and alignment
 *
 * @param msg message to display
 * @param modifier modifier to apply to elements
 */
@Composable
fun MessageText(msg: String, modifier: Modifier = Modifier) {
    Text(
        text = msg,
        fontSize = 64.sp,
        lineHeight = 72.sp,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

/**
 * Renders sender text to screen
 *
 * @param sender name of sender
 * @param modifier modifier to apply to elements
 */
@Composable
fun SenderText(sender: String, modifier: Modifier = Modifier) {
    Text(
        text = buildString {
            append(stringResource(R.string.from))
            append(sender) },
        fontSize = 28.sp,
        lineHeight = 32.sp,
        textAlign = TextAlign.End,
        modifier = modifier
    )
}

//endregion

//region Previews

@Preview(
    showBackground = false,
    showSystemUi = true,
    name = "My Preview",
)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        Screen(
            bgImg = painterResource(R.drawable.androidparty),
            msg = stringResource(R.string.happy_birthday_text),
            sender = stringResource(R.string.sender),
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

//endregion

