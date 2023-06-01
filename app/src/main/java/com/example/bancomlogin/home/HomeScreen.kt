package com.example.bancomlogin.home

import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(homeViewModel: HomeViewModel = koinViewModel()) {

    homeViewModel.callUsers()

   if (homeViewModel.loading.isNotEmpty()) {
       Toast.makeText(LocalContext.current, homeViewModel.loading, Toast.LENGTH_LONG).show()
   }

    val users = homeViewModel.users
    LazyColumn(state = rememberLazyListState()) {
        items(users) { item ->
            HomeItemScreen(user = item)
        }
    }

}