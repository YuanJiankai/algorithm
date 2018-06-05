package hard;

import entity.ListNode;

/**
 * 74.84% 也不是很快不过勉强及格了 采用的是递归的方法
 */
public class Problem_25_2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode h = null;
        ListNode n = null;
        ListNode head2 = head;
        int index = 0;
        while (head2 != null) {
            index++;
            ListNode node = new ListNode(head2.val);
            node.next = h;
            h = node;
            if (n == null) {
                n = node;
            }
            head2 = head2.next;
            if (index == k) {
                n.next = reverseKGroup(head2, k); // 核心在这里 如果可以反转 就向后递归
                break;
            }
        }
        if (index < k) {
            return head;
        } else {
            return h;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode nodes = new Problem_25_2().reverseKGroup(n1, 2);
        while (nodes != null) {
            System.out.println(nodes.val);
            nodes = nodes.next;
        }
    }
}
