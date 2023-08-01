package com.example.carlos_app.ui.screens.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.carlos_app.data.MenuRepository.getMenuCategoriesData
import com.example.carlos_app.providers.Local
import com.example.carlos_app.ui.viewmodel.AppViewModel
import com.example.carlos_app.util.CustomModifiers.backgroundGradiant

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
    val menuCategoriesList = getMenuCategoriesData()
    var size by remember { mutableStateOf(IntSize.Zero)}
    Box(
        modifier = Modifier
            .fillMaxSize()
            .onGloballyPositioned {
                size = it.size
            }
            .padding(horizontal = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
        ) {
            items(items = menuCategoriesList, itemContent = {
                MenuCategoryCard(title = it.title)
            })
        }
    }
}

@Composable
fun MenuCategoryCard(
    title: String,
    thumbnail: ImageVector? = null
) {
    Surface(
        modifier = Modifier
            .height(156.dp)
            .width(86.dp)
            .padding(vertical = 10.dp),
        color = MaterialTheme.colors.surface,
        elevation = 12.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .height(140.dp)
                    .width(90.dp),
                backgroundColor = Color.Transparent,
                shape = RoundedCornerShape(5.dp),
                elevation = 8.dp
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp),
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
                            .height(50.dp)
                            .background(Color.Blue),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = title)
                    }
                }
            }
        }
    }
}
