### MVC Dependency Injection 相依注入(DI) ###

=== 解釋 ===

依賴注入的意義是：

「保留抽象介面，讓組件依賴於抽象介面，
當組件要與其它實際的物件發生依賴關係時，
藉過抽象介面來注入依賴的實際物件。」

抽象介面是他的爹

=== IOC的好處 ===

待補


有三種注入方式

1. Interface(不推薦)
type I IoC
註 : 
子物件會 過度受制於 父介面
如果依賴關係複雜要修改會很難拆開 => 重用性低


2. Setter(推薦)
type II IoC
註 : 適合 物件關係很多 參數一長串

3. Construct
type III IoC
註 : 建物件時一併完成相關關係



Java

@Autowired

@RequestMapping("add")

請求 "/add" 時，會由標籤下的方法處理






https://openhome.cc/Gossip/SpringGossip/DI.html

http://www.codedata.com.tw/java/java-tutorial-the-4th-class-2-spring-dependency-injection/