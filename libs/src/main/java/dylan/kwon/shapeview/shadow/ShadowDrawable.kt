package dylan.kwon.shapeview.shadow

import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Path
import android.graphics.drawable.Drawable
import androidx.annotation.CallSuper

internal abstract class ShadowDrawable(

    protected val shadowPath: Path

) : Drawable() {

    override fun setAlpha(alpha: Int) {
        throw IllegalArgumentException()
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        throw IllegalArgumentException()
    }

    @Deprecated(message = "deprecated")
    override fun getOpacity(): Int {
        throw IllegalArgumentException()
    }

    protected var shadowBlur: Float = 0f
        private set

    protected var shadowColor: Int = Color.TRANSPARENT
        private set

    protected var shadowInset: Boolean = false
        private set

    @CallSuper
    open fun setShadowBlur(blur: Float) {
        this.shadowBlur = blur
        onShadowChange(this.shadowBlur, this.shadowColor, this.shadowInset)
    }

    @CallSuper
    open fun setShadowColor(color: Int) {
        this.shadowColor = color
        onShadowChange(this.shadowBlur, this.shadowColor, this.shadowInset)
    }

    @CallSuper
    open fun setShadowInset(inset: Boolean) {
        this.shadowInset = inset
        onShadowChange(this.shadowBlur, this.shadowColor, this.shadowInset)
    }

    open fun invalidateCache() = Unit

    abstract fun onShadowChange(
        blur: Float,
        color: Int,
        inset: Boolean
    )

    open fun release() = Unit
}