package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

//region Main
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadScreen()
                }
            }
        }
    }
}
//endregion

//region Functions

/**
 * Text layout for each individual quadrant
 *
 * @param title title text for area
 * @param text main text for area
 * @param modifier modifier to be applied to the layout
 */
@Composable
fun Quadrant(title: String, text: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(
                    bottom = 16.dp
                )
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify,
            modifier = modifier
        )
    }
}

/**
 * Layout for the four Quadrants
 *
 * @param color_topLeft color for top left quadrant
 * @param title_topLeft title text for top left quadrant
 * @param text_topLeft main text for top left quadrant
 * @param color_topRight color for top right quadrant
 * @param title_topRight title text for top right quadrant
 * @param text_topRight main text for top right quadrant
 * @param color_bottomLeft color for bottom left quadrant
 * @param title_bottomLeft title text for bottom left quadrant
 * @param text_bottomLeft main text for bottom left quadrant
 * @param color_bottomRight color for bottom right quadrant
 * @param title_bottomRight title text for bottom right quadrant
 * @param text_bottomRight main text for bottom right quadrant
 * @param modifier modifier to be applied to the layout
 */
@Composable
fun QuadLayout(
    color_topLeft: Color,
    title_topLeft: String,
    text_topLeft: String,
    color_topRight: Color,
    title_topRight: String,
    text_topRight: String,
    color_bottomLeft: Color,
    title_bottomLeft: String,
    text_bottomLeft: String,
    color_bottomRight: Color,
    title_bottomRight: String,
    text_bottomRight: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        val mod = Modifier.weight(0.5f, true)
        // top row
        Row (
            modifier = mod
        ){
            // top left
            Surface(
                color = color_topLeft,
                modifier = mod
            ){
                Quadrant(
                    title = title_topLeft,
                    text = text_topLeft
                )
            }
            // top right
            Surface(
                color = color_topRight,
                modifier = mod
            ){
                Quadrant(
                    title = title_topRight,
                    text = text_topRight
                )

            }
        }
        // bottom row
        Row (
            modifier = mod
        ){
            // bottom left
            Surface(
                color = color_bottomLeft,
                modifier = mod
            ){
                Quadrant(
                    title = title_bottomLeft,
                    text = text_bottomLeft
                )
            }
            // bottom right
            Surface(
                color = color_bottomRight,
                modifier = mod
            ){
                Quadrant(
                    title = title_bottomRight,
                    text = text_bottomRight
                )
            }
        }
    }
}

/**
 * Displays QuadLayout on a screen
 *
 */
@Composable
fun QuadScreen() {
    QuadLayout(
        colorResource(R.color.purple_200),
        stringResource(R.string.text_composable_title),
        stringResource(R.string.text_composable_text),
        colorResource(R.color.purple_400),
        stringResource(R.string.image_composable_title),
        stringResource(R.string.image_composable_text),
        colorResource(R.color.purple_600),
        stringResource(R.string.row_composable_title),
        stringResource(R.string.row_composable_text),
        colorResource(R.color.purple_100),
        stringResource(R.string.column_composable_title),
        stringResource(R.string.column_composable_text)
    )
}

//endregion

//region Preview
@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        QuadScreen()
    }
}
//endregion