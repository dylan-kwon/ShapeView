package dylan.kwon.shapeview.shape

import androidx.annotation.StyleableRes

class ShapeViewAttrIds(

    @StyleableRes val attrs: IntArray,
    @StyleableRes val cornerRadius: Int = NONE,
    @StyleableRes val topLeftRadius: Int = NONE,
    @StyleableRes val topRightRadius: Int = NONE,
    @StyleableRes val bottomLeftRadius: Int = NONE,
    @StyleableRes val bottomRightRadius: Int = NONE,
    @StyleableRes val solidColor: Int = NONE,
    @StyleableRes val rippleColor: Int = NONE,
    @StyleableRes val strokeWidth: Int = NONE,
    @StyleableRes val strokeDashWidth: Int = NONE,
    @StyleableRes val strokeDashGap: Int = NONE,
    @StyleableRes val strokeColor: Int = NONE,
    @StyleableRes val useClip: Int = NONE,
    @StyleableRes val useRipple: Int = NONE,
    @StyleableRes val gradientType: Int = NONE,
    @StyleableRes val gradientStartColor: Int = NONE,
    @StyleableRes val gradientCenterColor: Int = NONE,
    @StyleableRes val gradientEndColor: Int = NONE,
    @StyleableRes val gradientRadius: Int = NONE,
    @StyleableRes val gradientX: Int = NONE,
    @StyleableRes val gradientY: Int = NONE,
    @StyleableRes val gradientOrientation: Int = NONE

) {
    companion object {
        const val NONE = -1
    }
}