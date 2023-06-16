package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

//region Main

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        val horizontalPadding = Modifier.padding(
                            horizontal = integerResource(R.integer.padding_amount).dp
                        )
                        val padding = Modifier.padding(
                            integerResource(R.integer.padding_amount).dp
                        )
                        HeaderImage(
                            img =  painterResource(R.drawable.bg_compose_background),
                        )
                        TitleText(
                            text = stringResource(R.string.page_title),
                            modifier = padding
                        )
                        NormalText(
                            text = stringResource(R.string.intro_text),
                            modifier = horizontalPadding
                        )
                        NormalText(
                            stringResource(R.string.main_text),
                            modifier = padding
                        )
                    }
                }
            }
        }
    }
}

//endregion

//region Functions

/**
 * Render header image to fit width of container
 *
 * @param img image to render
 * @param modifier modifiers to apply
 */
@Composable
fun HeaderImage(img: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = img,
        contentDescription = "a decorative header image",
        modifier = modifier
            .fillMaxWidth()
    )
}

/**
 * Render Title text
 *
 * @param text title to render
 * @param modifier modifiers to apply
 */
@Composable
fun TitleText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = integerResource(R.integer.title_size).sp,
        modifier = modifier
    )
}

/**
 * Render Normal text
 *
 * @param text text to render
 * @param modifier modifiers to apply
 */
@Composable
fun NormalText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        textAlign = TextAlign.Justify,
        modifier = modifier
    )
}

//endregion

//region Previews

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun ArticlePreview() {
    ComposeArticleTheme {
        Column {
            val horizontalPadding = Modifier.padding(horizontal = 16.dp)
            val padding = Modifier.padding(16.dp)
            HeaderImage(
                img =  painterResource(R.drawable.bg_compose_background),
            )
            TitleText(
                text = stringResource(R.string.page_title),
                modifier = padding
            )
            NormalText(
                text = stringResource(R.string.intro_text),
                modifier = horizontalPadding
            )
            NormalText(
                stringResource(R.string.main_text),
                modifier = padding
            )
        }
    }
}

//endregion