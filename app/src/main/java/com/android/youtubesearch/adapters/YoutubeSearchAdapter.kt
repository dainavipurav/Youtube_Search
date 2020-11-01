package com.android.youtubesearch.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.youtubesearch.R
import com.android.youtubesearch.models.VideoIDModel
import com.android.youtubesearch.models.VideoModel
import com.bumptech.glide.Glide
import kotlin.collections.ArrayList

class YoutubeSearchAdapter(
    var mContext: Context,
    var mVideoList: ArrayList<VideoModel>

) : RecyclerView.Adapter<YoutubeSearchAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater
                .from(mContext)
                .inflate(
                    R.layout.custom_item_layout,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(mContext).load(mVideoList[position].snippet.thumbnails.medium.url)
            .placeholder(R.drawable.splash_theme)
            .into(holder.mImageViewThumbnail)
        holder.mTextViewTitle.text = mVideoList[position].snippet.title
        holder.mTextViewDescription.text = mVideoList[position].snippet.description
        holder.mTextViewTime.text = mVideoList[position].snippet.publishedAt
    }

    override fun getItemCount(): Int {
        return mVideoList.size
    }

    class MyViewHolder(mItemView: View) : RecyclerView.ViewHolder(mItemView) {
        var mImageViewThumbnail: ImageView =
            mItemView.findViewById(R.id.imageviewCustomItemLayout)

        var mTextViewTitle: TextView =
            mItemView.findViewById(R.id.textviewCustomItemLayoutHeading)

        var mTextViewDescription: TextView =
            mItemView.findViewById(R.id.textviewCustomItemLayoutChannel)

        var mTextViewTime: TextView =
            mItemView.findViewById(R.id.textviewCustomItemLayoutViews)
    }


}