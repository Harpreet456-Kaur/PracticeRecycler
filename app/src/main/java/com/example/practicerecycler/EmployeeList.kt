package com.example.practicerecycler

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicerecycler.databinding.FragmentEmployeeListBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class EmployeeList : Fragment(), RecInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentEmployeeListBinding
    lateinit var recAdapter : RecAdapter
    var list = ArrayList<Model>()
    //val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
//        db.collection("Employee").addSnapshotListener { value, error ->
//            if (value != null)
//                for (snapshots in value!!.documentChanges){
//                    when (snapshots.type) {
//                        DocumentChange.Type.ADDED -> {
//                            var model = Model()
//                            model = snapshots.document.toObject(Model::class.java)
//                            model.key = snapshots.document.id ?: ""
//                            list.add(model)
//                            recAdapter.notifyDataSetChanged()
//                        }
//                        DocumentChange.Type.REMOVED -> {
//                            var model = Model()
//                            model = snapshots.document.toObject(Model::class.java)
//                            model.key = snapshots.document.id ?: ""
//                            for (i in 0..list.size - 1) {
//                                if ((snapshots.document.id ?: "").equals(list[i].key)) {
//                                    list.removeAt(i)
//                                    break
//                                }
//                            }
//                            recAdapter.notifyDataSetChanged()
//                        }
//                        else -> {}
//                    }
//                }
//            binding.recycler.clearFocus()
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmployeeListBinding.inflate(layoutInflater)

        recAdapter = RecAdapter(list,this)
        binding.recycler.adapter = recAdapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())

        binding.floatingBtn.setOnClickListener {
            findNavController().navigate(R.id.action_employeeList_to_addDetails)
        }

        val name = arguments?.getString("personName")
        val age = arguments?.getString("personAge")

        //binding.recycler.adapter = recAdapter
        list.clear()
        //list.add(Model(name.toString(),age.toString()))
        list.add(Model(name,age))
        //recAdapter.notifyDataSetChanged()


//        try {
//            binding.name.text = name.toString()
//            binding.age.text = age.toString()
//        } catch (e: Exception) {
//            e.printStackTrace()
//            Log.d("TAG----->", e.message.toString())
//        }


        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EmployeeList().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun delete(position: Int) {
        list.removeAt(position)
        recAdapter.notifyDataSetChanged()
        }
}