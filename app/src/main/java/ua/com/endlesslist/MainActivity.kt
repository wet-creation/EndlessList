package ua.com.endlesslist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import ua.com.endlesslist.navigation.NavigationRoot
import ua.com.endlesslist.ui.theme.EndlessListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            EndlessListTheme {
                NavigationRoot(
                    navController = navController,
                )
            }
        }
    }
}

fun comingSoonToast(context: Context) {
    Toast.makeText(context, R.string.coming_soon, Toast.LENGTH_SHORT).show()
}
