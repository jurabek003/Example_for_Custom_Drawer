package uz.turgunboyevjurabek.exampleforcustomdrawer.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uz.turgunboyevjurabek.exampleforcustomdrawer.core.utils.coloredShadow
import kotlin.random.Random

@Composable
fun BoxUIList() {
    Card(
        modifier = Modifier
            .height(Random.nextInt(100,300).dp)
    ) {

    }
}
