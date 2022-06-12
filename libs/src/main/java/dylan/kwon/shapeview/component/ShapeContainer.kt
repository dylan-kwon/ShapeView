package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import dylan.kwon.shapeview.*

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
        ShapeViewDelegateImpl(this, attrs, defStyleAttr, defStyleRes)
    }

    /**
     * initialize.
     */
    init {
        delegate.init(
            ShapeViewAttrIds(
                attrs = R.styleable.ShapeContainer,
                cornerRadius = R.styleable.ShapeContainer_cornerRadius,
                topLeftRadius = R.styleable.ShapeContainer_topLeftRadius,
                topRightRadius = R.styleable.ShapeContainer_topRightRadius,
                bottomLeftRadius = R.styleable.ShapeContainer_bottomLeftRadius,
                bottomRightRadius = R.styleable.ShapeContainer_bottomRightRadius,
                solidColor = R.styleable.ShapeContainer_solidColor,
                rippleColor = R.styleable.ShapeContainer_rippleColor,
                strokeWidth = R.styleable.ShapeContainer_strokeWidth,
                strokeDashWidth = R.styleable.ShapeContainer_strokeDashWidth,
                strokeDashGap = R.styleable.ShapeContainer_strokeDashGap,
                strokeColor = R.styleable.ShapeContainer_strokeColor,
                useClip = R.styleable.ShapeContainer_useClip,
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