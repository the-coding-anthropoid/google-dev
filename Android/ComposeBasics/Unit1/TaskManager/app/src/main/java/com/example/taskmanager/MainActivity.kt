package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme


//region Main
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeTaskFailedActivity()
                }
            }
        }
    }
}
//endregion

//region Functions
/**
 * Generates activity output for a TaskComplete activity in a hypothetical TaskManager app.
 *
 */
@Composable
fun ComposeTaskCompleteActivity() {
    TaskFeedbackCard(
        img = painterResource(R.drawable.ic_task_completed),
        imgDesc = stringResource(R.string.tasks_completed_image_content_description),
        completedText = stringResource(R.string.tasks_completed_text),
        affirmationText = stringResource(R.string.tasks_completed_affirmation)
    )
}
/*
NOTES: This container function is not strictly necessary. I hypothesise it is probably best practice
based on the solution code for ComposeArticle and postulate two reasons -
1)  Most activities will contain more than one card element; and
2)  Handling parameters through an intermediary function will facilitate cleaner MainActivity and
    preview code.
3)  Can reuse the card in different scenarios...
*/

/**
 * Generates activity output for a TaskFailed activity in a hypothetical TaskManager app.
 *
 */
@Composable
fun ComposeTaskFailedActivity() {
    TaskFeedbackCard(
        img = painterResource(R.drawable.ic_task_failed),
        imgDesc = stringResource(R.string.tasks_failed_image_content_description),
        completedText = stringResource(R.string.tasks_failed_text),
        affirmationText = stringResource(R.string.tasks_failed_affirmation)
    )
}

/**
 * A card to inform the user as to the state of their task completion.
 *
 * @param img Image to use for card
 * @param imgDesc Description of image
 * @param completedText Task completion notification text
 * @param affirmationText Text to provide user with positive feedback
 * @param modifier The modifier to be applied to the card and its elements
 */
@Composable
fun TaskFeedbackCard(
    img: Painter,
    imgDesc: String,
    completedText: String,
    affirmationText: String,
    modifier: Modifier = Modifier
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
            ) {
        Image(
            painter = img,
            contentDescription = imgDesc,
            modifier = modifier
        )
        Text(
            text = completedText,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                    .padding(
                        top = 24.dp,
                        bottom = 8.dp
                    )
        )
        Text (
            text = affirmationText,
            fontSize = 16.sp,
            modifier = modifier
        )
    }
}
//endregion

//region Preview
@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        ComposeTaskCompleteActivity()
    }
}
//endregion