package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatToggleButton
import dylan.kwon.shapeview.R
import dylan.kwon.shapeview.shadow.ShadowView
import dylan.kwon.shapeview.shadow.ShadowViewAttrIds
import dylan.kwon.shapeview.shadow.ShadowViewDelegate
import dylan.kwon.shapeview.shadow.ShadowViewDelegateImpl
import dylan.kwon.shapeview.shape.ShapeView
import dylan.kwon.shapeview.shape.ShapeViewAttrIds
import dylan.kwon.shapeview.shape.ShapeViewDelegate
import dylan.kwon.shapeview.shape.ShapeViewDelegateImpl

open class ShapeToggleButton @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = android.R.attr.buttonStyleToggle

) : AppCompatToggleButton(context, attrs, defStyleAttr), ShapeView, ShadowView {

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
                attrs = R.styleable.ShapeToggleButton,
                cornerRadius = R.styleable.ShapeToggleButton_cornerRadius,
                topLeftRadius = R.styleable.ShapeToggleButton_topLeftRadius,
                topRightRadius = R.styleable.ShapeToggleButton_topRightRadius,
                bottomLeftRadius = R.styleable.ShapeToggleButton_bottomLeftRadius,
                bottomRightRadius = R.styleable.ShapeToggleButton_bottomRightRadius,
                solidColor = R.styleable.ShapeToggleButton_solidColor,
                rippleColor = R.styleable.ShapeToggleButton_rippleColor,
                strokeWidth = R.styleable.ShapeToggleButton_strokeWidth,
                strokeDashWidth = R.styleable.ShapeToggleButton_strokeDashWidth,
                strokeDashGap = R.styleable.ShapeToggleButton_strokeDashGap,
                strokeColor = R.styleable.ShapeToggleButton_strokeColor,
                useClip = R.styleable.ShapeToggleButton_useClip,
                useRipple = R.styleable.ShapeToggleButton_useRipple,
                gradientType = R.styleable.ShapeToggleButton_gradientType,
                gradientStartColor = R.styleable.ShapeToggleButton_gradientStartColor,
                gradientCenterColor = R.styleable.ShapeToggleButton_gradientCenterColor,
                gradientEndColor = R.styleable.ShapeToggleButton_gradientEndColor,
                gradientRadius = R.styleable.ShapeToggleButton_gradientRadius,
                gradientX = R.styleable.ShapeToggleButton_gradientX,
                gradientY = R.styleable.ShapeToggleButton_gradientY,
                gradientOrientation = R.styleable.ShapeToggleButton_gradientOrientation
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