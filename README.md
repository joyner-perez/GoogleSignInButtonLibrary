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
