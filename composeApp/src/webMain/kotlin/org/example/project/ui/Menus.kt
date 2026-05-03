package org.example.project.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.state.MenuState

@Composable
fun MainMenu(onNavigate: (MenuState) -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        MenuItem(label = "Experiences", onClick = { onNavigate(MenuState.Experiences) })
        MenuItem(label = "Projects", onClick = { onNavigate(MenuState.Projects) })
        MenuItem(label = "About", onClick = { onNavigate(MenuState.About) })
    }
}

@Composable
fun MenuItem(label: String, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered = interactionSource.collectIsHoveredAsState().value
    val scale by animateFloatAsState(if (isHovered) 1.5f else 1f);

    Button(
        onClick = onClick,
        interactionSource = interactionSource,
        modifier = Modifier
            .width(200.dp)
            .height(60.dp)
            .scale(scale)
    ) {
        Text(text = label, fontSize = 20.sp)
    }
}