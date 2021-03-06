package ink.lichen.leecode.tx;

import ink.lichen.leecode.support.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lichen@daojia.com on 2018-11-20.
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 */
public class DetectCycle {


    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head))
            {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
