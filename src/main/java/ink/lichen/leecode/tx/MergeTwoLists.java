package ink.lichen.leecode.tx;

import ink.lichen.leecode.support.ListNode;

public class MergeTwoLists {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(0);
        ListNode dummy = cur;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }

        while (l1 != null){
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }

        while (l2 != null){
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        return dummy.next;

    }
}
