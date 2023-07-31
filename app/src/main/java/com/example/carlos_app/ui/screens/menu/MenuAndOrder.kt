package com.example.carlos_app.ui.screens.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
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
    var size by remember { mutableStateOf(IntSize.Zero)}
    Box(
        modifier = Modifier
            .fillMaxSize()
            .onGloballyPositioned {
                size = it.size
            }
            .backgroundGradiant(
                colors = listOf(
                    Color.White, Color.Gray
                ),
                start = size.height * 0.6f
            ),
        contentAlignment = Alignment.Center
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
        ) {

        }
    }
}

@Composable
fun MenuCategoryCard(
    title: String,
    thumbnail: ImageVector? = null
) {
    Column(
        modifier = Modifier
            .height(50.dp)
            .width(30.dp)
            .background(color = Color.Transparent, shape = RoundedCornerShape(5.dp))
            .shadow(5.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp),
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
                    .background(Color.Cyan))
                Text(text = "Image Not Available")
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        ) {

        }

    }
}
