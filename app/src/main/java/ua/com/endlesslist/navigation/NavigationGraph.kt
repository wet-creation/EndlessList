package ua.com.endlesslist.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import ua.com.endlesslist.screens.list.EndlessListRoot
import ua.com.endlesslist.ui.compoents.scaffold.Background


@Composable
fun NavigationRoot(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = List,
    ) {
        composable<List> {
            EndlessListRoot()

        }
        composable<Details> {

        }

    }
}

@Serializable
data object List

@Serializable
data class Details(val id: Int)
