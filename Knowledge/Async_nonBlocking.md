### 非同步(Async) ###



*為呵要用非同步

程式碼是一行一行執行的

但有些處理非常耗時(ex.撈一大包資料,請求方回傳要很久)

所以非同步是用來請求完後放著

(讓它放在那邊跑)

繼續處理其他的程式

而不是整個系統直接卡在那一行

=============

舉例

那邊每一張桌子上面都會有桌號。你去點餐的時候，只要跟老闆講說你坐哪一桌，等餐點完成之後老闆就會自己主動送過來。
所以我不需要站在店家門口等，我只要在位子上繼續坐我的事情，反正餐點好了之後老闆會送過來。

=============

### nonblocking read ###

讀取的時候 有時會因為被請求方沒寫入資料

而導致停止不動(blocking)


#### 參考頁面 ####

Async

https://medium.com/@hyWang/%E9%9D%9E%E5%90%8C%E6%AD%A5-asynchronous-%E8%88%87%E5%90%8C%E6%AD%A5-synchronous-%E7%9A%84%E5%B7%AE%E7%95%B0-c7f99b9a298a

https://blog.techbridge.cc/2017/05/20/api-ajax-cors-and-jsonp/

nonblocking

https://medium.com/@fcamel/%E9%9D%9E%E5%90%8C%E6%AD%A5%E7%A8%8B%E5%BC%8F%E8%A8%AD%E8%A8%88%E5%92%8C-non-blocking-io-a43881081aac