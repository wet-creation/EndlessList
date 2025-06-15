package ua.com.endlesslist.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.serpro69.kfaker.Faker
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import ua.com.endlesslist.screens.models.Item

class EndlessListViewModel : ViewModel() {

    private var hasLoadedInitialData = false
    private val faker = Faker()

    private val _state = MutableStateFlow(EndlessListState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = EndlessListState()
        )

    fun onAction(action: EndlessListAction) {
        when (action) {
            EndlessListAction.LoadNext ->
                loadNextItems()


            else -> Unit
        }
    }

    private fun loadNextItems() {
        val list = _state.value.items.toMutableList()
        (0..20).forEach {
            list.add(generateItem(list.size))
        }
        _state.update {
            it.copy(list)
        }
    }

    private fun generateItem(id: Int): Item {
        val title = faker.book.title()
        val subtitle = faker.departed.quotes()
        val pictureId = (0..500).random()
        val url = "https://picsum.photos/id/$pictureId/200"

        return Item(
            id = id,
            title = title,
            subtitle = subtitle,
            imageUrl = url
        )
    }

}