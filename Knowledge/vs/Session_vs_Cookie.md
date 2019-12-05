### Session_vs_Cookie ###

Cookie 

1. 最常見用在表單填寫
2. 如果網頁關掉重先前填的內容還在，靠的就是 cookie。
3. 只針對原本的 domain 起作用
4. 到了所設定的生命期限之後會失效
5. 要指定 key 及 value
6. document.cookie = "key=value";
5. 參數 : name 名稱(value) , expire 期限(date) , path 路徑(path) , domain 網域(domain) , secure 安全姓

Session

1. 記錄在 web server
2. 身分認證後 -> 存下用戶資料 -> 產生id -> 存入 cookie -> 傳回用戶
3. id 用 uuid
4. 伺服器產生 cookie 時，都會加上 secret 來作 hash






https://blog.hellojcc.tw/2016/01/12/introduce-session-and-cookie/

Cookie parameters
https://www.csie.ntu.edu.tw/~r92092/html/tech/cookie.html