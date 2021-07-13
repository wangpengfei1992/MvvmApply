# 组件化+Jetpack+Kotlin+MVVM

![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly91c2VyLWdvbGQtY2RuLnhpdHUuaW8vMjAxOS80LzE1LzE2YTIxMDE2ZGY5Yzc2YzU?x-oss-process=image/format,png)

## 一、项目简介

该项目主要以`组件化+Jetpack+MVVM`为架构，使用`Kotlin`语言，集合了最新的`Jetpack`组件，如`Navigation`、`Paging3`、`Room`等，另外还加上了依赖注入框架`Koin`和图片加载框架`Coil`。

网络请求部分使用`OkHttp`+`Retrofit`，配合Kotlin的`协程`，完成了对`Retrofit和协程的请求封装`，结合`LoadSir`进行状态切换管理，让开发者只用关注自己的业务逻辑，而不要操心界面的切换和通知。

对于具体的网络封装思路，可参考

## 二、项目使用

### 2.1、组件化搭建项目时暴露出的问题

##### 2.1.1、如何独立运行一个Module？

运行总App时，子Module是属于`library`，而独立运行时，子Module是属于`application`。那么我们只需要在根目录下`gradle.properties`中添加一个标志位来区分一下子Module的状态，例如`singleModule = false` ，该标志位可以用来表示当前Module是否是独立模块，`true`表示处于独立模块，可单独运行，`false`则表示是一个library。


![image-20210425094424273.png](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/4c15b06abea8408985e19037c5063579~tplv-k3u1fbpfcp-watermark.image)

如何使用呢？

在每个`Module`的`build.gradle`中加入`singleModule`的判断，以区分是`application`还是`library`。如下：

```js
if (!singleModule.toBoolean()) {
    apply plugin: 'com.android.library'
} else {
    apply plugin: 'com.android.application'
}

......
dependencies {
}
```

如果需要独立运行只需要修改`gradle.properties`标志位`singleModule`的值。

##### 2.1.2、编译运行后，桌面会出现多个相同图标；

当新建多个Moudle的时候，运行后你会发现桌面上会出现多个相同的图标，

2.1.3、路由跳转及回调

跳转到指定页面aRouter（页面，过程回调，结果回调）

```
aRouter(Constants.RouterPath.LOGIN_ACTIVITY_PATH,navigationCallback = object :NavigationCallback{
                override fun onFound(postcard: Postcard?) {
                    LogUtil.e(TAG,"onFound---")
                }

                override fun onLost(postcard: Postcard?) {
                    LogUtil.e(TAG,"onLost---")
                }

                override fun onArrival(postcard: Postcard?) {
                    LogUtil.e(TAG,"onArrival---")
                }

                override fun onInterrupt(postcard: Postcard?) {
                    LogUtil.e(TAG,"onInterrupt---")
                }

            }, resultCallBack = object : CoreRouterResult{
                override fun onResult(result: String) {
                    LogUtil.e(TAG,"onResult---${result}")
                }

            })
```

回调调用：

```
aRouterOk(reslut = "我想返回什么呢")
```



## 三、更新记录