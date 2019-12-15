### StaticNestdeClass v.s. InnerClass ###

*** Static Nested class(靜態巢狀類別) ***

1. 在 class 內有 static class
2. 非 static 的 nested class，會有一個 Reference 指向外層的物件
3. 內部類別加上static後就可以直接拜訪到
4. 不需先實體化 外部類別 , 就能實體化 該類別
5. 就好像把該類別拉到最上層的層級一樣

*** Inner class(內部類別) ***

1. 有個Class包在另一個Class裡面

    class ExampleClass{
        //field area
        //全域
        void method(){
            //local area
            //區域
        }
    }

2. 當某個 副類別 完全只服務一個 主類別 時 , 即為 內部類別

3. 包裡面的 class 如果要設變數 必須要加 final

#### 參考頁面 ####

https://rx1226.pixnet.net/blog/post/342302130

https://yaya741228.pixnet.net/blog/post/73916447-innerclass-%E7%9A%84%E8%A7%A3%E6%9E%90