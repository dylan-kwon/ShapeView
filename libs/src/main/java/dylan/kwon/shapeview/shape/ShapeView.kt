package dylan.kwon.shapeview.shape

import android.content.res.ColorStateList
import androidx.annotation.ColorInt

/**
 * ShapeView.
 */
interface ShapeView {

    /**
     * ShapeView Delegate.
     */
    val shapeDelegate: ShapeViewDelegate

    /**
     * change shape color.
     */
    fun setShapeColor(color: ColorStateList?) {
        shapeDelegate.shapeColor = color
    }

    /**
     * change ripple color.
     */
    fun setRippleColor(color: ColorStateList?) {
        shapeDelegate.rippleColor = color
    }

    /**
     * change shape color.
     */
    fun setStrokeWidth(width: Float) {
        shapeDelegate.strokeWidth = width
    }

    /**
     * change stroke dash width.
     */
    fun setStrokeDashWidth(width: Float) {
        shapeDelegate.strokeDashWidth = width
    }

    /**
     * change stroke dash gap.
     */
    fun setStrokeDashGap(gap: Float) {
        shapeDelegate.strokeDashGap = gap
    }

    /**
     * change stroke color.
     */
    fun setStrokeColor(color: ColorStateList?) {
        shapeDelegate.strokeColor = color
    }

    /**
     * change all radius.
     */
    fun setCornerRadius(radius: Float) {
        shapeDelegate.setCornerRadius(radius)
    }

    /**
     * change top-left radius.
     */
    fun setTopLeftRadius(radius: Float) {
        shapeDelegate.topLeftRadius = radius
    }

    /**
     * change top-right radius.
     */
    fun setTopRightRadius(radius: Float) {
        shapeDelegate.topRightRadius = radius
    }

    /**
     * change bottom-left radius.
     */
    fun setBottomLeftRadius(radius: Float) {
        shapeDelegate.bottomLeftRadius = radius
    }

    /**
     * change bottom-right radius.
     */
    fun setBottomRightRadius(radius: Float) {
        shapeDelegate.bottomRightRadius = radius
    }

    /**
     * change use clip.
     */
    fun setUseClip(useClip: Boolean) {
        shapeDelegate.useClip = useClip
    }

    /**
     * change gradient type.
     */
    fun setGradientType(type: Int) {
        shapeDelegate.gradientType = type
    }

    /**
     * change gradient start color.
     */
    fun setGradientStartColor(@ColorInt color: Int) {
        shapeDelegate.gradientStartColor = color
    }

    /**
     * change gradient center color.
     */
    fun setGradientCenterColor(@ColorInt color: Int) {
        shapeDelegate.gradientCenterColor = color
    }

    /**
     * change gradient end color.
     */
    fun setGradientEndColor(@ColorInt color: Int) {
        shapeDelegate.gradientEndColor = color
    }

    /**
     * change gradient radius.
     */
    fun setGradientRadius(radius: Float) {
        shapeDelegate.gradientRadius = radius
    }

    /**
     * change gradient x.
     */
    fun setGradientX(x: Float) {
        shapeDelegate.gradientX = x
    }

    /**
     * change gradient y.
     */
    fun setGradientY(y: Float) {
        shapeDelegate.gradientY = y
    }

    /**
     * change gradient orientation.
     */
    fun setGradientOrientation(orientation: Int) {
        shapeDelegate.gradientOrientation = orientation
    }
}