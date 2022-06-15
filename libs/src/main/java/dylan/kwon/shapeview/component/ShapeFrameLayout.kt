package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import dylan.kwon.shapeview.*

open class ShapeFrameLayout @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0

) : FrameLayout(context, attrs, defStyleAttr, defStyleRes), ShapeView {

    /**
     * ShapeView Delegate.
     */
    final override val delegate: ShapeViewDelegate by lazy {
        ShapeViewDelegateImpl(this, attrs, defStyleAttr, defStyleRes)
    }

    /**
     * initialize.
     */
    init {
        delegate.init(
            ShapeViewAttrIds(
                attrs = R.styleable.ShapeFrameLayout,
                cornerRadius = R.styleable.ShapeFrameLayout_cornerRadius,
                topLeftRadius = R.styleable.ShapeFrameLayout_topLeftRadius,
                topRightRadius = R.styleable.ShapeFrameLayout_topRightRadius,
                bottomLeftRadius = R.styleable.ShapeFrameLayout_bottomLeftRadius,
                bottomRightRadius = R.styleable.ShapeFrameLayout_bottomRightRadius,
                solidColor = R.styleable.ShapeFrameLayout_solidColor,
                rippleColor = R.styleable.ShapeFrameLayout_rippleColor,
                strokeWidth = R.styleable.ShapeFrameLayout_strokeWidth,
                strokeDashWidth = R.styleable.ShapeFrameLayout_strokeDashWidth,
                strokeDashGap = R.styleable.ShapeFrameLayout_strokeDashGap,
                strokeColor = R.styleable.ShapeFrameLayout_strokeColor,
                useClip = R.styleable.ShapeFrameLayout_useClip,
                useRipple = R.styleable.ShapeFrameLayout_useRipple,
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