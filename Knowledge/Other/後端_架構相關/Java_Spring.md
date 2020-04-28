
### Spring框架的差別 ###

=== 前言

Spring Boot和Spring、Spring MVC不是競爭關係，
Spring Boot使我們更加容易使用Spring和Spring MVC

詳見
https://kknews.cc/zh-tw/code/9z8paml.html

=== Spring

以下為他的宗親

1. 設置複雜
2. XML,properties 設置繁瑣

Spring AOP
Spring JDBC
Spring MVC
Spring ORM
Spring JMS
Spring Test


=== SpringMVC

1. 屬於 Spring
2. 一種 MVC 框架
3. Servlet 為基底
4. 增加业务代码，如controller，service，model等，最后生成 war 包，通过容器进行启动
5. Dispatcher Servlet, ModelAndView 和 View Resolve
6. 需要配置組件掃描，調度器servlet，視圖解析器


=== SpringBoot

1. 屬於 Spring
2. 因為 Spring 設置實在太煩了
3. Python Node.Js 都比他方便
4. 所以出現這個 降低 Spring 使用門檻
5. 統合包外帶全家桶餐
6. 重點 : 自動配置 降低建立複雜度


=== SpringJPA

=== SpringSecurity

1. 用來身分驗證
2. 可以跟 Spring MVC 良好整合
3. 確保使用者僅可存取允許的資源。
        ex.Spring Security提供幾種授權的層級，有http請求、http方法、物件等.


#### 參考頁面 ####

https://www.jianshu.com/p/42620a0a2c33

https://kknews.cc/zh-tw/code/9z8paml.html