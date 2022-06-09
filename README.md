# ShapeContainer
[![](https://jitpack.io/v/dylan-kwon/ShapeContainer.svg)](https://jitpack.io/#dylan-kwon/ShapeContainer)

**ShapeContainer** is a container layout that allows you to use ShapeDrawable attributes immediately in layout xml without creating a separate ShapeDrawable.

## Preview
<p>
	<image src = "/sample/images/sample.gif" width = 401 height = 849)/>
</p>

## Install
### Project: build.gradle
```groovy
allprojects {
    repositories {
	    ...
	    maven { url 'https://jitpack.io' }
	}
}
```

### App: build.gradle
``` groovy
dependencies {
    implementation 'com.github.dylan-kwon:ShapeContainer:$latest-version'
}
```

### Attributes
```xml
<dylan.kwon.shapecontainer.ShapeContainer
    android:layout_width="100dp"
    android:layout_height="100dp"

    android:clickable="true"
    android:focusable="true"

    app:solidColor="@color/white"
    app:solidDisabledColor="@color/black"

    app:strokeColor="@color/black"
    app:strokeDisabledColor="@color/red"

    app:strokeWidth="5dp"
    app:strokeDisabledWidth="5dp"

    app:strokeDashWidth="5dp"
    app:strokeDisabledDashWidth="0dp"

    app:strokeDashGap="5dp"
    app:strokeDisabledDashGap="0dp"

    app:cornerRadius="8dp"
    app:cornerDisableRadius="100dp"

    app:rippleColor="@color/red"

    app:enabled="true"
    app:useClip="true" />
```

| name  | description  |
|---|---|
| app:solidColor  | Background color in enabled.  |
| app:solidDisabledColor  | Background color in disabled.  |
| app:strokeColor  | Stroke color in enabled.  |
| app:strokeDisabledColor  | Stroke color in disabled.  |
| app:strokeWidth  | Stroke width in enabled.  |
| app:strokeDisabledWidth  | Stroke width in disabled.  |
| app:strokeDashWidth  | Stroke dash width in enabled.  |
| app:strokeDisabledDashWidth  | Stroke dash width in disabled.  |
| app:strokeDashGap  | Stroke dash gap in enabled.  |
| app:strokeDisabledDashGap  | Stroke dash gap in disabled.  |
| app:cornerRadius  | Radius in enabled.  |
| app:cornerDisableRadius  | Radius in disabled.  |
| app:rippleColor  | Container ripple color.  |
| app:enabled  | container activation status.  |
| app:useClip  | Whether to cut corner radius.  |

