package pt.iade.ei.kebabfinder.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.kebabfinder.models.GeoCoord
import pt.iade.ei.kebabfinder.models.Restaurant
import java.net.URI
import kotlin.math.roundToInt

@Composable
fun FeaturedItem(
    restaurant: Restaurant,
    currentLocation: GeoCoord
) {
    val distance = restaurant.location.distanceFrom(currentLocation)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${restaurant.rating.roundToInt()} stars",
            color = Color.hsv(0.54f, 0.61f, 0.84f)
        )
        Text(
            text = restaurant.name,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "${distance}m",
            color = if (distance < 500) Color.Green
                else if ((distance >= 500) and (distance < 1000)) Color.Yellow
                else Color.Red
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FeaturedItemPreview() {
    val restaurant = Restaurant(
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
    )
    FeaturedItem(
        restaurant = restaurant,
        currentLocation = GeoCoord(
            latitude = 12.340,
            longitude = 43.220
        )
    )
}