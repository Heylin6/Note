#### 費氏數列

===================

0	1	1	2	3	5	8	13	21	34	55

===================

時間複雜度

迭代法：O(n)

遞迴法：O(2^n)

===================

F(0) = 0
F(1) = 1
F(n) = F(n-1) + F(n-2)

===================

迴圈解法

        public static long Fibonacci(int n)
        {
            //n為第幾個位置的數

            long v1 = 0;
            long v2 = 1;           
            long result = n;

            for (int i = 2; i <= n; ++i)
            {
                // r = 前兩個數相加
                result = v2 + v1;
                // 原先第二個數移到第一個
                v1 = v2;
                // 第二個放入r
                v2 = result;
            }

            return result;
        }

===================

動態迴圈

public class IterativeDynamicProgramming {
    public static long Fibonacci(int n)
    {
        Map<Integer, Long> map = new HashMap<Integer, Long>() {{ put(0, 0L); put(1, 1L); }};
         
        for (int i = 2; i <= n; ++i)
            // 把 第2(i=1) 跟 第1(i=0) 加起來放到 第 3(i=2) 個數
            // 依此類推
            map.put(i, map.get(i - 1) + map.get(i - 2));
        return map.get(n);
    }
}


#### 參考頁面 ####

https://emn178.pixnet.net/blog/post/91987861

https://www.facebook.com/groups/836704183194912/permalink/1015968675268461/