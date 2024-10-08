package pt.iade.ei.kebabfinder.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.kebabfinder.models.GeoCoord
import pt.iade.ei.kebabfinder.models.Restaurant
import java.net.URI

@Composable
fun FeaturedItem(
    restaurant: Restaurant,
    currentLocation: GeoCoord
) {
    val distance = restaurant.location.distanceFrom(currentLocation)
    Column(
        modifier = Modifier.width(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StarRating(
            starSize = 20.dp,
            restaurant = restaurant
        )
        Text(
            text = restaurant.name,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "${distance}m",
            color = currentLocation.distanceColor(distance)
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