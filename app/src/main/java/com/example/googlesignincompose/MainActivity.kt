package com.example.googlesignincompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.googlesignincompose.ui.theme.GoogleSignInButtonLibraryTheme
import com.joyner.googlesignincomposelibrary.enums.Elevated
import com.joyner.googlesignincomposelibrary.enums.Fab
import com.joyner.googlesignincomposelibrary.enums.FabExtended
import com.joyner.googlesignincomposelibrary.enums.Filled
import com.joyner.googlesignincomposelibrary.enums.FilledTonal
import com.joyner.googlesignincomposelibrary.enums.LargeFab
import com.joyner.googlesignincomposelibrary.enums.Outlined
import com.joyner.googlesignincomposelibrary.enums.SmallFab
import com.joyner.googlesignincomposelibrary.enums.Text
import com.joyner.googlesignincomposelibrary.ui.GoogleSignButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleSignInButtonLibraryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GoogleSign()
                }
            }
        }
    }
}

@Composable
fun GoogleSign() {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GoogleSignButton(
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignButton(
            buttonType = Elevated(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignButton(
            buttonType = Filled(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignButton(
            buttonType = FilledTonal(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignButton(
            buttonType = Outlined(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignButton(
            buttonType = Text(),
            showIcon = false,
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignButton(
            modifier = Modifier.padding(8.dp),
            buttonType = Fab(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignButton(
            modifier = Modifier.padding(8.dp),
            buttonType = SmallFab(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignButton(
            modifier = Modifier.padding(8.dp),
            buttonType = LargeFab(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignButton(
            modifier = Modifier.padding(8.dp),
            buttonType = FabExtended(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignButton(
            modifier = Modifier.padding(8.dp),
            buttonType = FabExtended(),
            showIcon = false,
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GoogleSignInButtonLibraryTheme {
        GoogleSign()
    }
}