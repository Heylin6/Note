#### 羅馬數字 轉 數字

    public int romanToInt(String s) {

        //先行記下特殊的代表字 與對應的值

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        
        //初始化回傳值
        int ans = 0;
        
        for(int i = 0;i < s.length();) {

       
            if(i + 1 < s.length() && map.containsKey(s.substring(i, i+2))) {

                //開始檢查 第1第2 第2第3 第3第4 依此類推
                //前提是確定有兩位數 => i = 0 => length > 1
                //假設抓的兩個數有符合map雙符號(IV,IX...)的紀錄 => 直接加進回傳值
                //並且 計數器 直跳兩位 (ex. i = 0 變 i = 2) 
                ans += map.get(s.substring(i, i+2));
                i += 2;

            } else {
                
                //都不是的話改抓單符號(I,V,X...)對應的值加進回傳值
                //此時 計數器 只抓一個符號 所以跳一位即可
                ans += map.get(s.substring(i, i+1));
                i ++;
            }
        }
        return ans;
    }

#### 參考頁面 ####

https://leetcode-cn.com/problems/roman-to-integer/solution/hua-jie-suan-fa-13-luo-ma-shu-zi-zhuan-zheng-shu-b/
