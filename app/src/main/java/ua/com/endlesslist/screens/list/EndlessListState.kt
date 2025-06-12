package ua.com.endlesslist.screens.list

import ua.com.endlesslist.screens.models.Item

data class EndlessListState(
    val items: List<Item> = emptyList(),
)