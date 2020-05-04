### 字典搜尋/新增 ###

===========

題目

211. Add and Search Word - Data structure design
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word 
or a regular expression string containing only letters a-z or .. A . 
means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:

You may assume that all words are consist of lowercase letters a-z.

===========

Map 裡面 有各種字數的 ArrayList

解題架構

新增
=> input文字 
=> 檢查文字字數(Length)
=> 該文字字數的List 有無存在在 Map 中 
=> 新增 該文字字數的List or 存進該字數的List

搜尋
=> input文字
=> Map是否為空()
=> 文字是否為空()
=> 預設output值為 false
=> 查詢 該文字字數的 List 有無存在在 Map 中 
=> 有的話 get 抽出 該文字字數的 List
=> 第一迴圈 RUN List 中每一個單字
=> 假設找到了 => output 為 true => break
=> 第二回圈 RUN 單字 每一個字母
=> 第二回圈判斷如下

|  | 查詢字母 == 抽出字母 | 查詢字母 != 抽出字母 | 
| --- | --- | --- |
| 是'.' | X | true |
| 不是'.' | true | false |

=> 第二回圈跑完後 跑下一個單字 or 跑完跳出

    => 跑下一個單字     
        => 如果是true 則跳出回傳結果
        => 如果是false 則繼續
    
    => 跑完跳出
        => 回傳結果

===========

class WordDictionary {

    HashMap<Integer,List<String>> hmap = 
                    new HashMap<Integer,List<String>>();

    /** 串列新增文字 */
    public void addWord(String word) {

        //假設字串不為空
        if(word != null && word.length() > 0) {

            //該文字字數的List 有無存在在 Map 中 
            if(!hmap.containsKey(word.length())){

                //建一個 ArrayList 放 Map
                ArrayList<String> list = new ArrayList<String>();
                list.add(word);
                hmap.put(word.length(), list);
            } else {
                hmap.get(word.length()).add(word);
            }
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {

        if(hmap.isEmpty())
            return false;
        if(word == null || word.length() == 0)
            return false;
        boolean found = false;
        if(hmap.containsKey(word.length())) {
            List<String> list = hmap.get(word.length()); 
            for(int lindex=0; lindex<list.size(); lindex++) {

                //抓出 list 中每一個單字
                String s = list.get(lindex);
                if(found == true)
                    break;

                //抓出 單字 中每一個 字母
                for(int index=0; index<s.length(); index++){

                    //查詢字第index個字母 如果不是 抽出單字第index個字母
                    //而且不是'.' => false
                    if(word.charAt(index) != s.charAt(index) && word.charAt(index) != '.'){
                        found = false;
                        break;
                    } else
                        found = true;
                }
            }
        }
        return found;
    }
}

#### 參考頁面 ####

https://angledark0123.pixnet.net/blog/post/66071415