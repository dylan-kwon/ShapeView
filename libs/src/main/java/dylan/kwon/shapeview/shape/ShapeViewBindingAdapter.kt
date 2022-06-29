package dylan.kwon.shapeview.shape

import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods

@BindingMethods(
    BindingMethod(
        type = ShapeView::class,
        attribute = "solidColor",
        method = "setShapeColor"
    ),
    BindingMethod(
        type = ShapeView::class,
        attribute = "shadow_x_offset",
        method = "setShadowXOffset"
    ),
    BindingMethod(
        type = ShapeView::class,
        attribute = "shadow_y_offset",
        method = "setShadowYOffset"
    ),
)
object ShapeViewBindingAdapter