package com.leetcode;

import com.util.ListNode;

/*
       题目（24）：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
                  你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
       示例：
            给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {
    /**
     *构造辅助指针：
     * 第一对：
     *    dummyHead   ->    1   ->    2   ->    3   ->  4   ->NULL
     *       cur           node1    node2      next
     *   四个辅助指针确立，node1和node2直接交换即可：
     *   cur.next=node2;
     *   node2.next=node1;
     *   node1.next=next
     *第二对：cur=node1：直接跨越两个节点
     *   dummyHead   ->    2   ->    1   ->    3   ->  4    ->   NULL
     *                              cur      node1    node2      next
     *  时间复杂度：O(n),n为链表的长度
     *  空间复杂度：O(1)
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next=head;
        ListNode cur = dummyHead;
        /*
        注意：循环终止条件：防止空指针：
             所有对象调用成员属性前都要检查其是否为NULL
         */
        while(cur.next !=null && cur.next.next!=null){
            //初始化辅助节点
            ListNode node1 = cur.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            //交换节点位置
            cur.next = node2;
            node2.next=node1;
            node1.next=next;
            cur=node1;
        }
        return dummyHead.next;//返回交换后链表的新的头节点
    }
}
