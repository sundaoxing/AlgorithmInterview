package com.leetcode;

import com.util.ListNode;

/*
        题目（206）：反转一个单链表。
        示例:
            输入: 1->2->3->4->5->NULL
            输出: 5->4->3->2->1->NULL
 */
public class ReverseList {
    /**
     * 反转链表：借助pre/current/next指针操作两个节点，完成反转
     *  初始：NULL   1   ->    2   ->    3   ->    4   ->    5 ->NULL
     *       |      |         |
     *      pre   current    next
     *  注意：这里指针移动需要注意顺序性
     *      1.确定pre/current/next指针的正确指向
     *      2.反转节点：current.next->pre
     *      3.更新指针指向：向下一个节点移动
     *移动：NULL <-1   ->    2   ->    3   ->    4   ->    5 ->NULL
     *            |         |         |
     *           pre   current    next
     *最后：NULL <-1   <-    2   <-    3   <-    4   <-    5     NULL
     *                                                    |       |
     *                                                   pre   current
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head      链表头指针
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre =null;//当前节点的前一个节点
        ListNode current = head;//当前节点，代替头指针行使连接节点功能
        while(current !=null){//一直移动到最后一个节点
            ListNode next=current.next;//当前节点的下一个节点
            current.next=pre;//反转
            pre= current;//更新指针
            current=next;
        }
        return pre;
    }
}
