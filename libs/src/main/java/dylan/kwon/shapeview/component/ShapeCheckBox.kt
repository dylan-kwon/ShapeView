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

open class ShapeCheckBox @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = android.R.attr.checkboxStyle

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
                attrs = R.styleable.ShapeCheckBox,
                cornerRadius = R.styleable.ShapeCheckBox_cornerRadius,
                topLeftRadius = R.styleable.ShapeCheckBox_topLeftRadius,
                topRightRadius = R.styleable.ShapeCheckBox_topRightRadius,
                bottomLeftRadius = R.styleable.ShapeCheckBox_bottomLeftRadius,
                bottomRightRadius = R.styleable.ShapeCheckBox_bottomRightRadius,
                solidColor = R.styleable.ShapeCheckBox_solidColor,
                rippleColor = R.styleable.ShapeCheckBox_rippleColor,
                strokeWidth = R.styleable.ShapeCheckBox_strokeWidth,
                strokeDashWidth = R.styleable.ShapeCheckBox_strokeDashWidth,
                strokeDashGap = R.styleable.ShapeCheckBox_strokeDashGap,
                strokeColor = R.styleable.ShapeCheckBox_strokeColor,
                useClip = R.styleable.ShapeCheckBox_useClip,
                useRipple = R.styleable.ShapeCheckBox_useRipple,
                gradientType = R.styleable.ShapeCheckBox_gradientType,
                gradientStartColor = R.styleable.ShapeCheckBox_gradientStartColor,
                gradientCenterColor = R.styleable.ShapeCheckBox_gradientCenterColor,
                gradientEndColor = R.styleable.ShapeCheckBox_gradientEndColor,
                gradientRadius = R.styleable.ShapeCheckBox_gradientRadius,
                gradientX = R.styleable.ShapeCheckBox_gradientX,
                gradientY = R.styleable.ShapeCheckBox_gradientY,
                gradientOrientation = R.styleable.ShapeCheckBox_gradientOrientation
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