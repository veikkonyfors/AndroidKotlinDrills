package fi.viware.emc2noactivitytabbed

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Adapt specific fragments to ViewPagers TabLayout
 */
class TabPagerAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // Return the fragment for the corresponding page
        return when (position) {
            0 -> ObserverFragment()
            1 -> TravelerFragment()
            else -> ObserverFragment()
        }
    }

    override fun getCount(): Int {
        // Return the total number of pages
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        // Return the title for the corresponding page
        return when (position) {
            0 -> "Observer"
            1 -> "Traveler"
            else -> "Page 3"
        }
    }
}