# Spring Boot Archetype


[![Build Status](https://img.shields.io/travis/drtrang/maven-archetype-springboot/master.svg?style=flat-square)](https://www.travis-ci.org/drtrang/maven-archetype-springboot)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.drtrang/maven-archetype-springboot.svg?style=flat-square)](https://maven-badges.herokuapp.com/maven-central/com.github.drtrang/maven-archetype-springboot)
[![GitHub Release](https://img.shields.io/github/release/drtrang/maven-archetype-springboot.svg?style=flat-square)](https://github.com/drtrang/maven-archetype-springboot/releases)
[![License](http://img.shields.io/badge/license-apache%202-blue.svg?style=flat-square)](https://github.com/drtrang/maven-archetype-springboot/blob/master/LICENSE)


Spring Boot Archetype 将帮助你快速生成 Spring Boot 项目。


## 注意！
* 本项目不是可运行项目，无需 clone 到本地，请直接运行脚本
* 本项目依赖于 Lombok 插件，请在 IDE 中安装 `Lombok Plugin`，了解 Lombok 请查看：[Lombok：让 Java 代码更优雅](https://mp.weixin.qq.com/s?__biz=MzI0OTIzOTMzMA==&mid=2247483851&idx=1&sn=007ceceaa3a3e6fecbeb23873a230e19&chksm=e995c386dee24a90c9493949bd1cb159114f5d457d4354a93050c3a218c5d111a193406dff74&mpshare=1&scene=1&srcid=0606I1Vkahdws6aFa04Ytvpv#rd)


## 前置条件
* [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven 3](http://maven.apache.org/download.cgi)
* [Lombok](https://mp.weixin.qq.com/s?__biz=MzI0OTIzOTMzMA==&mid=2247483851&idx=1&sn=007ceceaa3a3e6fecbeb23873a230e19&chksm=e995c386dee24a90c9493949bd1cb159114f5d457d4354a93050c3a218c5d111a193406dff74&mpshare=1&scene=1&srcid=0606I1Vkahdws6aFa04Ytvpv#rd)


## 特点
* 基于 Spring Boot 1.5.9，内嵌 Jetty
* 提供全局异常捕获、View to Json、跨域访问等功能
* 提供 Maven Profile 和 Spring Profile 完美融合的解决方案
* 集成通用 Mapper 和 PageHelper，新增 BaseService，常用 CRUD 无需编写代码
* 集成 MyBatis Generator，额外提供功能强大的插件拓展 [MBG Plugin Extension](https://github.com/drtrang/mybatis-generator-extension)
* 集成 [Druid Spring Boot Starter](https://github.com/drtrang/druid-spring-boot)，无需显式声明数据源，支持多数据源
* 集成 Swagger2，HTTP 接口自动生成接口文档
* 集成常用工具，如 Copiers、CsvUtils、DateUtils……


## 运行
### 创建项目
运行以下脚本即可创建项目，脚本中包含 `${groupId}`、`${artifactId}`、`${version}`、`${package}` 4 个变量，可根据实际情况灵活改变。

| 变量 | 必填 | 默认值
| :-- | :-- | :-- | 
| groupId | 是 | 无
| artifactId | 是 | 无
| version | 是 | 1.0.0-SNAPSHOT 
| package | 是 | 无

```
mvn archetype:generate -DarchetypeGroupId=com.github.drtrang -DarchetypeArtifactId=maven-archetype-springboot -DarchetypeVersion=1.0.1 -DinteractiveMode=false -DarchetypeCatalog=local -DgroupId=${groupId} -DartifactId=${artifactId} -Dversion=${version} -Dpackage=${package}
```

### 启动项目
在项目的根路径下执行以下脚本：
```
mvn spring-boot:run
```

启动后即可通过浏览器访问该项目，默认端口号为 **8080**：
```html
http://localhost:8080
```

项目自带 Swagger2，便于查看文档和调试：
```html
http://localhost:8080/swagger-ui.html
```

![swagger2](https://user-images.githubusercontent.com/13851701/29209263-34dcbc78-7ec0-11e7-85c2-4f6cd63c2fae.png)


## 详细介绍
[Spring Boot 的 Maven 项目原型](http://blog.trang.space/2017/08/11/Spring%20Boot%20%E7%9A%84%20Maven%20%E9%A1%B9%E7%9B%AE%E5%8E%9F%E5%9E%8B/)


## 集成 Intellij IDEA
* 新建项目 `File > New > Project`
* 选择 Maven 并勾选 `Create from archetype`
* 点击 `Add Archetype` 按钮
* 填写 `GroupId`: `com.github.drtrang`
* 填写 `ArtifactId`: `maven-archetype-springboot`
* 填写 `Version`: `1.0.1`
* 点击 `OK` 按钮
* 选择 `maven-archetype-springboot:1.0.1` 并点击 `Next` 按钮
* 填写项目属性，创建项目

**Note：`Add Archetype` 步骤只需执行一次，以后可直接选择 `maven-archetype-springboot:1.0.1`**

![idea2](https://user-images.githubusercontent.com/13851701/29200507-7562009c-7e88-11e7-9cbf-2329da6f037b.png)


## Change Log
[Release Notes](https://github.com/drtrang/maven-archetype-springboot/releases)


## TODO
任何意见和建议可以提 [ISSUE](https://github.com/drtrang/maven-archetype-springboot/issues)，我会酌情加到 [TODO List](https://github.com/drtrang/maven-archetype-springboot/blob/master/TODO.md)，一般情况一周内迭代完毕。


## About Me
QQ：349096849<br>
Email：donghao.l@hotmail.com<br>
Blog：[Trang's Blog](http://blog.trang.space)