package 常见链表算法;

public class 链表翻转 {
    public ListNode ReverseList(ListNode head) {
        ListNode h=null;
        ListNode cur=head;
        ListNode pre=head;
        while (pre != null){
            pre=cur.next;
            cur.next = h;
            h=cur;
            cur = pre;
        }

        return h;


    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
