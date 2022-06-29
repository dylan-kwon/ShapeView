package dylan.kwon.shapeview.shadow

interface ShadowView {

    /**
     * ShadowView Delegate.
     */
    val shadowDelegate: ShadowViewDelegate

    fun setShadowColor(shadowColor: Int) {
        shadowDelegate.shadowColor = shadowColor
    }

    fun setShadowBlur(shadowBlur: Float) {
        shadowDelegate.shadowBlur = shadowBlur
    }

    fun setShadowSpread(shadowSpread: Float) {
        shadowDelegate.shadowSpread = shadowSpread
    }

    fun setShadowInset(shadowInset: Boolean) {
        shadowDelegate.shadowInset = shadowInset
    }

    fun setShadowXOffset(xOffset: Float) {
        shadowDelegate.shadowXOffset = xOffset
    }

    fun setShadowYOffset(yOffset: Float) {
        shadowDelegate.shadowYOffset = yOffset
    }

}