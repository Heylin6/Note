### hoisting ###

    concole.log(a)

會回傳 a is not defined

    concole.log(a)
    var a

會回傳 undefined

因為某些原因變數宣告被移置最上層

*只有宣告會 給值到變數不會上升

    concole.log(a) 
    var a=5

    var a
    concole.log(a)
    var=5

這兩個都會是 undefined


#### 參考頁面 ####

https://blog.techbridge.cc/2018/11/10/javascript-hoisting/