### Exception v.s. RuntimeEXception ###

簡單來說 :

非 RuntimeException 要自己寫 catch 處理掉

*** Exception ***

1. 檢查型異常
2. 要使用try…catch進行處理

*** RuntimeEXception ***

1. "非" 檢查型異常
2. 關鍵字 : Runtime
3. 所有方法都可以在不聲明throws的情況下拋出RuntimeException及其子類
4. 可不使用try…catch進行處理
5. 但是如果有異常產生，則異常由 JVM 進行處理

========

常見的 RuntimeEXception

1. NullPointerException

    例如: 在 null 的值用上方法

2. NumberFormatException
    
    例如: Integer.parseInt(“ab3”)

3. ArrayIndexOutOfBoundsException

    例如: 陣列 size 爆了

4. StringIndexOutOfBoundsException

    例如: String 轉 char 的時候爆掉

5. ArithmeticException

    例如: 算術錯誤 , 例如 5 除以 0

6. IllegalArgumentException

    例如:  非法參數

#### 參考頁面 ####

https://blog.csdn.net/qq_33535433/article/details/79293809