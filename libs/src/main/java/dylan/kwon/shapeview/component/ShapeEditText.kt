package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatEditText
import dylan.kwon.shapeview.*

open class ShapeEditText @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = android.R.attr.editTextStyle,

    ) : AppCompatEditText(context, attrs, defStyleAttr), ShapeView {

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
                attrs = R.styleable.ShapeEditText,
                cornerRadius = R.styleable.ShapeEditText_cornerRadius,
                topLeftRadius = R.styleable.ShapeEditText_topLeftRadius,
                topRightRadius = R.styleable.ShapeEditText_topRightRadius,
                bottomLeftRadius = R.styleable.ShapeEditText_bottomLeftRadius,
                bottomRightRadius = R.styleable.ShapeEditText_bottomRightRadius,
                solidColor = R.styleable.ShapeEditText_solidColor,
                rippleColor = -1,
                strokeWidth = R.styleable.ShapeEditText_strokeWidth,
                strokeDashWidth = R.styleable.ShapeEditText_strokeDashWidth,
                strokeDashGap = R.styleable.ShapeEditText_strokeDashGap,
                strokeColor = R.styleable.ShapeEditText_strokeColor,
                useClip = R.styleable.ShapeEditText_useClip,
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