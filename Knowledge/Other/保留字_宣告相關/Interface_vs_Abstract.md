###  Interface vs Abstract ###
###
###

1. 從某種意義上說，interface是一種特殊形式的abstract class。 
2. abstract class在Java語言中表示的是一種繼承關係，
   一個類只能使用一次繼承關係。但是，一個類卻可以實現多個interface。
3. 使用 abstract 定義抽象類別 (不得宣告為 final class)
4. abstract class不能用new關鍵字去產生物件


使用abstract class的方式定義Demo抽像類的方式如下： 

abstract class Demo ｛ 

    abstract void method1(); 

    abstract void method2(); 
｝ 

使用interface的方式定義Demo抽像類的方式如下： 

interface Demo { 

    void method1(); 

    void method2(); 

} 


#### 參考頁面 ####

https://jjnnykimo.pixnet.net/blog/post/21585257

https://coffee0127.github.io/blog/2016/09/10/abstract-class-vs-interface/

https://www.javaworld.com.tw/jute/post/view?bid=29&id=195263&fbclid=IwAR32NlhiCQyrMODWb5zpMB_ndo7YU95nophF5AosmYb7I47MxGxV7YjMiEg

https://www.mobile01.com/topicdetail.php?f=37&t=1839533&fbclid=IwAR0xqYNxy4HJzWLvmCrCvT41EQv2rGWf9DuCH23bxROvWyuoKEO66xYp1t0