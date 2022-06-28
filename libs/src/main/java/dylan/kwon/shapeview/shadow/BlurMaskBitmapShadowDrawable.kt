package dylan.kwon.shapeview.shadow

import android.graphics.*

internal class BlurMaskBitmapShadowDrawable(

    shadowPath: Path

) : BitmapShadowDrawable(shadowPath) {

    private val shadowPaint = Paint().apply {
        isDither = true
        isAntiAlias = true
        style = Paint.Style.FILL
    }

    override fun onDrawBitmap(bitmap: Bitmap) {
        with(Canvas(bitmap)) {
            drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
            translate(shadowBlur * 2, shadowBlur * 2)
            drawPath(shadowPath, shadowPaint)
        }
    }

    override fun onShadowChange(blur: Float, color: Int, inset: Boolean) {
        super.onShadowChange(blur, color, inset)
        val type = if (this.shadowInset) {
            BlurMaskFilter.Blur.INNER
        } else {
            BlurMaskFilter.Blur.NORMAL
        }
        shadowPaint.maskFilter = if (this.shadowBlur == 0f) {
            null
        } else {
            BlurMaskFilter(this.shadowBlur, type)
        }
        shadowPaint.color = color
    }

}