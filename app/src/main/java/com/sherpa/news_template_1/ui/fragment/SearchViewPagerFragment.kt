package com.sherpa.news_template_1.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sherpa.news_template_1.adapter.SearchTabRecyclerViewAdapter
import com.sherpa.news_template_1.databinding.SearchViewpagerFragmentBinding
import com.sherpa.news_template_1.ui.DetailActivity
import com.sherpa.news_template_1.ui.MainActivity
import com.sherpa.news_template_1.ui.NewsViewModel

/**
 * CREATED BY->
 * @Author: "Tenzing Sherpa"
 * @Email: "tenzingsherpaaa@gmail.com
 * @Date: 2024-12-30
 */
class SearchViewPagerFragment : Fragment() {

    private lateinit var binding: SearchViewpagerFragmentBinding

    lateinit var viewModel: NewsViewModel
    lateinit var mSearchAdapter: SearchTabRecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchViewpagerFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel
        setUpRecyclerView()

        mSearchAdapter.setOnItemClickListener { it ->
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra("article", it)
            activity?.startActivity(intent)

        }
        fetchLocalData()
    }

    private fun fetchLocalData() {
        viewModel.getNewsFromLocalDb().observe(viewLifecycleOwner, Observer { response ->
            mSearchAdapter.differ.submitList(response)
        })
    }

    private fun setUpRecyclerView() {
        mSearchAdapter = SearchTabRecyclerViewAdapter()
        binding.rvSearchViewFragment.apply {
            adapter = mSearchAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}