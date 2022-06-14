package dylan.kwon.shapeview

import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Path
import android.graphics.RectF
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes

open class ShapeViewDelegateImpl(

    protected val view: View,
    val attrs: AttributeSet? = null,
    @AttrRes val defStyleAttr: Int = 0,
    @StyleRes val defStyleRes: Int = 0

) : ShapeViewDelegate {

    /**
     * initialize state.
     */
    override var isInitialized: Boolean = false

    /**
     * Background color.
     */
    override var shapeColor: ColorStateList? = null
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * Ripple color.
     */
    override var rippleColor: ColorStateList? = null
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * Stroke width.
     */
    override var strokeWidth: Float = 0f
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * Stroke dash width.
     */
    override var strokeDashWidth: Float = 0f
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * Stroke dash gap.
     */
    override var strokeDashGap: Float = 0f
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * Stroke color.
     */
    override var strokeColor: ColorStateList? = null
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * top-left radius.
     */
    override var topLeftRadius: Float = 0f
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * top-right radius.
     */
    override var topRightRadius: Float = 0f
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * bottom-left radius.
     */
    override var bottomLeftRadius: Float = 0f
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * bottom-right radius.
     */
    override var bottomRightRadius: Float = 0f
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * If this value is true, the edges are clipped by the radius.
     */
    override var useClip: Boolean = false
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * Whether to use ripple.
     */
    override var useRipple: Boolean = false
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * initialize.
     */
    override fun init(attrIds: ShapeViewAttrIds) {
        view.context.obtainStyledAttributes(
            this.attrs, attrIds.attrs, defStyleAttr, defStyleRes
        ).use {
            val cornerEnabledRadius = it.getDimension(
                attrIds.cornerRadius, -1f
            )
            if (cornerEnabledRadius > -1) {
                setCornerRadius(cornerEnabledRadius)
            } else {
                topLeftRadius = it.getDimension(
                    attrIds.topLeftRadius, 0f
                )
                topRightRadius = it.getDimension(
                    attrIds.topRightRadius, 0f
                )
                bottomLeftRadius = it.getDimension(
                    attrIds.bottomLeftRadius, 0f
                )
                bottomRightRadius = it.getDimension(
                    attrIds.bottomRightRadius, 0f
                )
            }
            shapeColor = it.getColorStateList(
                attrIds.solidColor
            ) ?: ColorStateList(
                arrayOf(
                    intArrayOf()
                ),
                intArrayOf(
                    Color.TRANSPARENT
                )
            )
            useRipple =
                attrIds.useRipple > ShapeViewAttrIds.NONE &&
                        it.getBoolean(attrIds.useRipple, true)

            if (useRipple && attrIds.rippleColor > ShapeViewAttrIds.NONE) {
                rippleColor = it.getColorStateList(
                    attrIds.rippleColor,
                )
                if (rippleColor == null) {
                    try {
                        val typedValue = TypedValue()
                        val isFindColor = view.context.theme.resolveAttribute(
                            androidx.databinding.library.baseAdapters.R.attr.colorControlHighlight,
                            typedValue,
                            true
                        )
                        if (isFindColor) {
                            rippleColor = ColorStateList(
                                arrayOf(
                                    intArrayOf()
                                ),
                                intArrayOf(
                                    typedValue.data
                                )
                            )
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
            strokeWidth = it.getDimension(
                attrIds.strokeWidth, 0f
            )
            strokeDashWidth = it.getDimension(
                attrIds.strokeDashWidth, 0f
            )
            strokeDashGap = it.getDimension(
                attrIds.strokeDashGap, 0f
            )
            strokeColor = it.getColorStateList(
                attrIds.strokeColor
            )
            useClip = it.getBoolean(
                attrIds.useClip, false
            )
        }
        apply {
            isInitialized = true
            invalidateShape()
        }
    }

    /**
     * If useClip is true, clip the corner.
     */
    override fun draw(canvas: Canvas?) {
        if (useClip && canvas != null) {
            clip(canvas)
        }
    }

    /**
     * The edges are clipped by the radius.
     */
    override fun clip(canvas: Canvas) {
        val clipPath = Path().apply {
            addRoundRect(
                RectF(canvas.clipBounds), createRadius(), Path.Direction.CW
            )
        }
        canvas.clipPath(clipPath)
    }

    /**
     * Apply radius to all corners.
     */
    override fun setCornerRadius(radius: Float) {
        topLeftRadius = radius
        topRightRadius = radius
        bottomLeftRadius = radius
        bottomRightRadius = radius
    }

    /**
     * Create and apply the background and foreground to be used in ShapeView.
     */
    override fun invalidateShape() {
        if (!isInitialized) {
            return
        }
        view.background = createBackground()

        if (useRipple) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                view.foreground = createForeground()
            }
        }
    }

    /**
     * Returns the background to use in the ShapeView.
     */
    override fun createBackground(): GradientDrawable = GradientDrawable().apply {
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
     * Returns the foreground to use in the ShapeView.
     */
    override fun createForeground(): RippleDrawable? {
        val mask = createBackground().apply {
            color = ColorStateList(
                arrayOf(
                    intArrayOf()
                ),
                intArrayOf(
                    Color.WHITE
                )
            )
        }
        return when (val rippleColor = rippleColor) {
            null -> null
            else -> RippleDrawable(
                rippleColor, null, mask
            )
        }
    }


    /**
     * Returns the radius.
     */
    override fun createRadius(): FloatArray = floatArrayOf(
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