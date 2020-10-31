package com.android.youtubesearch.models

import com.squareup.moshi.Json

class VideoIDModel (
    @field:Json(name = "kind")
    var kind : String,
    @field:Json(name = "videoId")
    var videoId : String
)