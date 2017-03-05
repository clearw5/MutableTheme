#MutableTheme
安卓上一个改变“主题色”的库。所谓“主题色”，通常指colorPrimary。目前该库仍很不完善，支持控件很少。
Usages
--------

###Step 1
Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
Add the dependency
```
dependencies {
        compile 'com.github.hyb1996:MutableTheme:v0.2.0'
}
```
###Step 2
用ThemeColor的Widgets代替原来的控件，之后通过`ThemeColorManager.setColorPrimary(color)`来改变主题色。
或者直接通过`ThemeColorHelper.setThemeColor(view, color)`来设置，这会遍历该view及其所有子View并将可以改变设置主题色的改变颜色（不完善，只支持了一小部分）。

License
--------

    Copyright (c) 2016 hyb1996.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.