package dylan.kwon.shapeview.shape

import android.graphics.drawable.GradientDrawable

object GradientOrientation {
    const val TOP_BOTTOM = 0
    const val TR_BL = 1
    const val RIGHT_LEFT = 2
    const val BR_TL = 3
    const val BOTTOM_TOP = 4
    const val BL_TR = 5
    const val LEFT_RIGHT = 6
    const val TL_BR = 7
}

fun GradientDrawable.Orientation.toInt(): Int {
    return when (this) {
        GradientDrawable.Orientation.TOP_BOTTOM -> GradientOrientation.TOP_BOTTOM
        GradientDrawable.Orientation.TR_BL -> GradientOrientation.TR_BL
        GradientDrawable.Orientation.RIGHT_LEFT -> GradientOrientation.RIGHT_LEFT
        GradientDrawable.Orientation.BR_TL -> GradientOrientation.BR_TL
        GradientDrawable.Orientation.BOTTOM_TOP -> GradientOrientation.BOTTOM_TOP
        GradientDrawable.Orientation.BL_TR -> GradientOrientation.BL_TR
        GradientDrawable.Orientation.LEFT_RIGHT -> GradientOrientation.LEFT_RIGHT
        GradientDrawable.Orientation.TL_BR -> GradientOrientation.TL_BR
    }
}

fun gradientOrientationOf(orientation: Int): GradientDrawable.Orientation {
    return when (orientation) {
        GradientOrientation.TOP_BOTTOM -> GradientDrawable.Orientation.TOP_BOTTOM
        GradientOrientation.TR_BL -> GradientDrawable.Orientation.TR_BL
        GradientOrientation.RIGHT_LEFT -> GradientDrawable.Orientation.RIGHT_LEFT
        GradientOrientation.BR_TL -> GradientDrawable.Orientation.BR_TL
        GradientOrientation.BOTTOM_TOP -> GradientDrawable.Orientation.BOTTOM_TOP
        GradientOrientation.BL_TR -> GradientDrawable.Orientation.BL_TR
        GradientOrientation.TL_BR -> GradientDrawable.Orientation.TL_BR
        else -> GradientDrawable.Orientation.LEFT_RIGHT
    }
}
