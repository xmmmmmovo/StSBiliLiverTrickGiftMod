package BiliLiverTrickGift.utils

import com.evacipated.cardcrawl.modthespire.lib.SpireConfig
import java.io.IOException

fun saveSettings() {
    try {
        val config = SpireConfig("blive", "blivesettings")
        config.save()
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

fun loadSettings() {
    try {
        val config = SpireConfig("blive", "blivesettings")
        config.load()
    } catch (e: IOException) {
        e.printStackTrace()
    }
}