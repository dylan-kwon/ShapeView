package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatCheckBox
import dylan.kwon.shapeview.R
import dylan.kwon.shapeview.shadow.ShadowView
import dylan.kwon.shapeview.shadow.ShadowViewAttrIds
import dylan.kwon.shapeview.shadow.ShadowViewDelegate
import dylan.kwon.shapeview.shadow.ShadowViewDelegateImpl
import dylan.kwon.shapeview.shape.ShapeView
import dylan.kwon.shapeview.shape.ShapeViewAttrIds
import dylan.kwon.shapeview.shape.ShapeViewDelegate
import dylan.kwon.shapeview.shape.ShapeViewDelegateImpl

open class ShapeRadioButton @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = android.R.attr.radioButtonStyle

) : AppCompatCheckBox(context, attrs, defStyleAttr), ShapeView, ShadowView {

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
                attrs = R.styleable.ShapeRadioButton,
                cornerRadius = R.styleable.ShapeRadioButton_cornerRadius,
                topLeftRadius = R.styleable.ShapeRadioButton_topLeftRadius,
                topRightRadius = R.styleable.ShapeRadioButton_topRightRadius,
                bottomLeftRadius = R.styleable.ShapeRadioButton_bottomLeftRadius,
                bottomRightRadius = R.styleable.ShapeRadioButton_bottomRightRadius,
                solidColor = R.styleable.ShapeRadioButton_solidColor,
                rippleColor = R.styleable.ShapeRadioButton_rippleColor,
                strokeWidth = R.styleable.ShapeRadioButton_strokeWidth,
                strokeDashWidth = R.styleable.ShapeRadioButton_strokeDashWidth,
                strokeDashGap = R.styleable.ShapeRadioButton_strokeDashGap,
                strokeColor = R.styleable.ShapeRadioButton_strokeColor,
                useClip = R.styleable.ShapeRadioButton_useClip,
                useRipple = R.styleable.ShapeRadioButton_useRipple,
                gradientType = R.styleable.ShapeRadioButton_gradientType,
                gradientStartColor = R.styleable.ShapeRadioButton_gradientStartColor,
                gradientCenterColor = R.styleable.ShapeRadioButton_gradientCenterColor,
                gradientEndColor = R.styleable.ShapeRadioButton_gradientEndColor,
                gradientRadius = R.styleable.ShapeRadioButton_gradientRadius,
                gradientX = R.styleable.ShapeRadioButton_gradientX,
                gradientY = R.styleable.ShapeRadioButton_gradientY,
                gradientOrientation = R.styleable.ShapeRadioButton_gradientOrientation
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