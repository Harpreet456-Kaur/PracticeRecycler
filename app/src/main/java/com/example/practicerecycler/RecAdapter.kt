package com.example.practicerecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.practicerecycler.databinding.EmployeeLayoutBinding

class RecAdapter(val list: ArrayList<Model>, var recInterface: RecInterface) : RecyclerView.Adapter<RecAdapter.viewHolder>(){
    inner class viewHolder(val binding : EmployeeLayoutBinding)
        : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding = EmployeeLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.binding.name.text = list[position].name
        holder.binding.age.text = list[position].age

        holder.itemView.setOnClickListener {
            recInterface.delete(position)
        }
    }
}