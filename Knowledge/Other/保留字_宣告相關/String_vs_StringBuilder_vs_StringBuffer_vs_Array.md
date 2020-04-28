### String v.s. StringBuilder v.s. StringBuffer v.s. Array ###

|   | 資料量 | 線程 |
| --- | --- | --- |
| String  | 小 | 單線程 |
| StringBuilder  | 大 | 單線程 |
| StringBuffer  | 大 | 多線程 |

============================

*** String v.s. StringBuilder v.s. StringBuffer ***

小量資料 用 String

單線程   用 StringBuilder

多線程   用 StringBuffer

*** String v.s. Array ***

1. length

陣列 只有 length 的屬性
String 有 length() 的方法

#### 參考頁面 ####