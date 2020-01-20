package com.alimasanov.beeapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.alimasanov.beeapp.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val rg: RadioGroup = root.findViewById(R.id.rg1)
        val button: Button = root.findViewById(R.id.button)


        rg.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{group, checkedId ->
            val radio: RadioButton = root.findViewById(checkedId)
            val index = rg.indexOfChild(activity!!.findViewById(checkedId))
            Toast.makeText(context, "${radio.text} $checkedId", Toast.LENGTH_SHORT).show()
        })

        return root
    }
}