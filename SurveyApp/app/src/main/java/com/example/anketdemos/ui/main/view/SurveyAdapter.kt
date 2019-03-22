package com.example.anketdemos.ui.main.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anketdemos.R
import com.example.anketdemos.data.model.Survey
import kotlinx.android.synthetic.main.item_survey.view.*

class SurveyAdapter(var items: List<Survey>) : RecyclerView.Adapter<SurveyAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) = holder.run {
        onBind(p1)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_survey, p0, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(position: Int) {
            itemView.txtQuestion.text = items[position].content
        }
    }
}