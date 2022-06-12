package dylan.kwon.shapeview.component

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.res.use
import com.google.android.material.color.MaterialColors
import dylan.kwon.shapeview.R
import dylan.kwon.shapeview.ShapeView
import dylan.kwon.shapeview.ShapeViewDelegate
import dylan.kwon.shapeview.ShapeViewDelegateImpl

open class ShapeButton @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = android.R.attr.buttonStyle,

    ) : AppCompatButton(context, attrs, defStyleAttr), ShapeView {

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
            attrs, R.styleable.ShapeButton, defStyleAttr, 0
        ).use {
            val cornerEnabledRadius = it.getDimension(
                R.styleable.ShapeButton_cornerRadius, -1f
            )
            if (cornerEnabledRadius > -1) {
                delegate.setCornerRadius(cornerEnabledRadius)
            } else {
                delegate.topLeftRadius = it.getDimension(
                    R.styleable.ShapeButton_topLeftRadius, 0f
                )
                delegate.topRightRadius = it.getDimension(
                    R.styleable.ShapeButton_topRightRadius, 0f
                )
                delegate.bottomLeftRadius = it.getDimension(
                    R.styleable.ShapeButton_bottomLeftRadius, 0f
                )
                delegate.bottomRightRadius = it.getDimension(
                    R.styleable.ShapeButton_bottomRightRadius, 0f
                )
            }
            delegate.shapeColor = it.getColorStateList(
                R.styleable.ShapeButton_solidColor
            )
            delegate.rippleColor = it.getColorStateList(
                R.styleable.ShapeButton_rippleColor,
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
                R.styleable.ShapeButton_strokeWidth, 0f
            )
            delegate.strokeDashWidth = it.getDimension(
                R.styleable.ShapeButton_strokeDashWidth, 0f
            )
            delegate.strokeDashGap = it.getDimension(
                R.styleable.ShapeButton_strokeDashGap, 0f
            )
            delegate.strokeColor = it.getColorStateList(
                R.styleable.ShapeButton_strokeColor
            )
            delegate.useClip = it.getBoolean(
                R.styleable.ShapeButton_useClip, false
            )
        }
        stateListAnimator = null

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