package com.example.carlos_app.ui.screens.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.carlos_app.data.MenuRepository.getMenuCategoriesData
import com.example.carlos_app.providers.Local
import com.example.carlos_app.ui.components.switches.ToggleSwitch
import com.example.carlos_app.ui.theme.DarkGray
import com.example.carlos_app.ui.theme.OffWhite
import com.example.carlos_app.ui.theme.SolidWhite
import com.example.carlos_app.ui.viewmodel.AppViewModel

@Composable
fun MenuAndOrderScreen(
) {
    val viewModel = Local.AppViewModel.current
    MenuAndOrderContent(viewModel = viewModel)
}

@Composable
fun MenuAndOrderContent(
    viewModel: AppViewModel
) {
    val navController = Local.NavController.current
    val state = viewModel.state.collectAsState()
    val systemBarsPaddingValues = WindowInsets.systemBars.asPaddingValues()
    val menuCategoriesList = getMenuCategoriesData()
    var size by remember { mutableStateOf(IntSize.Zero)}
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top surface
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp + systemBarsPaddingValues.calculateTopPadding())
                    .padding(bottom = 5.dp),
                elevation = 5.dp,
                contentColor = DarkGray
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                        .padding(horizontal = 24.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Order",
                            fontSize = MaterialTheme.typography.h3.fontSize,
                            fontWeight = FontWeight.Black
                        )
                        Icon(
                            modifier = Modifier.size(20.dp),
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    ToggleSwitch(labelList = listOf(
                        "Carryout", "Curbside"
                    ))
                }
            }

            // Menu categories
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .onGloballyPositioned {
                        size = it.size
                    },
                contentAlignment = Alignment.Center
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                ) {
                    items(items = menuCategoriesList, itemContent = {
                        MenuCategoryCard(title = it.title)
                    })
                }
            }
        }
    }
}

@Composable
fun MenuCategoryCard(
    title: String,
    thumbnail: ImageVector? = null
) {
    val containerShape: Shape = RoundedCornerShape(10.dp)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(8.dp)
            .clickable {

            },
        backgroundColor = SolidWhite,
        shape = containerShape,
        elevation = 1.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(104.dp),
                contentAlignment = Alignment.Center
            ) {
                if(thumbnail != null) {
                    Image(
                        imageVector = thumbnail,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Spacer(modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                    )
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 4.dp),
                        text = "Image Not Available",
                        color = MaterialTheme.colors.onPrimary,
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        lineHeight = MaterialTheme.typography.h6.lineHeight,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(SolidWhite),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = MaterialTheme.typography.h5.letterSpacing,
                    color = DarkGray
                )
            }
        }
    }
}

@Composable
fun MenuCategoryRow(
    title: String,
    thumbnail: ImageVector? = null
) {
    val containerShape: Shape = RoundedCornerShape(0.dp)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        backgroundColor = SolidWhite,
        shape = containerShape,
        elevation = 1.dp
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(119.dp)
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Box(
                    modifier = Modifier
                        .size(100.dp),
                    contentAlignment = Alignment.Center
                ) {
                    if(thumbnail != null) {
                        Image(
                            imageVector = thumbnail,
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Spacer(modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black)
                        )
                        Text(
                            modifier = Modifier
                                .padding(horizontal = 4.dp),
                            text = "Image Not Available",
                            color = MaterialTheme.colors.onPrimary,
                            fontSize = MaterialTheme.typography.h6.fontSize,
                            lineHeight = MaterialTheme.typography.h6.lineHeight,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .background(SolidWhite),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = title,
                        textAlign = TextAlign.Center,
                        fontSize = MaterialTheme.typography.h5.fontSize,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = MaterialTheme.typography.h5.letterSpacing,
                        color = DarkGray
                    )
                }
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(SolidWhite),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        imageVector = Icons.Default.ArrowForwardIos,
                        contentDescription = null,
                        tint = DarkGray
                    )
                }
            }
            Divider(
                color = Color.LightGray.copy(alpha = 0.5f),
                thickness = 0.8.dp
            )
        }
    }
}
