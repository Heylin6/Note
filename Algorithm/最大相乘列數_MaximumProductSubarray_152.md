### 最大相乘列數 ###

===========

建立一個函式: 當一個int[], 包含 正數,負數, 以及0

求陣列內連續乘積最大值

EX: [-7, 3, 0, 2, 5, 4, -6]  ,則 Max值 2 * 5 * 4 為 40

===========

解題架構

1. 建立最大值imax 最小值imin (初始值1) ANS
2. 跑 for 迴圈 
2-1. imax* 第index個數 跟 第index個數 比 最大值
2-2. imin* 第index個數 跟 第index個數 比 最小值
3. 注意 如果是 負數相乘 最大數會變最小 最小數會變最大(反轉)
4. 比完後imax 跟 ANS 比最大 放入 ANS

===========

最佳解 O(n)

public int maxProduct(int[] nums) {

        int ANS = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] >= 0){

                imax = Math.max(imax*nums[i], nums[i]);
                imin = Math.min(imin*nums[i], nums[i]);
            }
            else{

                // 小於0時最大最小反轉
                int temp = imax;

                imax = Math.max(imin*nums[i], nums[i]);
                imin = Math.min(tmp*nums[i], nums[i]);
            }

            ANS = Math.max(max, imax);
        }
        return ANS;
}

===========

#### 參考頁面 ####

https://ithelp.ithome.com.tw/articles/10160439
