package dylan.kwon.shapecontainer

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
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

) : FrameLayout(context, attrs, defStyleAttr, defStyleRes), ShapeView.Updatable {

    /**
     * Shape View.
     */
    protected val shapeView: ShapeView by lazy {
        ShapeViewImpl(this)
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
                shapeView.setCornerRadius(cornerEnabledRadius)
            } else {
                shapeView.topLeftRadius = it.getDimension(
                    R.styleable.ShapeContainer_topLeftRadius, 0f
                )
                shapeView.topRightRadius = it.getDimension(
                    R.styleable.ShapeContainer_topRightRadius, 0f
                )
                shapeView.bottomLeftRadius = it.getDimension(
                    R.styleable.ShapeContainer_bottomLeftRadius, 0f
                )
                shapeView.bottomRightRadius = it.getDimension(
                    R.styleable.ShapeContainer_bottomRightRadius, 0f
                )
            }
            shapeView.shapeColor = it.getColorStateList(
                R.styleable.ShapeContainer_solidColor
            )
            shapeView.rippleColor = it.getColorStateList(
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
            shapeView.strokeWidth = it.getDimension(
                R.styleable.ShapeContainer_strokeWidth, 0f
            )
            shapeView.strokeDashWidth = it.getDimension(
                R.styleable.ShapeContainer_strokeDashWidth, 0f
            )
            shapeView.strokeDashGap = it.getDimension(
                R.styleable.ShapeContainer_strokeDashGap, 0f
            )
            shapeView.strokeColor = it.getColorStateList(
                R.styleable.ShapeContainer_strokeColor
            )
            shapeView.useClip = it.getBoolean(
                R.styleable.ShapeContainer_useClip, false
            )
        }
        shapeView.apply {
            isInitialized = true
            invalidateShape()
        }
    }

    /**
     * If useClip is true, clip the corner.
     */
    override fun draw(canvas: Canvas?) {
        shapeView.draw(canvas)
        super.draw(canvas)
    }

    /**
     * change shape color.
     */
    override fun setShapeColor(color: ColorStateList?) {
        shapeView.shapeColor = color
    }

    /**
     * change ripple color.
     */
    override fun setRippleColor(color: ColorStateList?) {
        shapeView.rippleColor = color
    }

    /**
     * change shape color.
     */
    override fun setStrokeWidth(width: Float) {
        shapeView.strokeWidth = width
    }

    /**
     * change stroke dash width.
     */
    override fun setStrokeDashWidth(width: Float) {
        shapeView.strokeDashWidth = width
    }

    /**
     * change stroke dash gap.
     */
    override fun setStrokeDashGap(gap: Float) {
        shapeView.strokeDashGap = gap
    }

    /**
     * change stroke color.
     */
    override fun setStrokeColor(color: ColorStateList?) {
        shapeView.strokeColor = color
    }

    /**
     * change all radius.
     */
    override fun setRadius(radius: Float) {
        shapeView.setCornerRadius(radius)
    }

    /**
     * change top-left radius.
     */
    override fun setTopLeftRadius(radius: Float) {
        shapeView.topLeftRadius = radius
    }

    /**
     * change top-right radius.
     */
    override fun setTopRightRadius(radius: Float) {
        shapeView.topRightRadius = radius
    }

    /**
     * change bottom-left radius.
     */
    override fun setBottomLeftRadius(radius: Float) {
        shapeView.bottomLeftRadius = radius
    }

    /**
     * change bottom-right radius.
     */
    override fun setBottomRightRadius(radius: Float) {
        shapeView.bottomRightRadius = radius
    }

    /**
     * change use clip.
     */
    override fun setUseClip(useClip: Boolean) {
        shapeView.useClip = useClip
    }
}