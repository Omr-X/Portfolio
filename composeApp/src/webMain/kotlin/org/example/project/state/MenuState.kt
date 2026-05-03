package org.example.project.state

sealed class MenuState {
    object Main : MenuState()
    object Experiences : MenuState()
    object Projects : MenuState()
    object About : MenuState()
}