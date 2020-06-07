### 標題名稱 ###



=== DISTINCT ===

防止欄位擷取重複資料

SELECT DISTINCT "欄位名"
FROM "表格名";

ex.

SELECT DISTINCT JobTitle
FROM HumanResources.Employee
ORDER BY JobTitle;

SELECT DISTINCT Store_Name 
FROM Store_Information;

=== case when ===

欄位資料符合判斷的話給予語句相對的值

ex.

SELECT 
Case 
    when col2='1' then '東'
    when col2='2' then '南' 
    when col2='3' then '西' 
    when col2='4' then '北' 
    else '中'
End 
as N'方位' 

from Table

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

假設該欄位存在null 經運行後會轉成括號的 0.00

ex.

SELECT Description, DiscountPct, MinQty, ISNULL(MaxQty, 0.00) AS 'Max Quantity'  
FROM Sales.SpecialOffer;  

=== COALESCE ===

https://docs.microsoft.com/zh-tw/sql/t-sql/language-elements/coalesce-transact-sql?view=sql-server-ver15

=== count ===

=== sum ===

=== max ===

=== min ===

=== avg ===

=== group by ===



=== having ===

使用group by的時候可用上來當where

ex.

SELECT ProductID 
FROM Sales.SalesOrderDetail
GROUP BY ProductID
HAVING AVG(OrderQty) > 5
ORDER BY ProductID;

SELECT SalesOrderID, CarrierTrackingNumber   
FROM Sales.SalesOrderDetail  
GROUP BY SalesOrderID, CarrierTrackingNumber  
HAVING CarrierTrackingNumber LIKE '4BD%'  
ORDER BY SalesOrderID ; 

https://www.1keydata.com/tw/sql/sqlhaving.html

=== union ===

處理聯集
組合兩個同欄位的表合一查看

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
https://docs.microsoft.com/zh-tw/sql/t-sql/queries/select-examples-transact-sql?view=sql-server-ver15