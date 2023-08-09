package com.example.carlos_app.domain.model

data class OrderOption(
    val title: String,
    val onClick: () -> Unit = {}
)