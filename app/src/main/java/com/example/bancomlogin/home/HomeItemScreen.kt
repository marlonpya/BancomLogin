package com.example.bancomlogin.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box

@Composable
fun HomeItemScreen(
    user: UserModel
) = with(user) {
    Card {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = name, style = MaterialTheme.typography.body1)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
            ) {
                Text(text = userName, style = MaterialTheme.typography.body1)
            }
            Text(text = address, style = MaterialTheme.typography.body1)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
            ) {
                Text(text = email, style = MaterialTheme.typography.body1)
            }
            Text(text = phoneNumber, style = MaterialTheme.typography.body1)
        }
    }
}

@Preview
@Composable
private fun HomeItemScreenPreview() {
    HomeItemScreen(
        UserModel(
            "Leanne Graham",
            "Bret",
            "Kulas Light",
            "Sincere@april.biz",
            "1-770-736-8031 x56442"
        )
    )
}