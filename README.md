[![](https://jitpack.io/v/joyner-perez/GoogleSignInButtonLibrary.svg)](https://jitpack.io/#joyner-perez/GoogleSignInButtonLibrary)
# Google Sign In button library for jetpack compose

Google Sign In button for compose, it will help you to create your Google button and reduce the code you have to write.
In the future I will be adding more features, if you have any suggestion let me know and I will analyze it.

**Show app folder example for more help**

**With Kotlin**

⚙️ How to install
--
1. Add it in your root build.gradle at the end of repositories:

		allprojects {
			repositories {
				...
				maven { url 'https://jitpack.io' }
			}
		}

2. Add the dependency:

		dependencies {
			implementation 'com.github.joyner-perez:GoogleSignInButtonLibrary:(insert latest version)'
		}

🕹 How to use:
--
	val context = LocalContext.current
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
		GoogleSignInFullButton(
            tokenClientId = stringResource(id = R.string.default_web_client_id),// Your token client id
            onClick = {
                Toast.makeText(context, "Result: ${it.result}, token: ${it.idToken}", Toast.LENGTH_SHORT).show()
            }
        )

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
    }
