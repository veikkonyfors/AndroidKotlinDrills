package fi.viware.emc2noactivitytabbed

import androidx.lifecycle.ViewModel

class ObserverViewModel : ViewModel() {

    fun getStationaryObserverTime(properTime: Double, relativeSpeed: Double): Double {
        return TimeDilation().getStationaryObserverTime(properTime, relativeSpeed)
    }

}
