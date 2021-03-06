package com.gavin.kotlindependencyinjection.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gavin.kotlindependencyinjection.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [PersonalFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [PersonalFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class PersonalFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal, container, false)
    }


}
