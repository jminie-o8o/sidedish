package com.example.sidedish.home.data

import android.graphics.Paint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setImage")
fun setImage(view: ImageView, url: String) {
    Glide.with(view.context) // with() = ()안의 View, Fragment 혹은 Activity로부터 Context를 가져온다.
        .load(url) // 이미지를 로드한다.
        .into(view) // 이미지를 보여줄 View를 지정한다.
}

@BindingAdapter("setPrice")
fun setPrice(view: TextView, body: String?) {
    view.text = body
    view.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
    if (body == null) {
        view.visibility = View.GONE
    }
}

@BindingAdapter("setEventOn")
fun setEventOn(view: TextView, event: String?) {
    if (event == null) {
        view.visibility = View.GONE
    }
}