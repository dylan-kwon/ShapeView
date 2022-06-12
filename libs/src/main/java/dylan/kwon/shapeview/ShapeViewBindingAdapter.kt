package dylan.kwon.shapeview

import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods

@BindingMethods(
    BindingMethod(
        type = ShapeView::class,
        attribute = "solidColor",
        method = "setShapeColor"
    ),
)
object ShapeViewBindingAdapter