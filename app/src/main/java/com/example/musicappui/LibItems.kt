package com.example.musicappui
import androidx.annotation.DrawableRes

data class LibItems(@DrawableRes val icon: Int,val name: String )

val lib = listOf<LibItems>(
    LibItems(R.drawable.outline_queue_music_24,"Playlist"),
    LibItems(R.drawable.outline_mic_24,"Artists"),
    LibItems(R.drawable.outline_album_24,"Album"),
    LibItems(R.drawable.outline_music_note_24,"Songs"),
    LibItems(R.drawable.outline_genres_24,"Genre")
    )
