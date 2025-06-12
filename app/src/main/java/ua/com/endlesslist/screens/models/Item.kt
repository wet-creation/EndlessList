package ua.com.endlesslist.screens.models

typealias ImageUrl = String?

data class Item(
    val id: Int = -1,
    val title: String = "",
    val subtitle: String = "",
    val imageUrl: ImageUrl = ""
)