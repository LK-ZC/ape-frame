<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">Ape Frame</h1>
<h4 align="center">基于SpringBoot开发的轻量级框架</h4>
<p align="center">
<a href='https://gitee.com/classicChickenWings/ape-frame/stargazers'>
<img src='https://gitee.com/classicChickenWings/ape-frame/badge/star.svg?theme=dark' alt='star'>
</a>
<a href="#公众号"><img src="https://img.shields.io/badge/公众号-经典鸡翅-orange.svg?style=plasticr"></a>
<a href="#公众号"><img src="https://img.shields.io/badge/交流群-开源项目实战群-purple.svg?style=plasticr"></a>
<a href="https://gitee.com/classicChickenWings/ape-frame">
<img src="https://img.shields.io/badge/version-v1.0-red.svg">
</a>
<a href="https://gitee.com/classicChickenWings/ape-frame">
<img src="https://img.shields.io/badge/微信-jingdianjichi-brightgreen.svg">
</a>
</p>

## ✨项目简介
ape-frame，ape是“猿”的意思，正好符合我们程序猿的称号！我希望未来这个框架是专属于我们程序猿的首选开发框架。

一直想做一款适用于中小企业的轻量级快速开发框架，涵盖平时业务开发的常用场景，做到开箱即用。用户可根据自身情况选择组件来进行使用。采取组件化开发模式。

比如用户需要redis，则选择redis组件，需要websocket，则引入websocket组件，用户自身不需要再开发什么，只需要按照组件规则进行使用即可。

同时，有些经典的工具以及经典的设计模式代码，提供了大量实例参考，用户的业务场景一旦用到，就可以直接使用。

项目整体采用maven结构开发，封装了大量的模块，彼此解耦。满足用户日常开发需要。

希望大家可以帮忙点点Star，您的Star就是对我最大的支持。持续更新中，微服务版本更新中！

<a href="https://imgse.com/i/pPKkSLF"><img src="https://s1.ax1x.com/2023/08/13/pPKkSLF.png" alt="pPKkSLF.png" border="0" /></a>

## 🔥项目模块结构介绍
### ape-cloud
微服务模块更新中，目前具备以下模块
* ape-cloud-eureka：eureka服务注册组件
* ape-cloud-eureka-server：eureka服务端用于服务治理与服务发现
* ape-cloud-ribbon：ribbon负载均衡
* ape-cloud-openFeign：feign远程调用
* ape-cloud-home：用于微服务调用案例的首页微服务
* ape-cloud-sku：用于微服务调用案例的sku微服务
### ape-common
* ape-common-job：分布式任务调度组件
* ape-common-log：日志组件，提供日志切面自动记录及异步日志提升性能
* ape-common-mybatisplus：采用Mybatisplus作为与数据库交互
* ape-common-redis：缓存组件，提供基于redis的操作封装，redis分布式锁，guava的cache工具类
* ape-common-starter：启动类组件，与启动类相关的功能，放到此组件处，目前包含mongoStarter
* ape-common-swagger：swagger组件，提供整体项目访问api的入口及方法文档
* ape-common-test：测试组件，集成springboot-test，及代码单元测试，代码覆盖率，行覆盖率检测
* ape-common-tool：常用的工具类组件，满足业务日常开发的各种需要，保障安全性，低入侵性
* ape-common-web：web组件，提供统一异常处理，web模块转换，统一返回值
* ape-common-websocket：websocket组件，提供一套带鉴权的websocket，引入即用，简单方便
* ape-mail：邮件发送组件
### ape-demo
demo里提供了大量的实例，教大家如何直接使用这个项目框架，大家在开发中，可以直接参考这个模块来建立自己的项目进行使用。
目前已经提供的示例功能
<a href="https://imgse.com/i/pPM6Lge"><img src="https://s1.ax1x.com/2023/08/15/pPM6Lge.png" alt="pPM6Lge.png" border="0" /></a>

### ape-dependencies
该模块为一个父pom模块，提供项目整体的maven包的锁定及规范，统一升级，统一引入。
