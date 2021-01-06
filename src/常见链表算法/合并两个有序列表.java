package 常见链表算法;

public class 合并两个有序列表 {
    public static void main(String[] args) {

    }

    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode head = new ListNode();
        ListNode tail = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail=tail.next;
        }

        tail.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public class ListNode {
        int val;

        ListNode next = null;
    }

}
