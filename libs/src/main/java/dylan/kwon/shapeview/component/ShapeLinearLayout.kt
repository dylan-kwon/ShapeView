package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.LinearLayoutCompat
import dylan.kwon.shapeview.R
import dylan.kwon.shapeview.shadow.ShadowView
import dylan.kwon.shapeview.shadow.ShadowViewAttrIds
import dylan.kwon.shapeview.shadow.ShadowViewDelegate
import dylan.kwon.shapeview.shadow.ShadowViewDelegateImpl
import dylan.kwon.shapeview.shape.ShapeView
import dylan.kwon.shapeview.shape.ShapeViewAttrIds
import dylan.kwon.shapeview.shape.ShapeViewDelegate
import dylan.kwon.shapeview.shape.ShapeViewDelegateImpl

open class ShapeLinearLayout @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0

) : LinearLayoutCompat(context, attrs, defStyleAttr), ShapeView, ShadowView {

    /**
     * ShapeView Delegate.
     */
    final override val shapeDelegate: ShapeViewDelegate by lazy {
        ShapeViewDelegateImpl(this, attrs, defStyleAttr)
    }

    /**
     * ShadowView Delegate.
     */
    final override val shadowDelegate: ShadowViewDelegate by lazy {
        ShadowViewDelegateImpl(this, attrs, defStyleAttr)
    }

    init {
        shapeDelegate.init(
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
                gradientType = R.styleable.ShapeLinearLayout_gradientType,
                gradientStartColor = R.styleable.ShapeLinearLayout_gradientStartColor,
                gradientCenterColor = R.styleable.ShapeLinearLayout_gradientCenterColor,
                gradientEndColor = R.styleable.ShapeLinearLayout_gradientEndColor,
                gradientRadius = R.styleable.ShapeLinearLayout_gradientRadius,
                gradientX = R.styleable.ShapeLinearLayout_gradientX,
                gradientY = R.styleable.ShapeLinearLayout_gradientY,
                gradientOrientation = R.styleable.ShapeLinearLayout_gradientOrientation
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