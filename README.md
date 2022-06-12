# ShapeView
[![](https://jitpack.io/v/dylan-kwon/ShapeView.svg)](https://jitpack.io/#dylan-kwon/ShapeView)

**ShapeView** is a view or layout that allows you to use ShapeDrawable attributes immediately in layout xml without creating a separate ShapeDrawable.

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
    implementation 'com.github.dylan-kwon:ShapeView:$latest-version'
}
```

### Attributes
```xml
<fundylan.kwon.shapeview.ShapeContainer
    android:layout_width="100dp"
    android:layout_height="100dp"

    android:clickable="true"
    android:focusable="true"

    app:solidColor="@color/white"
    app:strokeColor="@color/black"
    app:strokeWidth="5dp"
    app:strokeDashWidth="5dp"
    app:strokeDashGap="5dp"

    app:cornerRadius="8dp"

    app:rippleColor="@color/red"
    
    app:useClip="true" />
```

| name  | description  |
|---|---|
| app:solidColor  | Background color in enabled.  |
| app:strokeColor  | Stroke color in enabled.  |
| app:strokeWidth  | Stroke width in enabled.  |
| app:strokeDashWidth  | Stroke dash width in enabled.  |
| app:strokeDashGap  | Stroke dash gap in enabled.  |
| app:cornerRadius  | Radius in enabled.  |
| app:rippleColor  | Container ripple color.  |
| app:useClip  | Whether to cut corner radius.  |

