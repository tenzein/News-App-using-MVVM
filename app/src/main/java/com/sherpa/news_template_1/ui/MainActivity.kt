package com.sherpa.news_template_1.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.sherpa.news_template_1.R
import com.sherpa.news_template_1.databinding.ActivityMainBinding
import com.sherpa.news_template_1.db.ArticleDatabase
import com.sherpa.news_template_1.repository.NewsRepository

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : NewsViewModel

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragments) as NavHostFragment

        binding.bottomNavigationView.setupWithNavController(navHostFragment.navController)



        val repository = NewsRepository(ArticleDatabase(this))

        val viewModelProvideFactory = NewsViewModelProvideFactory(repository)

        viewModel = ViewModelProvider(this,viewModelProvideFactory).get(NewsViewModel::class.java)



    }
}