package io.homeassistant.companion.android.sensors

import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * Converts mainland-China GCJ-02 coordinates returned by AMap to WGS-84
 * coordinates expected by Home Assistant. AMap already returns WGS-84 abroad.
 */
internal object AMapCoordinateConverter {
    fun toWgs84(latitude: Double, longitude: Double): Pair<Double, Double> {
        if (longitude !in 72.004..137.8347 || latitude !in 0.8293..55.8271) {
            return latitude to longitude
        }

        val pi = Math.PI
        val axis = 6378245.0
        val eccentricitySquared = 0.006693421622965943
        val x = longitude - 105.0
        val y = latitude - 35.0

        var deltaLatitude = transformLatitude(x, y)
        var deltaLongitude = transformLongitude(x, y)
        val radians = latitude / 180.0 * pi
        val magic = 1.0 - eccentricitySquared * sin(radians) * sin(radians)
        val sqrtMagic = sqrt(magic)

        deltaLatitude = deltaLatitude * 180.0 /
            (axis * (1.0 - eccentricitySquared) / (magic * sqrtMagic) * pi)
        deltaLongitude = deltaLongitude * 180.0 /
            (axis / sqrtMagic * cos(radians) * pi)

        return (latitude - deltaLatitude) to (longitude - deltaLongitude)
    }

    private fun transformLatitude(x: Double, y: Double): Double {
        var result = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y +
            0.1 * x * y + 0.2 * sqrt(abs(x))
        result += (20.0 * sin(6.0 * x * Math.PI) + 20.0 * sin(2.0 * x * Math.PI)) * 2.0 / 3.0
        result += (20.0 * sin(y * Math.PI) + 40.0 * sin(y / 3.0 * Math.PI)) * 2.0 / 3.0
        result += (160.0 * sin(y / 12.0 * Math.PI) + 320.0 * sin(y * Math.PI / 30.0)) * 2.0 / 3.0
        return result
    }

    private fun transformLongitude(x: Double, y: Double): Double {
        var result = 300.0 + x + 2.0 * y + 0.1 * x * x +
            0.1 * x * y + 0.1 * sqrt(abs(x))
        result += (20.0 * sin(6.0 * x * Math.PI) + 20.0 * sin(2.0 * x * Math.PI)) * 2.0 / 3.0
        result += (20.0 * sin(x * Math.PI) + 40.0 * sin(x / 3.0 * Math.PI)) * 2.0 / 3.0
        result += (150.0 * sin(x / 12.0 * Math.PI) + 300.0 * sin(x / 30.0 * Math.PI)) * 2.0 / 3.0
        return result
    }
}
