package BiliLiverTrickGift

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer
import utils.logger

@SpireInitializer
class BiliLiverTrickGift {

    companion object {
        private val _modID = "BiliLiverTrickGift"
        private val logger = logger()

        val modId
            get() = _modID

        @JvmStatic
        fun initialize() {
            logger.info("========================= Initializing Default Mod. Hi. =========================");
            BiliLiverTrickGift()
            logger.info("========================= /Default Mod Initialized. Hello World./ =========================");
        }
    }

}