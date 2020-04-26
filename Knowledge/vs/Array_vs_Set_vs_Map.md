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

Set

1. 繼承 collection 的介面

Map

1. 不是 繼承 collection 的介面

*** Array & ArrayList ***

1. Array 大小需固定 , ArrayList 可以動態
2. ArrayList 可以使用較多 method

ArrayList、LinkedList、Hashtable、HashMap、ConcurrentHashMap、HashSet 實現原理

#### 參考頁面 ####

https://www.itread01.com/p/866063.html