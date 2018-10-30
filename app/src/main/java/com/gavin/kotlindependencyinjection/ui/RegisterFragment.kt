package com.gavin.kotlindependencyinjection.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.gavin.kotlindependencyinjection.R

/**
 * description:
 * Created by liNan on 2018/10/16 14:14

 */
class RegisterFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_title_screen, container, false)
        view.findViewById<Button>(R.id.play_btn).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_title_screen_to_register)
        }

        return view
    }


}