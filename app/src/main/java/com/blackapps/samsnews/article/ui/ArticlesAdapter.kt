package com.blackapps.samsnews.article.ui

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.blackapps.samsnews.MainApplication
import com.blackapps.samsnews.R
import com.blackapps.samsnews.article.model.Article
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class ArticlesAdapter(private var articles: List<Article>) :
    RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>() {

    open class ArticlesViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val itemCv: CardView = itemView.findViewById(R.id.item_cv)
        private val itemHeadline: TextView = itemView.findViewById(R.id.item_headline)
        private val itemImage: ImageView = itemView.findViewById(R.id.item_image)

        fun onBind(article: Article) {
            itemHeadline.text = article.title
            setUrlToImage(article)
            itemCv.setOnClickListener {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(article.url))
                browserIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                MainApplication.appContext?.let { startActivity(it, browserIntent, null) }
            }
        }

        private fun setUrlToImage(article: Article) {
            val options: RequestOptions = RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
            MainApplication.appContext?.let {
                Glide.with(it).load(article.urlToImage).apply(options).into(itemImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        return ArticlesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        articles[position].let { holder.onBind(it) }
    }

    override fun getItemCount(): Int {
        return if (articles.isNullOrEmpty()) 0 else articles.size
    }

    fun updateAdapterList(articleList: List<Article>) {
        this.articles = articleList
        notifyDataSetChanged()
    }
}