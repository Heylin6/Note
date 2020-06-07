#### 给出两个 非空 的链表用来表示两个非负的整数。
#### 其中，它们各自的位数是按照 逆序 的方式存储的，
#### 并且它们的每个节点只能存储 一位 数字。
#### 如果，我们将这两个数相加起来，
#### 则会返回一个新的链表来表示它们的和。
#### 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

#### 输入：
#### (2 -> 4 -> 3) + 
#### (5 -> 6 -> 4)
#### 输出：7 -> 0 -> 8
#### 原因：342 + 465 = 807


#### 将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 00，比如 987 + 23 = 987 + 023 = 1010
#### 每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //先建立預設節點
        ListNode pre = new ListNode(0);

        ListNode cur = pre;
        int carry = 0;

        // 當 l1 l2 當下有一節點不為 null
        // while 就繼續跑下去 
        while(l1 != null || l2 != null) {

            //判斷該節點 有沒有值
            //萬一為
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            // x 跟 y 之外 還要同時加上進位值
            int sum = x + y + carry;
            
            //紀錄進位值
            carry = sum / 10;
            //存入節點的值
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;

            // l1 l2 用 next 移到下一個位子

            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {

            //假設跑到 l1 l2 都 null了
            //相加還大於10 -> carry為 1
            //cur 再用 next 新增一節點

            cur.next = new ListNode(carry);
        }

        //因為傳址關係 cur 等同 pre
        //此時用 pre.next 移除當初設置的預設節點
        return pre.next;
    }
}

#### 參考頁面 ####

https://leetcode-cn.com/problems/add-two-numbers/solution/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/
