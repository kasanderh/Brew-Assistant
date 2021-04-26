package com.kasanderh.newcoffeeapp

import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.layout_bottom_bar.*
import kotlinx.android.synthetic.main.layout_bottom_bar_two.*

class CustomBottomSheetDialogFragment: BottomSheetDialogFragment() {

    lateinit var counter: Chronometer
    private var timeWhenStopped: Long = 0L

    companion object {
        const val TAG = "BottomSheetDialogFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_bottom_bar_two, container, false)
//        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        counter = Chronometer(this.context)

        // onclickListeners here
        //start timer
        button_bottom_start_test.setOnClickListener {
            if(chronometer_bottom_bar.isActivated) {
                Toast.makeText(this.context, "Stopwatch is already running!", Toast.LENGTH_SHORT).show()
            } else if (!chronometer_bottom_bar.isActivated) {
                if(timeWhenStopped.equals(0)) {
                    chronometer_bottom_bar.text.toString()
                    chronometer_bottom_bar.base = SystemClock.elapsedRealtime()
                    chronometer_bottom_bar.start()
                } else {
                    chronometer_bottom_bar.base = SystemClock.elapsedRealtime() + timeWhenStopped
                    chronometer_bottom_bar.start()
                }
            }
        }

        button_bottom_stop_test.setOnClickListener {
            timeWhenStopped = chronometer_bottom_bar.base - SystemClock.elapsedRealtime()
            chronometer_bottom_bar.stop()
        }

        button_bottom_reset_test.setOnClickListener {
            chronometer_bottom_bar.base = SystemClock.elapsedRealtime()
            timeWhenStopped = 0
        }

        //stop timer

    }


}