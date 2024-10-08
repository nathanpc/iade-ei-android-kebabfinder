package pt.iade.ei.kebabfinder.ui.components

import android.location.Location
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import pt.iade.ei.kebabfinder.models.GeoCoord
import pt.iade.ei.kebabfinder.models.Restaurant
import java.net.URI

@Composable
fun RestaurantListItem(
    restaurant: Restaurant,
    currentLocation: GeoCoord
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(
            horizontal = 10.dp,
            vertical = 15.dp
        )
    ) {
        Text("Image here")

        Column(
            modifier = Modifier.padding(start = 10.dp)
        ) {
            Text(
                text = restaurant.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Text(
                text = restaurant.description,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            // Shows how to make things expand and show side-by-side.
            Row(
                modifier = Modifier.fillMaxWidth(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val distance = restaurant.location.distanceFrom(currentLocation)
                StarRating(
                    restaurant = restaurant
                )

                Row {
                    Text(
                        text = "${distance}m",
                        color = currentLocation.distanceColor(distance),
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Text(" - ")
                    if (restaurant.isOpenNow()) {
                        Text(
                            text = "Open",
                            color = Color.Green
                        )
                    } else {
                        Text(
                            text = "Closed",
                            color = Color.Red
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RestaurantListItemPreview() {
    val location = GeoCoord(
        latitude = 12.340,
        longitude = 43.220
    )
    val restaurant = Restaurant(
        id = 203040,
        name = "Palácio do Kebab",
        description = "O melhor kebab do bairro. Et tempora est maiores quaerat atque voluptatem " +
                "qui ducimus. Recusandae expedita ut beatae id aperiam voluptas. Ut fugiat vel.",
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

    RestaurantListItem(
        restaurant = restaurant,
        currentLocation = location
    )
}