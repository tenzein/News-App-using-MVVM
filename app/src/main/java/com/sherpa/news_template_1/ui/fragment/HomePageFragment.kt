package com.sherpa.news_template_1.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.sherpa.news_template_1.R
import com.sherpa.news_template_1.adapter.NewsAdapter
import com.sherpa.news_template_1.databinding.FragmentHomeBinding
import com.sherpa.news_template_1.model.Article
import com.sherpa.news_template_1.ui.MainActivity
import com.sherpa.news_template_1.ui.NewsViewModel
import com.sherpa.news_template_1.util.Resource
import kotlin.random.Random


/**
 * CREATED BY->
 * @Author: "Tenzing Sherpa"
 * @Email: "tenzingsherpaaa@gmail.com
 * @Date: 2024-12-26
 */
class HomePageFragment : Fragment(){

    private var _binding: FragmentHomeBinding ?= null

    private val binding get() = _binding!!

    val TAG = "HOME_PAGE_FRAGMENT"

    lateinit var  mNewsAdpater : NewsAdapter
    lateinit var viewModel : NewsViewModel

    var isLoading = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as  MainActivity).viewModel

        setUpRecyclerView()

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response ->
             when(response){

                 is Resource.Success -> {
                     hideProgressBar()
                     response.data?.let { newsResponse ->
                         val topNews = newsResponse.articles[Random.nextInt(newsResponse.articles.size)]
                         setUpNewsOfTheDay(topNews)
                         mNewsAdpater.differ.submitList(newsResponse.articles)

                     }
                 }
                 is Resource.Error -> {
                     hideProgressBar()
                     response.message.let { message ->
                         Snackbar.make(binding.root, "${response.message}", Snackbar.LENGTH_SHORT).show()

                     }
                 }
                 is Resource.Loading -> {
                     showProgressBar()
                 }
             }
        })

    }

    private fun setUpRecyclerView(){
        mNewsAdpater = NewsAdapter()
        binding.rvBreakingNews.apply {
            adapter = mNewsAdpater
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)

        }


    }

    private fun setUpNewsOfTheDay(article: Article){
        binding.txNewsOfTheDayTitle.text = article.title
        Glide.with(this).load(article.urlToImage).placeholder(R.drawable.placeholder)
            .into(binding.imgMain)
    }

    private fun showProgressBar(){
        binding.homeProgressBar.visibility  = View.VISIBLE
        binding.clMain.visibility = View.INVISIBLE
        isLoading = true

    }

    private fun hideProgressBar(){
        binding.homeProgressBar.visibility = View.GONE
        binding.clMain.visibility = View.VISIBLE
        isLoading = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}