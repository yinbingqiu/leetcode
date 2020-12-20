package 链表常见算法;

public class 判断链表中是否有环 {

    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;

        while (fast!=null ){

            if (fast.next ==null|| fast.next.next == null){
                return false;
            }

            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                return true;
            }
        }
        return false;
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
