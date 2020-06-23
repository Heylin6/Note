给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

(0) 字串長度max
(1) 字串長度小於2不列入
(2) 切成array
(3) 列出各種情景(0,1)(0,2)...(max-1,max)
(4) 其中一情景(a,b)符合 
(6) 就開始(a+1,b-1) 繼續比 相同就(a+2,b-2) 依此繼續
(7) 比到 a加到開始大於b為止
(8) 假設一路符合到跳出 
(9) 則字串的第a到第b個值就是答案

==============================

### 暴力法 ###

public class Solution {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
        char[] charArray = s.toCharArray();

        // 枚举所有长度大于 1 的子串 charArray[i..j]
        // 假設 s = abcdedcbe
        // 就是比對 ab ac ad ... cb ce

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {

                    // 用substring返回
                    // 所以 結束位置 扣掉 開始位置 再加1

                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 验证子串 s[left..right] 是否为回文串
     */
    private boolean validPalindromic(char[] charArray, int left, int right) {

        // 假設進來 i=0,j=8 => 左0右8 
        // 得知 s[0] = a,s[8] =a
        // 左0右8 -> 都為 a 繼續推 s[1],s[7] ....
        // 直到左3右4跳出都相等 => 返回true

        // 假設進來 i=1,j=5 => 左1右5
        // 得知 s[1] = b,s[5] =d => 不同 返false跳出
        
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

### 时间复杂度：O(N^3)  N : 字串長,字串左邊界,字串右邊界

=======================================

### 動態規劃

    public String longestPalindrome(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {

            //单个字符一定是回文串，
            //因此把对角线先初始化为 true，
            //即 dp[i][i] = true 。
            dp[i][i] = true;
        }


        //從(0,1)(0,2)(1,2)(0,3)(1,3)(2,3)
        //開始跑下去
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    
                    //若相等
                    //(3,1)(2,0) 
                    //相減小於3 => 只隔一個間隔
                    //必定回文
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {

                        // 若相等
                        // (4,1)(3,0) 
                        // 相減大於等於3 => 相隔至少兩間隔以上
                        // 此時dp[1][4] = db[2][3] 的值
                        // 判斷內層是否一樣
                        // 推倒當下位置是否回文
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，
                // 就表示子串 s[i..j] 是回文，
                // 此时记录回文长度maxLen 和 起始位置begin
                // 如果原先有值就再度更新maxLen,begin
                if (dp[i][j] && j - i + 1 > maxLen) {
                    
                    //末位扣掉初始位置+1 = 長度
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

=== 首重紀錄 ij 位置先不要抓字串
=== 因為抓字串還是要額外耗能的

### 时间复杂度：O(N^2) for迴圈裡有for 
### 空间复杂度：O(N^2) dp二維陣列

=======================================

### 中心擴散

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        
        int maxLen = 1;
        
        //初始化
        String res = s.substring(0, 1);
        
        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < len - 1; i++) {
            
            //字符串為單數
            String oddStr = centerSpread(s, i, i);
            //字符串為雙數
            String evenStr = centerSpread(s, i, i + 1);

            //抓完的字串誰長就用誰
            String maxLenStr = 
                oddStr.length() > evenStr.length() ? 
                                        oddStr : evenStr;

            //假設大於初始值
            //更新長度 maxLen
            //更新解答字符串
            if (maxLenStr.length() > maxLen) {
                
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }

        return res;
    }

    private String centerSpread(String s, int left, int right) {

        // left = right 的时候，
        //此时回文中心是一个字符，回文串的长度是奇数
        
        // right = left + 1 的时候，
        //此时回文中心是一个空隙，回文串长度是偶数

        int len = s.length();
        int i = left;
        int j = right;

        //比對相同時逐漸縮小內距
        //左邊減少右邊增加逐漸從中間點擴散
        //過程只要不相等就跳出
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }

        // 这里要小心，跳出 while 循环时，
        // 恰好满足 s.charAt(i) != s.charAt(j)，
        // 因此不能取 i，不能取 j
        // 要抓 i的上一動 因為i-- => 抓i+1
        // 要抓 j的上一動 因為j++ => 抓j-1

        return s.substring(i + 1, j - 1);
    }

### 时间复杂度：O(N^2) for迴圈裡 while 迴圈
### 枚举“中心位置”时间复杂度为 O(N)，
### 从“中心位置”扩散    得到“回文子串”的时间复杂度为 O(N)，
### 因此时间复杂度 可以降到 O(N^2)

### 空间复杂度：O(1)，只使用到常数个临时变量，与字符串长度无关

=======================================

### Manacher 算法

(1) 在字串間隔塞入一字元
(2) 確保塞完的字串必為單數
(3) 減少當下位置 向左向右比對
(4) 直接抓每一字元當下對應回文數
(5) 最後取最大

 public String longestPalindrome(String s) {

        int len = s.length();
        if (len < 2) {
            return s;
        }

        //塞入新字元成為新字串
        String str = addBoundaries(s, '#');
        //新字串長度
        int sLen = 2 * len + 1;
        
        int maxLen = 1;
        int start = 0;
        
        //新字串用start迴圈一遍
        for (int i = 0; i < sLen; i++) {
            
            int curLen = centerSpread(str, i);

            //假設當下長度大於預設長度
            //更新最大長度
            //紀錄開始位置(最大長度-開始位置)折半
            if (curLen > maxLen) {
                
                maxLen = curLen;
                start = (i - maxLen) / 2;
            }
        }
        
        return s.substring(start, start + maxLen);
    }

    private int centerSpread(String s, int center) {
        int len = s.length();
        int i = center - 1;
        int j = center + 1;
        int step = 0;
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            step++;
        }
        return step;
    }


    /**
     * 创建预处理字符串
     *
     * @param s      原始字符串
     * @param divide 分隔字符
     * @return 使用分隔字符处理以后得到的字符串
     */
    private String addBoundaries(String s, char divide) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        
        if (s.indexOf(divide) != -1) {
            
            //避免塞的字符已存在於字串
            //造成判斷錯誤
            throw new IllegalArgumentException("参数错误，您传递的分割字符，在输入字符串中存在！");
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
        
            stringBuilder.append(divide);
            stringBuilder.append(s.charAt(i));
        }
        
        stringBuilder.append(divide);
        
        return stringBuilder.toString();
    }
}

### 參考

https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/