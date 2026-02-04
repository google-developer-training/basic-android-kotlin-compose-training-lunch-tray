package com.example.lunchtray.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.lunchtray.LunchTrayApp
import com.example.lunchtray.LunchTrayScreen
import com.example.lunchtray.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class LunchTrayScreenNavigationTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    fun setupLunchTrayNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            LunchTrayApp(navController = navController)
        }
    }

    private fun navigateToEntreeMenu() {
        composeTestRule.onNodeWithStringId(R.string.start_order)
            .performClick()
        composeTestRule.onNodeWithText("Cauliflower")
            .performClick()
    }

    private fun navigateToSideDishMenu() {
        navigateToEntreeMenu()
        performNavigateNext()
        composeTestRule.onNodeWithText("Summer Salad")
            .performClick()
    }

    private fun navigateToAccompanimentMenu() {
        navigateToSideDishMenu()
        performNavigateNext()
        composeTestRule.onNodeWithText("Lunch Roll")
            .performClick()
    }

    private fun navigateToCheckout() {
        navigateToAccompanimentMenu()
        performNavigateNext()
    }

    private fun performNavigateUp() {
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithContentDescription(backText).performClick()
    }

    private fun performNavigateNext() {
        composeTestRule.onNodeWithText("NEXT") // боже...
            .performClick()
    }

    private fun performNavigateCancel() {
        composeTestRule.onNodeWithText("CANCEL") // чему я позволяю быть...
            .performClick()
    }

    @Test
    fun lunchTrayNavHost_verifyStartDestination() {
        navController.assertCurrentRouteName(LunchTrayScreen.Start.name)
    }

    @Test
    fun lunchTrayNavHost_verifyBackNavigationNotShownOnStartOrderScreen() {
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithContentDescription(backText).assertDoesNotExist()
    }

    // Entree Menu
    @Test
    fun lunchTrayNavHost_clickStartOrder_navigatesToSelectEntreeMenuScreen() {
        navigateToEntreeMenu()
        navController.assertCurrentRouteName(LunchTrayScreen.EntreeMenu.name)
    }

    @Test
    fun lunchTrayNavHost_clickBackOnEntreeMenuScreen_navigatesToStartOrderScreen() {
        navigateToEntreeMenu()
        performNavigateUp()
        navController.assertCurrentRouteName(LunchTrayScreen.Start.name)
    }

    @Test
    fun lunchTrayNavHost_clickCancelOnEntreeMenuScreen_navigatesToStartOrderScreen() {
        navigateToEntreeMenu()
        performNavigateCancel()
        navController.assertCurrentRouteName(LunchTrayScreen.Start.name)
    }

    // Side Dish Menu
    @Test
    fun lunchTrayNavHost_navigatesToSideDishMenuScreen() {
        navigateToSideDishMenu()
        navController.assertCurrentRouteName(LunchTrayScreen.SideDishMenu.name)
    }

    @Test
    fun lunchTrayNavHost_clickBackOnSideDishMenuScreen_navigatesToEntreeMenuScreen() {
        navigateToSideDishMenu()
        performNavigateUp()
        navController.assertCurrentRouteName(LunchTrayScreen.EntreeMenu.name)
    }

    @Test
    fun lunchTrayNavHost_clickCancelOnSideDishMenuScreen_navigatesToStartOrderScreen() {
        navigateToSideDishMenu()
        performNavigateCancel()
        navController.assertCurrentRouteName(LunchTrayScreen.Start.name)
    }

    // Accompaniment Menu
    @Test
    fun lunchTrayNavHost_navigatesToAccompanimentMenuScreen() {
        navigateToAccompanimentMenu()
        navController.assertCurrentRouteName(LunchTrayScreen.AccompanimentMenu.name)
    }

    @Test
    fun lunchTrayNavHost_clickBackOnAccompanimentMenuScreen_navigatesToSideDishMenuScreen() {
        navigateToAccompanimentMenu()
        performNavigateUp()
        navController.assertCurrentRouteName(LunchTrayScreen.SideDishMenu.name)
    }

    @Test
    fun lunchTrayNavHost_clickCancelOnAccompanimentMenuScreen_navigatesToStartOrderScreen() {
        navigateToAccompanimentMenu()
        performNavigateCancel()
        navController.assertCurrentRouteName(LunchTrayScreen.Start.name)
    }

    // Checkout
    @Test
    fun lunchTrayNavHost_navigatesToCheckout() {
        navigateToCheckout()
        navController.assertCurrentRouteName(LunchTrayScreen.Checkout.name)
    }

    @Test
    fun lunchTrayNavHost_clickBackOnCheckoutScreen_navigatesToAccompanimentMenuScreen() {
        navigateToCheckout()
        performNavigateUp()
        navController.assertCurrentRouteName(LunchTrayScreen.AccompanimentMenu.name)
    }

    @Test
    fun lunchTrayNavHost_clickCancelOnCheckoutScreen_navigatesToStartOrderScreen() {
        navigateToCheckout()
        performNavigateCancel()
        navController.assertCurrentRouteName(LunchTrayScreen.Start.name)
    }
}