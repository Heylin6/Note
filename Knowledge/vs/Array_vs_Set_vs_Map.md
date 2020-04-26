###  Array Set Map ###
###
###

|   | 隸屬於 | 可重複值 | 可null | 順序 | 常見的 | 使用時機 |
| --- | --- | --- | --- | --- | --- | --- |
| List  | Collection  | O | 可多個 | 有 | ArrayList(查找)<br/>LinkedList(增刪) | 知道index時<br/>查詢 -> ArrayList<br/>增刪 -> LinkedList |
| Set  | Collection  | X | 只可一個 | 無 | HashSet(查找)<br/>TreeSet(保存次序) | 確認值不重複時<br/>快找 -> HashSet<br/>次序 -> TreeSet |
| Map  | Map  | Key只能一個<br/>Value隨意 | Key只能一個<br/>Value幾個隨意 | | HashMap<br/>TreeMap<br/>HashTable | 需以KeyValue方式處存時<br/>快找 -> HashMap<br/>次序 -> TreeMap |

==================================

List

1. 繼承 collection 的介面
2. 重複值(O)
3. 可重複null
4. 有順序


Set

1. 繼承 collection 的介面
2. 重複值(X)
3. 只能有一個null
4. 沒有順序
5. 查找速度快

Map

1. 不是 繼承 collection 的介面
2. Key重複值(O),Value重複值(X)
3. Key只能有1個null,Value幾個null都沒關係


*** Array & ArrayList ***

1. Array 大小需固定 , ArrayList 可以動態
2. ArrayList 可以使用較多 method

ArrayList、LinkedList、Hashtable、HashMap、ConcurrentHashMap、HashSet 實現原理待補

#### 參考頁面 ####

https://www.itread01.com/p/866063.html
https://jax-work-archive.blogspot.com/2015/02/java-setlistmap.html
https://www.itread01.com/content/1517808043.html