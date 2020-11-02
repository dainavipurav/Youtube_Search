package com.android.youtubesearch.models

import com.squareup.moshi.Json

class ResponseModel (
    @field:Json(name="nextPageToken")
    var nextPageToken : String,
    @field:Json(name = "items")
    var items : List<VideoModel>,
    @field:Json(name = "error")
    var error : ErrorModel
)