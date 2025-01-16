package com.sherpa.news_template_1.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sherpa.news_template_1.R
import com.sherpa.news_template_1.databinding.ActivityDetailBinding
import com.sherpa.news_template_1.model.Article
import com.sherpa.news_template_1.util.getTimeAgo

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val article = intent.getSerializableExtra("article") as Article
        setUpDetails(article)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setUpDetails(article: Article) {

        //setup details top part
        binding.txDetailsTitle.text = article.title
        binding.txtDetailsDes.text = article.description
        Glide.with(this).load(article.urlToImage).placeholder(R.drawable.placeholder)
            .into(binding.imgDetails)


        //setup bottom details part

        Glide.with(this).load(article.urlToImage)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.placeholder)
            .into(binding.layoutDetailsBottom.imgAurthor)

        binding.layoutDetailsBottom.txtAuthor.text = article.author
        binding.layoutDetailsBottom.txtDetailsTime.text = getTimeAgo(article.publishedAt.toString())
        binding.layoutDetailsBottom.txtDescription.text = article.description



        binding.imgBack.setOnClickListener {
            finish()
        }
    }
}