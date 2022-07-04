package dylan.kwon.shapeview.shape

import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Path
import android.graphics.RectF
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.core.content.res.use

open class ShapeViewDelegateImpl(

    protected val view: View,
    val attrs: AttributeSet? = null,
    @AttrRes val defStyleAttr: Int = 0,
    @StyleRes val defStyleRes: Int = 0

) : ShapeViewDelegate {

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
     * Gradient type.
     */
    override var gradientType: Int = -1
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * Gradient start color.
     */
    override var gradientStartColor: Int = Color.TRANSPARENT
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * Gradient center color.
     */
    override var gradientCenterColor: Int = -1
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * Gradient end color.
     */
    override var gradientEndColor: Int = Color.TRANSPARENT
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * Gradient radius.
     */
    override var gradientRadius: Float = 0.0f
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * Gradient x.
     */
    override var gradientX: Float = 0.5f
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * Gradient y.
     */
    override var gradientY: Float = 0.5f
        set(value) {
            field = value
            invalidateShape()
        }

    /**
     * Gradient orientation.
     */
    override var gradientOrientation: Int = GradientDrawable.Orientation.LEFT_RIGHT.toInt()
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
            val cornerRadius = it.getDimension(
                attrIds.cornerRadius, -1f
            )
            if (cornerRadius > -1) {
                setCornerRadius(cornerRadius)
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
            gradientType = it.getInt(
                attrIds.gradientType, -1
            )
            gradientStartColor = it.getColor(
                attrIds.gradientStartColor, Color.TRANSPARENT
            )
            gradientCenterColor = it.getColor(
                attrIds.gradientCenterColor, -1
            )
            gradientEndColor = it.getColor(
                attrIds.gradientEndColor, Color.TRANSPARENT
            )
            gradientRadius = it.getDimension(
                attrIds.gradientRadius, 0.0f
            )
            gradientX = it.getFloat(
                attrIds.gradientX, 0.5f
            )
            gradientY = it.getFloat(
                attrIds.gradientY, 0.5f
            )
            gradientOrientation = it.getInt(
                attrIds.gradientOrientation, GradientOrientation.LEFT_RIGHT
            )
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
        view.background = createBackground()

        if (useRipple) {
            view.foreground = createForeground()
        }
    }

    /**
     * Returns the background to use in the ShapeView.
     */
    override fun createBackground(): GradientDrawable = GradientDrawable().also {
        it.shape = GradientDrawable.RECTANGLE
        it.color = shapeColor
        it.cornerRadii = createRadius()
        it.setStroke(
            strokeWidth.toInt(),
            strokeColor,
            strokeDashWidth,
            strokeDashGap
        )
        if (gradientType > -1) {
            it.colors = mutableListOf<Int>().apply {
                this += gradientStartColor
                if (gradientCenterColor != -1) {
                    this += gradientCenterColor
                }
                this += gradientEndColor
            }.toIntArray()
            it.gradientType = gradientType
            it.gradientRadius = gradientRadius
            it.orientation = gradientOrientationOf(gradientOrientation)
            it.setGradientCenter(gradientX, gradientY)
        }
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