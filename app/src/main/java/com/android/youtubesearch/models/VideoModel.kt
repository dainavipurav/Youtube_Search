package com.android.youtubesearch.models

import com.squareup.moshi.Json

class VideoModel (
    @field:Json(name = "id")
    var id : VideoIDModel,
    @field:Json(name = "snippet")
    var snippet : SnippetModel
)