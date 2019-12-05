### Memcached v.s. Radis ###

Memcached

1. 一個記憶體key-value資料庫
2. 不支援資料的持久化
3. 伺服器關閉之後資料全部丟失
4. 資料型態簡單
5. 多執行續
6. 使用基於Slab的記憶體管理方式
7. 有利於減少記憶體頻繁分配銷燬的開銷
8. 只有再次讀取相關資料時才檢查時間戳，或記憶體不夠用需要淘汰資料時進一步檢查LRU資料
9. memcache還可用於快取其他東西，例如圖片、視訊等等。
10. 使用情境 快取 工作階段存放區

Redis

1. 開源的key-value儲存系統
2. 支援字串、雜湊表、連結串列、集合(資料型態複雜)
3. 讀寫分離
4. 使用情境 快取 聊天、簡訊和佇列 遊戲排行榜 工作階段存放區 豐富的媒體串流 地理位置資訊 機器學習 即時分析
5. 支援備份

*. Radis 運用 限流器 => 用來限制用戶每多久時間發出的請求次數
*. Radis 運用 推播通知 

#1 

當暫存的叢集有問題需要恢復(ex.發生斷電)
Redis 可以 handle 
(存放時間長)
Memcached 不行
(資料一出問題整包都會不見) 

#2

存儲方式 : 讀取 -> 修改 -> 寫入

Memcached:

遊戲中使用 Memcached 時，
會需要整列資料讀下來後才能修改寫入。
但若同時有 另一個改動 在 第一次改動時 發生，
系統會不知道該儲存哪一筆修改後的資料，
這時候就需要另外寫程式去處理這個問題

Redis:

只要將修改的那部分寫入快取即可，
不需要抓整串資料拿出來修改
(ex.更新遊戲中血量,MP,硬幣)

可以隨時取用來恢復有問題的叢集
快照是某個時尖下所建立的整個 Redis 叢集的備份





https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/438692/

https://www.ecloudture.com/aws-elasticache-redis-and-memcache/

https://leicode.com/posts/9e983597/

https://jigsawye.com/2015/12/22/push-notification-to-user-in-laravel-5/