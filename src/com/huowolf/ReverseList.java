package com.huowolf;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author huowolf
 * @date 2019/4/15
 * @description 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {

    //头结点
    private static ListNode head=new ListNode(0);

    //初始化一个链表
    @BeforeClass
    public static void setUp(){

        ListNode node = head;

        for (int i = 1; i <= 6; i++) {
            ListNode listNode = new ListNode(i);
            node.next = listNode;
            node = listNode;
        }
    }

    //改链法翻转链表
    public static ListNode ReverseList(ListNode head) {
        //定义三个指针，分别指向当前节点以及前一个节点和后一个节点

        ListNode ReverseHead = null;    //指向翻转后的链表的头指针
        ListNode pNode= head;           //工作节点
        ListNode pPrev = null;          //前一个节点
        ListNode pNext = null;          //后一个节点

        while(pNode!=null){

            //保存后一个指针，防止修改指针时断链
            pNext = pNode.next;

            //如果遍历到原链表的尾结点，那么就找到了翻转后链表的头结点
            if(pNext==null){
                ReverseHead = pNode;
            }

            //改链
            pNode.next = pPrev;

            //go on
            pPrev = pNode;
            pNode = pNext;
        }
        return ReverseHead;
    }


    //头插法翻转链表(去除引入的那个头结点，才能通过牛客网评测机)
    public static ListNode ReverseList2(ListNode head){

        if(head == null){
            return null;
        }

        ListNode pNext;

        //搞个头结点
        ListNode ReverseHead = new ListNode(-1);

        ListNode pNode = head;

        while (pNode!=null){

            //保存后一个节点，防止断链
            pNext = pNode.next;

            //头插（让工作节点的next指针指向头结点）
            pNode.next = ReverseHead;
            ReverseHead = pNode;

            //go on
            pNode = pNext;
        }

        //移除那个翻转后的头结点
        ListNode node = ReverseHead;
        while (node.next.next!=null){
            node = node.next;
        }
        node.next = null;

        return ReverseHead;
    }



    @Test
    public void testReverseList(){

        ListNode listNode = ReverseList(head);
        Assert.assertEquals(6,listNode.val);

        //检查当头指针为空的情况
        head = null;
        ListNode node = ReverseList(head);
        Assert.assertEquals(null,node);

        //检查输入的链表只有一个节点的情况
        ListNode headNew = new ListNode(1);
        ListNode reverseList = ReverseList(headNew);
        Assert.assertEquals(1,reverseList.val);

    }


    @Test
    public void testReverseList2(){

        ListNode listNode = ReverseList2(head);
        Assert.assertEquals(6,listNode.val);

        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

        head = null;
        ListNode node = ReverseList2(head);
        Assert.assertEquals(null,node);

        ListNode headNew = new ListNode(1);
        ListNode reverseList = ReverseList2(headNew);
        Assert.assertEquals(1,reverseList.val);

    }
}
