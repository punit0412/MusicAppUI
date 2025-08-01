package com.example.musicappui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SubscriptionView(){
    Column(modifier = Modifier.fillMaxSize().padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text("Manage Subscription", modifier = Modifier.padding(bottom = 8.dp))

        Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {

            Column() {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Column {
                        Text("Musical", modifier = Modifier.padding(bottom = 4.dp))
                        Text("Free Tier")
                    }

                    IconButton(onClick = {}) {
                        Row(horizontalArrangement = Arrangement.SpaceBetween) {
                            Text("See All Plans",
                                modifier = Modifier.padding(end = 8.dp),
                                color = Color.Magenta)
                            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                contentDescription = null,
                                tint = Color.Magenta
                            )

                        }

                    }

                }

                Divider()

                Row(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)) {
                    Icon(imageVector = Icons.Default.AccountBox,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 4.dp))
                    Text("Get a Plan")
                }
            }
        }

    }
}



