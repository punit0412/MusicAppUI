package com.example.musicappui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LibraryView(){
    Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {
        lib.forEach {
            it -> LibraryItem(it.icon,it.name)
            Divider()
        }

    }
}

@Composable
fun LibraryItem(icon: Int,title:String){
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {

        Row(modifier = Modifier.padding(top = 4.dp)) {
            Icon(painter = painterResource(icon),
                contentDescription = title,
                modifier = Modifier.padding(end = 8.dp))

            Text(text = title)


        }

        IconButton(onClick = {}) {
            Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LibraryViewPreview(){
    LibraryView()
}