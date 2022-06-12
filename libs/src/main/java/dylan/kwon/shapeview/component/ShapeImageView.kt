package dylan.kwon.shapeview.component

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatImageView
import dylan.kwon.shapeview.*

open class ShapeImageView @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0

) : AppCompatImageView(context, attrs, defStyleAttr), ShapeView {

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
            )
        )
    }

    /**
     * If useClip is true, clip the corner.
     */
    override fun draw(canvas: Canvas?) {
        delegate.draw(canvas)
        super.draw(canvas)
    }

    /**
     * change shape color.
     */
    override fun setShapeColor(color: ColorStateList?) {
        delegate.shapeColor = color
    }

    /**
     * change ripple color.
     */
    override fun setRippleColor(color: ColorStateList?) {
        delegate.rippleColor = color
    }

    /**
     * change shape color.
     */
    override fun setStrokeWidth(width: Float) {
        delegate.strokeWidth = width
    }

    /**
     * change stroke dash width.
     */
    override fun setStrokeDashWidth(width: Float) {
        delegate.strokeDashWidth = width
    }

    /**
     * change stroke dash gap.
     */
    override fun setStrokeDashGap(gap: Float) {
        delegate.strokeDashGap = gap
    }

    /**
     * change stroke color.
     */
    override fun setStrokeColor(color: ColorStateList?) {
        delegate.strokeColor = color
    }

    /**
     * change all radius.
     */
    override fun setRadius(radius: Float) {
        delegate.setCornerRadius(radius)
    }

    /**
     * change top-left radius.
     */
    override fun setTopLeftRadius(radius: Float) {
        delegate.topLeftRadius = radius
    }

    /**
     * change top-right radius.
     */
    override fun setTopRightRadius(radius: Float) {
        delegate.topRightRadius = radius
    }

    /**
     * change bottom-left radius.
     */
    override fun setBottomLeftRadius(radius: Float) {
        delegate.bottomLeftRadius = radius
    }

    /**
     * change bottom-right radius.
     */
    override fun setBottomRightRadius(radius: Float) {
        delegate.bottomRightRadius = radius
    }

    /**
     * change use clip.
     */
    override fun setUseClip(useClip: Boolean) {
        delegate.useClip = useClip
    }
}