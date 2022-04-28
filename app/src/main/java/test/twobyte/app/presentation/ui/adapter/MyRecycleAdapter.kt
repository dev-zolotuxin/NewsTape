package test.twobyte.app.presentation.ui.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import test.twobyte.app.databinding.AdapterViewBinding
import test.twobyte.app.domain.model.NewsApi

class MyRecycleAdapter : RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder>() {

    private lateinit var context: Context
    private var listNewsApi: NewsApi = NewsApi()

    class MyViewHolder(val binding: AdapterViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        val binding = AdapterViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemData = listNewsApi.articles?.get(position)
        with(holder.binding) {
            tvTitle.text = itemData?.title
            tvDescription.text = itemData?.description
            tvAuthor.text = itemData?.author
            tvPublicDate.text = itemData?.publishedAt
            Picasso.get().load(itemData?.urlToImage).into(imgNews)
        }
        val address: Uri = Uri.parse(itemData?.url)
        holder.binding.itemNewsLayout.setOnClickListener {
            context.startActivity(Intent(Intent.ACTION_VIEW, address))
        }
    }

    override fun getItemCount(): Int = listNewsApi.articles?.size ?: 0

    fun setData(newsApi: NewsApi) {
        this.listNewsApi = newsApi
    }
}