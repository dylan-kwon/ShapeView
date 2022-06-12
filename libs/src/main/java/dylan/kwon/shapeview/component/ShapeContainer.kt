package dylan.kwon.shapeview.component

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.core.content.res.use
import com.google.android.material.color.MaterialColors
import dylan.kwon.shapeview.R
import dylan.kwon.shapeview.ShapeView
import dylan.kwon.shapeview.ShapeViewDelegate
import dylan.kwon.shapeview.ShapeViewDelegateImpl

open class ShapeContainer @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0

) : FrameLayout(context, attrs, defStyleAttr, defStyleRes), ShapeView {

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
            attrs, R.styleable.ShapeContainer, defStyleAttr, defStyleRes
        ).use {
            val cornerEnabledRadius = it.getDimension(
                R.styleable.ShapeContainer_cornerRadius, -1f
            )
            if (cornerEnabledRadius > -1) {
                delegate.setCornerRadius(cornerEnabledRadius)
            } else {
                delegate.topLeftRadius = it.getDimension(
                    R.styleable.ShapeContainer_topLeftRadius, 0f
                )
                delegate.topRightRadius = it.getDimension(
                    R.styleable.ShapeContainer_topRightRadius, 0f
                )
                delegate.bottomLeftRadius = it.getDimension(
                    R.styleable.ShapeContainer_bottomLeftRadius, 0f
                )
                delegate.bottomRightRadius = it.getDimension(
                    R.styleable.ShapeContainer_bottomRightRadius, 0f
                )
            }
            delegate.shapeColor = it.getColorStateList(
                R.styleable.ShapeContainer_solidColor
            )
            delegate.rippleColor = it.getColorStateList(
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
            delegate.strokeWidth = it.getDimension(
                R.styleable.ShapeContainer_strokeWidth, 0f
            )
            delegate.strokeDashWidth = it.getDimension(
                R.styleable.ShapeContainer_strokeDashWidth, 0f
            )
            delegate.strokeDashGap = it.getDimension(
                R.styleable.ShapeContainer_strokeDashGap, 0f
            )
            delegate.strokeColor = it.getColorStateList(
                R.styleable.ShapeContainer_strokeColor
            )
            delegate.useClip = it.getBoolean(
                R.styleable.ShapeContainer_useClip, false
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
}