package com.rodrigo.samplecompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val list = listOf("Rodrigo","Elvis","Ian")
            List(list)
        }
    }
}

@Composable
fun List(items:List<String>) {
    /*
    ScrollableColumn {
        items.map {
            ListItem(title = it)
        }
    }
     */
    LazyColumnFor(items = items) {
        ListItem(title = it)
    }
}

@Composable
fun ListItem(title:String) {
    Card (modifier = Modifier.fillMaxWidth().padding(5.dp)){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ) {
            Icon(asset = vectorResource(id =R.drawable.ic_photo ))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = title,style = TextStyle(fontWeight = FontWeight.Bold,fontSize = 20.sp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val list = listOf("Rodrigo","Elvis","Ian")
    List(list)
}