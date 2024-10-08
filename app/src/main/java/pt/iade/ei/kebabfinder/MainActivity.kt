package pt.iade.ei.kebabfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.kebabfinder.models.GeoCoord
import pt.iade.ei.kebabfinder.models.Restaurant
import pt.iade.ei.kebabfinder.ui.components.FeaturedItem
import pt.iade.ei.kebabfinder.ui.theme.KebabFinderTheme
import java.net.URI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KebabFinderTheme {
                // TODO: Get location from GPS.
                val location = GeoCoord(
                    latitude = 12.340,
                    longitude = 43.220
                )

                MainView(
                    currentLocation = location
                )
            }
        }
    }
}

@Composable
fun FeaturedItemRow(
    restaurants: List<Restaurant>,
    currentLocation: GeoCoord
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        for (restaurant in restaurants) {
            FeaturedItem(
                restaurant = restaurant,
                currentLocation = currentLocation
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(
    currentLocation: GeoCoord,
    modifier: Modifier = Modifier,
    featuredRestaurants: List<Restaurant> = listOf()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Top app bar")
                }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {

            FeaturedItemRow(
                restaurants = featuredRestaurants,
                currentLocation = currentLocation
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    val location = GeoCoord(
        latitude = 12.340,
        longitude = 43.220
    )

    val featuredRestaurants = listOf(
        Restaurant(
            id = 203040,
            name = "Palácio do Kebab",
            description = "O melhor kebab do bairro.",
            location = GeoCoord(
                latitude = 12.345,
                longitude = 43.210
            ),
            rating = 4.6f,
            address = "Rua do Kebab 123 - Santos\n1200-649 Lisboa",
            contacts = null,
            openingHours = null,
            image = URI.create(
                "https://c8.alamy.com/comp/ECYHK1/kebab-shop-fast-food-restaurant-on-city-road-in-east-london-uk-ECYHK1.jpg"
            )
        ),
        Restaurant(
            id = 203040,
            name = "Kebab House",
            description = "O melhor kebab do bairro.",
            location = GeoCoord(
                latitude = 12.338,
                longitude = 43.212
            ),
            rating = 3.2f,
            address = "Rua do Kebab 123 - Santos\n1200-649 Lisboa",
            contacts = null,
            openingHours = null,
            image = URI.create(
                "https://c8.alamy.com/comp/ECYHK1/kebab-shop-fast-food-restaurant-on-city-road-in-east-london-uk-ECYHK1.jpg"
            )
        ),
        Restaurant(
            id = 203040,
            name = "The Palace",
            description = "O melhor kebab do bairro.",
            location = GeoCoord(
                latitude = 12.338,
                longitude = 43.217
            ),
            rating = 4f,
            address = "Rua do Kebab 123 - Santos\n1200-649 Lisboa",
            contacts = null,
            openingHours = null,
            image = URI.create(
                "https://c8.alamy.com/comp/ECYHK1/kebab-shop-fast-food-restaurant-on-city-road-in-east-london-uk-ECYHK1.jpg"
            )
        )
    )

    KebabFinderTheme {
        MainView(
            currentLocation = location,
            featuredRestaurants = featuredRestaurants
        )
    }
}