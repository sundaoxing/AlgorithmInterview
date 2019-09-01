package com.leetcode;

import com.util.ListNode;

/*
        题目（237）：请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，
                    你将只被给定要求被删除的节点。
        示例：
            输入: head = [4,5,1,9], node = 5
            输出: [4,1,9]
            解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
        说明：
            1.链表至少包含两个节点。
            2.链表中所有节点的值都是唯一的。
            3.给定的节点为非末尾节点并且一定是链表中的一个有效节点。
            4.不要从你的函数中返回任何结果。
 */
public class DeleteNode {
    /**
     * 赋值的方式：删除
     *              4   ->  5   ->  1   ->  9
     *                      |
     *                    delNode   |
     *                            delNode.next
     *      思想：使用当前要删除的节点delNode的后继delNode.next替代该节点
     *            然后删除该后继节点
     *             4   ->  1   ->  1   ->  9
     *                     |
     *                   delNode   |
     *                    |       delNode.next
     *                   pre     |delNode
     *  时间复杂度：O(1)
     *  空间复杂度：O(1)
     * @param node      要删除的节点
     */
    public void deleteNode(ListNode node) {
        if(node == null){
            return;
        }
        if(node.next == null){
            node=null;
            return;
        }
        node.val=node.next.val;//后继替代当前要删除节点
        ListNode delNode = node.next;//删除后继
        ListNode next = delNode.next;
        node.next=next;
        delNode.next=null;
    }
}
