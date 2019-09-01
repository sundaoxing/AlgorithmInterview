package com.leetcode;

import com.util.ListNode;

/*
        题目（19）：给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
        示例：
            给定一个链表: 1->2->3->4->5, 和 n = 2.
            当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class RemoveNthFromEnd {
    /**
     * 借助滑动窗口的思想：[p,q]：p，q之间的距离固定为n个节点
     *  p:当前删除节点的前一个节点  ；q:链表的尾节点NULL节点
     *    dummyHead     ->   1   ->  2   ->  3   ->  4   ->  5   ->  NULL
     *       p                               q
     *   当q移动到NULL节点时，p节点就是要删除节点的前一个节点
     *
     *    dummyHead     ->   1   ->  2   ->  3   ->  4   ->  5   ->  NULL
     *                                       p       |       |        q
     *                                            delNode  next
     *  时间复杂度：O(n),n为链表的长度
     *  空间复杂度：O(1)
     * @param head      链表的头节点
     * @param n         倒数第n个节点（从1开始）
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n<=0){
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next=head;
        ListNode p = dummyHead;
        ListNode q = p;//初始时都在虚拟头节点的位置
        //构造窗口[p,q]，大小为n
        for(int i=0;i<=n;i++){
            if(q ==null){
                return head;
            }
            q = q.next;
        }
        //找到要删除节点的前一个节点p
        while(q !=null){
            q=q.next;
            p=p.next;
        }
        //删除节点
        ListNode delNode = p.next;
        p.next = delNode.next;
        delNode.next=null;
        return dummyHead.next;//返回删除后的链表的头节点
    }
}
