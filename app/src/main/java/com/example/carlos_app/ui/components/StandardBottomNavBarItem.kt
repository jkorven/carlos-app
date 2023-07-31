package com.example.carlos_app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carlos_app.ui.theme.IconSizeMedium
import com.example.carlos_app.ui.theme.MediumGray

@Composable
fun RowScope.StandardBottomNavBarItem(
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    title: String? = null,
    alertCount: Int? = null,
    contentDescription: String? = null,
    selected: Boolean = false,
    selectedColor: Color = MaterialTheme.colors.primary,
    unselectedColor: Color = MediumGray,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    BottomNavigationItem(
        modifier = modifier,
        selected = selected,
        onClick = onClick,
        enabled = enabled,
        selectedContentColor = selectedColor,
        unselectedContentColor = unselectedColor,
        label = {
            if(title != null) {
                val textStyle = MaterialTheme.typography.button
                BoxWithConstraints {
                    Text(
                        modifier = Modifier
                            .wrapContentWidth(unbounded = true)
                            .requiredWidth(maxWidth + 24.dp),
                        text = title,
                        fontSize = textStyle.fontSize,
                        fontWeight = FontWeight.Bold,
                        softWrap = false
                    )
                }
            }
        },
        icon = {
            Box(
                modifier = Modifier
            ) {
                if(icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = contentDescription,
                        modifier = Modifier
                            .size(IconSizeMedium)
                    )
                }
                if (alertCount != null) {
                    val alertText = if (alertCount > 99) {
                        "99+"
                    } else {
                        alertCount.toString()
                    }
                    Text(
                        text = alertText,
                        color = MaterialTheme.colors.onPrimary,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 10.sp,
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(10.dp)
                            .size(15.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colors.primary)
                    )
                }
            }
        },
    )
}