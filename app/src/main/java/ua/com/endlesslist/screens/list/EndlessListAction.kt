package ua.com.endlesslist.screens.list

sealed interface EndlessListAction {
    data class NavigateDetail(val title: String): EndlessListAction

    data object LoadNext: EndlessListAction
}