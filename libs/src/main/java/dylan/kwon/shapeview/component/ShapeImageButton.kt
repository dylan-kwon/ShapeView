package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatImageButton
import dylan.kwon.shapeview.*

open class ShapeImageButton @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = android.R.attr.imageButtonStyle

) : AppCompatImageButton(context, attrs, defStyleAttr), ShapeView {

    /**
     * ShapeView Delegate.
     */
    final override val delegate: ShapeViewDelegate by lazy {
        ShapeViewDelegateImpl(this, attrs, defStyleAttr)
    }

    /**
     * initialize.
     */
    init {
        delegate.init(
            ShapeViewAttrIds(
                attrs = R.styleable.ShapeImageButton,
                cornerRadius = R.styleable.ShapeImageButton_cornerRadius,
                topLeftRadius = R.styleable.ShapeImageButton_topLeftRadius,
                topRightRadius = R.styleable.ShapeImageButton_topRightRadius,
                bottomLeftRadius = R.styleable.ShapeImageButton_bottomLeftRadius,
                bottomRightRadius = R.styleable.ShapeImageButton_bottomRightRadius,
                solidColor = R.styleable.ShapeImageButton_solidColor,
                rippleColor = R.styleable.ShapeImageButton_rippleColor,
                strokeWidth = R.styleable.ShapeImageButton_strokeWidth,
                strokeDashWidth = R.styleable.ShapeImageButton_strokeDashWidth,
                strokeDashGap = R.styleable.ShapeImageButton_strokeDashGap,
                strokeColor = R.styleable.ShapeImageButton_strokeColor,
                useClip = R.styleable.ShapeImageButton_useClip,
            )
        )
    }

    /**
     * If useClip is true, clip the corner.
     */
    override fun draw(canvas: Canvas?) {
        delegate.draw(canvas)
        super.draw(canvas)
    }
}