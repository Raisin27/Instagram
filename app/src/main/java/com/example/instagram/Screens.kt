package com.example.instagram

import androidx.annotation.StringRes

sealed class Screens(val screen: String, @StringRes val resourceId: Int) {
    data object Home : Screens("home", R.string.home)
    data object Search : Screens("search", R.string.search )
    data object Profile : Screens("profile", R.string.profile)
    data object Reel : Screens("reel", R.string.reel)
    data object NewPost : Screens("newpost", R.string.new_post)
}