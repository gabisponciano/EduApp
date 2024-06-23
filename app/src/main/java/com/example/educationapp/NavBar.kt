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
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.educationapp.ui.theme.Inter
import com.example.educationapp.viewmodels.NavButtonModelView

data class BottomNavigationItem(
    val title:String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavApp(navController: NavController){
    val navViewModel = viewModel<NavButtonModelView>()
    //Essas duas Val auxilia para ver qual tela o usuário está vendo no momento
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    //Lista para o NavBar
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
    //Quando rota atual altera, é atualizado o icone que está na NavBar
    LaunchedEffect(currentRoute) {
        navViewModel.selectedItemIndex.value = items.indexOfFirst { it.title == currentRoute }
    }
    //Criando a NavBar com os respectivos itens
    NavigationBar (modifier = Modifier.height(68.dp)){
        items.forEachIndexed{index, item ->
            NavigationBarItem(
                selected = navViewModel.selectedItemIndex.value== index,
                onClick = {
                    navViewModel.selectedItemIndex.value = index
                    navController.navigate(item.title){
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                label = { Text(text = item.title, fontSize = 14.sp, fontFamily = Inter)},
                icon = {
                    Icon(
                        imageVector = (if (index == navViewModel.selectedItemIndex.value ){
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