package com.saraebadi.compose_coin.sysytemdesign.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconText: String
){
    COINS_RATE(
        selectedIcon = Icons.Filled.Home,
        unselectedIcon =Icons.Outlined.Home,
        iconText = "Coins Rate"
    ),
    SETTINGS(
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon =Icons.Outlined.Settings,
        iconText = "Settings"
    )
}