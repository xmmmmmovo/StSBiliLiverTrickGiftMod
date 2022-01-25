package BiliLiverTrickGift.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.full.companionObject

inline fun <reified R : Any> R.logger(): Logger = LoggerFactory.getLogger(unwrapCompanionClass(R::class.java))

fun <T : Any> unwrapCompanionClass(ofClass: Class<T>): Class<*> =
    if (ofClass.enclosingClass != null && ofClass.enclosingClass.kotlin.companionObject?.java == ofClass) {
        ofClass.enclosingClass
    } else {
        ofClass
    }
