package com.example.educationapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.educationapp.R

data class BottomNavItem(
    val title: String,
    val selectedItem: ImageVector,
    val unselectedItem: ImageVector,
    val hasBadge: Boolean,
    val badgeNum: Int
)

@Composable
fun NavBar(){
    val item = listOf(
        BottomNavItem(
            title = "Home",
            selectedItem = Icons.Filled.CheckCircle,
            unselectedItem = Icons.Outlined.CheckCircle,
            hasBadge = false,
            badgeNum = 0

        )
    )
}
