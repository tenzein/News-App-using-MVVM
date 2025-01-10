package com.sherpa.news_template_1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sherpa.news_template_1.databinding.SearchTabRecyclerViewSingleItemBinding
import com.sherpa.news_template_1.model.Article

/**
 * CREATED BY->
 * @Author: "Tenzing Sherpa"
 * @Email: "tenzingsherpaaa@gmail.com
 * @Date: 2025-01-09
 */
class SearchTabRecyclerViewAdapter : RecyclerView.Adapter<SearchTabRecyclerViewAdapter.SearchViewHolder>() {


    private val diffCallBack  = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(
            oldItem: Article,
            newItem: Article
        ): Boolean {
          return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(
            oldItem: Article,
            newItem: Article
        ): Boolean {
            return oldItem == newItem
        }

    }

    var differ = AsyncListDiffer(this,diffCallBack)


    private lateinit var binding: SearchTabRecyclerViewSingleItemBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchViewHolder {
        binding = SearchTabRecyclerViewSingleItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  SearchViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: SearchViewHolder,
        position: Int
    ) {
       val article = differ.currentList[position]
        with(holder){
            holder.itemView.apply {

            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class SearchViewHolder( binding: SearchTabRecyclerViewSingleItemBinding) : RecyclerView.ViewHolder(binding.root)
}