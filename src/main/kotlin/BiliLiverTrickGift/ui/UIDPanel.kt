package BiliLiverTrickGift.ui

import BiliLiverTrickGift.makeID
import com.megacrit.cardcrawl.core.CardCrawlGame
import com.megacrit.cardcrawl.ui.panels.SeedPanel


class UIDPanel : SeedPanel() {
    private val uiStrings = CardCrawlGame.languagePack.getUIString(makeID("UIDPanel"))
    val TEXT = uiStrings.TEXT

    init {
        textField = ""
    }

    override fun confirm() {
        textField = textField.trim()
        close()
    }

    override fun close() {
        super.close()
    }
}