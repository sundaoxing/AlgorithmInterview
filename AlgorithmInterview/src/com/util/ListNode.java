package com.util;

public class ListNode { //链表的节点
    public int val;
    public ListNode next;
    public ListNode(){}
    public ListNode(int x) { val = x; }

    /**
     * 创建一个链表，返回链表的头指针
     *        1    2    3   4   5 ->NULL
     *        |   |
     *      head  node(新建)
     *       |      |
     *       cur[1,next]:下一步cur移动到新建节点
     *
     * @return
     */
    public ListNode getLists(int [] arr){
        //注意：头指针不是通过节点的next指针连接的，而是直接创建
        ListNode head = new ListNode(arr[0]);
        //创建头指针的使者，代替头指针行使连接节点功能
        ListNode cur = head;
        for(int i=1;i<arr.length;i++){
            ListNode node = new ListNode(arr[i]);
            cur.next=node;
            cur=cur.next;
        }
        return head;
    }

    /**
     * 打印链表
     * @param head      链表的头指针
     */
    public void print(ListNode head){
        ListNode cur = head;
        while(cur !=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
    }

}
