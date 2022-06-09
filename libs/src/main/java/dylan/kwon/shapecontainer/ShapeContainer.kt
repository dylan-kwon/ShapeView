package dylan.kwon.shapecontainer

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Path
import android.graphics.RectF
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.core.content.res.use
import com.google.android.material.color.MaterialColors

open class ShapeContainer @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0

) : FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

    /**
     * Background color.
     */
    var solidEnabledColor: Int = Color.WHITE  // enabled.
    var solidDisabledColor: Int = Color.WHITE // disabled.

    /**
     * Ripple color.
     */
    var rippleColor: Int = Color.TRANSPARENT // enabled.

    /**
     * Stroke width.
     */
    var strokeEnabledWidth: Float = 0f  // enabled.
    var strokeDisabledWidth: Float = 0f // disabled.

    /**
     * Stroke dash width.
     */
    var strokeEnabledDashWidth: Float = 0f  // enabled.
    var strokeDisabledDashWidth: Float = 0f // disabled.

    /**
     * Stroke dash gap.
     */
    var strokeEnabledDashGap: Float = 0f  // enabled.
    var strokeDisabledDashGap: Float = 0f // disabled.

    /**
     * Stroke color.
     */
    var strokeEnabledColor: Int = Color.TRANSPARENT  // enabled.
    var strokeDisabledColor: Int = Color.TRANSPARENT // disabled.

    /**
     * top-left radius.
     */
    var topLeftEnabledRadius: Float = 0f  // enabled.
    var topLeftDisabledRadius: Float = 0f // disabled.

    /**
     * top-right radius.
     */
    var topRightEnabledRadius: Float = 0f  // enabled.
    var topRightDisabledRadius: Float = 0f // disabled.

    /**
     * bottom-left radius.
     */
    var bottomLeftEnabledRadius: Float = 0f  // enabled.
    var bottomLeftDisabledRadius: Float = 0f // disabled.

    /**
     * bottom-right radius.
     */
    var bottomRightEnabledRadius: Float = 0f  // enabled.
    var bottomRightDisabledRadius: Float = 0f // disabled.

    /**
     * If this value is true, the edges are clipped by the radius.
     */
    var useClip: Boolean = false

    /**
     * initialize.
     */
    init {
        context.obtainStyledAttributes(
            attrs, R.styleable.ShapeContainer, defStyleAttr, defStyleRes
        ).use {
            val cornerEnabledRadius = it.getDimension(
                R.styleable.ShapeContainer_cornerRadius, -1f
            )
            if (cornerEnabledRadius > -1) {
                setCornerEnabledRadius(cornerEnabledRadius)
            } else {
                topLeftEnabledRadius = it.getDimension(
                    R.styleable.ShapeContainer_topLeftRadius, 0f
                )
                topRightEnabledRadius = it.getDimension(
                    R.styleable.ShapeContainer_topRightRadius, 0f
                )
                bottomLeftEnabledRadius = it.getDimension(
                    R.styleable.ShapeContainer_bottomLeftRadius, 0f
                )
                bottomRightEnabledRadius = it.getDimension(
                    R.styleable.ShapeContainer_bottomRightRadius, 0f
                )
            }
            val cornerDisabledRadius = it.getDimension(
                R.styleable.ShapeContainer_cornerDisableRadius, cornerEnabledRadius
            )
            if (cornerDisabledRadius > -1) {
                setCornerDisabledRadius(cornerDisabledRadius)
            } else {
                topLeftDisabledRadius = it.getDimension(
                    R.styleable.ShapeContainer_topLeftDisableRadius, topLeftEnabledRadius
                )
                topRightDisabledRadius = it.getDimension(
                    R.styleable.ShapeContainer_topRightDisableRadius, topRightEnabledRadius
                )
                bottomLeftDisabledRadius = it.getDimension(
                    R.styleable.ShapeContainer_bottomLeftDisableRadius, bottomLeftEnabledRadius
                )
                bottomRightDisabledRadius = it.getDimension(
                    R.styleable.ShapeContainer_bottomRightDisableRadius, bottomRightEnabledRadius
                )
            }
            solidEnabledColor = it.getColor(
                R.styleable.ShapeContainer_solidColor, Color.WHITE
            )
            solidDisabledColor = it.getColor(
                R.styleable.ShapeContainer_solidDisabledColor, solidEnabledColor
            )
            rippleColor = it.getColor(
                R.styleable.ShapeContainer_rippleColor,
                MaterialColors.getColor(
                    this,
                    com.google.android.material.R.attr.colorControlHighlight
                )
            )
            strokeEnabledWidth = it.getDimension(
                R.styleable.ShapeContainer_strokeWidth, 0f
            )
            strokeDisabledWidth = it.getDimension(
                R.styleable.ShapeContainer_strokeDisabledWidth, strokeEnabledWidth
            )
            strokeEnabledDashWidth = it.getDimension(
                R.styleable.ShapeContainer_strokeDashWidth, 0f
            )
            strokeDisabledDashWidth = it.getDimension(
                R.styleable.ShapeContainer_strokeDisabledDashWidth, strokeEnabledDashWidth
            )
            strokeEnabledDashGap = it.getDimension(
                R.styleable.ShapeContainer_strokeDashGap, 0f
            )
            strokeDisabledDashGap = it.getDimension(
                R.styleable.ShapeContainer_strokeDisabledDashGap, strokeEnabledDashGap
            )
            strokeEnabledColor = it.getColor(
                R.styleable.ShapeContainer_strokeColor, Color.WHITE
            )
            strokeDisabledColor = it.getColor(
                R.styleable.ShapeContainer_strokeDisabledColor, strokeEnabledColor
            )
            isEnabled = it.getBoolean(
                R.styleable.ShapeContainer_enabled, true
            )
            useClip = it.getBoolean(
                R.styleable.ShapeContainer_useClip, false
            )
        }
        createShape()
    }

    /**
     * If useClip is true, clip the corner.
     */
    override fun draw(canvas: Canvas?) {
        if (useClip && canvas != null) {
            clip(canvas)
        }
        super.draw(canvas)
    }

    /**
     * The edges are clipped by the radius.
     */
    @Suppress("MemberVisibilityCanBePrivate")
    protected fun clip(canvas: Canvas) {
        val clipPath = Path().apply {
            addRoundRect(
                RectF(canvas.clipBounds), createRadius(), Path.Direction.CW
            )
        }
        canvas.clipPath(clipPath)
    }

    /**
     * Apply radius to all enabled corners.
     */
    fun setCornerEnabledRadius(radius: Float) {
        topLeftEnabledRadius = radius
        topRightEnabledRadius = radius
        bottomLeftEnabledRadius = radius
        bottomRightEnabledRadius = radius
    }

    /**
     * Apply radius to all disabled corners.
     */
    fun setCornerDisabledRadius(radius: Float) {
        topLeftDisabledRadius = radius
        topRightDisabledRadius = radius
        bottomLeftDisabledRadius = radius
        bottomRightDisabledRadius = radius
    }

    /**
     * Create and apply the background and foreground to be used in ShapeContainer.
     */
    private fun createShape() {
        background = createBackground()
        foreground = createForeground(background)
    }

    /**
     * Returns the background to use in the ShapeContainer.
     */
    private fun createBackground(): GradientDrawable = GradientDrawable().apply {
        this.shape = GradientDrawable.RECTANGLE
        this.color = createSolidColor()
        this.cornerRadii = createRadius()
        this.setStroke(
            getStrokeWidth().toInt(),
            createStrokeColor(),
            getStrokeDashWidth(),
            getStrokeDashGap()
        )
    }

    /**
     * Returns the stroke width.
     */
    protected fun getStrokeWidth(): Float = when (isEnabled) {
        true -> strokeEnabledWidth
        else -> strokeDisabledWidth
    }

    /**
     * Returns the stroke dash width.
     */
    protected fun getStrokeDashWidth(): Float = when (isEnabled) {
        true -> strokeEnabledDashWidth
        else -> strokeDisabledDashWidth
    }

    /**
     * Returns the stroke dash gap.
     */
    protected fun getStrokeDashGap(): Float = when (isEnabled) {
        true -> strokeEnabledDashGap
        else -> strokeDisabledDashGap
    }

    /**
     * Returns the foreground to use in the ShapeContainer.
     */
    protected fun createForeground(mask: Drawable): RippleDrawable =
        RippleDrawable(createRippleColor(), null, mask)

    /**
     * Returns the solid color.
     */
    protected fun createSolidColor(): ColorStateList = ColorStateList(
        arrayOf(
            intArrayOf(-android.R.attr.state_enabled),
            intArrayOf()
        ),
        intArrayOf(
            solidDisabledColor,
            solidEnabledColor
        )
    )

    /**
     * Returns the stroke color.
     */
    protected fun createStrokeColor(): ColorStateList = ColorStateList(
        arrayOf(
            intArrayOf(-android.R.attr.state_enabled),
            intArrayOf()
        ),
        intArrayOf(
            strokeDisabledColor,
            strokeEnabledColor
        )
    )

    /**
     * Returns the ripple color.
     */
    protected fun createRippleColor(): ColorStateList = ColorStateList(
        arrayOf(
            intArrayOf()
        ),
        intArrayOf(
            this.rippleColor
        )
    )

    /**
     * Returns the radius.
     */
    protected fun createRadius(): FloatArray {
        val topLeftRadius = getTopLeftRadius()
        val topRightRadius = getTopRightRadius()
        val bottomLeftRadius = getBottomLeftRadius()
        val bottomRightRadius = getBottomRightRadius()

        return floatArrayOf(
            topLeftRadius,
            topLeftRadius,
            topRightRadius,
            topRightRadius,
            bottomLeftRadius,
            bottomLeftRadius,
            bottomRightRadius,
            bottomRightRadius
        )

    }

    /**
     * Returns the top-left radius.
     */
    protected fun getTopLeftRadius(): Float = when (isEnabled) {
        true -> topLeftEnabledRadius
        else -> topLeftDisabledRadius
    }

    /**
     * Returns the top-right radius.
     */
    protected fun getTopRightRadius(): Float = when (isEnabled) {
        true -> topRightEnabledRadius
        else -> topRightDisabledRadius
    }

    /**
     * Returns the bottom-left radius.
     */
    protected fun getBottomLeftRadius(): Float = when (isEnabled) {
        true -> bottomLeftEnabledRadius
        else -> bottomLeftDisabledRadius
    }

    /**
     * Returns the bottom-right radius.
     */
    protected fun getBottomRightRadius(): Float = when (isEnabled) {
        true -> bottomRightEnabledRadius
        else -> bottomRightDisabledRadius
    }

}