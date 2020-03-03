package com.example.jmemo.adapter

import android.content.Context
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.jmemo.R
import com.example.jmemo.activity.EditActivity
import com.example.jmemo.database.Memo
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import org.jetbrains.anko.startActivity


class MemoLinearRecycleAdapter(realmResult: OrderedRealmCollection<Memo>, context: Context)
    : RealmRecyclerViewAdapter<Memo, MemoLinearRecycleAdapter.ViewHolderOfLinearRecycleView>(realmResult, false){
    var context : Context? = null
    init {
        this.context = context
    }
    override fun getItem(index: Int): Memo? {
        return super.getItem(index)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderOfLinearRecycleView {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_memo_linear, parent, false)
        return ViewHolderOfLinearRecycleView(view!!)
    }

    override fun onBindViewHolder(holder: ViewHolderOfLinearRecycleView, position: Int) {
        val memo = getItem(position)
        holder.titleTextView.text = memo!!.title
        holder.dateTextView.text = DateFormat.format("yyyy년 MM월 dd일", memo.lastDate)
        holder.bodyTextView.text = memo.body
        if(memo.images.size != 0){
            holder.imageView.visibility = View.VISIBLE
            val multiOption = MultiTransformation(CenterCrop(), RoundedCorners(30))
            Glide.with(holder.view!!).load(memo.images.first())
                .placeholder(R.drawable.ic_sync_black_24dp)
                .error(R.drawable.ic_error)
                .apply(RequestOptions.bitmapTransform(multiOption))
                .into(holder.imageView)
            holder.imageView.background = holder.view!!.resources.getDrawable(R.drawable.border_layout, null)
        }
        else{
            holder.imageView.visibility = View.GONE
        }
        holder.view!!.setOnClickListener {
            context!!.startActivity<EditActivity>("id" to memo.id)
        }
    }

    class ViewHolderOfLinearRecycleView(itemView: View): RecyclerView.ViewHolder(itemView){
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        val bodyTextView: TextView = itemView.findViewById(R.id.bodyTextView)
        val imageView: ImageView = itemView.findViewById(R.id.mainImageView)
        val view = itemView
    }
}
