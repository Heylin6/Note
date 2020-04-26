### MVC Dependency Injection 相依注入(DI) ###

=== 解釋 ===

Inversion of Control 控制反轉
Dependency Injection 依賴注入

不負責小翻譯:

跑個程式不用甚麼都把東西丟上去(ex.Bean Service的東西)
只要看到 @甚麼鬼 的放相對應的東西

火鍋一次全丟 丟肉丟菜丟芋頭 快熟慢熟的混在一起
然後整鍋又混肉渣

所以決定 
前期 看到@芋頭 丟芋頭
中期 @蔬菜
後期 @肉

================================
=== IOC ===

1. 目的 => 解除耦合(decoupling)。
2. 反轉控制流程的相對點是指 => 靜態綁定(Statically binding) 和 動態綁定(Dynamic binding)。
3. 靜態綁定

    val fami = Dog()
    那法米就會是狗，他不會是貓、龍之類的

4. 動態綁定

    fun method(creatureNumer:Int) {
        val fami: Creature
        when (creatureNumber) {
            IS_DOG -> fami = Dog()
            IS_CAT -> fami = Cat()
            IS_MONKEY -> fami = Monkey()
            IS_GODZILLA -> fami = Godzilla()

        }
    }
    那法米有可能是狗、是貓、是猴、也有可能是哥吉拉，
    根據程式怎麼跑決定。


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

================================

=== DI ===

依賴注入的意義是：

「保留抽象介面，讓組件依賴於抽象介面，
當組件要與其它實際的物件發生依賴關係時，
藉過抽象介面來注入依賴的實際物件。」 

將依賴對象(Service)傳遞給依賴者(Client)，
而不是允許依賴者建立或者是自己去找依賴對象，
是這個模式的基本要求。
=> 類似 Java 的 @Autowired

================================


Java

@Autowired

@RequestMapping("add")



#### 參考頁面 ####

https://medium.com/jastzeonic/inversion-of-control-ioc-%E7%9A%84%E9%82%A3%E4%B8%80%E5%85%A9%E5%80%8B%E5%BF%83%E5%BE%97-d2324cb8b5f1

https://openhome.cc/Gossip/SpringGossip/DI.html

http://www.codedata.com.tw/java/java-tutorial-the-4th-class-2-spring-dependency-injection/