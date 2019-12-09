### http ###
###

HTTP protocol

### status code

1xx訊息——請求已被伺服器接收，繼續處理

2xx成功——請求已成功被伺服器接收、理解、並接受

    200 OK

3xx重新導向——需要後續操作才能完成這一請求

4xx請求錯誤——請求含有詞法錯誤或者無法被執行

    400 Bad Request（格式錯誤，太大，無效請求）

    403 Forbidden (身分驗證)

    404 Not Found

5xx伺服器錯誤——伺服器在處理某個正確請求時發生錯誤

    500 Internal Server Error(通用錯誤，沒有給出具體錯誤資訊)

    501 Not Implemented(不支援某個功能)

    502 Bad Gateway(閘道器或代理伺服器接收無效)


### domain v.s. path

host.domain是造訪網站的主機名稱

path/filename是造訪網站的路徑和檔案名稱






#### 參考頁面 ####

HTTP protocol

https://zh.wikipedia.org/wiki/%E8%B6%85%E6%96%87%E6%9C%AC%E4%BC%A0%E8%BE%93%E5%8D%8F%E8%AE%AE

http2

http://www.ruanyifeng.com/blog/2018/03/http2_server_push.html


https://medium.com/@chienrongkhor/%E5%A6%82%E4%BD%95%E7%94%A8javascript%E5%8F%96%E5%BE%97%E7%B6%B2%E5%9D%80-url-d0c69934d2a9