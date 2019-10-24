
### SQL Injection ###

## ex. 在登入頁面的帳號密碼下手

 SELECT * FROM users  
 WHERE (name = '" + 'aaa' + "') and (pw = '"+ 'bbb' +"');"

 當帳號欄位輸入 (1' OR '1'='1) , 密碼 (1' OR '1'='1)

 變成

 SELECT * FROM users 
 WHERE (name = '1' OR '1'='1') and (pw = '1' OR '1'='1')

 等同於

 SELECT * FROM users

### 避免方式
## === SQL ===

## .net

用 SqlDataSource 或者 LINQ to SQL

string sql = “SELECT * FROM Customers WHERE CId” = @CId”;

SqlCommand cmd = new SqlCommand(sql);
cmd.Parameters.Add(new SqlParameter(“@CId”, System.Data.SqlDbType.Int));
cmd.Parameters[“@CId”].Value = 1;

## Java

使用 PreparedStatement

PreparedStatement ps = conn.prepareStatement(“UPDATE MEMBERS SET NAME = ? WHERE ID = ?”);
ps.setString(1, _Name);
ps.setInt(2, _Id);

## PHP



## 其他

用正則表示式過濾字串



#### 參考頁面 ####

https://zh.wikipedia.org/wiki/SQL%E6%B3%A8%E5%85%A5
https://newaurora.pixnet.net/blog/post/166231341-sql-injection-%E7%AF%84%E4%BE%8B(%E7%99%BB%E5%85%A5%E7%AF%84%E4%BE%8B)
https://www.qa-knowhow.com/?p=4127
https://docs.microsoft.com/zh-tw/sql/relational-databases/security/sql-injection?view=sql-server-ver15
https://www.qa-knowhow.com/?p=3186