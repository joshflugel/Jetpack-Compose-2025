package com.josh.compose.components.layout

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.josh.compose.R
import com.josh.compose.model.Guitar


@Composable
fun SimpleRecyclerView() {
    val myList = listOf("Flugel", "Mowif", "2052", "NBG", "504th")
    LazyColumn {
        item{ Text("Primer Item") }
        items(7){
            Text("This is item: $it")
        }
        items(myList) {
            Text("*$it")
        }
        item { Text(text = "Footer") }
    }
}

@Composable
fun GuitarGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Fixed(3), content = {
    // LazyVerticalGrid(columns = GridCells.Adaptive(100.dp), content = {
        items(getGuitars()){ guitar ->
            ItemGuitar(guitar = guitar){
                Log.e("joshtag", "$it.nickname")
                Toast.makeText(context, it.nickname, Toast.LENGTH_SHORT).show()
            }
        }
    }, contentPadding =  PaddingValues(horizontal = 16.dp, vertical = 8.dp))
}

@Composable
fun GuitarView() {
    val context = LocalContext.current
    LazyRow( horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getGuitars()){ guitar ->
            ItemGuitar(
                guitar = guitar,
            ){
                Log.e("joshtag", "$it.nickname")
                Toast.makeText(context, it.nickname, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun ItemGuitar(guitar: Guitar, onItemSelected:(Guitar) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.LightGray),
        modifier = Modifier
            .width(200.dp)
            .padding(3.dp)
            .clickable {
                onItemSelected(guitar)
            }) {
        Column() {
            Image(
                painter = painterResource(guitar.photo),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                guitar.nickname,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                guitar.modelName,
                modifier =  Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                guitar.brandName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
        }
    }
}

fun getGuitars(): List<Guitar>{
    return listOf(
        Guitar("Flügel", "Fender", "Stratocaster HSS", R.drawable.flugel),
        Guitar("Oberlügel", "Fender", "Stratocaster HSS Custom", R.drawable.oberflugel),
        Guitar("Tekkadan", "Squier", "Telecaster Contemporary RH", R.drawable.telecaster),
        Guitar("Thunder", "Epihone", "Thunderbird Goth", R.drawable.thunderbird),
        Guitar("Lan-se", "Squier", "J-Bass", R.drawable.lanse),
        Guitar( "Martin", "Hoffner", "Violin Bass", R.drawable.martin),
        Guitar("Bassman", "Fender", "P-Bass", R.drawable.pbass),
        Guitar("Audrey", "Fender", "Jazzmaster", R.drawable.audrey),
        Guitar("Grond", "Squier", "Baritone Jazzmaster VM", R.drawable.grond)


    )
}