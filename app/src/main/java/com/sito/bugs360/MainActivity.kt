package com.sito.bugs360

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sito.bugs360.ui.theme.Bugs360Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bugs360Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ShowImage()
                }
            }
        }
    }
}

@Preview
@Composable
fun ShowImage() {
    var image by remember {
        mutableStateOf(R.drawable.ixodus_ricinus_a)
    }
    val start = R.drawable.ixodus_ricinus_a

    //var offsetX by remember { mutableStateOf(0f) }
    var del by remember {
        mutableStateOf(0f)
    }

    var d by remember {
        mutableStateOf(R.drawable.ixodus_ricinus_a)
    }

    Column() {
        Image(
            modifier = Modifier
                .padding(5.dp)
                .draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { delta ->
                        d = image
                        del = delta
                        if (del > 0) {
                            d++
                        } else {
                            d--
                        }
                        if (d > start + 17)
                            d = start
                        else if (d < start)
                            d = start + 17
                        image = d
                        del = delta
                        //offsetX = delta
                        delta
                    }
                ),
            contentDescription = "",
            painter = painterResource(id = image)
        )
        Text(text=image.toString())
        Text(text=start.toString())
        Text(text=d.toString())
        /*Button(onClick = {
            image++
            if (image > start + 17)
                image = start
            else if (image < start - 17)
                image = start + 18
        }) {
            Text(text = "add")
        }*/
    }
}