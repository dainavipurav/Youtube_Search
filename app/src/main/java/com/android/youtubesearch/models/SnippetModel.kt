package com.android.youtubesearch.models

import com.squareup.moshi.Json

class SnippetModel(
    @field:Json(name = "publishedAt")
    var publishedAt : String,
    @field:Json(name = "title")
    var title : String,
    @field:Json(name = "description")
    var description : String,
    @field:Json(name = "thumbnails")
    var thumbnails : ThumbnailModel,
)