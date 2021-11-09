package BiliLiverTrickGift

val modID = "BiliLiverTrickGift"

val resourceDir = "$modID/resources"
val localizationDir = "$resourceDir/localization"

fun makeID(text: String) = "$modID:$text"

fun makeRelicPath(resourcePath: String): String = "$resourceDir/images/relics/$resourcePath"


fun makeRelicOutlinePath(resourcePath: String): String = "$resourceDir/images/relics/outline/$resourcePath"

