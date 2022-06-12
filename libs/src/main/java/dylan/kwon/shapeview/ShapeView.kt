package dylan.kwon.shapeview

import android.content.res.ColorStateList

/**
 * ShapeView.
 */
interface ShapeView {

    /**
     * ShapeView Delegate.
     */
    val delegate: ShapeViewDelegate

    /**
     * change shape color.
     */
    fun setShapeColor(color: ColorStateList?) {
        delegate.shapeColor = color
    }

    /**
     * change ripple color.
     */
    fun setRippleColor(color: ColorStateList?) {
        delegate.rippleColor = color
    }

    /**
     * change shape color.
     */
    fun setStrokeWidth(width: Float) {
        delegate.strokeWidth = width
    }

    /**
     * change stroke dash width.
     */
    fun setStrokeDashWidth(width: Float) {
        delegate.strokeDashWidth = width
    }

    /**
     * change stroke dash gap.
     */
    fun setStrokeDashGap(gap: Float) {
        delegate.strokeDashGap = gap
    }

    /**
     * change stroke color.
     */
    fun setStrokeColor(color: ColorStateList?) {
        delegate.strokeColor = color
    }

    /**
     * change all radius.
     */
    fun setCornerRadius(radius: Float) {
        delegate.setCornerRadius(radius)
    }

    /**
     * change top-left radius.
     */
    fun setTopLeftRadius(radius: Float) {
        delegate.topLeftRadius = radius
    }

    /**
     * change top-right radius.
     */
    fun setTopRightRadius(radius: Float) {
        delegate.topRightRadius = radius
    }

    /**
     * change bottom-left radius.
     */
    fun setBottomLeftRadius(radius: Float) {
        delegate.bottomLeftRadius = radius
    }

    /**
     * change bottom-right radius.
     */
    fun setBottomRightRadius(radius: Float) {
        delegate.bottomRightRadius = radius
    }

    /**
     * change use clip.
     */
    fun setUseClip(useClip: Boolean) {
        delegate.useClip = useClip
    }
}