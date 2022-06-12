package dylan.kwon.shapeview.component

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.res.use
import com.google.android.material.color.MaterialColors
import dylan.kwon.shapeview.R
import dylan.kwon.shapeview.ShapeView
import dylan.kwon.shapeview.ShapeViewDelegate
import dylan.kwon.shapeview.ShapeViewDelegateImpl

open class ShapeImageView @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0

) : AppCompatImageView(context, attrs, defStyleAttr), ShapeView {

    /**
     * ShapeView Delegate.
     */
    final override val delegate: ShapeViewDelegate by lazy {
        ShapeViewDelegateImpl(this)
    }

    /**
     * initialize.
     */
    init {
        context.obtainStyledAttributes(
            attrs, R.styleable.ShapeImageView, defStyleAttr, 0
        ).use {
            val cornerEnabledRadius = it.getDimension(
                R.styleable.ShapeImageView_cornerRadius, -1f
            )
            if (cornerEnabledRadius > -1) {
                delegate.setCornerRadius(cornerEnabledRadius)
            } else {
                delegate.topLeftRadius = it.getDimension(
                    R.styleable.ShapeImageView_topLeftRadius, 0f
                )
                delegate.topRightRadius = it.getDimension(
                    R.styleable.ShapeImageView_topRightRadius, 0f
                )
                delegate.bottomLeftRadius = it.getDimension(
                    R.styleable.ShapeImageView_bottomLeftRadius, 0f
                )
                delegate.bottomRightRadius = it.getDimension(
                    R.styleable.ShapeImageView_bottomRightRadius, 0f
                )
            }
            delegate.shapeColor = it.getColorStateList(
                R.styleable.ShapeImageView_solidColor
            )
            delegate.rippleColor = it.getColorStateList(
                R.styleable.ShapeImageView_rippleColor,
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
            delegate.strokeWidth = it.getDimension(
                R.styleable.ShapeImageView_strokeWidth, 0f
            )
            delegate.strokeDashWidth = it.getDimension(
                R.styleable.ShapeImageView_strokeDashWidth, 0f
            )
            delegate.strokeDashGap = it.getDimension(
                R.styleable.ShapeImageView_strokeDashGap, 0f
            )
            delegate.strokeColor = it.getColorStateList(
                R.styleable.ShapeImageView_strokeColor
            )
            delegate.useClip = it.getBoolean(
                R.styleable.ShapeImageView_useClip, false
            )
        }
        delegate.apply {
            isInitialized = true
            invalidateShape()
        }
    }

    /**
     * If useClip is true, clip the corner.
     */
    override fun draw(canvas: Canvas?) {
        delegate.draw(canvas)
        super.draw(canvas)
    }

    /**
     * change shape color.
     */
    override fun setShapeColor(color: ColorStateList?) {
        delegate.shapeColor = color
    }

    /**
     * change ripple color.
     */
    override fun setRippleColor(color: ColorStateList?) {
        delegate.rippleColor = color
    }

    /**
     * change shape color.
     */
    override fun setStrokeWidth(width: Float) {
        delegate.strokeWidth = width
    }

    /**
     * change stroke dash width.
     */
    override fun setStrokeDashWidth(width: Float) {
        delegate.strokeDashWidth = width
    }

    /**
     * change stroke dash gap.
     */
    override fun setStrokeDashGap(gap: Float) {
        delegate.strokeDashGap = gap
    }

    /**
     * change stroke color.
     */
    override fun setStrokeColor(color: ColorStateList?) {
        delegate.strokeColor = color
    }

    /**
     * change all radius.
     */
    override fun setRadius(radius: Float) {
        delegate.setCornerRadius(radius)
    }

    /**
     * change top-left radius.
     */
    override fun setTopLeftRadius(radius: Float) {
        delegate.topLeftRadius = radius
    }

    /**
     * change top-right radius.
     */
    override fun setTopRightRadius(radius: Float) {
        delegate.topRightRadius = radius
    }

    /**
     * change bottom-left radius.
     */
    override fun setBottomLeftRadius(radius: Float) {
        delegate.bottomLeftRadius = radius
    }

    /**
     * change bottom-right radius.
     */
    override fun setBottomRightRadius(radius: Float) {
        delegate.bottomRightRadius = radius
    }

    /**
     * change use clip.
     */
    override fun setUseClip(useClip: Boolean) {
        delegate.useClip = useClip
    }
}