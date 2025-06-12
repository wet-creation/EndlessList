package ua.com.endlesslist.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import ua.com.endlesslist.screens.detail.DetailScreen
import ua.com.endlesslist.screens.list.EndlessListRoot


@Composable
fun NavigationRoot(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = List,
    ) {
        composable<List> {
            EndlessListRoot {
                navController.navigate(Details(it))
            }

        }
        composable<Details> {
            val title = it.toRoute<Details>().title
            DetailScreen(title) {
                navController.navigateUp()
            }
        }

    }
}

@Serializable
data object List

@Serializable
data class Details(val title: String)
