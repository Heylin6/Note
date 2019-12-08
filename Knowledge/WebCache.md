### Web Cache ###

1. HTTP 快取 => 快取 及 重複使用先前的資源

ETag

1. 傳遞一雜湊值
2. 假設資訊未變更 => 雜湊值不變
3. 客戶端發出請求先送雜湊值
4. 如值不變 則當沒這請求發生(回傳 304 Not modified)
5. 用在 get 請求

Cache-Control

1. 這類別的指令 負責管控可快取的 使用者 條件和 快取時限
1-1. "no-cache" 和 "no-store"

no-cache : 
跟 ETag 相互輝映
先問 伺服器 東西有沒有改到
有才跑請求沒就裝死

no-store : 
禁止儲存 請求與回應的東西(ex.個人隱私,銀行卡)
所以沒有快取
每次都得發請求
但存不存還是要看客戶端的良心
所以不能全依賴這當隱私保護

1-2. 「public」和「private」

public :
顧名思義
不過通常都會配合 max-age 之類的
所以意義不大

private : 
只給單一使用者快取(ex.私人資訊) 
然後cdn禁止快取

1-3. max-age

這快取幾秒內有效
max-age = 10 的話
就只能撐 10 秒


Expires

1. 限定快取到期的時間
2. 沒超過那時間就不會發出任何請求
3. HTTP 1.0 的產物
4. HTTP 1.1 用 max-age
5. 同時有 max-age 跟 Expires, Expires 會被 max-age 蓋過

Last-Modified

1. 紀錄東西上次更改是啥時
2. HTTP 1.0 的產物
3. If-Modified-Since => 假設有編輯 就發請求
4. 但是檔案開著不修改也算有編輯
5. 所以乾脆用 ETag

FileSystem




https://blog.techbridge.cc/2017/06/17/cache-introduction/

https://developers.google.com/web/fundamentals/performance/optimizing-content-efficiency/http-caching?hl=zh-TW

https://notfalse.net/56/http-stale-response