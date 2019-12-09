#### 一個背包內放出最大價值的物品

    const int N ;   // 物品總數上限
    const int W ;   // 背包耐重上限

    int cost[N], weight[N]; // 物品的價值與重量
    int c[N + 1][W + 1];    // DP表格

    // 回傳最大價值
    // n 物品個數
    // m 負重量
    public static int knapsack(int n,int w)
    {  
        if(w < 0)
        {
            //超過背包負重
            return -1
        }

        if(n == 0)
        {
            //沒東西
            return 0
        }

        //假設取到陣列尾端
        //這是最大值
        if(c[n][w])
        {
            return c[n][w]
        }


        // 遞迴比較取出最大
        //  knapsack(n-1,w-weight[n]) : 東西再減少一個(放入背包)後的背包價值(因為放進去了所以加上cost)
        //  knapsack(n,w) : 當下狀態的價值
        return c[n][w] = 
        max(
            knapsack(n-1,w-weight[n])+ cost[n],
            knapsack(n,w)
        )

    }








#### 參考頁面 ####

http://www.csie.ntnu.edu.tw/~u91029/KnapsackProblem.html