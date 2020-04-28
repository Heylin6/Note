### ArratyList vs Linkedlist ###


|   | 結構 | 來自 | 查找方式 | 查詢速度 | 增刪速度 |
| --- | --- | --- | --- | --- | --- |
| ArratyList  | 陣列 | List | 透過索引 | 快 | 慢<br/>刪除某位置後<br/>該值後面的index皆須重新賦予<br/> |
| Linkedlist  | 串列 | List | 節點查找 | 慢 | 快<br/>只需處理前一個節點 |


============================

1. ArratyList Linkedlist 皆來自 List

2. ArratyList -> array 結構
   Linkedlist -> 串列 結構

3. ArratyList -> 
    
    1. 透過索引查找 搜尋速度較快
    2. 新增刪除後需要更動位置以後的節點
       還要重新上索引值 

    適合持續 讀取 list 的情境
   
   Linkedlist -> 
    
    1. 透過節點查找 搜尋速度較慢
    2. 新增刪除只需處理前一個節點

    適合持續 新增or刪除 list 的情境


#### 參考頁面 ####

https://pclevinblog.pixnet.net/blog/post/314563429-%5Bjava%5Darraylist%E8%88%87linkedlist%E7%9A%84%E6%AF%94%E8%BC%83
https://www.itread01.com/articles/1478538637.html

