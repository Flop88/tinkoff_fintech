package ru.mvlikhachev.tinkoff_fintech.model

import com.google.gson.annotations.SerializedName

data class Model (

    @SerializedName("id")
    val id: Long,

    @SerializedName("description")
    val description: String,

    @SerializedName("votes")
    val votes: Long,

    @SerializedName("author")
    val author: String,

    @SerializedName("date")
    val date: String,

    @SerializedName("gifURL")
    val gifURL: String,

    @SerializedName("gifSize")
    val gifSize: Long,

    @SerializedName("previewURL")
    val previewURL: String,

    @SerializedName("videoURL")
    val videoURL: String,

    @SerializedName("videoPath")
    val videoPath: String,

    @SerializedName("videoSize")
    val videoSize: Long,

    @SerializedName("type")
    val type: String,

    @SerializedName("width")
    val width: String,

    @SerializedName("height")
    val height: String,

    @SerializedName("commentsCount")
    val commentsCount: Long,

    @SerializedName("fileSize")
    val fileSize: Long,

    @SerializedName("canVote")
    val canVote: Boolean
)
