package BiliLiverTrickGift

import BiliLiverTrickGift.relics.BiliLiveObserver
import basemod.BaseMod
import basemod.helpers.RelicType
import basemod.interfaces.*
import com.badlogic.gdx.Gdx
import com.evacipated.cardcrawl.mod.stslib.Keyword
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer
import com.google.gson.Gson
import com.megacrit.cardcrawl.unlock.UnlockTracker
import utils.logger
import java.nio.charset.StandardCharsets
import java.util.*

@SpireInitializer
class BiliLiverTrickGift :
    EditRelicsSubscriber,
    EditStringsSubscriber,
    EditKeywordsSubscriber,
    PostInitializeSubscriber {

    companion object {
        private val logger = logger()

        val settings = Properties()

        @JvmStatic
        fun initialize() {
            logger.info("========================= Initializing Default Mod. Hi. =========================");
            BiliLiverTrickGift()
            logger.info("========================= /Default Mod Initialized. Hello World./ =========================");
        }
    }

    init {
        BaseMod.subscribe(this)
    }

    override fun receiveEditRelics() {
        BaseMod.addRelic(BiliLiveObserver(), RelicType.SHARED)
        UnlockTracker.markRelicAsSeen(BiliLiveObserver.ID)
    }

    override fun receiveEditStrings() {
    }

    override fun receiveEditKeywords() {
        val gson = Gson()
        val json = Gdx.files.internal("$localizationDir/zhs/keyword.json").readString(StandardCharsets.UTF_8.toString())
        val keywords = gson.fromJson(json, Array<Keyword>::class.java)
        if (keywords != null) {
            for (keyword in keywords) {
                BaseMod.addKeyword(modID.toLowerCase(), keyword.PROPER_NAME, keyword.NAMES, keyword.DESCRIPTION)
            }
        }
    }

    override fun receivePostInitialize() {
    }
}