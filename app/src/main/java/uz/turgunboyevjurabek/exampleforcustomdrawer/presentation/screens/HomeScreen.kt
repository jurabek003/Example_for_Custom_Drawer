package uz.turgunboyevjurabek.exampleforcustomdrawer.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import uz.turgunboyevjurabek.exampleforcustomdrawer.domein.models.LoremPicsumItem
import uz.turgunboyevjurabek.exampleforcustomdrawer.presentation.components.BoxUIList
import uz.turgunboyevjurabek.exampleforcustomdrawer.presentation.state.LoremPicsumState
import uz.turgunboyevjurabek.exampleforcustomdrawer.presentation.viewModels.GetLoremViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: GetLoremViewModel=hiltViewModel()
) {
    val state=viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.fetchLorem()
    }
    LoremMainContent(state = state.value)
}

@Composable
fun LoremMainContent(modifier: Modifier = Modifier,state: LoremPicsumState) {
    when(state){
        is  LoremPicsumState.Loading->{
            LoadingContent(modifier)
        }
        is LoremPicsumState.Success->{
            SuccessContent(modifier,state.listOfCats as ArrayList<LoremPicsumItem>)
        }
        is LoremPicsumState.Error->{
            ErrorContent(exception = state.exception.message)
            state.exception.printStackTrace()
        }
    }

}

@Composable
fun SuccessContent(modifier: Modifier = Modifier,list:ArrayList<LoremPicsumItem>) {
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
            items(list.size){it->
                BoxUIList(list[it])
            }
        }
    }
}
@Composable
fun ErrorContent(exception: String?) {
    exception?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = it)
        }
    }
}

@Composable
fun LoadingContent(modifier: Modifier = Modifier) {
    Column(
        modifier=modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}