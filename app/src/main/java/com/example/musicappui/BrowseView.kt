package com.example.musicappui


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Browse(){

    val categories = listOf("Hits","Happy","Workout","Running","TGIF","Yoga")

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(categories){
            item -> BrowserItem(item,R.drawable.outline_browse_24)

        }

    }

}



@Preview(showBackground = true)
@Composable
fun BrowsePreview(){
    Browse()
}
