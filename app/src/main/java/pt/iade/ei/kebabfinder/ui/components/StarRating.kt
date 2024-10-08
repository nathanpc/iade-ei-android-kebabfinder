package pt.iade.ei.kebabfinder.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pt.iade.ei.kebabfinder.R
import pt.iade.ei.kebabfinder.models.GeoCoord
import pt.iade.ei.kebabfinder.models.Restaurant
import java.net.URI
import kotlin.math.roundToInt

@Composable
fun StarRating(
    restaurant: Restaurant,
    starSize: Dp = 24.dp
) {
    val stars = restaurant.rating.roundToInt()
    Row {
        for (i in 1..stars) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.star_rate),
                contentDescription = "$stars stars",
                modifier = Modifier.width(starSize)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StarRatingPreview() {
    Column {
        for (i in 0..5) {
            StarRating(
                restaurant = Restaurant(
                    id = 0,
                    name = "",
                    description = "",
                    location = GeoCoord(
                        latitude = 12.345,
                        longitude = 43.210
                    ),
                    rating = i.toFloat(),
                    address = "",
                    contacts = null,
                    openingHours = null,
                    image = URI.create("")
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StarRatingPreviewSizing() {
    Column {
        for (i in 0..5) {
            StarRating(
                starSize = (i * 10).dp,
                restaurant = Restaurant(
                    id = 0,
                    name = "",
                    description = "",
                    location = GeoCoord(
                        latitude = 12.345,
                        longitude = 43.210
                    ),
                    rating = i.toFloat(),
                    address = "",
                    contacts = null,
                    openingHours = null,
                    image = URI.create("")
                )
            )
        }
    }
}
