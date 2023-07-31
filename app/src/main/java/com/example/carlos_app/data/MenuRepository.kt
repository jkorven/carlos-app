package com.example.carlos_app.data

import com.example.carlos_app.domain.model.MenuCategory

object MenuRepository {
    fun getMenuCategoriesData(): List<MenuCategory> {
        return listOf(
            MenuCategory(
                title = "Appetizers",
                thumbnail = null
            ),
            MenuCategory(
                title = "Salads",
                thumbnail = null
            ),
            MenuCategory(
                title = "Taco Street",
                thumbnail = null,
            ),
            MenuCategory(
                title = "Burritos",
                thumbnail = null,

            ),
            MenuCategory(
                title = "Enchiladas",
                thumbnail = null,

            ),
            MenuCategory(
                title = "Fajitas",
                thumbnail = null,

            ),MenuCategory(
                title = "Chimichangas",
                thumbnail = null,

            ),
            MenuCategory(
                title = "Combo Platters",
                thumbnail = null,

            ),
            MenuCategory(
                title = "Sides",
                thumbnail = null,

            ),
            MenuCategory(
                title = "Drinks",
                thumbnail = null,

            ),
            MenuCategory(
                title = "Desserts",
                thumbnail = null,

            ),
        )
    }

}