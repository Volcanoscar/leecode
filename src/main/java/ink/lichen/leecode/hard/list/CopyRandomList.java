package ink.lichen.leecode.hard.list;

import ink.lichen.leecode.support.RandomListNode;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lichen@daojia.com on 2018-11-22.
 *
 *给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 *要求返回这个链表的深度拷贝
 */
public class CopyRandomList {


    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }
        Map<RandomListNode,RandomListNode> oldNewMap = new HashMap<RandomListNode,RandomListNode>();

        RandomListNode dummy = new RandomListNode(0);

        RandomListNode cur = dummy;
        RandomListNode temp = head;

        while (temp != null){
            RandomListNode newNode = new RandomListNode(temp.label);
            oldNewMap.put(temp,newNode);
            temp = temp.next;
            cur.next = newNode;
            cur = cur.next;
        }

        RandomListNode newHead = dummy.next;
        temp = head;
        while (temp != null){
            if (temp.random != null){
                newHead.random = oldNewMap.get(temp.random);
                temp = temp.next;
                newHead = newHead.next;
            }
        }

        return dummy.next;

//        if(head == null)
//            return head;
//        RandomListNode node = head;
//        while(node!=null){
//            RandomListNode newNode = new RandomListNode(node.label);
//            newNode.next = node.next;
//            node.next = newNode;
//            node = newNode.next;
//        }
//
//        node = head;
//        while(node!=null){
//            if(node.random != null)
//                node.next.random = node.random.next;
//            node = node.next.next;
//        }
//
//        RandomListNode newHead = head.next;
//        node = head;
//        while(node != null){
//            RandomListNode newNode = node.next;
//            node.next = newNode.next;
//            if(newNode.next!=null)
//                newNode.next = newNode.next.next;
//            node = node.next;
//        }
//        return newHead;
    }
}
