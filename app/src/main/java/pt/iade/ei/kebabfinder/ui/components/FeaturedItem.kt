package pt.iade.ei.kebabfinder.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import kotlin.math.roundToInt

@Composable
fun FeaturedItem(
    stars: Float,
    name: String,
    distance: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${stars.roundToInt()} stars",
            color = Color.hsv(0.54f, 0.61f, 0.84f)
        )
        Text(
            text = name,
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
    FeaturedItem(
        stars = 4.6f,
        name = "Palácio do Kebab",
        distance = 800
    )
}