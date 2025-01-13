package com.sherpa.news_template_1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sherpa.news_template_1.R
import com.sherpa.news_template_1.databinding.BreakingNewsRvSingleItemBinding
import com.sherpa.news_template_1.model.Article
import com.sherpa.news_template_1.util.getTimeAgo

/**
 * CREATED BY->
 * @Author: "Tenzing Sherpa"
 * @Email: "tenzingsherpaaa@gmail.com
 * @Date: 2024-12-27
 */
class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    inner class NewsViewHolder(binding: BreakingNewsRvSingleItemBinding) :
        RecyclerView.ViewHolder(binding.root)

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

    val differ = AsyncListDiffer(this, diffCallBack)

    private lateinit var binding: BreakingNewsRvSingleItemBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsViewHolder {

        binding = BreakingNewsRvSingleItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: NewsViewHolder,
        position: Int
    ) {
        val article = differ.currentList[position]
        with(holder) {
            holder.itemView.apply {

                Glide.with(this).load(article.urlToImage).placeholder(R.drawable.placeholder)
                    .into(binding.imgArticle)
                binding.txtTitle.text = article.title
                binding.txtTime.text = getTimeAgo(article.publishedAt.toString())
                binding.txtPublisher.text = StringBuilder().append("By ${article.source.name}")


            }
        }


    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}