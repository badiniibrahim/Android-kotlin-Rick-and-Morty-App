package com.badiniibrahim.myapplication.presentation.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.badiniibrahim.myapplication.presentation.main.widgets.AppTopBar
import com.badiniibrahim.myapplication.presentation.main.widgets.DataItem
import com.badiniibrahim.myapplication.presentation.main.widgets.LoadingDialog

@Composable
internal fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val state by viewModel.state.collectAsStateWithLifecycle();
    Content(state, navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(mainViewState: MainViewState,  navController: NavHostController){
    LoadingDialog(isLoading = mainViewState.isLoading)
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            AppTopBar(title = "Rick and Morty")
        }
    ) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(top = it.calculateTopPadding()),
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 10.dp
        ) {
            items(mainViewState.mainData){data ->
                DataItem(data = data, navController = navController)
            }
        }
    }

}