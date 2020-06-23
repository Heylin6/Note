#### 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

#### 示例 1:
#### 输入: "abcabcbb"
#### 输出: 3 
#### 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

#### 示例 2:
#### 输入: "bbbbb"
#### 输出: 1
#### 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
#### 示例 3:

#### 输入: "pwwkew"
#### 输出: 3
#### 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
####     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

class Solution {
    public int lengthOfLongestSubstring(String s) {

        //字串長度
        int n = s.length(), 
        //ans初始值0
        ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            
            //取出當下位置的字元
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                //假設原本存放的map有這字元
                //抓出map存的值 跟當下位置比對
                //更新開始位置
                start = Math.max(map.get(alpha), start);
            }
            
            //每跑完後比對一次(見解析)
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }


            //假設 pwwkew
            //p (0 ,0 - 0 + 1) => 1 ,map.put(p, 0 + 1); =>(p, 1) start =0
            //w (1 ,1 - 0 + 1) => 2 ,map.put(w, 1 + 1); =>(w, 2) start =0
            //w (2 ,2 - 2 + 1) => 2 ,map.put(w, 2 + 1); =>(w ,3) start =2
            //k (2 ,3 - 2 + 1) => 2 ,map.put(k, 3 + 1); =>(k ,4) start =2
            //e (2 ,4 - 2 + 1) => 3 ,map.put(e, 4 + 1); =>(e ,5) start =2
            //w (3 ,5 - 3 + 1) => 3 ,map.put(w, 2 + 1); =>(w ,6) start =3
}

#### 參考頁面 ####

https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/