package com.example.musicappui

import androidx.annotation.DrawableRes

// nobody could able to inherit from a sealed class
sealed class Screen(val title:String, val route: String) {

    sealed class BottomScreen(val bTitle: String,
                              val bRoute: String,
                              @DrawableRes val icon: Int):  Screen(bTitle,bRoute)
    { object Home : BottomScreen("Home",
                                      "home",
                                      R.drawable.outline_music_video_24)

        object Browse: BottomScreen("Browse",
            "browse",
            R.drawable.outline_browse_24)

        object Library: BottomScreen("Library",
            "library",
            R.drawable.baseline_library_music_24)


    }

    sealed class DrawerScreen(
        val dTitle: String,
        val dRoute: String,
        @DrawableRes val icon: Int
        ): Screen(dTitle,dRoute){

            object Account: DrawerScreen(
                "Account",
                "account",
                R.drawable.ic_account
            )
            object Subscription: DrawerScreen(
                "Subscription",
                "subscribe",
                R.drawable.ic_subscribe
            )

            object AddAccount: DrawerScreen(
                "Add Account",
                "add_account",
                R.drawable.outline_person_add_24
            )
        }


}

val screensInBottom = listOf(
    Screen.BottomScreen.Home,
    Screen.BottomScreen.Browse,
    Screen.BottomScreen.Library
)
val screensInDrawer = listOf(
    Screen.DrawerScreen.AddAccount,
    Screen.DrawerScreen.Subscription,
    Screen.DrawerScreen.Account
)