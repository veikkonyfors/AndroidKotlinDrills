package fi.viware.emc2noactivitytabbed

import org.junit.Before
import org.junit.Test
import kotlin.math.roundToInt

class TimeDilationTest {

    @Before
    fun setUp() {
    }

    @Test
    fun getSPEED_OF_LIGHT() {
    }

    @Test
    fun getStationaryObserverTime() {
        val stationaryTime = TimeDilation().getStationaryObserverTime(8.0, 180000000.0)
        println("relTime = ${stationaryTime.toInt()}")
        assert(stationaryTime.roundToInt() == 10)
    }

    @Test
    fun getTravelerProperTime() {
        val properTime = TimeDilation().getTravelerProperTime(10.0, 180000000.0)
        println("relTime = ${properTime}")
        assert(properTime.roundToInt() == 8)
    }
}