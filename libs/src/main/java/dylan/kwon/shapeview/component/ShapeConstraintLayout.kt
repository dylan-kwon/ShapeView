package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.constraintlayout.widget.ConstraintLayout
import dylan.kwon.shapeview.R
import dylan.kwon.shapeview.shadow.ShadowView
import dylan.kwon.shapeview.shadow.ShadowViewAttrIds
import dylan.kwon.shapeview.shadow.ShadowViewDelegate
import dylan.kwon.shapeview.shadow.ShadowViewDelegateImpl
import dylan.kwon.shapeview.shape.ShapeView
import dylan.kwon.shapeview.shape.ShapeViewAttrIds
import dylan.kwon.shapeview.shape.ShapeViewDelegate
import dylan.kwon.shapeview.shape.ShapeViewDelegateImpl

open class ShapeConstraintLayout @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0

) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes), ShapeView, ShadowView {

    /**
     * ShapeView Delegate.
     */
    final override val shapeDelegate: ShapeViewDelegate by lazy {
        ShapeViewDelegateImpl(this, attrs, defStyleAttr, defStyleRes)
    }

    /**
     * ShadowView Delegate.
     */
    final override val shadowDelegate: ShadowViewDelegate by lazy {
        ShadowViewDelegateImpl(this, attrs, defStyleAttr, defStyleRes)
    }

    init {
        shapeDelegate.init(
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
                gradientType = R.styleable.ShapeConstraintLayout_gradientType,
                gradientStartColor = R.styleable.ShapeConstraintLayout_gradientStartColor,
                gradientCenterColor = R.styleable.ShapeConstraintLayout_gradientCenterColor,
                gradientEndColor = R.styleable.ShapeConstraintLayout_gradientEndColor,
                gradientRadius = R.styleable.ShapeConstraintLayout_gradientRadius,
                gradientX = R.styleable.ShapeConstraintLayout_gradientX,
                gradientY = R.styleable.ShapeConstraintLayout_gradientY,
                gradientOrientation = R.styleable.ShapeConstraintLayout_gradientOrientation
            )
        )
        shadowDelegate.init(
            ShadowViewAttrIds(
                attrs = R.styleable.ShapeFrameLayout,
                shadowXOffset = R.styleable.ShapeFrameLayout_shadow_x_offset,
                shadowYOffset = R.styleable.ShapeFrameLayout_shadow_y_offset,
                shadowColor = R.styleable.ShapeFrameLayout_shadowColor,
                shadowBlur = R.styleable.ShapeFrameLayout_shadowBlur,
                shadowSpread = R.styleable.ShapeFrameLayout_shadowSpread,
                shadowInset = R.styleable.ShapeFrameLayout_shadowInset,
                shadowRadius = R.styleable.ShapeFrameLayout_cornerRadius,
                topLeftShadowRadius = R.styleable.ShapeFrameLayout_topLeftRadius,
                topRightShadowRadius = R.styleable.ShapeFrameLayout_topRightRadius,
                bottomLeftShadowRadius = R.styleable.ShapeFrameLayout_bottomLeftRadius,
                bottomRightShadowRadius = R.styleable.ShapeFrameLayout_bottomRightRadius,
            )
        )
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        shadowDelegate.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        shadowDelegate.onDetachedFromWindow()
    }

    override fun draw(canvas: Canvas?) {
        shadowDelegate.draw(canvas)
        shapeDelegate.draw(canvas)
        super.draw(canvas)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        shadowDelegate.onSizeChanged(w, h, oldw, oldh)
    }
}