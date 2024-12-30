package com.example.jetpackcopmmposecomponent.viewpager

import androidx.annotation.DrawableRes
import com.example.jetpackcopmmposecomponent.R

data class Pager(
    @DrawableRes val image: Int,
    val description: String
)

val dataList = listOf(
    Pager(R.drawable.page_one, "PAGE ONE"),
    Pager(R.drawable.page_two, "PAGE TWO"),
    Pager(R.drawable.page_one, "PAGE THREE")
)