package com.longsh.mvvm.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.longsh.mvvm.R
import com.longsh.mvvm.databinding.ItemTestBinding


/**
 * @author LongShaoHua
 * @date 2021/7/15
 */
class TestAdapter(private val context: Context) :
    RecyclerView.Adapter<TestAdapter.MyViewHolder>() {
    private var data: ArrayList<String> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_test,parent,false);
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding?.data = data[position]
        holder.binding?.executePendingBindings()
    }
    override fun getItemCount(): Int {
        return data.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ItemTestBinding? = DataBindingUtil.bind(view)
    }

    fun setList(data: ArrayList<String>){
        this.data = data
    }
}