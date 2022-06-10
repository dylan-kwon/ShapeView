package dylan.kwon.shapecontainer

import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods

@BindingMethods(
    BindingMethod(
        type = ShapeContainer::class,
        attribute = "solidColor",
        method = "setShapeColor"
    ),
)
object ShapeContainerBindingAdapter