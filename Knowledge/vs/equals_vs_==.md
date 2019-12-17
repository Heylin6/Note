### equals v.s. == ###

*** equals ***

1. 比較的是 : 物件(邏輯比較)
2. 實體 , 記憶體空間之類的

*** == ***

1. 比較的是 : 值
2. 看堆疊指向的記憶題是否相等

========

1.

String ss  = new String("abc");
String sss = new String("abc");

(ss) ==    (sss) => false
(ss).equals(sss) => true

2.

String ss = new String(“abc”);
String ssss = ss;

(ss) ==    (ssss) => true
(ss).equals(ssss) => true

3.

TestBean obj1 = new TestBean();
TestBean obj2 = new TestBean();
TestBean obj3 = obj1;

obj1 ==     obj2 => false
obj1 ==     obj3 => true
========

#### 參考頁面 ####

https://www.javaworld.com.tw/jute/post/view?bid=29&id=200487

http://melvin0530.blogspot.com/2017/03/equals.html

https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/314825/