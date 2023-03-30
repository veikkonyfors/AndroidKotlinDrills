package fi.viware.emc2noactivitytabbed

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.roundToInt


/**
 * Time dilation from stationary object's frame
*/
class ObserverFragment : Fragment() {

    companion object {
        fun newInstance() = ObserverFragment()
    }

    private lateinit var viewModel: ObserverViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_observer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ObserverViewModel::class.java)
        // TODO: Use the ViewModel

        val editTextRelativeSpeed = view.findViewById<EditText>(R.id.edTxt_RelativeSpeed)
        val editTextProperTime = view.findViewById<EditText>(R.id.edTxt_StationaryTime)
        val textViewObservedTime = view.findViewById<TextView>(R.id.txt_ProperTime)

        val btnCalculate = view.findViewById<Button>(R.id.btn_Calculate)
        btnCalculate.setOnClickListener { view ->
            val relativeSpeed = editTextRelativeSpeed.text.toString()
            val properTime = editTextProperTime.text.toString()

            textViewObservedTime.text =
                viewModel.getStationaryObserverTime(properTime.toDouble(), relativeSpeed.toDouble())
                    .roundToInt()
                    .toString()


            //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //    .setAction("Action", null).show()
        }
    }
}