Cekrek
======
[![Build Status](https://travis-ci.org/zetbaitsu/Cekrek.svg?branch=master)](https://travis-ci.org/zetbaitsu/Cekrek)
[![codecov](https://codecov.io/gh/zetbaitsu/Cekrek/branch/master/graph/badge.svg)](https://codecov.io/gh/zetbaitsu/Cekrek)
[![Code Climate](https://codeclimate.com/github/zetbaitsu/Cekrek/badges/gpa.svg)](https://codeclimate.com/github/zetbaitsu/Cekrek)

Cekrek is an android library that allows you to export any view to bitmap or image file in a convenient way.

* Export or generate `Bitmap` from a `View` without needed to displaying it.
* Export or generate `Image File` from a `View` without needed to displaying it.
* Configurable bitmap and image file generator.
* With `View` extension function for `Kotlin` user.
* Friendly method for `Java` user too.


# Gradle
```groovy
dependencies {
    implementation 'id.zelory:cekrek:1.0.0'
}
```
# Export a view to bitmap
#### Export to bitmap
```kotlin
val bitmap = Cekrek.toBitmap(view)
```
#### Export to bitmap with configuration
```kotlin
// export view to 1280 x 1280 canvas with red background color.
val bitmap = Cekrek.toBitmap(view) {
    canvasConfig.width = CanvasSize.Specific(1280) // set canvas size to 1280 px
    canvasConfig.height = CanvasSize.Specific(1280) // default is CanvasSize.WrapContent
    canvasConfig.color = Color.RED // default is Color.WHITE
}
```
#### Export to bitmap with extension function
```kotlin
val bitmap = view.cekrekToBitmap()
```
#### Export to bitmap with extension function + configuration
```kotlin
// export view to 1280 x 1280 canvas with red background color.
val bitmap = view.cekrekToBitmap {
    canvasConfig.width = CanvasSize.Specific(1280) // set canvas size to 1280 px
    canvasConfig.height = CanvasSize.Specific(1280) // default is CanvasSize.WrapContent
    canvasConfig.color = Color.RED // default is Color.WHITE
}
```
#### Export to bitmap with config variable
```kotlin
val config = CekrekConfig().apply {
    canvasConfig.width = CanvasSize.Specific(1280)
}
val bitmap = Cekrek.toBitmap(view, config)
// or
val bitmap = view.cekrekToBitmap(config)
```
# Export a view to image file
#### Export to image file
```kotlin
val imageFile = Cekrek.toImageFile(view, destination)
```
#### Export to image file with configuration
```kotlin
// export view to 1280 x 1280 canvas with red background color and save it as PNG file.
val imageFile = Cekrek.toImageFile(view, destination) {
    cekrekConfig.canvasConfig.width = CanvasSize.Specific(1280) // set canvas size to 1280 px
    cekrekConfig.canvasConfig.height = CanvasSize.Specific(1280) // default is CanvasSize.WrapContent
    cekrekConfig.canvasConfig.color = Color.RED // default is Color.WHITE
    format = Bitmap.CompressFormat.PNG
}
```
#### Export to image file with extension function
```kotlin
val imageFile = view.cekrekToImageFile(destination)
```
#### Export to image file with extension function + configuration
```kotlin
// export view to 1280 x 1280 canvas with red background color and save it as PNG file.
val imageFile = view.cekrekToImageFile(destination) {
    cekrekConfig.canvasConfig.width = CanvasSize.Specific(1280) // set canvas size to 1280 px
    cekrekConfig.canvasConfig.height = CanvasSize.Specific(1280) // default is CanvasSize.WrapContent
    cekrekConfig.canvasConfig.color = Color.RED // default is Color.WHITE
    format = Bitmap.CompressFormat.PNG
}
```
#### Export to image file with config variable
```kotlin
val config = CekrekImageFileConfig().apply {
    cekrekConfig.canvasConfig.width = CanvasSize.Specific(1280)
    format = Bitmap.CompressFormat.PNG
}
val imageFile = Cekrek.toImageFile(view, config)
// or
val imageFile = view.cekrekToImageFile(config)
```
License
-------
    Copyright (c) 2020 Zetra.
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
