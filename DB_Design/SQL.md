### 標題名稱 ###

=== group by ===

=== DISTINCT ===

SELECT DISTINCT "欄位名"
FROM "表格名";

SELECT DISTINCT Store_Name 
FROM Store_Information;

=== case when ===

SELECT 
Store_Name, 

CASE Store_Name
  WHEN 'Los Angeles' THEN Sales * 2
  WHEN 'San Diego' THEN Sales * 1.5
  ELSE Sales
END
"New Sales",

Txn_Date
FROM Store_Information;

=== isNull ===

=== count ===

=== sum ===

=== max ===

=== min ===

=== avg ===

=== having ===

https://www.1keydata.com/tw/sql/sqlhaving.html

=== union ===

處理聯集

SELECT Txn_Date FROM Store_Information
UNION
SELECT Txn_Date FROM Internet_Sales;

=== INTERSECT ===

跟union很像 處理交集

SELECT Txn_Date FROM Store_Information
INTERSECT
SELECT Txn_Date FROM Internet_Sales;






=== CREATE INDEX ===

CREATE INDEX IDX_CUSTOMER_LAST_NAME
ON Customer (Last_Name);

CREATE INDEX IDX_CUSTOMER_LOCATION
ON Customer (City, Country);

=== 子查詢 ===

SELECT 
SUM(Sales) 
FROM 
Store_Information
WHERE 
Store_Name 
IN
(SELECT Store_Name FROM Geography
WHERE Region_Name = 'West');

#### 參考頁面 ####

https://www.1keydata.com/tw/sql/sql.html