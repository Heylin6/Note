###
### table前宣告dbo有甚麼效能上的差異 ###
###

*預設(使用者)的結構描述

1. 全名 dbowner 使用者帳戶 (也稱為資料庫擁有者) 

2. dbo也是架構的名稱，如 SQL Server 中的擁有權和使用者架構分離中所述。

3. dbo 結構描述是新建立資料庫的預設結構描述。 
   dbo 結構描述是由 dbo 使用者帳戶所擁有。 
   依預設，使用 CREATE USER Transact-SQL 命令所建立的使用者
   都會將 dbo 當做預設的結構描述。
   被指派 dbo 結構描述的使用者並不會繼承 dbo 使用者帳戶的權限。 
   使用者不會從結構描述繼承權限；結構描述權限是由結構描述中包含的資料庫物件所繼承。

4. 當資料庫物件是使用一段式名稱來參考時，
   SQL Server 會先查看使用者的預設結構描述。 如果在該處找不到物件，SQL Server 接著會在 dbo 結構描述中尋找。 
   如果在 dbo 結構描述中也找不到物件，就會傳回錯誤。

5. DBO是每個數據庫的默認用戶，具有所有者權限
   通過用DBO作爲所有者來定義對象，能夠使數據庫中的任何用戶引用而不必提供所有者名稱。
   比如：你以User1登錄進去並建表Table，而未指定DBO，
   當用戶User2登進去想訪問Table時就得知道這個Table是你User1建立的，要寫上User1.Table，如果他不知道是你建的，則訪問會有問題。
   如果你建表時把所有者指給了Dbo，則別的用戶進來時寫上Dbo.Table就行了，不必知道User1。
   不光表是如此，視圖等等數據庫對象建立時也要如此纔算是好。

6. 結構描述的用途類似資料夾, 可以用來將物件分門別類；

#### 參考頁面 ####

https://docs.microsoft.com/zh-tw/dotnet/framework/data/adonet/sql/ownership-and-user-schema-separation-in-sql-server

https://docs.microsoft.com/zh-tw/dotnet/framework/data/adonet/sql/server-and-database-roles-in-sql-server

https://www.twblogs.net/a/5c9ded9dbd9eee75238867e1

https://blog.miniasp.com/post/2008/09/21/SQL-Server-User-should-set-the-right-Default-Schema