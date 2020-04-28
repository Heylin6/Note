### Auth Session Cookie JWT Outh2 ###

*** Cookie ***

1. 最常見用在表單填寫
2. 如果網頁關掉重先前填的內容還在，靠的就是 cookie。
3. 只針對原本的 domain 起作用
4. 到了所設定的生命期限之後會失效
5. 要指定 key 及 value
6. document.cookie = "key=value";
5. 參數 : name 名稱(value) , expire 期限(date) , path 路徑(path) , domain 網域(domain) , secure 安全姓

*** Session ***

1. 記錄在 web server
2. 身分認證後 -> 存下用戶資料 -> 產生id -> 存入 cookie -> 傳回用戶
3. id 用 uuid
4. 伺服器產生 cookie 時，都會加上 secret 來作 hash

*** JWT ***

1. JSON Web Token
2. header(BASE64)
3. payload(BASE64)
4. 簽名 : 加密方式(header(BASE64)+'.'+payload(BASE64),'secret') => 加密方式看alg
5. secret 保存在 server 端
6. header(BASE64)+'.'+payload(BASE64)+'.'+加密完的簽名(BASE64)
7. 輕量化
8. server 端不用存session
9. 只用 json => 所以可跨語言
10. 不要放太敏感的訊息 如卡號 => 因為 BASE64 可逆推

*** Oauth2 ***

1. OAuth 的下一版
2. 但不相容 OAuth 1.0
3. 註冊懶得填寫會出現用 fb,google 登入那些
4. 小故事

我今天開始玩 某個app
選加入會員 但我不想填一堆資料
此時跳出用 fb註冊會員

(app 向 使用者 請求拿資料)

我按下允許 => 准許 app 去拿
那 app 就拿我的 ID 跟 管理員系統 要 臨時訪客證

(使用者同意 並提供 身分ID)
(app 拿 身分ID 去跟 系統要token)

管理員系統 確認是我的ID後 給app 臨時訪客證

(系統確認正確後發token 給 app)

app 拿 訪客證 去跟 fb 要 我的資訊 填寫會員資料

(app 拿 token 跟 fb要資料)


#### 參考頁面 ####

https://medium.com/@justinlee_78563/%E9%97%9C%E6%96%BCoauth-2-0-%E4%BB%A5facebook%E7%82%BA%E4%BE%8B-6f78a4a55f52

https://blog.hellojcc.tw/2016/01/12/introduce-session-and-cookie/

Cookie parameters
https://www.csie.ntu.edu.tw/~r92092/html/tech/cookie.html

JWT
https://mgleon08.github.io/blog/2018/07/16/jwt/