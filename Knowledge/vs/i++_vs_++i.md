###
###  i++ vs ++i ###
###

int main(){

    int A = 2;
    int B = 2;
    // 先把 A 放到 C 再加 1
    int C = A++; 
    // 先執行 B = B+1
    int D = ++B; 


return 0;
}

A++：
意思是先把A放到C，再執行A=A+1 的動作。
因為A先放到C，所以C的值會是2

++B：意思是先再執行B=B+1，再把B放到D。
因為B會先執行B=B+1的動作，所以D的值會是3

#### 參考頁面 ####

https://ithelp.ithome.com.tw/m/articles/10192800