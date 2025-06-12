package ua.com.endlesslist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import ua.com.endlesslist.screens.list.EndlessListRoot
import ua.com.endlesslist.ui.theme.EndlessListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EndlessListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EndlessListRoot()
                }
            }
        }
    }
}

fun comingSoonToast(context: Context) {
    Toast.makeText(context, R.string.coming_soon, Toast.LENGTH_SHORT).show()
}
