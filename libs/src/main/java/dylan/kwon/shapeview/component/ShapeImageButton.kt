package dylan.kwon.shapeview.component

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.content.res.use
import com.google.android.material.color.MaterialColors
import dylan.kwon.shapeview.R
import dylan.kwon.shapeview.ShapeView
import dylan.kwon.shapeview.ShapeViewDelegate
import dylan.kwon.shapeview.ShapeViewDelegateImpl

open class ShapeImageButton @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = android.R.attr.imageButtonStyle

) : AppCompatImageButton(context, attrs, defStyleAttr), ShapeView {

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
            attrs, R.styleable.ShapeImageButton, defStyleAttr, 0
        ).use {
            val cornerEnabledRadius = it.getDimension(
                R.styleable.ShapeImageButton_cornerRadius, -1f
            )
            if (cornerEnabledRadius > -1) {
                delegate.setCornerRadius(cornerEnabledRadius)
            } else {
                delegate.topLeftRadius = it.getDimension(
                    R.styleable.ShapeImageButton_topLeftRadius, 0f
                )
                delegate.topRightRadius = it.getDimension(
                    R.styleable.ShapeImageButton_topRightRadius, 0f
                )
                delegate.bottomLeftRadius = it.getDimension(
                    R.styleable.ShapeImageButton_bottomLeftRadius, 0f
                )
                delegate.bottomRightRadius = it.getDimension(
                    R.styleable.ShapeImageButton_bottomRightRadius, 0f
                )
            }
            delegate.shapeColor = it.getColorStateList(
                R.styleable.ShapeImageButton_solidColor
            )
            delegate.rippleColor = it.getColorStateList(
                R.styleable.ShapeImageButton_rippleColor,
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
                R.styleable.ShapeImageButton_strokeWidth, 0f
            )
            delegate.strokeDashWidth = it.getDimension(
                R.styleable.ShapeImageButton_strokeDashWidth, 0f
            )
            delegate.strokeDashGap = it.getDimension(
                R.styleable.ShapeImageButton_strokeDashGap, 0f
            )
            delegate.strokeColor = it.getColorStateList(
                R.styleable.ShapeImageButton_strokeColor
            )
            delegate.useClip = it.getBoolean(
                R.styleable.ShapeImageButton_useClip, false
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