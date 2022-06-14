package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatCheckBox
import dylan.kwon.shapeview.*

open class ShapeRadioButton @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = android.R.attr.radioButtonStyle,

    ) : AppCompatCheckBox(context, attrs, defStyleAttr), ShapeView {

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
                attrs = R.styleable.ShapeRadioButton,
                cornerRadius = R.styleable.ShapeRadioButton_cornerRadius,
                topLeftRadius = R.styleable.ShapeRadioButton_topLeftRadius,
                topRightRadius = R.styleable.ShapeRadioButton_topRightRadius,
                bottomLeftRadius = R.styleable.ShapeRadioButton_bottomLeftRadius,
                bottomRightRadius = R.styleable.ShapeRadioButton_bottomRightRadius,
                solidColor = R.styleable.ShapeRadioButton_solidColor,
                rippleColor = R.styleable.ShapeRadioButton_rippleColor,
                strokeWidth = R.styleable.ShapeRadioButton_strokeWidth,
                strokeDashWidth = R.styleable.ShapeRadioButton_strokeDashWidth,
                strokeDashGap = R.styleable.ShapeRadioButton_strokeDashGap,
                strokeColor = R.styleable.ShapeRadioButton_strokeColor,
                useClip = R.styleable.ShapeRadioButton_useClip,
                useRipple = R.styleable.ShapeRadioButton_useRipple,
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