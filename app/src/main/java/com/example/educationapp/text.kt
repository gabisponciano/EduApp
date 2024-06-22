package com.example.educationapp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.educationapp.ui.theme.Inter

data class BottomNavigationItem(
    val title:String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavApp(navController: NavController){
    //val navController = rememberNavController()
    var selectedItemIndex by remember {
        mutableStateOf(0)
    }
    val items = listOf(
        BottomNavigationItem(
            title = "course",
            selectedIcon = Icons.Filled.CheckCircle,
            unselectedIcon = Icons.Outlined.CheckCircle
        ),
        BottomNavigationItem(
            title = "classes",
            selectedIcon = Icons.Filled.CheckCircle,
            unselectedIcon = Icons.Outlined.CheckCircle
        ),
        BottomNavigationItem(
            title = "profile",
            selectedIcon = Icons.Filled.CheckCircle,
            unselectedIcon = Icons.Outlined.CheckCircle
        ),
        BottomNavigationItem(
            title = "support",
            selectedIcon = Icons.Filled.CheckCircle,
            unselectedIcon = Icons.Outlined.CheckCircle
        )
    )
    NavigationBar (modifier = Modifier.height(68.dp)){
        items.forEachIndexed{index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    if(item.title == "course")
                    {
                        navController.navigate("course")
                    }
                    else if(item.title == "classes"){
                        navController.navigate("classes")
                    }
                    else if(item.title == "profile"){
                        navController.navigate("profile")
                    }
                    else if(item.title == "support"){
                        navController.navigate("support")
                    }


                },
                label = { Text(text = item.title, fontSize = 14.sp, fontFamily = Inter)},
                icon = {
                    Icon(
                        imageVector = (if (index == selectedItemIndex ){
                            item.selectedIcon
                        }else item.unselectedIcon),
                        contentDescription = item.title )

                },
                modifier = Modifier.height(70.dp)
            )

        }
    }

}





@Preview
@Composable
fun ButtonTestPreview(){
    val navController = rememberNavController()
    NavApp(navController)
}