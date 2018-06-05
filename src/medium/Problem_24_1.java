package medium;

import entity.ListNode;

public class Problem_24_1 {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode node = newHead;
        ListNode n1, n2;
        while(head != null) {
            n1 = new ListNode(head.val);
            if (head.next != null) {
                head = head.next;
                n2 = new ListNode(head.val);
                node.next = n2;
                node = node.next;
            }
            node.next = n1;
            node = node.next;
            head = head.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode nodes = new Problem_24_1().swapPairs(node1);
        while(nodes != null) {
            System.out.println(nodes.val);
            nodes = nodes.next;
        }
    }
}
