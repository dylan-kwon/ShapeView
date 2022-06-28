package dylan.kwon.shapeview.shadow

import androidx.annotation.StyleableRes

class ShadowViewAttrIds(

    @StyleableRes val attrs: IntArray,
    @StyleableRes val shadowXOffset: Int = NONE,
    @StyleableRes val shadowYOffset: Int = NONE,
    @StyleableRes val shadowColor: Int = NONE,
    @StyleableRes val shadowBlur: Int = NONE,
    @StyleableRes val shadowSpread: Int = NONE,
    @StyleableRes val shadowInset: Int = NONE,
    @StyleableRes val shadowRadius: Int = NONE,
    @StyleableRes val topLeftShadowRadius: Int = NONE,
    @StyleableRes val topRightShadowRadius: Int = NONE,
    @StyleableRes val bottomLeftShadowRadius: Int = NONE,
    @StyleableRes val bottomRightShadowRadius: Int = NONE

) {

    companion object {
        const val NONE = -1
    }

}