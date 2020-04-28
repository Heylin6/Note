### Statement v.s. PreparedStatement ###

用在 DB 處理

*** Statement ***

1. 適合一次性存取

*** PreparedStatement ***

1. 預編譯 => 會先 初始化 在 DB 中 預處理
2. 適合批量處理 => 多次使用同一 SQL 語句
3. 又稱 JDBC 存儲過程
4. 開銷比 Statement 大 => 一次性使用並不會比較好
5. 可預防 SQL injection	

* but ! 

在 Oracle DB 會緩存 SQL 語句 
=> 使用 PreparedStatement 的話會花更多時間

#### 參考頁面 ####

https://sites.google.com/site/rainbaby59/java-bi-ji/xx_database_01/03_preparedstatement-he-statement-ju-ti-de-cha-yi

https://xken831.pixnet.net/blog/post/460524932-%5Bjava2sqlite%5D-preparedstatement-%E8%88%87-statement-%E7%9A%84%E5%B7%AE%E7%95%B0