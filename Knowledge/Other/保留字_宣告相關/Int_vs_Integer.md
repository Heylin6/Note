### Int v.s. Integer ###

*** Int ***

1. 他是 原始型別


*** Integer ***

1. 他是 物件類別
2. 所以初始值可以 null
3. 裡面有很多 method


============

(1) 
int i =1；Integer i= new Integer(1);
Integer 要當成類別看

(2)
只是宣告數字用 int
如果要對數字進行處理用 Integer

(3)
ArrayList，HashMap 這種 int 放不進去
要宣告成 Integer
(because 容器都是裝 object)

(4) 
定義類型時

    List<Integer> 
    => (O)
    List<int>
    => (X)

#### 參考頁面 ####

https://www.cnblogs.com/shenliang123/archive/2011/10/27/2226903.html