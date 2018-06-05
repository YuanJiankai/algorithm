package hard;

import entity.ListNode;

/**
 * 用数组来存储反转的元素 比用Stack 应该快那么一点. 整体速度不算快 30.57%
 */
public class Problem_25_1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        ListNode head2 = head;
        ListNode h = new ListNode(0); // 新链表的头结点
        ListNode n = h; // 对于新链表的一个节点引用 一直指向最后一个节点
        int len = 0;
        ListNode[] nodes = new ListNode[k]; // 声明一个数组存储反转的节点
        int index = 0;
        while(head2 != null) { // 把所有的节点遍历一遍
            len++; // 存储一下总链表长度 用于判断边界情况
            nodes[index++] = new ListNode(head2.val);
            if(index == k) { // 如果已经到k这个节点
                while(index > 0) { // 从数组中取节点 然后穿串
                    n.next = nodes[--index];
                    n = n.next;
                }
                index = 0; // 下表归零
            }
            head2 = head2.next;
        }
        if(len < k) { // 这一步用来判断边界情况
             return head;
        } else { // 如果没问题 就正常判断是不是还有剩下的没连起来的, 就把它顺序的连起来
            int i = 0;
            while(index-- > 0) {
                n.next = nodes[i++];
                n = n.next;
            }
        }
        return h.next;
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
        ListNode nodes = new Problem_25_1().reverseKGroup(n1, 4);
        while(nodes != null) {
            System.out.println(nodes.val);
            nodes = nodes.next;
        }
    }
}
