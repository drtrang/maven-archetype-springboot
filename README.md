# Spring Boot Archetype

[![Build Status](https://img.shields.io/travis/drtrang/maven-archetype-springboot/master.svg?style=flat-square)](https://www.travis-ci.org/drtrang/maven-archetype-springboot)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.drtrang/maven-archetype-springboot.svg?style=flat-square)](https://maven-badges.herokuapp.com/maven-central/com.github.drtrang/maven-archetype-springboot)
[![GitHub Release](https://img.shields.io/github/release/drtrang/maven-archetype-springboot.svg?style=flat-square)](https://github.com/drtrang/maven-archetype-springboot/releases)
[![License](http://img.shields.io/badge/license-apache%202-blue.svg?style=flat-square)](https://github.com/drtrang/maven-archetype-springboot/blob/master/LICENSE)

Spring Boot Archetype 将帮助你快速生成 Spring Boot 项目。


## 前置条件
* [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven 3](http://maven.apache.org/download.cgi)


## 特点
* [Spring Boot 1.5.6.RELEASE](https://github.com/spring-projects/spring-boot) & Jetty
* [MyBatis](https://github.com/mybatis/mybatis-3) & [MyBatis Generator](https://github.com/mybatis/generator) & [Mapper](https://github.com/abel533/mapper) & [PageHelper](https://github.com/pagehelper/Mybatis-PageHelper)
* [Druid](https://github.com/alibaba/druid)
* [Redisson](https://github.com/redisson/redisson)
* [Copiers](https://github.com/drtrang/copiers)
* [Swagger2](https://github.com/springfox/springfox)
* [Lombok](https://github.com/rzwitserloot/lombok)


## 运行
### 创建项目
```
mvn archetype:generate -DarchetypeGroupId=com.github.drtrang -DarchetypeArtifactId=maven-archetype-springboot -DarchetypeVersion=1.0.0 -DinteractiveMode=false -DgroupId=$groupId -DartifactId=$artifactId -Dversion=$version -Dpackage=$package
```

其中 `$groupId`、`$artifactId`、`$version`、`$package` 为占位符，根据实际情况替换即可。

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

![swagger2](https://user-images.githubusercontent.com/13851701/29200486-45681c32-7e88-11e7-934c-c22eabe3a63f.png)


## 集成 Intellij IDEA
* 新建项目 `File > New > Project`
* 选择 Maven 并勾选 `Create from archetype`
* 点击 `Add Archetype` 按钮
* 填写 `GroupId`: `com.github.drtrang`
* 填写 `ArtifactId`: `maven-archetype-springboot`
* 填写 `Version`: `1.0.0`
* 点击 `OK` 按钮
* 选择 `maven-archetype-springboot:1.0.0` 并点击 `Next` 按钮
* 填写项目属性，创建项目

Note：`Add Archetype` 步骤只需执行一次，以后可直接选择 `maven-archetype-springboot:1.0.0`

![idea2](https://user-images.githubusercontent.com/13851701/29200507-7562009c-7e88-11e7-9cbf-2329da6f037b.png)


## 更新记录
[Release Notes](https://github.com/drtrang/maven-archetype-springboot/releases)


## TODO
任何意见和建议可以提 [Issue](https://github.com/drtrang/maven-archetype-springboot/issues)，我会酌情加到 [Todo List](https://github.com/drtrang/maven-archetype-springboot/blob/master/TODO.md)，一般情况一周内迭代完毕。


## 作者信息
QQ：349096849<br>
Email：donghao.l@hotmail.com<br>
Blog：[blog.trang.space](http://blog.trang.space)
