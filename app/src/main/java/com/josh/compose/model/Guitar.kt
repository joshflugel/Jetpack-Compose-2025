package com.josh.compose.model

import androidx.annotation.DrawableRes

data class Guitar(
    var nickname: String,
    var brandName: String,
    var modelName: String,
    @DrawableRes var photo: Int
)
