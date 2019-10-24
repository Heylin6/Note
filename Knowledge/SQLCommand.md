
### SQLCommand ###

## isnull

假設該欄位存在null 經運行後會轉成括號的 0.00

ex.

SELECT Description, DiscountPct, MinQty, ISNULL(MaxQty, 0.00) AS 'Max Quantity'  
FROM Sales.SpecialOffer;  

## case when

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

## Distinct

防止欄位擷取重複資料

ex.

SELECT DISTINCT JobTitle
FROM HumanResources.Employee
ORDER BY JobTitle;

## having

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

## UNION

組合兩個同欄位的表合一查看

#### 參考頁面 ####

https://docs.microsoft.com/zh-tw/sql/t-sql/queries/select-examples-transact-sql?view=sql-server-ver15