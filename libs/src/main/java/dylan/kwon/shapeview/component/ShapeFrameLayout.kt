package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import dylan.kwon.shapeview.R
import dylan.kwon.shapeview.shadow.ShadowView
import dylan.kwon.shapeview.shadow.ShadowViewAttrIds
import dylan.kwon.shapeview.shadow.ShadowViewDelegate
import dylan.kwon.shapeview.shadow.ShadowViewDelegateImpl
import dylan.kwon.shapeview.shape.ShapeView
import dylan.kwon.shapeview.shape.ShapeViewAttrIds
import dylan.kwon.shapeview.shape.ShapeViewDelegate
import dylan.kwon.shapeview.shape.ShapeViewDelegateImpl

open class ShapeFrameLayout @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0

) : FrameLayout(context, attrs, defStyleAttr, defStyleRes), ShapeView, ShadowView {

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

    /**
     * initialize.
     */
    init {
        shapeDelegate.init(
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
                gradientType = R.styleable.ShapeFrameLayout_gradientType,
                gradientStartColor = R.styleable.ShapeFrameLayout_gradientStartColor,
                gradientCenterColor = R.styleable.ShapeFrameLayout_gradientCenterColor,
                gradientEndColor = R.styleable.ShapeFrameLayout_gradientEndColor,
                gradientRadius = R.styleable.ShapeFrameLayout_gradientRadius,
                gradientX = R.styleable.ShapeFrameLayout_gradientX,
                gradientY = R.styleable.ShapeFrameLayout_gradientY,
                gradientOrientation = R.styleable.ShapeFrameLayout_gradientOrientation
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