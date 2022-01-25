package BiliLiverTrickGift

const val modID = "BiliLiverTrickGift"

const val MODNAME = "BliveGiftMod"
const val AUTHOR = "xmmmmmovo"
const val DESCRIPTION = "TEST."

fun makeID(text: String) = "$modID:$text"

fun makeImgResPath(text:String) = "$modID/images/$text"

fun makeLocalizationPath(text: String) = "$modID/localization/$text"

fun makeRelicPath(resourcePath: String): String = "$modID/images/relics/$resourcePath"


fun makeRelicOutlinePath(resourcePath: String): String = "$modID/images/relics/outline/$resourcePath"

