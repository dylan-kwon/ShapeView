package dylan.kwon.shapeview.shadow

import android.graphics.Canvas
import androidx.annotation.Px

interface ShadowViewDelegate {

    var shadowColor: Int

    var shadowBlur: Float

    var shadowSpread: Float

    var shadowXOffset: Float

    var shadowYOffset: Float

    var shadowRadius: Float

    var topLeftShadowRadius: Float

    var topRightShadowRadius: Float

    var bottomLeftShadowRadius: Float

    var bottomRightShadowRadius: Float

    var shadowInset: Boolean

    fun init(attrIds: ShadowViewAttrIds)

    fun setShadowRadius(
        @Px topLeft: Float,
        @Px topRight: Float,
        @Px bottomLeft: Float,
        @Px bottomRight: Float
    )

    fun resetShadowOffset()

    fun invalidate()

    fun onAttachedToWindow()

    fun onDetachedFromWindow()

    fun draw(canvas: Canvas?)

    fun drawShadow(canvas: Canvas)

    fun onSizeChanged(w: Int, h: Int, oldW: Int, oldH: Int)
}