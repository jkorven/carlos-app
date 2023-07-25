package com.example.carlos_app.ui.components.scaffolds

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.carlos_app.domain.model.BottomNavBarItem
import com.example.carlos_app.ui.components.StandardBottomNavBar
import com.example.carlos_app.util.conditional

@ExperimentalMaterial3Api
@Composable
fun StandardScaffold(
    modifier: Modifier = Modifier,
    showBottomNavBar: Boolean = true,
    bottomNavBarItems: List<BottomNavBarItem>,
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            if(showBottomNavBar) {
                StandardBottomNavBar(bottomNavBarItems = bottomNavBarItems)
            }
        }
    ) {innerPadding ->
        Box(
            modifier =  Modifier
                .conditional(showBottomNavBar) {
                    padding(PaddingValues(bottom = innerPadding.calculateBottomPadding()))
                }
        ) {
            content()
        }
    }
}