package com.sherpa.news_template_1.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.sherpa.news_template_1.ui.fragment.SearchViewPagerFragment
import com.sherpa.news_template_1.util.Constants.Companion.ARG_OBJECT

/**
 * CREATED BY->
 * @Author: "Tenzing Sherpa"
 * @Email: "tenzingsherpaaa@gmail.com
 * @Date: 2024-12-30
 */

class SearchViewPagerAdapter( mFanager: FragmentManager, var tabList: List<String>) :
    FragmentStatePagerAdapter(mFanager) {


    override fun getItem(position: Int): Fragment {
        val fragment = SearchViewPagerFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position + 1)
        }
        return fragment

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabList[position]
    }

    override fun getCount(): Int {
        return tabList.size
    }


}