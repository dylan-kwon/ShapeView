package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatButton
import dylan.kwon.shapeview.*

open class ShapeButton @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = android.R.attr.buttonStyle,

    ) : AppCompatButton(context, attrs, defStyleAttr), ShapeView {

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
                attrs = R.styleable.ShapeButton,
                cornerRadius = R.styleable.ShapeButton_cornerRadius,
                topLeftRadius = R.styleable.ShapeButton_topLeftRadius,
                topRightRadius = R.styleable.ShapeButton_topRightRadius,
                bottomLeftRadius = R.styleable.ShapeButton_bottomLeftRadius,
                bottomRightRadius = R.styleable.ShapeButton_bottomRightRadius,
                solidColor = R.styleable.ShapeButton_solidColor,
                rippleColor = R.styleable.ShapeButton_rippleColor,
                strokeWidth = R.styleable.ShapeButton_strokeWidth,
                strokeDashWidth = R.styleable.ShapeButton_strokeDashWidth,
                strokeDashGap = R.styleable.ShapeButton_strokeDashGap,
                strokeColor = R.styleable.ShapeButton_strokeColor,
                useClip = R.styleable.ShapeButton_useClip,
            )
        )
        stateListAnimator = null

    }

    /**
     * If useClip is true, clip the corner.
     */
    override fun draw(canvas: Canvas?) {
        delegate.draw(canvas)
        super.draw(canvas)
    }
}