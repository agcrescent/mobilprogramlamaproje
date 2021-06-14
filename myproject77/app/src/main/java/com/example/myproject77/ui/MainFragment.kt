package com.example.myproject77.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.navigation.findNavController
import com.example.myproject77.R
import com.example.myproject77.models.Student

class MainFragment : Fragment() {

    private lateinit var listview : ListView
    private lateinit var students: ArrayList<Student>
    private lateinit var names: ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeVariables()
        fillListView()
        setAdapter()
        listenListView()
    }

    private fun initializeVariables(){
        listview = requireView().findViewById(R.id.listView)
    }

    private fun fillListView(){
        students = ArrayList()
        names = ArrayList()

        val std1 = Student("Fatma", 17,1967)
        val std2 = Student("Öznur", 18,1905)
        val std3 = Student("Eray", 20,-1)
        val std4 = Student("Emir", -1,1903)
        val std5 = Student("Beyza", 21,1907)

        students.add(std1)
        students.add(std2)
        students.add(std3)
        students.add(std4)
        students.add(std5)


        names.add(std1.name)
        names.add(std2.name)
        names.add(std3.name)
        names.add(std4.name)
        names.add(std5.name)
    }

    private fun setAdapter(){
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, names)

        listview.adapter = adapter
    }

    private fun listenListView(){

        listview.setOnItemClickListener{_,_,position,_ ->
            val action = MainFragmentDirections.actionMainFragmentToDetailFragment(students[position].name, students[position].age, students[position].number)

            requireView().findNavController().navigate(action)
        }

    }
}