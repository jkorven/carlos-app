package com.example.carlos_app.data

import com.example.carlos_app.domain.model.ToggleOption

object OrderOptionsRepository {
    fun getOrderOptionsData(): List<ToggleOption> {
        return listOf(
            ToggleOption(
                title = "Carryout"
            ),
            ToggleOption(
                title = "Curbside"
            )
        )
    }
}