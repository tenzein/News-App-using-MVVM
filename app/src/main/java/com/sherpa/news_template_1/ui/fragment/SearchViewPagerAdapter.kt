package com.sherpa.news_template_1.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sherpa.news_template_1.util.Constants.Companion.ARG_OBJECT

/**
 * CREATED BY->
 * @Author: "Tenzing Sherpa"
 * @Email: "tenzingsherpaaa@gmail.com
 * @Date: 2024-12-30
 */

class SearchViewPagerAdapter(fragment: Fragment,var tabSize: Int) : FragmentStateAdapter(fragment) {
    override fun createFragment(position: Int): Fragment {
        //Return a new fragment instance
        val fragment = SearchViewPagerFragment()
        fragment.arguments= Bundle().apply {
            putInt(ARG_OBJECT, position + 1)

        }
        return fragment
    }

    override fun getItemCount(): Int {
        return tabSize
    }


}