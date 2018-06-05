package hard;

import entity.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Problem_23_1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        for(int i = 0, len = lists.length; i < len; i++) {
            list.add(lists[i]);
        }
        return mergeList(list).get(0);
    }

    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        while(list1 != null || list2 != null) {
            if(list1 != null && list2 != null) {
                if(list1.val > list2.val) {
                    node.next = list2;
                    list2 = list2.next;
                } else {
                    node.next = list1;
                    list1 = list1.next;
                }
            } else if (list1 != null){
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        return head.next;
    }

    public List<ListNode> mergeList(List<ListNode> list) {
        if(list.size() == 1) {
            return list;
        }
        List<ListNode> newList = new ArrayList<>();
        for(int i = 0, size = list.size(); i < size; i += 2) {
            if(i + 1 > list.size() - 1) {
                newList.add(list.get(i));
                break;
            }
            ListNode newNode = mergeTwoList(list.get(i), list.get(i + 1));
            newList.add(newNode);
        }
        return mergeList(newList);
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(8);
        head1.next = n1;
        n1.next = n2;
        head2.next = n4;
        n4.next = n5;
        head3.next = n3;
        ListNode[] list = new ListNode[]{head1, head2, head3, null};
        ListNode nodes = new Problem_23_1().mergeKLists(list);
        while(nodes != null) {
            System.out.println(nodes.val);
            nodes = nodes.next;
        }
    }
}
