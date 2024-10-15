package pt.iade.ei.kebabfinder.models

import android.location.Location
import androidx.compose.ui.graphics.Color
import java.io.Serializable
import kotlin.math.roundToInt

data class GeoCoord(
    val latitude: Double,
    val longitude: Double
) : Serializable {
    fun distanceFrom(startingPoint: GeoCoord): Int {
        val results = FloatArray(3)
        Location.distanceBetween(
            startingPoint.latitude,
            startingPoint.longitude,
            latitude, longitude,
            results
        )

        return results[0].roundToInt()
    }

    fun distanceColor(distance: Int): Color {
        return if (distance < 500) {
            Color.Green
        } else if ((distance >= 500) and (distance < 1000)) {
            Color.Yellow
        } else {
            Color.Red
        }
    }
}
