package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.LinearLayoutCompat
import dylan.kwon.shapeview.*

open class ShapeLinearLayout @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0

) : LinearLayoutCompat(context, attrs, defStyleAttr), ShapeView {

    final override val delegate: ShapeViewDelegate by lazy {
        ShapeViewDelegateImpl(this, attrs, defStyleAttr)
    }

    init {
        delegate.init(
            ShapeViewAttrIds(
                attrs = R.styleable.ShapeLinearLayout,
                cornerRadius = R.styleable.ShapeLinearLayout_cornerRadius,
                topLeftRadius = R.styleable.ShapeLinearLayout_topLeftRadius,
                topRightRadius = R.styleable.ShapeLinearLayout_topRightRadius,
                bottomLeftRadius = R.styleable.ShapeLinearLayout_bottomLeftRadius,
                bottomRightRadius = R.styleable.ShapeLinearLayout_bottomRightRadius,
                solidColor = R.styleable.ShapeLinearLayout_solidColor,
                rippleColor = R.styleable.ShapeLinearLayout_rippleColor,
                strokeWidth = R.styleable.ShapeLinearLayout_strokeWidth,
                strokeDashWidth = R.styleable.ShapeLinearLayout_strokeDashWidth,
                strokeDashGap = R.styleable.ShapeLinearLayout_strokeDashGap,
                strokeColor = R.styleable.ShapeLinearLayout_strokeColor,
                useClip = R.styleable.ShapeLinearLayout_useClip,
                useRipple = R.styleable.ShapeLinearLayout_useRipple,
            )
        )
    }

    override fun draw(canvas: Canvas?) {
        delegate.draw(canvas)
        super.draw(canvas)
    }
}