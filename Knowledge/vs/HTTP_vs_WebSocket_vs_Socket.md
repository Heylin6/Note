### HTTP v.s. WebSocket v.s. Socket ###

HTTP

瀏覽器 與 伺服器 交換資料的方式之一



WebSocket

1. 瀏覽器 與 伺服器 交換資料的方式之一
2. 是一個 持續的 雙向連線(反應更即時)
3. 沒有重新連線 沒有重新傳送檔頭 等多餘負荷
4. 分 程式上的介面 與 伺服器端 的 傳輸協定標準
5. 類型為 text/binary(只能擇一使用)

Socket.io

1. 跟 WebSocket 很像
2. 但她不算種協議,只是一個框架

Socket

1. 就是 TCP/IP
2. 傳輸方式為 stream , 類型為 binary





https://ithelp.ithome.com.tw/articles/10102394

https://leesonhsu.blogspot.com/2018/07/socketwebsocketsocketio.html