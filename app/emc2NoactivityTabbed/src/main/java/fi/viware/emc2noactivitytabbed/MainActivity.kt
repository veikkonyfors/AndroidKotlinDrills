package fi.viware.emc2noactivitytabbed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

/**
 * emc2noactivitytabbed app provides assistance for special relativity calculations.
 *
 * Currently there is functionality to compute Time Dilation only.<br>
 * For stationary observer's reference frame in one tab and for traveling object's frame
 * in another.
 *
 * This app also serves as a playground for me to learn how a tabbed activity is composed
 * from scratch, without using any of templates available in Android Studio.<br>
 * Those templates mostly tend to be too complicated in my taste to start with.
 *
 * To start with noactivity template and then adding flesh on the bones enables one to understand
 * more deeply what really is going on.<br>
 * Notes on steps below.
 *
 * 20230327, VN/ViWare:
 *
 * **I To create a plain tabbed app**:
 * - Add MainActivity.kt
 * - Add ViewPager and TabLayout elements to activity_main.xml, A'la chatGPT
 * - Obtain viewPager from layout (in code //1)
 * - Obtain tabLayout from layout (//2)
 * - Create class TabPagerAdapter, A'la chatGPT
 * - Instantiate TabPagerAdapter to adapter (//3)
 * - Add adapter to viewPager (//4)
 * - Set up tabLayout with viewPager:(//5)
 *  -This apparently fires up whatever intent is under tab 0 of TabPagerAdapter, which is
 *   ObserverFragment(), see TabPagerAdapter for more
 *   In basic MainActivity first intent is simply fired up by 'setContentView(R.layout.activity_main)'<br>
 *   Alternatively, one could replace MainActivty's container with TabFragment as follows:<br>
 *   MainActivity could replace it's intent by calling:<br>
 *           if (savedInstanceState == null) {<br>
 *              supportFragmentManager.beginTransaction()<br>
 *              .replace(R.id.container, TabFragment.newInstance())<br>
 *              .commitNow()<br>
 *              }<br>
 *   in which case ViewPager and TabLayout should be in TabFragment's layout, not in MainActivity's.<br>
 *   TabFragment then makes use of TabPagerAdapter the same way as MainActivity above.
 *   This was the case in emc2_fragment_viewmodel sample
 *
 * - Add activity entry point into androidmanifest.xml (tools:context=".MainActivity")
 * <br><br>
 *
 * **II Make use of ViewModel**<br>
 * It is recommended to have a ViewModel per fragment (or activity).
 * - Add TimeDilation with method
 *         getStationaryObserverTime(properTime: Double, relativeSpeed: Double): Double
 * - Add ObserverFragment
 * - Add ObserverViewModel
 * - Add method getStationaryObserverTime into ObserverViewModel, which makes use of
 *   TimeDilation().getStationaryObserverTime
 * - Populate GUI textfield in ObserverFragment with viewModel.getStationaryObserverTime(....)
 *
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager = findViewById(R.id.pager) //1
        val tabLayout: TabLayout = findViewById(R.id.tabLayout) //2

    // Create a FragmentPagerAdapter to handle the pages in the ViewPager
            val adapter = TabPagerAdapter(supportFragmentManager) //3
            viewPager.adapter = adapter //4)

    // Attach the TabLayout to the ViewPager
            tabLayout.setupWithViewPager(viewPager) //5)
    }

}