package dylan.kwon.shapecontainer

import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable

interface ShapeView {

    /**
     * initialize state.
     */
    var isInitialized: Boolean

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
     * Create and apply the background and foreground to be used in ShapeContainer.
     */
    fun invalidateShape()

    /**
     * Returns the background to use in the ShapeContainer.
     */
    fun createBackground(): GradientDrawable

    /**
     * Returns the foreground to use in the ShapeContainer.
     */
    fun createForeground(mask: Drawable): RippleDrawable?


    /**
     * Returns the radius.
     */
    fun createRadius(): FloatArray

    /**
     * Updatable.
     */
    interface Updatable {
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
}