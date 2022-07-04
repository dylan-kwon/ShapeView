package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatButton
import dylan.kwon.shapeview.R
import dylan.kwon.shapeview.shadow.ShadowView
import dylan.kwon.shapeview.shadow.ShadowViewAttrIds
import dylan.kwon.shapeview.shadow.ShadowViewDelegate
import dylan.kwon.shapeview.shadow.ShadowViewDelegateImpl
import dylan.kwon.shapeview.shape.ShapeView
import dylan.kwon.shapeview.shape.ShapeViewAttrIds
import dylan.kwon.shapeview.shape.ShapeViewDelegate
import dylan.kwon.shapeview.shape.ShapeViewDelegateImpl

open class ShapeButton @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = android.R.attr.buttonStyle

) : AppCompatButton(context, attrs, defStyleAttr), ShapeView, ShadowView {

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
                attrs = R.styleable.ShapeButton,
                cornerRadius = R.styleable.ShapeButton_cornerRadius,
                topLeftRadius = R.styleable.ShapeButton_topLeftRadius,
                topRightRadius = R.styleable.ShapeButton_topRightRadius,
                bottomLeftRadius = R.styleable.ShapeButton_bottomLeftRadius,
                bottomRightRadius = R.styleable.ShapeButton_bottomRightRadius,
                solidColor = R.styleable.ShapeButton_solidColor,
                rippleColor = R.styleable.ShapeButton_rippleColor,
                strokeWidth = R.styleable.ShapeButton_strokeWidth,
                strokeDashWidth = R.styleable.ShapeButton_strokeDashWidth,
                strokeDashGap = R.styleable.ShapeButton_strokeDashGap,
                strokeColor = R.styleable.ShapeButton_strokeColor,
                useClip = R.styleable.ShapeButton_useClip,
                useRipple = R.styleable.ShapeButton_useRipple,
                gradientType = R.styleable.ShapeButton_gradientType,
                gradientStartColor = R.styleable.ShapeButton_gradientStartColor,
                gradientCenterColor = R.styleable.ShapeButton_gradientCenterColor,
                gradientEndColor = R.styleable.ShapeButton_gradientEndColor,
                gradientRadius = R.styleable.ShapeButton_gradientRadius,
                gradientX = R.styleable.ShapeButton_gradientX,
                gradientY = R.styleable.ShapeButton_gradientY,
                gradientOrientation = R.styleable.ShapeButton_gradientOrientation
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