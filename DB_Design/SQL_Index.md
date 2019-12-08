### SQL Index (SQL 索引) ###

1. 用上索引搜尋速度會加快
2. create index 索引名稱 on 資料表名(欄位名稱)
3. 一個表只能有一個索引
4. 
原理

    假設一資料表有 5000萬 筆
    select * from table where total=50
    最壞情況要匹配 5000萬 次才找的到結果(從主鍵id開始做搜尋)
    如果今天將 total 作為索引
    改變結構後 total 依數字放入個別的區塊
    今日再下 select * from table where total=50 後
    系統就會先從該數字所屬的區塊作搜尋

    b tree (balence tree)

5. 查找快 但寫入就會慢
6. 因為設定索引後資料處理的結構

balence tree 原理
https://kknews.cc/code/xje3rlq.html

https://ingramchen.io/blog/2007/06/2007-06-08-2.html