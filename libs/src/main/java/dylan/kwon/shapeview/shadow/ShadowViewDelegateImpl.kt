package dylan.kwon.shapeview.shadow

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Path
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AttrRes
import androidx.annotation.Px
import androidx.annotation.StyleRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.use
import dylan.kwon.shapeview.R
import kotlin.math.absoluteValue

open class ShadowViewDelegateImpl(

    protected val view: View,
    val attrs: AttributeSet? = null,
    @AttrRes val defStyleAttr: Int = 0,
    @StyleRes val defStyleRes: Int = 0

) : ShadowViewDelegate {

    override var shadowColor: Int = Color.TRANSPARENT
        set(value) {
            field = value
            shadowDrawable.setShadowColor(shadowColor)
            invalidate()
        }

    override var shadowBlur: Float = 0f
        set(value) {
            field = value
            shadowDrawable.setShadowBlur(shadowBlur)
            invalidate()
        }

    override var shadowSpread: Float = 0f
        set(value) {
            field = value
            resetShadowOffset()
            invalidate()
        }

    override var shadowXOffset: Float = 0f
        set(value) {
            field = value
            resetShadowOffset()
            invalidate()
        }

    override var shadowYOffset: Float = 0f
        set(value) {
            field = value
            resetShadowOffset()
            invalidate()
        }

    override var shadowRadius: Float = 0f

    override var topLeftShadowRadius: Float = 0f

    override var topRightShadowRadius: Float = 0f

    override var bottomLeftShadowRadius: Float = 0f

    override var bottomRightShadowRadius: Float = 0f

    override var shadowInset: Boolean = false
        set(value) {
            field = value
            shadowDrawable.setShadowInset(shadowInset)
            invalidate()
        }

    private val shadowPath = Path()

    private val shadowDrawable: ShadowDrawable =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            BlurMaskShadowDrawable(shadowPath)
        } else {
            BlurMaskBitmapShadowDrawable(shadowPath)
        }

    protected var shadowPathOffsetX = 0f

    protected var shadowPathOffsetY = 0f

    override fun init(attrIds: ShadowViewAttrIds) {
        view.context.obtainStyledAttributes(
            attrs, attrIds.attrs, defStyleAttr, defStyleRes
        ).use {
            shadowXOffset = it.getDimension(
                attrIds.shadowXOffset, 0f
            )
            shadowYOffset = it.getDimension(
                attrIds.shadowYOffset, 0f
            )
            shadowColor = it.getColor(
                attrIds.shadowColor,
                ContextCompat.getColor(view.context, R.color.default_shadow_color)
            )
            shadowBlur = it.getDimension(
                attrIds.shadowBlur, 0f
            )
            shadowSpread = it.getDimension(
                attrIds.shadowSpread, 0f
            )
            shadowInset = it.getBoolean(
                attrIds.shadowInset, false
            )
            shadowRadius = it.getDimension(
                attrIds.shadowRadius, 0f
            )
            if (it.hasValue(attrIds.topLeftShadowRadius) ||
                it.hasValue(attrIds.topRightShadowRadius) ||
                it.hasValue(attrIds.bottomLeftShadowRadius) ||
                it.hasValue(attrIds.bottomRightShadowRadius)
            ) {
                setShadowRadius(
                    it.getDimension(attrIds.topLeftShadowRadius, shadowRadius),
                    it.getDimension(attrIds.topRightShadowRadius, shadowRadius),
                    it.getDimension(attrIds.bottomLeftShadowRadius, shadowRadius),
                    it.getDimension(attrIds.bottomRightShadowRadius, shadowRadius)
                )
            } else {
                setShadowRadius(shadowRadius, shadowRadius, shadowRadius, shadowRadius)
            }
        }
    }

    override fun setShadowRadius(
        @Px topLeft: Float,
        @Px topRight: Float,
        @Px bottomLeft: Float,
        @Px bottomRight: Float
    ) {
        topLeftShadowRadius = topLeft.absoluteValue
        topRightShadowRadius = topRight.absoluteValue
        bottomLeftShadowRadius = bottomLeft.absoluteValue
        bottomRightShadowRadius = bottomRight.absoluteValue

        shadowPathOffsetX = 0f
        shadowPathOffsetY = 0f

        shadowPath.apply {
            reset()
            fillType = Path.FillType.WINDING
            addRoundRect(
                topLeftShadowRadius,
                topRightShadowRadius,
                bottomLeftShadowRadius,
                bottomRightShadowRadius,
                view.width.toFloat() + shadowSpread * 2,
                view.height.toFloat() + shadowSpread * 2
            )
        }
        resetShadowOffset()
        invalidate()
    }

    override fun resetShadowOffset() {
        shadowPath.offset(-shadowPathOffsetX, -shadowPathOffsetY)
        shadowPathOffsetX = -shadowSpread + shadowXOffset
        shadowPathOffsetY = -shadowSpread + shadowYOffset
        shadowPath.offset(shadowPathOffsetX, shadowPathOffsetY)
        shadowDrawable.invalidateCache()
    }

    private fun Path.addRoundRect(
        tL: Float,
        tR: Float,
        bL: Float,
        bR: Float,
        w: Float,
        h: Float
    ) {
        val radii = floatArrayOf(tL, tL, tR, tR, bR, bR, bL, bL)
        addRoundRect(0f, 0f, w, h, radii, Path.Direction.CW)
    }

    override fun invalidate() {
        view.invalidate()
    }

    override fun onAttachedToWindow() {
        if (shadowBlur > 0f) {
            (view.parent as? ViewGroup)?.clipChildren = false
        }
    }

    override fun onDetachedFromWindow() {
        shadowDrawable.release()
    }

    override fun draw(canvas: Canvas?) {
        if (canvas == null) {
            return
        }
        if (shadowBlur <= 0) {
            return
        }
        drawShadow(canvas)

        canvas.restoreToCount(
            canvas.saveLayer(null, null)
        )
    }

    override fun drawShadow(canvas: Canvas) {
        try {
            shadowDrawable.draw(canvas)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldW: Int, oldH: Int) {
        shadowDrawable.setBounds(0, 0, w, h)
        setShadowRadius(
            this.topLeftShadowRadius,
            this.topRightShadowRadius,
            this.bottomLeftShadowRadius,
            this.bottomRightShadowRadius
        )
    }
}