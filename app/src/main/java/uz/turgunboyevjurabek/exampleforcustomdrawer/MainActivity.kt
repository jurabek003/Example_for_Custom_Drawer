package uz.turgunboyevjurabek.exampleforcustomdrawer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.turgunboyevjurabek.exampleforcustomdrawer.core.utils.coloredShadow
import uz.turgunboyevjurabek.exampleforcustomdrawer.domein.models.CustomDrawerState
import uz.turgunboyevjurabek.exampleforcustomdrawer.domein.models.NavigationItem
import uz.turgunboyevjurabek.exampleforcustomdrawer.domein.models.isOpened
import uz.turgunboyevjurabek.exampleforcustomdrawer.domein.models.opposite
import uz.turgunboyevjurabek.exampleforcustomdrawer.presentation.components.CustomDrawer
import uz.turgunboyevjurabek.exampleforcustomdrawer.ui.theme.ExampleForCustomDrawerTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var drawerState by remember { mutableStateOf(CustomDrawerState.Closed) }
            var selectedNavigationItem by remember { mutableStateOf(NavigationItem.Home) }

            val configuration = LocalConfiguration.current
            val density = LocalDensity.current.density

            val screenWidth = remember {
                derivedStateOf { (configuration.screenWidthDp * density).roundToInt() }
            }
            val offsetValue by remember { derivedStateOf { (screenWidth.value / 4.5).dp } }

            val animatedOffset by animateDpAsState(
                targetValue = if (drawerState.isOpened()) offsetValue else 0.dp,
                label = "Animated Offset"
            )
            val animatedScale by animateFloatAsState(
                targetValue = if (drawerState.isOpened()) 0.8f else 1f,
                label = "Animated Scale"
            )
            val animatedRotation by animateFloatAsState(
                targetValue = if (drawerState.isOpened()) -12f else 0f,
                label = "Animated Rotation"
            )
            BackHandler(enabled = drawerState.isOpened()) {
                drawerState = CustomDrawerState.Closed
            }
            ExampleForCustomDrawerTheme {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Box(
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.surface)
                                .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f))
                                .fillMaxSize()
                        ) {
                            CustomDrawer(
                                selectedNavigationItem = selectedNavigationItem,
                                onNavigationItemClick = {
                                    selectedNavigationItem = it
                                },
                                onCloseClick = { drawerState = CustomDrawerState.Closed }
                            )
                            MainContent(
                                modifier = Modifier
                                    .offset(x = animatedOffset)
                                    .scale(scale = animatedScale)
                                    .rotate(animatedRotation)
                                    .coloredShadow(
                                        color = Color.Yellow,
                                        alpha = 0.5f,
                                        shadowRadius = 50.dp
                                    ),
                                drawerState = drawerState,
                                onDrawerClick = { drawerState = it },
                            )
                        }
                    }
                }
            }
        }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainContent(
        modifier: Modifier = Modifier,
        drawerState: CustomDrawerState,
        onDrawerClick: (CustomDrawerState) -> Unit
    ) {
        Scaffold(
            modifier = modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(if (drawerState.isOpened()) 16.dp else 0.dp))
                .clickable(enabled = drawerState == CustomDrawerState.Opened) {
                    onDrawerClick(CustomDrawerState.Closed)
                },
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer
                    ),
                    title = {
                        Text(text = "Home")
                    },
                    navigationIcon = {
                        IconButton(onClick = { onDrawerClick(drawerState.opposite()) }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu Icon",
                            )
                        }
                    }
                )
            }
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                Text(
                    text = "Home",
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

