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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.kebabfinder.models.GeoCoord
import pt.iade.ei.kebabfinder.models.Restaurant
import pt.iade.ei.kebabfinder.ui.components.FeaturedItem
import pt.iade.ei.kebabfinder.ui.components.RestaurantListItem
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
                    featuredRestaurants = ExampleRestaurants(),
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
            Text(
                text = "Featured Kebab Places",
                fontSize = 24.sp,
                modifier = Modifier.padding(
                    bottom = 10.dp
                )
            )
            FeaturedItemRow(
                restaurants = featuredRestaurants,
                currentLocation = currentLocation
            )

            Text(
                text = "Other Places to Eat",
                fontSize = 24.sp,
                modifier = Modifier.padding(
                    top = 30.dp
                )
            )
            RestaurantList(
                restaurants = featuredRestaurants,
                currentLocation = currentLocation
            )
        }
    }
}

@Composable
fun RestaurantList(
    restaurants: List<Restaurant>,
    currentLocation: GeoCoord
) {
    LazyColumn {
        items(restaurants) { restaurant ->
            RestaurantListItem(
                restaurant = restaurant,
                currentLocation = currentLocation
            )
        }
    }

    /*
    Column {
        for (restaurant in restaurants) {
            RestaurantListItem(
                restaurant = restaurant,
                currentLocation = currentLocation
            )
        }
    }
    */
}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    val location = GeoCoord(
        latitude = 12.340,
        longitude = 43.220
    )

    KebabFinderTheme {
        MainView(
            currentLocation = location,
            featuredRestaurants = ExampleRestaurants()
        )
    }
}

fun ExampleRestaurants(): List<Restaurant> {
    return listOf(
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
}
