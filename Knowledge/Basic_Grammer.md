### 基本語法 ###
###
###

static

    靜態值 , 宣告該語句時會配一個記憶體空間給他(唯一值)
    用來宣告 變數 函數居多

final

    1.用在類別上 -> 該類別無法繼承
    2.用在變數上 -> 該變數值無法再更改
    3.用在方法上 -> 該方法無法被 override

finally

    用在 try/catch 中
    執行完後一定會跑到 finally 這部分

    *假設 try 裡面有 return 的話
     finally 會先在 return 前執行

JAVA - transient

    有些資訊不想被序列化時 , 可加上這個詞修飾
    (ex.密碼 信用卡號))

    *當變數有 static 時 transient 會無效

註 : 序列化(Serialize) -> 物件 Object 轉成串流 Stream
    反序列化(Serialize) -> 串流 Stream 轉成物件 Object

foreach的原理

    1.設計模式 的 迭代器(Iterator Pattern)

#### 參考頁面 #### 

#static

https://openhome.cc/Gossip/Java/Static.html
http://blog.kenyang.net/2011/03/09/java-staticfinal

#foreach

https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/75063/
https://ithelp.ithome.com.tw/articles/10193261

#JAVA - transient

https://dotblogs.com.tw/grayyin/2016/07/05/145920
*序列化 反序列化
https://matthung0807.blogspot.com/2019/01/java-serializedeserialize.html