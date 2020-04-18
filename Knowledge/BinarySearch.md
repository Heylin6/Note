###
### Csharp 跟其他語言 BinarySearch 上的差異 ###
###

註 : 任何語言 在用 BinarySearch 之前一定要排序(Sort)

============================

java & C#

進行 BinarySearch 時

ex.{a,b,c,e,f}

如果找的到
起始值從 0 開始

此時找e => 3

[ a,b,c,e,f ]
[ 0,1,2,3,4 ]

如果找不到
起始值從 -1 開始
並把查找的字串塞入list中

此時找d => -4

[  a,  b,  c, {d},  e,  f]
[ -1, -2, -3,  -4, -5, -6]

============================

#### 參考頁面 ####

https://www.cnblogs.com/hans_gis/archive/2011/07/31/2123257.html

https://www.javaworld.com.tw/jute/post/view?bid=29&id=271398

