/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.lunchtray.datasource

import com.example.lunchtray.model.MenuItem.AccompanimentItem
import com.example.lunchtray.model.MenuItem.EntreeItem
import com.example.lunchtray.model.MenuItem.SideDishItem

/**
 * Map of available menu items to be displayed in the menu fragments.
 */
object DataSource {

    val entreeMenuItems = listOf(
        EntreeItem(
            name = "Cauliflower",
            description = "Whole cauliflower, brined, roasted, and deep fried",
            price = 7.00,
        ),
        EntreeItem(
            name = "Three Bean Chili",
            description = "Black beans, red beans, kidney beans, slow cooked, topped with onion",
            price = 4.00,
        ),
        EntreeItem(
            name = "Mushroom Pasta",
            description = "Penne pasta, mushrooms, basil, with plum tomatoes cooked in garlic " +
                    "and olive oil",
            price = 5.50,
        ),
        EntreeItem(
            name = "Spicy Black Bean Skillet",
            description = "Seasonal vegetables, black beans, house spice blend, served with " +
                    "avocado and quick pickled onions",
            price = 5.50,
        )
    )

    val sideDishMenuItems = listOf(
        SideDishItem(
            name = "Summer Salad",
            description = "Heirloom tomatoes, butter lettuce, peaches, avocado, balsamic dressing",
            price = 2.50,
        ),
        SideDishItem(
            name = "Butternut Squash Soup",
            description = "Roasted butternut squash, roasted peppers, chili oil",
            price = 3.00,
        ),
        SideDishItem(
            name = "Spicy Potatoes",
            description = "Marble potatoes, roasted, and fried in house spice blend",
            price = 2.00,
        ),
        SideDishItem(
            name = "Coconut Rice",
            description = "Rice, coconut milk, lime, and sugar",
            price = 1.50,
        )
    )

    val accompanimentMenuItems = listOf(
        AccompanimentItem(
            name = "Lunch Roll",
            description = "Fresh baked roll made in house",
            price = 0.50,
        ),
        AccompanimentItem(
            name = "Mixed Berries",
            description = "Strawberries, blueberries, raspberries, and huckleberries",
            price = 1.00,
        ),
        AccompanimentItem(
            name = "Pickled Veggies",
            description = "Pickled cucumbers and carrots, made in house",
            price = 0.50,
        )
    )
}
