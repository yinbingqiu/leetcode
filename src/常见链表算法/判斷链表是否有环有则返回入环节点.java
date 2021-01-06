package 常见链表算法;

public class 判斷链表是否有环有则返回入环节点 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

            if(fast==slow){                 //利用快慢指针找相遇点
                ListNode slow2=head;    //设置以相同速度的新指针从起始位置出发
                while(slow2!=slow){      //未相遇循环。
                    slow=slow.next;
                    slow2=slow2.next;
                }
                return slow;
            }
        }
        return null;

    }

    class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
