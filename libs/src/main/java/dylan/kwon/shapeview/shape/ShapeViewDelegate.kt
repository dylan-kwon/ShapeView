package dylan.kwon.shapeview.shape

import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable

/**
 * ShapeView Delegate.
 */
interface ShapeViewDelegate {

    /**
     * Background color.
     */
    var shapeColor: ColorStateList?

    /**
     * Ripple color.
     */
    var rippleColor: ColorStateList?

    /**
     * Stroke width.
     */
    var strokeWidth: Float

    /**
     * Stroke dash width.
     */
    var strokeDashWidth: Float

    /**
     * Stroke dash gap.
     */
    var strokeDashGap: Float

    /**
     * Stroke color.
     */
    var strokeColor: ColorStateList?

    /**
     * top-left radius.
     */
    var topLeftRadius: Float

    /**
     * top-right radius.
     */
    var topRightRadius: Float

    /**
     * bottom-left radius.
     */
    var bottomLeftRadius: Float

    /**
     * bottom-right radius.
     */
    var bottomRightRadius: Float

    /**
     * If this value is true, the edges are clipped by the radius.
     */
    var useClip: Boolean

    /**
     * Whether to use ripple.
     */
    var useRipple: Boolean

    /**
     * Gradient type.
     */
    var gradientType: Int

    /**
     * Gradient start color.
     */
    var gradientStartColor: Int

    /**
     * Gradient center color.
     */
    var gradientCenterColor: Int

    /**
     * Gradient end color.
     */
    var gradientEndColor: Int

    /**
     * Gradient radius.
     */
    var gradientRadius: Float

    /**
     * Gradient x.
     */
    var gradientX: Float

    /**
     * Gradient y.
     */
    var gradientY: Float

    /**
     * Gradient orientation.
     */
    var gradientOrientation: Int

    /**
     * initialize.
     */
    fun init(attrIds: ShapeViewAttrIds)

    /**
     * If useClip is true, clip the corner.
     */
    fun draw(canvas: Canvas?)

    /**
     * The edges are clipped by the radius.
     */
    fun clip(canvas: Canvas)

    /**
     * Apply radius to all corners.
     */
    fun setCornerRadius(radius: Float)

    /**
     * Create and apply the background and foreground to be used in the ShapeView.
     */
    fun invalidateShape()

    /**
     * Returns the background to use in the ShapeView.
     */
    fun createBackground(): GradientDrawable

    /**
     * Returns the foreground to use in the ShapeView.
     */
    fun createForeground(): RippleDrawable?

    /**
     * Returns the radius.
     */
    fun createRadius(): FloatArray
}