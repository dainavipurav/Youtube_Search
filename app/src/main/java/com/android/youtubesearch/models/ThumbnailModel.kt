package com.android.youtubesearch.models

import com.squareup.moshi.Json

class ThumbnailModel(
    @field:Json(name = "medium")
    var medium : MediumModel
)