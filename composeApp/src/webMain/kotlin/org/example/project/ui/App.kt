package org.example.project.ui
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.state.MenuState

@Composable
fun App() {
    var menuStack by remember { mutableStateOf(listOf<MenuState>(MenuState.Main)) }

    Box(modifier = Modifier.fillMaxSize()) {
        MainMenu(
            onNavigate = { menuStack = menuStack + it },
            modifier = Modifier.align(Alignment.BottomStart).padding(65.dp)
        )
    }
}
