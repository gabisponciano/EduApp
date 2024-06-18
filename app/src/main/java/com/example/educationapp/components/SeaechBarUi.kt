package com.example.educationapp.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.educationapp.ui.theme.BackField
import com.example.educationapp.ui.theme.TextFieldBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarUi(modifier: Modifier = Modifier,
                query: String,
                onQueryChange:(String) ->Unit
){
    SearchBar(
        modifier = modifier,
        query = query,
        onQueryChange = { onQueryChange (it)},
        onSearch = {},
        active = false,
        onActiveChange = {},
        placeholder = {
            Text(text = "Search")
        },
        colors = SearchBarDefaults.colors(BackField)
    ) {

    }

}