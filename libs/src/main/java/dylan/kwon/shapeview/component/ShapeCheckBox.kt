package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatCheckBox
import dylan.kwon.shapeview.*

open class ShapeCheckBox @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = android.R.attr.checkboxStyle,

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
                attrs = R.styleable.ShapeCheckBox,
                cornerRadius = R.styleable.ShapeCheckBox_cornerRadius,
                topLeftRadius = R.styleable.ShapeCheckBox_topLeftRadius,
                topRightRadius = R.styleable.ShapeCheckBox_topRightRadius,
                bottomLeftRadius = R.styleable.ShapeCheckBox_bottomLeftRadius,
                bottomRightRadius = R.styleable.ShapeCheckBox_bottomRightRadius,
                solidColor = R.styleable.ShapeCheckBox_solidColor,
                rippleColor = R.styleable.ShapeCheckBox_rippleColor,
                strokeWidth = R.styleable.ShapeCheckBox_strokeWidth,
                strokeDashWidth = R.styleable.ShapeCheckBox_strokeDashWidth,
                strokeDashGap = R.styleable.ShapeCheckBox_strokeDashGap,
                strokeColor = R.styleable.ShapeCheckBox_strokeColor,
                useClip = R.styleable.ShapeCheckBox_useClip,
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