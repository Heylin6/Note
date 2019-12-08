### MVC ###

M : Model => 

跟 DB 做聯繫 , 
將 DB 上的資料
轉介成程式尚可運用的格式

V : View => 

鋪陳在畫面上的視窗

C : Controller => 

在 View 與 Model 之間的中介器

* 通常會再加上 ViewModel Service

==== 其他細節 ====

1. Java 在 model 上用 pojo


==== 生命週期 ====

請求 => C 接收請求 => 要求 M 處理 => 處理完交還給 C => 處理完的鋪到 V 上 同時 回傳狀態

SpringMVC 版

請求 => 
傳到 Servlet => 
Servlet 向 HandlerMapping 查是誰處理 =>
HandlerMapping 找到是誰處理後告訴 Servlet =>
Servlet 叫 Handler 執行該處理(此時 Handler 就是 Controller) =>
Handler 處理完傳回 modal,view 給 Servlet =>
Servlet 再叫 ViewResolver 解析 =>
ViewResolver 解析完後丟 view 傳回給 Servlet =>
將視覺跟資料 response 到 view



==== ORM ====

1. 物件關聯對映
2. Object Relational Mapping
3. O/R mapping
4. Model 與 DB 之間的中介處理
5. Java 使用 Hibernate
6. C# 使用 Entity Framework



生命週期

https://blog.csdn.net/WuLex/article/details/77649944
