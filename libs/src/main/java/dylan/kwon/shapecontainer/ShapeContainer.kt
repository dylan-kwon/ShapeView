package dylan.kwon.shapecontainer

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
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

    private var isInitialized = false

    /**
     * Background color.
     */
    var shapeColor: ColorStateList? = null
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * Ripple color.
     */
    var rippleColor: ColorStateList? = null
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * Stroke width.
     */
    var strokeWidth: Float = 0f
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * Stroke dash width.
     */
    var strokeDashWidth: Float = 0f
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * Stroke dash gap.
     */
    var strokeDashGap: Float = 0f
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * Stroke color.
     */
    var strokeColor: ColorStateList? = null
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * top-left radius.
     */
    var topLeftRadius: Float = 0f
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * top-right radius.
     */
    var topRightRadius: Float = 0f
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * bottom-left radius.
     */
    var bottomLeftRadius: Float = 0f
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * bottom-right radius.
     */
    var bottomRightRadius: Float = 0f
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * If this value is true, the edges are clipped by the radius.
     */
    var useClip: Boolean = false
        set(value) {
            field = value
            invalidateShape()
        }

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
                topLeftRadius = it.getDimension(
                    R.styleable.ShapeContainer_topLeftRadius, 0f
                )
                topRightRadius = it.getDimension(
                    R.styleable.ShapeContainer_topRightRadius, 0f
                )
                bottomLeftRadius = it.getDimension(
                    R.styleable.ShapeContainer_bottomLeftRadius, 0f
                )
                bottomRightRadius = it.getDimension(
                    R.styleable.ShapeContainer_bottomRightRadius, 0f
                )
            }
            shapeColor = it.getColorStateList(
                R.styleable.ShapeContainer_solidColor
            )
            rippleColor = it.getColorStateList(
                R.styleable.ShapeContainer_rippleColor,
            ) ?: ColorStateList(
                arrayOf(
                    intArrayOf()
                ),
                intArrayOf(
                    MaterialColors.getColor(
                        this,
                        com.google.android.material.R.attr.colorControlHighlight
                    )
                )
            )
            strokeWidth = it.getDimension(
                R.styleable.ShapeContainer_strokeWidth, 0f
            )
            strokeDashWidth = it.getDimension(
                R.styleable.ShapeContainer_strokeDashWidth, 0f
            )
            strokeDashGap = it.getDimension(
                R.styleable.ShapeContainer_strokeDashGap, 0f
            )
            strokeColor = it.getColorStateList(
                R.styleable.ShapeContainer_strokeColor
            )
            isEnabled = it.getBoolean(
                R.styleable.ShapeContainer_enabled, true
            )
            useClip = it.getBoolean(
                R.styleable.ShapeContainer_useClip, false
            )
        }
        isInitialized = true

        invalidateShape()
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
        topLeftRadius = radius
        topRightRadius = radius
        bottomLeftRadius = radius
        bottomRightRadius = radius
    }

    /**
     * Create and apply the background and foreground to be used in ShapeContainer.
     */
    private fun invalidateShape() {
        if (!isInitialized) {
            return
        }
        background = createBackground()
        foreground = createForeground(background)
    }

    /**
     * Returns the background to use in the ShapeContainer.
     */
    private fun createBackground(): GradientDrawable = GradientDrawable().apply {
        this.shape = GradientDrawable.RECTANGLE
        this.color = shapeColor
        this.cornerRadii = createRadius()
        this.setStroke(
            strokeWidth.toInt(),
            strokeColor,
            strokeDashWidth,
            strokeDashGap
        )
    }

    /**
     * Returns the foreground to use in the ShapeContainer.
     */
    protected fun createForeground(mask: Drawable): RippleDrawable? =
        when (val rippleColor = rippleColor) {
            null -> null
            else -> RippleDrawable(rippleColor, null, mask)
        }


    /**
     * Returns the radius.
     */
    protected fun createRadius(): FloatArray = floatArrayOf(
        topLeftRadius,
        topLeftRadius,
        topRightRadius,
        topRightRadius,
        bottomLeftRadius,
        bottomLeftRadius,
        bottomRightRadius,
        bottomRightRadius
    )

    /**
     * When the enabled state is changed, a new drawable is created.
     */
    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        invalidateShape()
    }

}