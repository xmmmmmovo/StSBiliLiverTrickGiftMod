package BiliLiverTrickGift.relics

import BiliLiverTrickGift.makeID
import BiliLiverTrickGift.makeRelicOutlinePath
import BiliLiverTrickGift.makeRelicPath
import basemod.abstracts.CustomRelic
import com.badlogic.gdx.graphics.Texture;
import utils.TextureLoader


class BiliLiveObserver : CustomRelic(ID, IMG, OUTLINE, RelicTier.STARTER, LandingSound.MAGICAL) {
    companion object {
        val ID: String = makeID("BiliLiveObserver")
        private val IMG: Texture? = TextureLoader.getTexture(makeRelicPath("placeholder_relic.png"))
        private val OUTLINE: Texture? = TextureLoader.getTexture(makeRelicOutlinePath("placeholder_relic.png"))
    }

    override fun atBattleStart() {
        flash()
    }
}