package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatTextView
import dylan.kwon.shapeview.*

open class ShapeTextView @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = android.R.attr.textViewStyle

) : AppCompatTextView(context, attrs, defStyleAttr), ShapeView {

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
                attrs = R.styleable.ShapeTextView,
                cornerRadius = R.styleable.ShapeTextView_cornerRadius,
                topLeftRadius = R.styleable.ShapeTextView_topLeftRadius,
                topRightRadius = R.styleable.ShapeTextView_topRightRadius,
                bottomLeftRadius = R.styleable.ShapeTextView_bottomLeftRadius,
                bottomRightRadius = R.styleable.ShapeTextView_bottomRightRadius,
                solidColor = R.styleable.ShapeTextView_solidColor,
                rippleColor = R.styleable.ShapeTextView_rippleColor,
                strokeWidth = R.styleable.ShapeTextView_strokeWidth,
                strokeDashWidth = R.styleable.ShapeTextView_strokeDashWidth,
                strokeDashGap = R.styleable.ShapeTextView_strokeDashGap,
                strokeColor = R.styleable.ShapeTextView_strokeColor,
                useClip = R.styleable.ShapeTextView_useClip,
                useRipple = R.styleable.ShapeTextView_useRipple,
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