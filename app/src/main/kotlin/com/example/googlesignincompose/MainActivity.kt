package com.example.googlesignincompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.googlesignincompose.ui.theme.GoogleSignInButtonLibraryTheme
import com.joyner.googlesignincomposelibrary.models.types.Elevated
import com.joyner.googlesignincomposelibrary.models.types.Fab
import com.joyner.googlesignincomposelibrary.models.types.FabExtended
import com.joyner.googlesignincomposelibrary.models.types.Filled
import com.joyner.googlesignincomposelibrary.models.types.FilledTonal
import com.joyner.googlesignincomposelibrary.models.types.IconFilled
import com.joyner.googlesignincomposelibrary.models.types.IconFilledTonal
import com.joyner.googlesignincomposelibrary.models.types.IconOutlined
import com.joyner.googlesignincomposelibrary.models.types.IconStandard
import com.joyner.googlesignincomposelibrary.models.types.LargeFab
import com.joyner.googlesignincomposelibrary.models.types.Outlined
import com.joyner.googlesignincomposelibrary.models.types.SmallFab
import com.joyner.googlesignincomposelibrary.models.types.Text
import com.joyner.googlesignincomposelibrary.ui.GoogleSignInButton
import com.joyner.googlesignincomposelibrary.ui.GoogleSignInFullButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            GoogleSignInButtonLibraryTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    contentWindowInsets = WindowInsets.safeContent
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        GoogleSign()
                    }
                }
            }
        }
    }
}

@Composable
fun GoogleSign() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GoogleSignInButton(
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignInButton(
            buttonType = Elevated(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignInButton(
            buttonType = Filled(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignInButton(
            buttonType = FilledTonal(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignInButton(
            buttonType = Outlined(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignInButton(
            buttonType = Text(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignInButton(
            buttonType = Text(),
            showIcon = false,
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignInButton(
            modifier = Modifier.padding(8.dp),
            buttonType = Fab(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignInButton(
            modifier = Modifier.padding(8.dp),
            buttonType = SmallFab(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignInButton(
            modifier = Modifier.padding(8.dp),
            buttonType = LargeFab(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignInButton(
            modifier = Modifier.padding(8.dp),
            buttonType = FabExtended(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignInButton(
            modifier = Modifier.padding(8.dp),
            buttonType = FabExtended(),
            showIcon = false,
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignInButton(
            modifier = Modifier.padding(8.dp),
            buttonType = IconFilled(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignInButton(
            modifier = Modifier.padding(8.dp),
            buttonType = IconFilledTonal(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignInButton(
            modifier = Modifier.padding(8.dp),
            buttonType = IconOutlined(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignInButton(
            modifier = Modifier.padding(8.dp),
            buttonType = IconStandard(),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        )

        GoogleSignInFullButton(
            tokenClientId = stringResource(id = R.string.default_web_client_id), // Your token client id
            onClick = {
                Toast.makeText(
                    context,
                    "Result: ${it.result}, token: ${it.idToken}",
                    Toast.LENGTH_SHORT
                ).show()
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
