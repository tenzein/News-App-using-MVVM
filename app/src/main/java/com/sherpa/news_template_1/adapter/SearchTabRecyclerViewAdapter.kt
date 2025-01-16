package com.sherpa.news_template_1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sherpa.news_template_1.R
import com.sherpa.news_template_1.databinding.SearchTabRecyclerViewSingleItemBinding
import com.sherpa.news_template_1.model.Article
import com.sherpa.news_template_1.util.getTimeAgo
import kotlin.random.Random

/**
 * CREATED BY->
 * @Author: "Tenzing Sherpa"
 * @Email: "tenzingsherpaaa@gmail.com
 * @Date: 2025-01-09
 */
class SearchTabRecyclerViewAdapter :
    RecyclerView.Adapter<SearchTabRecyclerViewAdapter.SearchViewHolder>() {


    private val diffCallBack = object : DiffUtil.ItemCallback<Article>() {
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

    var differ = AsyncListDiffer(this, diffCallBack)


    private lateinit var binding: SearchTabRecyclerViewSingleItemBinding

    private var onItemClickListener: ((Article) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchViewHolder {
        binding = SearchTabRecyclerViewSingleItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: SearchViewHolder,
        position: Int
    ) {
        val article = differ.currentList[position]
        with(holder) {
            holder.itemView.apply {
                Glide.with(this).load(article.urlToImage).placeholder(R.drawable.placeholder)
                    .into(binding.imgSingleSearchItem)
                binding.txtTitle.text = article.title
                binding.txtTime.text = getTimeAgo(article.publishedAt.toString())
                binding.txtViews.text =
                    StringBuilder().append(Random.nextInt(200, 5000)).append(" Views")

                binding.clSearchMain.setOnClickListener {
                    onItemClickListener?.let { it(article) }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }

    inner class SearchViewHolder(binding: SearchTabRecyclerViewSingleItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}