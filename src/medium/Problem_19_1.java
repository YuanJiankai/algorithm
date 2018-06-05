package medium;

import entity.ListNode;

/**
 * Remove Nth Node From End of List
 * 16ms
 */
public class Problem_19_1 {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if(head.next == null) {
//            return null;
//        }
//        List<ListNode> list = new ArrayList<>();
//        while(head != null) {
//            list.add(head);
//            head = head.next;
//        }
//        int size = list.size();
//        int x = size - n;
//        if(x == 0) {
//            return list.get(1);
//        } else {
//            list.get(x - 1).next = list.get(x).next;
//            return list.get(0);
//        }
//    }
    public ListNode removeNthFromEnd(ListNode head, int n) { // 没什么用 这个还是16ms
        int len = 0;
        ListNode node = head;
        while(node != null) {
            len++;
            node = node.next;
        }
        int step = len - n;
        ListNode head2 = new ListNode(0);
        head2.next = head;
        node = head2;
        while(step-- > 0) {
            node = node.next;
        }
        node.next = node.next.next;
        return head2.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        System.out.println(new Problem_19_1().removeNthFromEnd(node1, 1).val);
    }
}

