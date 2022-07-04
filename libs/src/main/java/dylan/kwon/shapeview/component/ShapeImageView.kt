package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatImageView
import dylan.kwon.shapeview.R
import dylan.kwon.shapeview.shadow.ShadowView
import dylan.kwon.shapeview.shadow.ShadowViewAttrIds
import dylan.kwon.shapeview.shadow.ShadowViewDelegate
import dylan.kwon.shapeview.shadow.ShadowViewDelegateImpl
import dylan.kwon.shapeview.shape.ShapeView
import dylan.kwon.shapeview.shape.ShapeViewAttrIds
import dylan.kwon.shapeview.shape.ShapeViewDelegate
import dylan.kwon.shapeview.shape.ShapeViewDelegateImpl

open class ShapeImageView @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0

) : AppCompatImageView(context, attrs, defStyleAttr), ShapeView, ShadowView {

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

    /**
     * initialize.
     */
    init {
        shapeDelegate.init(
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
                gradientType = R.styleable.ShapeImageView_gradientType,
                gradientStartColor = R.styleable.ShapeImageView_gradientStartColor,
                gradientCenterColor = R.styleable.ShapeImageView_gradientCenterColor,
                gradientEndColor = R.styleable.ShapeImageView_gradientEndColor,
                gradientRadius = R.styleable.ShapeImageView_gradientRadius,
                gradientX = R.styleable.ShapeImageView_gradientX,
                gradientY = R.styleable.ShapeImageView_gradientY,
                gradientOrientation = R.styleable.ShapeImageView_gradientOrientation
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