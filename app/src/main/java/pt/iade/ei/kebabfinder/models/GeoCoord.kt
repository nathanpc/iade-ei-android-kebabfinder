package pt.iade.ei.kebabfinder.models

import android.location.Location
import kotlin.math.roundToInt

data class GeoCoord(
    val latitude: Double,
    val longitude: Double
) {
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
}
