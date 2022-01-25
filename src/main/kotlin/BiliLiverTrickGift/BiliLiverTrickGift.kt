package BiliLiverTrickGift

import BiliLiverTrickGift.relics.BiliLiveObserver
import BiliLiverTrickGift.utils.TextureLoader
import BiliLiverTrickGift.utils.loadSettings
import BiliLiverTrickGift.utils.logger
import basemod.BaseMod
import basemod.ModLabeledButton
import basemod.ModPanel
import basemod.helpers.RelicType
import basemod.interfaces.EditRelicsSubscriber
import basemod.interfaces.EditStringsSubscriber
import basemod.interfaces.PostCreateStartingRelicsSubscriber
import basemod.interfaces.PostInitializeSubscriber
import com.badlogic.gdx.graphics.Color
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer
import com.megacrit.cardcrawl.characters.AbstractPlayer
import com.megacrit.cardcrawl.core.CardCrawlGame
import com.megacrit.cardcrawl.core.Settings
import com.megacrit.cardcrawl.helpers.FontHelper
import com.megacrit.cardcrawl.localization.RelicStrings
import com.megacrit.cardcrawl.localization.UIStrings
import com.megacrit.cardcrawl.screens.mainMenu.MainMenuScreen
import com.megacrit.cardcrawl.ui.panels.SeedPanel
import com.megacrit.cardcrawl.unlock.UnlockTracker
import java.util.*

@SpireInitializer
class BiliLiverTrickGift :
    PostInitializeSubscriber,
    EditRelicsSubscriber,
    EditStringsSubscriber,
    PostCreateStartingRelicsSubscriber {

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
        logger.info("loading relics!")
        BaseMod.addRelic(BiliLiveObserver(), RelicType.SHARED)
        UnlockTracker.markRelicAsSeen(BiliLiveObserver.ID)
        logger.info("relics loading over!")
    }

    override fun receiveEditStrings() {
        BaseMod.loadCustomStringsFile(
            RelicStrings::class.java,
            makeLocalizationPath("relics-${Settings.language}.json")
        )
        BaseMod.loadCustomStringsFile(UIStrings::class.java, makeLocalizationPath("ui-${Settings.language}.json"))
    }

    override fun receivePostInitialize() {
        loadSettings()

        val uiStrings = CardCrawlGame.languagePack.getUIString(makeID("ModPanel"))
        val settingsPanel = ModPanel()
        settingsPanel.addUIElement(ModLabeledButton(
            uiStrings.TEXT[0], 370.0f, 700.0f,
            Color.WHITE, Color.WHITE, FontHelper.buttonLabelFont, settingsPanel
        ) { me: ModLabeledButton ->
            val sp = SeedPanel()
            sp.show(MainMenuScreen.CurScreen.NONE)
            me.label = uiStrings.TEXT[0]
        })

        val badgeTexture = TextureLoader.getTexture(makeImgResPath("TrainingBadge.png"))
        BaseMod.registerModBadge(badgeTexture, MODNAME, AUTHOR, DESCRIPTION, settingsPanel)
    }

    override fun receivePostCreateStartingRelics(player: AbstractPlayer.PlayerClass?, relics: ArrayList<String>?) {
        relics?.add(BiliLiveObserver.ID)
    }
}