package com.sherpa.news_template_1.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.sherpa.news_template_1.databinding.FragmentSearchBinding

/**
 * CREATED BY->
 * @Author: "Tenzing Sherpa"
 * @Email: "tenzingsherpaaa@gmail.com
 * @Date: 2024-12-26
 */
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewPagerAdapter: SearchViewPagerAdapter

    private val tabTitleList =
        listOf<String>("Health", "Politics", "Art", "Food", "Sports", "Entertainment", "Science")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewPagerAdapter = SearchViewPagerAdapter(this,tabTitleList.size)

        binding.vPagerSearchFragment.adapter = viewPagerAdapter

        TabLayoutMediator(
            binding.tabLSearchFragment,
            binding.vPagerSearchFragment
        ) { tab, position ->
            tab.text = tabTitleList[position]
        }.attach()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}