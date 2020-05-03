### 強弱型別 ###

==============

| 靜/動態語言 | 強型別 / 弱型別 | 程式語言 | 
| --- | --- | --- |
| 靜態(編譯)  | 強 | Java、C# |
| 靜態(編譯) | 弱 | C、C++ |
| 動態(直譯)  | 強 | Ruby、Python |
| 動態(直譯)  | 弱 | JS、PHP |

強型別語言

Java、C#     => 靜態語言
Ruby、Python => 動態語言

弱型別語言

C、C++          => 靜態語言
JavaScript、PHP => 動態語言

==============

編譯?直譯?

    舉個例子，使用某物件呼叫doSomething()，
    如果在編譯時就會告訴我們，這物件沒有doSomething()這方法，
    這就是靜態語言，
    
    如果到了執行時才發生沒有該方法的錯誤
    就是動態語言。

==============

強型別舉例(Java)

(1)
    String number1 = "3";
    String number2 = "2";
    int result = number1 - number2;     (X)    


宣告 String時 不能用int的型別去運算

(1)
    String number1 = "3";
    String number2 = "2";
    int result = Integer.parseInt(number1) - Integer.parseInt(number2);

通常要用一些方法轉換

Java 中的 + 運算子，只要有運算元有一個是字串，
就會嘗試將另一個運算元轉為字串，而後進行字串串接
如果前面宣告的是 int，照上面說的就理所當然地出錯了

(1)
    // "123"，基本型態按字面轉為字串
    String number = 1 + "23";     
    Person person = new Person();

    // 呼叫 person 的 toString()
    String description = "Person: " + person; 


(2)
    int x = 123 + "456";     (X) 
        -> incompatible types: String cannot be converted to int

弱型別舉例(JS)

    var result = '3' - '2';
    console.log(result);        // 1
    console.log(typeof result); // number

弱型別舉例(PHP)

    echo ("111" == 111) ? "Yes" : "No";     // "Yes"
    echo ("111" === 111) ? "Yes" : "No";    // "No"

#### 參考頁面 ####

https://openhome.cc/Gossip/CodeData/EssentialJavaScript/WeakType.html

https://ithelp.ithome.com.tw/articles/10202260

https://millenniummeetonce.blogspot.com/2018/04/blog-post_5.html