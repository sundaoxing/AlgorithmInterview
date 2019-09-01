package com.leetcode;

import com.util.ListNode;

/*
        题目（203）：删除链表中等于给定值 val 的所有节点。
        示例:
            输入: 1->2->6->3->4->5->6, val = 6
            输出: 1->2->3->4->5
 */
public class RemoveElements {
    /**
     * 不适用虚拟头节点，需要单独处理头节点
     *      (单独处理)
     *          1   ->  2 ->    6 ->    3   ->  4   ->  5   ->  6
     *          |       |
     *        head    cur.next（从这里开始）
     *         |
     *        cur
     *
     *          1   ->  2 ->    6 ->    3   ->  4   ->  5   ->  6
     *          |               |
     *        head             cur.next（找到要删除的节点）
     *                 |
     *                cur（cur.next->3,舍弃cur.next）
     *  时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head      链表的头节点
     * @param val       要删除的值
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        /*
            1.若头节点的值==要删除的值
                头节点直接向后移动
            2.若移动后的新头节点==要删除的值（此时要使用循环来判断）
         */
        while(head !=null && head.val ==val){
            ListNode delNode = head;
            head = head.next;
            delNode.next=null;
        }
        //若上面头节点删除后，链表为空，则需要单独判断，防止cur.next空指针
        if(head == null){
            return null;
        }
        ListNode cur = head;//新的头指针的使者，代替头指针行使连接节点功能
        while(cur.next !=null){
            ListNode next = cur.next;
            if(next.val ==val){//next节点是为要删除的节点
                cur.next = next.next;
                next.next = null;
            }else{//next节点不是为要删除的节点，cur节点向后移动，继续寻找下一个满足条件的节点
                cur = cur.next;
            }
        }
        return head;//返回新链表的头指针
    }

    /**
     * 使用虚拟头节点，不需要单独处理头节点
     *   （虚拟头指针）  head
     *    dummyHead ->   1   ->  2 ->    6 ->    3   ->  4   ->  5   ->  6
     *       |           |
     *      cur         cur.next（从这里开始，相当于从链表头节点开始，而不用单独考虑头节点）
     *  时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head      链表头指针
     * @param val       要删除的值
     * @return
     */
    public ListNode removeElements_better(ListNode head, int val) {
        ListNode dummyHead = new ListNode();//新建虚拟头指针
        dummyHead.next = head;//虚拟头指针指向链表头节点，加入链表
        ListNode cur = dummyHead;//新的头指针的使者，代替头指针行使连接节点功能
        while(cur.next !=null){
            ListNode next = cur.next;
            if(next.val ==val){//next节点是为要删除的节点
                cur.next = next.next;
                next.next = null;
            }else{//next节点不是为要删除的节点，cur节点向后移动，继续寻找下一个满足条件的节点
                cur=cur.next;
            }
        }
        return dummyHead.next;//虚拟头指针的下一个节点才是head头指针，所以要返回next节点
    }
}
