package dylan.kwon.shapeview

import android.content.res.ColorStateList

/**
 * ShapeView.
 */
interface ShapeView {
    /**
     * change shape color.
     */
    fun setShapeColor(color: ColorStateList?)

    /**
     * change ripple color.
     */
    fun setRippleColor(color: ColorStateList?)

    /**
     * change shape color.
     */
    fun setStrokeWidth(width: Float)

    /**
     * change stroke dash width.
     */
    fun setStrokeDashWidth(width: Float)

    /**
     * change stroke dash gap.
     */
    fun setStrokeDashGap(gap: Float)

    /**
     * change stroke color.
     */
    fun setStrokeColor(color: ColorStateList?)

    /**
     * change all radius.
     */
    fun setRadius(radius: Float)

    /**
     * change top-left radius.
     */
    fun setTopLeftRadius(radius: Float)

    /**
     * change top-right radius.
     */
    fun setTopRightRadius(radius: Float)

    /**
     * change bottom-left radius.
     */
    fun setBottomLeftRadius(radius: Float)

    /**
     * change bottom-right radius.
     */
    fun setBottomRightRadius(radius: Float)

    /**
     * change use clip.
     */
    fun setUseClip(useClip: Boolean)
}