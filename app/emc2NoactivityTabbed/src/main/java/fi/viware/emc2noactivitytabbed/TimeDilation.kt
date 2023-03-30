package fi.viware.emc2noactivitytabbed

import kotlin.math.sqrt

class TimeDilation {

    val SPEED_OF_LIGHT = 299792458

    /**
     * Get time passed for stationary observer corresponding the given proper time of object moving at given relative speed
     */
    fun getStationaryObserverTime(properTime: Double, relativeSpeed: Double): Double {

        val rspow2 = relativeSpeed * relativeSpeed
        val cpow2 = SPEED_OF_LIGHT.toDouble() * SPEED_OF_LIGHT.toDouble()
        val r = rspow2 / cpow2
        val tmp = (1 - r)
        val s = sqrt(tmp)
        var res = 1/(sqrt((1-relativeSpeed.toDouble()*relativeSpeed.toDouble()/SPEED_OF_LIGHT.toDouble()*SPEED_OF_LIGHT.toDouble()).toDouble()))
        val lorenz =
            1 / sqrt((1 - (relativeSpeed.toDouble() * relativeSpeed.toDouble()) / (SPEED_OF_LIGHT.toDouble() * SPEED_OF_LIGHT.toDouble())).toDouble())
        return (properTime * lorenz)  //t'=t_0/sqrt(1-v2/c2)
    }

    /**
     * Get proper time of an object moving at given relative speed, which corresponds to time passed for stationary observer
     */
    fun getTravelerProperTime(stationaryTime: Double, relativeSpeed: Double): Double {
        val lorenz =
            1 / sqrt((1 - (relativeSpeed.toDouble() * relativeSpeed.toDouble()) / (SPEED_OF_LIGHT.toDouble() * SPEED_OF_LIGHT.toDouble())).toDouble())
        return (stationaryTime / lorenz)  //t_0=t' * sqrt(1-v2/c2)
    }


}
