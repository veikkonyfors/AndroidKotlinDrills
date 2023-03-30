package fi.viware.emc2noactivitytabbed

import androidx.lifecycle.ViewModel

class TravelerViewModel : ViewModel() {

    fun getTravelerProperTime(properTime: Double, relativeSpeed: Double): Double {
        return TimeDilation().getTravelerProperTime(properTime, relativeSpeed)
    }
}
