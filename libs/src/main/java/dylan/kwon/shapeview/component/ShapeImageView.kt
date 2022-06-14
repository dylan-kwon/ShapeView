package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatImageView
import dylan.kwon.shapeview.*

open class ShapeImageView @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0

) : AppCompatImageView(context, attrs, defStyleAttr), ShapeView {

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
                attrs = R.styleable.ShapeImageView,
                cornerRadius = R.styleable.ShapeImageView_cornerRadius,
                topLeftRadius = R.styleable.ShapeImageView_topLeftRadius,
                topRightRadius = R.styleable.ShapeImageView_topRightRadius,
                bottomLeftRadius = R.styleable.ShapeImageView_bottomLeftRadius,
                bottomRightRadius = R.styleable.ShapeImageView_bottomRightRadius,
                solidColor = R.styleable.ShapeImageView_solidColor,
                rippleColor = R.styleable.ShapeImageView_rippleColor,
                strokeWidth = R.styleable.ShapeImageView_strokeWidth,
                strokeDashWidth = R.styleable.ShapeImageView_strokeDashWidth,
                strokeDashGap = R.styleable.ShapeImageView_strokeDashGap,
                strokeColor = R.styleable.ShapeImageView_strokeColor,
                useClip = R.styleable.ShapeImageView_useClip,
                useRipple = R.styleable.ShapeImageView_useRipple,
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