### 字典樹 ###

===========

應用

Trie(前綴樹)
GOOGLE搜尋時自動補字 
ip匹配
手機打字選字

===========

題目

208. Implement Trie (Prefix Tree)
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.

===========

概念版

//建立類別
class TrieNode {
    boolean isWord;
    TrieNode[] children;
    public TrieNode(){

        //字尾
        end = false;

        //A到Z 26個字母
        children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;
        
    /** Init **/
    public Trie() {
        root = new TrieNode();
    }
    
    
    public void insert(String word) {

        TrieNode current = root;
 
        //假設 word 為 'app'
        for(int i=0, l=word.length(); i<l; i++){           

            // char - 'a' => ASCII 中 從 A 的位置開始
            // ASCII的 Z 為122 ASCII的 A 為97

            // 跑第0個 => word.charAt(0) - 'a';
            // 假設第一個字是A => A的位址 - A的位址 = 0             
            // id =0
            // current.children[0] => 樹狀類別 a 
            int id = word.charAt(i) - 'a';

            //在node樹狀中沒有相關資料 => 樹狀新增
            if(current.children[id] == null){
                current.children[id] = new TrieNode();
                current.children[id].isWord = false;
            }

            //剛new完的樹狀放上去
            //或在node中有相關樹狀 => 樹狀抽出來
            current = current.children[id];
        }

        //跑到p完的時候跳出 => isWord 轉true => 字尾
        current.isWord = true;

        //此時得到p結尾的子節點
    }
    
    //完整搜尋
    public boolean search(String word) {
        return search(word,1);
    }
    
    //前綴搜尋
    public boolean startsWith(String prefix) {
        return search(prefix,2);
    }

    private boolean search(String word, int type){

        TrieNode current = root;

        //拆解每一個字 => 只要其中沒有紀錄就是 false
        for(int i=0,l=word.length(); i<l;i++){

            //抓出 ASCII 當下的字
            int id = word.charAt(i) - 'a';

            //在node的樹狀中沒有相關資料 找不到 => false
            if(current.children[id] == null){
                return false;
            }

            //有的話抓出那樹狀
            current = current.children[id];
        }

        //會跑到這邊基本上就是有找到
        //此時跑完的 current 一定是最後一個字母
        //例如 'app' => 'p'
        //這時看是否為完整(true=1) 或 前綴(true=2)
        //完整的話要看先前紀錄的 current.isWord 是否為字尾
        return type == 1 ? current.isWord : true;
    }
}
===========

#### 參考頁面 ####

https://medium.com/@desolution/%E5%BE%9Eleetcode%E5%AD%B8%E6%BC%94%E7%AE%97%E6%B3%95-73-trie-2-827573a72653

https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/shi-xian-trie-qian-zhui-shu-by-leetcode/

https://angledark0123.pixnet.net/blog/post/66071415

補充 :Char - 'a' ,Char - '0'是什么意思

https://www.jianshu.com/p/84e2b8d06f19