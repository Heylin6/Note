### API ###

全名1 : Application Programming Interface
全名2 : 應用程式 處理 介面

說明 : 用戶端(舉例) 向 另一個系統 交付要處理的資料

舉例 : 寄信 

小明 寄給小美情書 需填上 地址 收件人 郵票 交給郵局

郵局收到後依上面訊息轉交到小美

小美看到後給予相關訊息的回信



*** Restful API  *** 

有合乎規範的請求方式

EX.

獲取商品資料 /GET/items
獲取商品資料 /GET/items/1
新增商品資料 /POST/items
更新商品資料 /PATCH/items/1 
刪除商品資料 /DELETE/items/1

*** GET vs POST *** 

GET 就如明信片
POST就如要裝在信封的信

*** PUT vs POST (新增) *** 

POST => Create entities，輸出結果會異動

PUT => replace entities，輸出結果保持不變

*** PUT vs PATCH (修感) *** 

同樣是更新

put => 整包資料重新更新一次

patch => 只針對更動的部分做更新

所以耗能上會有差異
(ex.假設更新資料 有圖片的話)

*** idempotent *** 

解釋 :
如果相同的操作再執行第二遍第三遍，
結果還是跟第一遍的結果一樣 
(不管執行幾次，結果都跟只有執行一次一樣)。
GET, PUT 和 DELETE 都是

*** 其他 *** 
(URI, methods, Stateless, Cacheable...)




Restful API
https://progressbar.tw/posts/53

https://ihower.tw/blog/archives/6483

GET vs POST

https://blog.toright.com/posts/1203/%E6%B7%BA%E8%AB%87-http-method%EF%BC%9A%E8%A1%A8%E5%96%AE%E4%B8%AD%E7%9A%84-get-%E8%88%87-post-%E6%9C%89%E4%BB%80%E9%BA%BC%E5%B7%AE%E5%88%A5%EF%BC%9F.html