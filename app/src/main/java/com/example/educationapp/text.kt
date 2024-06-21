package com.example.educationapp

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.educationapp.ui.theme.Inter

data class BottomNavigationItem(
    val title:String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavApp(){
    var selectedItemIndex by remember {
        mutableStateOf(0)
    }
    val items = listOf(
        BottomNavigationItem(
            title = "Course",
            selectedIcon = Icons.Filled.CheckCircle,
            unselectedIcon = Icons.Outlined.CheckCircle
        ),
        BottomNavigationItem(
            title = "Classes",
            selectedIcon = Icons.Filled.CheckCircle,
            unselectedIcon = Icons.Outlined.CheckCircle
        ),
        BottomNavigationItem(
            title = "Profile",
            selectedIcon = Icons.Filled.CheckCircle,
            unselectedIcon = Icons.Outlined.CheckCircle
        ),
        BottomNavigationItem(
            title = "Suporte",
            selectedIcon = Icons.Filled.CheckCircle,
            unselectedIcon = Icons.Outlined.CheckCircle
        )
    )

    Scaffold (
        bottomBar = {
            NavigationBar {
                items.forEachIndexed{index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            //navController.navigate(item.title)

                        },
                        label = { Text(text = item.title, fontSize = 14.sp, fontFamily = Inter)},
                        icon = {
                                Icon(
                                    imageVector = (if (index == selectedItemIndex ){
                                    item.selectedIcon
                                }else item.unselectedIcon),
                                    contentDescription = item.title )

                        })

                }
            }
        }
    ){
        //
    }
}





@Preview
@Composable
fun ButtonTestPreview(){
    NavApp()
}