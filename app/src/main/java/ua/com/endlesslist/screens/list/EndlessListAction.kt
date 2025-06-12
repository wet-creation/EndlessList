package ua.com.endlesslist.screens.list

sealed interface EndlessListAction {
    data class NavigateDetail(val id: Int): EndlessListAction

    data object LoadNext: EndlessListAction
}