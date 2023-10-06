package com.example.practicerecycler

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.practicerecycler.databinding.FragmentAddDetailsBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AddDetails : Fragment(){
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentAddDetailsBinding
    //lateinit var recAdapter: RecAdapter
    var model = Model()
    //val db = Firebase.firestore
    var list = ArrayList<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddDetailsBinding.inflate(layoutInflater)
        binding.addBtn.setOnClickListener {
            //list.add(Model(binding.name.text.toString(),binding.age.text.toString()))
//            Log.d("TAG--->",new.toString())
            var bundle = Bundle()
            bundle.putString("personName",binding.name.text.toString())
            bundle.putString("personAge",binding.age.text.toString())
           // recAdapter = RecAdapter(list, requireActivity())
            findNavController().navigate(R.id.action_addDetails_to_employeeList, bundle)
        }
        return binding.root
    }

//    private fun addItems(){
//        if (binding.name.text.isNullOrEmpty() || binding.age.text.isNullOrEmpty()) {
//            binding.name.setText("Enter details")
//        }
//        else{
////            db.collection("Employee")
////                .add(Model(binding.name.text.toString(),binding.age.text.toString())).addOnSuccessListener {
////                    Toast.makeText(requireActivity(),"Done",Toast.LENGTH_LONG).show()
////                }
////                .addOnFailureListener {
////                    Toast.makeText(requireActivity(), "Failure", Toast.LENGTH_LONG).show()
////                }
////            findNavController().navigate(R.id.action_addDetails_to_employeeList)
//            val new = list.add(Model(binding.name.text.toString(),binding.age.text.toString()))
//            Log.d("TAG--->",new.toString())
//            var bundle = Bundle()
//            bundle.putString("List",new.toString())
//            findNavController().navigate(R.id.action_addDetails_to_employeeList,bundle)
//        }
//    }

    //override fun delete(position: Int) {
//        db.collection("Employee").document(model.key?:"").delete()
//            .addOnSuccessListener {
//                Toast.makeText(requireActivity(),"Successfully deleted",Toast.LENGTH_LONG).show()
//            }
//            .addOnFailureListener {
//                Toast.makeText(requireActivity(),"Failure",Toast.LENGTH_LONG).show()
//            }
   // }
}