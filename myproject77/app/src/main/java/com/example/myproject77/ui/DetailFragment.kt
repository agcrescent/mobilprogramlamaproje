package com.example.myproject77.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.myproject77.R

class DetailFragment : Fragment() {

    val args : DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtName = view.findViewById<TextView>(R.id.txtStudentName)
        val txtAge = view.findViewById<TextView>(R.id.txtStudentAge)
        val txtNumber = view.findViewById<TextView>(R.id.txtStudentNumber)

        var studentName = ""
        var studentAge = ""
        var studentNumber = ""

        if (args.name == "")
            studentName = getString(R.string.unknown)
        else
            studentName = args.name

        if (args.age <= -1)
            studentAge = getString(R.string.unknown)
        else
            studentAge = args.age.toString()

        if (args.number <= -1)
            studentNumber = getString(R.string.unknown)
        else
            studentNumber = args.number.toString()

        txtName.text = getString(R.string.studentName, studentName)
        txtAge.text = getString(R.string.studentAge, studentAge)
        txtNumber.text = getString(R.string.studentNumber, studentNumber)


    }
}