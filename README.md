[![Jcenter Status](https://api.bintray.com/packages/openproject/maven/lesscode-headerbar/images/download.svg)](https://bintray.com/openproject/maven/lesscode-headerbar)

# LessCode-HeaderBar
a common header bar ui for app

## Gradle

```groovy
compile('com.jayfeng:lesscode-lesscode:0.5');
```

## Overview
> * 支持常见状态栏效果
> * 支持阴影
> * 支持搜索
> * 支持下拉菜单(待开发)
> * 使用非常简单

## Usage
配置如下，
```java
HeaderBarConfig.getInstance()
    // header
    .setHeaderHeight(DisplayLess.$dp2px(56))
    .setHeaderBackgroundDrawable(new ColorDrawable(Color.RED))
    .setHeaderBackIcon(R.drawable.app_back)
    .setHeaderShadowDrawable(getResources().getDrawable(R.drawable.app_shadow))
    .setHeaderShadowHeight(100)
    // title
    .setTitleTextColor(Color.BLUE)
    .setTitleTextSize(24)
    // item
    .setItemTextNormalColor(getResources().getColor(R.color.header_menu_text_normal_color))
    .setItemTextPressedColor(getResources().getColor(R.color.header_menu_text_pressed_color))
    .setItemTextSize(10)
    .setItemBackgroudResource(R.drawable.app_item_bg_transparent)
    .build();
```
布局中定义HeaderBar,
```xml
<com.jayfeng.lesscode.headerbar.HeaderBar
    android:id="@+id/headerbar"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

## Author

> Author weibo：<a href="http://weibo.com/xiaofengjian" target="_blank">冯建V</a>&nbsp;&nbsp;&nbsp;&nbsp;mail：673592063@qq.com&nbsp;&nbsp;&nbsp;&nbsp;QQ：673592063

## License

```
Copyright (C)  LessCode Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
