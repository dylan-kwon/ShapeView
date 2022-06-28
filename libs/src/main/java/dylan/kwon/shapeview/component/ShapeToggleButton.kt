package dylan.kwon.shapeview.component

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatToggleButton
import dylan.kwon.shapeview.*

open class ShapeToggleButton @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = android.R.attr.buttonStyleToggle

) : AppCompatToggleButton(context, attrs, defStyleAttr), ShapeView {

    /**
     * ShapeView Delegate.
     */
    final override val delegate: ShapeViewDelegate by lazy {
        ShapeViewDelegateImpl(this, attrs, defStyleAttr)
    }

    /**
     * initialize.
     */
    init {
        delegate.init(
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
            )
        )
        stateListAnimator = null
    }

    /**
     * If useClip is true, clip the corner.
     */
    override fun draw(canvas: Canvas?) {
        delegate.draw(canvas)
        super.draw(canvas)
    }
}