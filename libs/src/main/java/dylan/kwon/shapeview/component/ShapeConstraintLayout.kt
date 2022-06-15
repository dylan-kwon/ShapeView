package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.constraintlayout.widget.ConstraintLayout
import dylan.kwon.shapeview.*

open class ShapeConstraintLayout @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0

) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes), ShapeView {

    final override val delegate: ShapeViewDelegate by lazy {
        ShapeViewDelegateImpl(this, attrs, defStyleAttr, defStyleRes)
    }

    init {
        delegate.init(
            ShapeViewAttrIds(
                attrs = R.styleable.ShapeConstraintLayout,
                cornerRadius = R.styleable.ShapeConstraintLayout_cornerRadius,
                topLeftRadius = R.styleable.ShapeConstraintLayout_topLeftRadius,
                topRightRadius = R.styleable.ShapeConstraintLayout_topRightRadius,
                bottomLeftRadius = R.styleable.ShapeConstraintLayout_bottomLeftRadius,
                bottomRightRadius = R.styleable.ShapeConstraintLayout_bottomRightRadius,
                solidColor = R.styleable.ShapeConstraintLayout_solidColor,
                rippleColor = R.styleable.ShapeConstraintLayout_rippleColor,
                strokeWidth = R.styleable.ShapeConstraintLayout_strokeWidth,
                strokeDashWidth = R.styleable.ShapeConstraintLayout_strokeDashWidth,
                strokeDashGap = R.styleable.ShapeConstraintLayout_strokeDashGap,
                strokeColor = R.styleable.ShapeConstraintLayout_strokeColor,
                useClip = R.styleable.ShapeConstraintLayout_useClip,
                useRipple = R.styleable.ShapeConstraintLayout_useRipple,
            )
        )
    }

    override fun draw(canvas: Canvas?) {
        delegate.draw(canvas)
        super.draw(canvas)
    }
}