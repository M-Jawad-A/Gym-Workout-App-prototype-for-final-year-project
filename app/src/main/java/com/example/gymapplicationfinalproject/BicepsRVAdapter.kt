package com.example.gymapplicationfinalproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BicepsRVAdapter (
    // on below line we are passing variables as course list and context
    private var exerciseList: ArrayList<ExerciseRVTemplate>,
) : RecyclerView.Adapter<BicepsRVAdapter.ExerciseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BicepsRVAdapter.ExerciseViewHolder {
        // this method is use to inflate the layout file
        // which we have created for our recycler view.
        // on below line we are inflating our layout file.
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.exercise_rv_item,
            parent, false
        )

        // at last we are returning our view holder
        // class with our item View File.
        return ExerciseViewHolder(itemView)
    }

    // method for filtering our recyclerview items.
    fun filterList(filterlist: ArrayList<ExerciseRVTemplate>) {
        // below line is to add our filtered
        // list in our course array list.
        exerciseList = filterlist
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BicepsRVAdapter.ExerciseViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.
        holder.exerciseNameTV.text = exerciseList.get(position).exerciseName
        holder.exerciseIV.setImageResource(exerciseList.get(position).exerciseImg)
        // holder.exerciseCategoryTV.text = exerciseList.get(position).exerciseCategory
    }

    override fun getItemCount(): Int {
        // on below line we are returning
        // our size of our list
        return exerciseList.size
    }

    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are initializing our exercise name text view and our image view.
        val exerciseNameTV: TextView = itemView.findViewById(R.id.exerciseName)
        val exerciseIV: ImageView = itemView.findViewById(R.id.exerciseImage)
        // val exerciseCategoryTV: TextView= itemView.findViewById(R.id.idTVCourse)
    }

    class OnClickListener(val clickListener: (exercise: ExerciseRVTemplate) -> Unit) {
        fun onClick(exercise: ExerciseRVTemplate) = clickListener(exercise)
    }
}
