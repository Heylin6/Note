###
### 各語言間GC回收上的差異 ###
###

Java

=================

流程 :

伊甸區E,倖存區S

年輕代Y :

E區 塞滿以後 , E區會先一次GC清除沒再用的
有在用的會放到 S區 

直到 S區 塞滿 S區會GC清除沒再用的
有在用的會放到 E區 

來回 15 次後丟到 老年代O
p.s. 如果 S區 不夠大會直接進到 老年代O

這時的 GC 稱為 Minor GC

老年代O :

從 年輕代Y 丟來的東西 等到塞滿後也會產生GC

這時的 GC 稱為 Major GC(或是 FullGC)


[速度上]

Minor GC = 10 倍 Major GC

=================

回收方式

舊方法 => 計數器

有一個引用，即增加一個計數，刪除一個引用則減少一個計數。
垃圾回收時，只用收集計數為0的對象。

(but 如果 A跟B 相互引用 這樣就無法回收)

=================


JVM 有三種方式

串行搜集器（serial collector）：
一條GC線程，
運行時需要暫停用戶程序（stop the world），
只適用於小數據量，
JDK5.0以前都是使用這。

並行搜集器（parallel collector）：
多條GC線程，
運行時需要暫停用戶程序（stop the world），


並發搜集器（concurrent collector）：
有一條或多條GC線程，
部分階段暫停用戶程序（stop the world），
部分階段與用戶程序並發執行。


串行搜集器的實現：
serial（用於新生代，採用複製算法）
serial old（用於年老代，採用標記/整理算法）

並行搜集器的實現：
ParNew（用於新生代，採用複製算法）
Parallel Scavenge（用於新生代，採用複製算法）
Parallel old（用於年老代，採用標記/整理算法）
 
並發搜集器的實現：
concurrent mark sweep[CMS]（用於年老代，採用標記/清除算法）

=================

#### 參考頁面 ####

java

https://kknews.cc/code/q4eeq3y.html
https://kknews.cc/news/kvlygoq.html
https://kknews.cc/code/zbjbjvl.html
https://kknews.cc/code/mo28om9.html
https://kknews.cc/zh-tw/code/63qmkxm.html