### CORS ###

跨來源資源共用 Cross-Origin Resource Sharing (CORS)

or

HTTP 存取控制

載入其他網域的資源時會受到一些限制

通常在 header 加上 Access-Control-Allow-Origin

讓瀏覽器作為確認有經過驗證的

### CSRF ###

跨站請求偉造 (Cross-site request forgery)

又稱作 one-click attack

例子是刪除文章，這可能覺得沒什麼，
那如果是銀行轉帳呢？攻擊者只要在自己的網頁上寫下轉帳給自己帳號的 code，
再把這個網頁散佈出去就好，就可以收到一大堆錢。

CSRF 就是在不同的 domain 底下卻能夠偽造出「使用者本人發出的 request」

CSRF 攻擊之所以能成立，是因為使用者在被攻擊的網頁是處於已經登入的狀態

所以使用者能做的其實有限，真的該做事的是 Server 那邊！

=== 處理方式 ===

Session/Cookie Token => [session_id + user_id] or [random_id + user_id], JWT


CORS

https://blog.techbridge.cc/2017/05/20/api-ajax-cors-and-jsonp/

https://blog.techbridge.cc/2018/08/18/cors-issue/

https://developer.mozilla.org/zh-TW/docs/Web/HTTP/CORS

CSRF

https://blog.techbridge.cc/2017/02/25/csrf-introduction/