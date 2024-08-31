package uz.turgunboyevjurabek.exampleforcustomdrawer.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import uz.turgunboyevjurabek.exampleforcustomdrawer.R
import uz.turgunboyevjurabek.exampleforcustomdrawer.core.utils.coloredShadow
import uz.turgunboyevjurabek.exampleforcustomdrawer.domein.models.LoremPicsumItem
import kotlin.random.Random

@Composable
fun BoxUIList(loremPicsumItem: LoremPicsumItem) {
    val height=Random.nextInt(100,300).dp
    Card(
        modifier = Modifier
            .height(height)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize(),
            model =ImageRequest.Builder(LocalContext.current)
                .data(loremPicsumItem.download_url)
                .crossfade(true)
                .build(),
            placeholder = painterResource(id = R.drawable.ic_dowlading),
            error = painterResource(id = R.drawable.ic_error),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}
