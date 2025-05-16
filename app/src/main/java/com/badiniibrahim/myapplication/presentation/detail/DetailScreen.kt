package com.badiniibrahim.myapplication.presentation.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.badiniibrahim.myapplication.presentation.main.widgets.AppTopBar
import com.badiniibrahim.myapplication.presentation.main.widgets.LoadingDialog

@Composable
internal fun DetailScreen(id: Int?, viewModel: DetailViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle();
    LaunchedEffect(key1 = id) {
        id?.let { viewModel.getById(it) }
    }
    Content(state)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Content(detailViewState: DetailViewState){
    LoadingDialog(isLoading = detailViewState.isLoading)
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            AppTopBar(title = detailViewState.mainData?.name.toString())
        }
    ) {
        Box(
            modifier = Modifier
                .padding(20.dp)
        ){
            Column(

            ) {
                AsyncImage(model = detailViewState.mainData?.image, contentDescription =  detailViewState.mainData?.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text =  detailViewState.mainData?.name.toString(), style = MaterialTheme.typography.titleMedium)
            }
        }
    }

}