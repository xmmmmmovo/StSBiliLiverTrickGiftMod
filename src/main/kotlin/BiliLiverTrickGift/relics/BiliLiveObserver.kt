package BiliLiverTrickGift.relics

import BiliLiverTrickGift.makeID
import BiliLiverTrickGift.makeRelicOutlinePath
import BiliLiverTrickGift.makeRelicPath
import BiliLiverTrickGift.ui.UIDPanel
import BiliLiverTrickGift.utils.TextureLoader
import BiliLiverTrickGift.utils.logger
import basemod.abstracts.CustomRelic
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.evacipated.cardcrawl.mod.stslib.relics.ClickableRelic
import com.megacrit.cardcrawl.screens.mainMenu.MainMenuScreen
import com.megacrit.cardcrawl.ui.panels.SeedPanel


class BiliLiveObserver : CustomRelic(ID, IMG, OUTLINE, RelicTier.STARTER, LandingSound.FLAT), ClickableRelic {
    companion object {
        @JvmStatic
        val ID: String = makeID("BiliLiveObserver")

        @JvmStatic
        private val IMG: Texture = TextureLoader.getTexture(makeRelicPath("placeholder_relic.png"))

        @JvmStatic
        private val OUTLINE: Texture = TextureLoader.getTexture(makeRelicOutlinePath("placeholder_relic.png"))

        val logger = logger()

    }

    private val sp = SeedPanel()

    override fun onEquip() {
        super.onEquip()
        logger.info("Equiped!")
    }

    override fun atBattleStart() {
        flash()
    }

    override fun onRightClick() {
        logger.info("clicked!")
        sp.show(MainMenuScreen.CurScreen.NEOW_SCREEN)
        logger.info("showed22!!")
    }

    override fun render(sb: SpriteBatch?) {
        super.render(sb)
        sp.render(sb)
    }

    // Description
    override fun getUpdatedDescription(): String? {
        return DESCRIPTIONS[0]
    }
}