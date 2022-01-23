package com.example.countryapp.binding.ui


import android.widget.ImageView

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.flag.Flag
import com.example.flag.FlagAdapter


@BindingAdapter("imageUrl")
fun bindImageFlags(imgView: ImageView, imgUrl: String?) {
    imgUrl.let {
        val imageLoader = ImageLoader.Builder(imgView.context)
            .componentRegistry { add(SvgDecoder(imgView.context)) }
            .build()

        val request = ImageRequest.Builder(imgView.context)
            .data(imgUrl)
            .target(imgView)
            .build()

        imageLoader.enqueue(request)
    }


}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Flag>?) {

    val adapter = recyclerView.adapter as FlagAdapter
    adapter.submitList(data)
}