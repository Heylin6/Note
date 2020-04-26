### final v.s. finally v.s. finalize ###

*** final ***

    1.用在類別上 -> 該類別無法繼承
    2.用在變數上 -> 該變數值無法再更改
    3.用在方法上 -> 該方法無法被 override

*** finally ***

    用在 try/catch 中
    執行完後一定會跑到 finally 這部分

    *假設 try 裡面有 return 的話
     finally 會先在 return 前執行

*** finalize ***

    用在 GC 上
    java.lang.Object 上的一個 method
    保證物件在被 GC(Garbage Collection,一種記憶體管理機制,處理記憶體的垃圾) 
    前能被回收

#### 參考頁面 ####

https://medium.com/@clu1022/java%E7%AD%86%E8%A8%98-final-finally-%E8%88%87-finalize-d72dc66e49eb
