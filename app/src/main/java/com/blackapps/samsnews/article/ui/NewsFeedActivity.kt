package com.blackapps.samsnews.article.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blackapps.samsnews.R
import com.blackapps.samsnews.article.model.CNN
import com.blackapps.samsnews.article.model.YNET

class NewsFeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_feed)

        val cnnBtn: TextView? = findViewById(R.id.cnn_btn)
        val yNetBtn: TextView? = findViewById(R.id.ynet_btn)

        val recyclerView: RecyclerView? = findViewById(R.id.articles_list)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.setHasFixedSize(true)

        val articlesAdapter = ArticlesAdapter(listOf())
        recyclerView?.adapter = articlesAdapter
        articlesAdapter.notifyDataSetChanged()

        val newsFeedFragmentViewModel =
            ViewModelProvider(this).get(NewsFeedViewModel::class.java)

        yNetBtn?.setTextColor(resources.getColor(R.color.white))
        cnnBtn?.setTextColor(resources.getColor(R.color.gray))
        newsFeedFragmentViewModel.getArticles(YNET).observe(this, Observer {
            articlesAdapter.updateAdapterList(it)
        })

        cnnBtn?.setOnClickListener {
            cnnBtn.setTextColor(resources.getColor(R.color.white))
            yNetBtn?.setTextColor(resources.getColor(R.color.gray))
            newsFeedFragmentViewModel.getArticles(CNN).observe(this, Observer {
                articlesAdapter.updateAdapterList(it)
            })
        }

        yNetBtn?.setOnClickListener {
            yNetBtn.setTextColor(resources.getColor(R.color.white))
            cnnBtn?.setTextColor(resources.getColor(R.color.gray))
            newsFeedFragmentViewModel.getArticles(YNET).observe(this, Observer {
                articlesAdapter.updateAdapterList(it)
            })
        }
    }
}
