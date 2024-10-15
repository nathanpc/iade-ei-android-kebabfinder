package pt.iade.ei.kebabfinder

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.kebabfinder.models.Restaurant
import pt.iade.ei.kebabfinder.ui.theme.KebabFinderTheme

class RestaurantDetailActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KebabFinderTheme {
                val restaurant = intent.extras?.getSerializable(
                    "restaurant",
                    Restaurant::class.java
                )

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    if (restaurant != null) {
                        Greeting(
                            name = restaurant.name,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KebabFinderTheme {
        Greeting("Android")
    }
}