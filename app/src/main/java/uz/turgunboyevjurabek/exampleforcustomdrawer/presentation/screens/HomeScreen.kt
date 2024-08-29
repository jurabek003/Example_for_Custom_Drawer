package uz.turgunboyevjurabek.exampleforcustomdrawer.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import uz.turgunboyevjurabek.exampleforcustomdrawer.presentation.components.BoxUIList

@Composable
fun HomeScreen(modifier: Modifier = Modifier,navHostController: NavHostController) {
    Column(
        modifier = modifier
            .fillMaxSize()
    )  {
        LazyVerticalStaggeredGrid(
            columns =StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(30.dp),
            verticalItemSpacing = 30.dp
        ) {
            items(100){
                BoxUIList()
            }
        }
    }

}