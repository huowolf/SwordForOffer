package com.huowolf;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huowolf
 * @date 2019/4/24
 * @description 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {

    /**
     * 递归法合并
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode mergeHead = null;
        if(list1.val <= list2.val){
            mergeHead = list1;
            mergeHead.next = Merge(list1.next,list2);
        }else{
            mergeHead = list2;
            mergeHead.next = Merge(list1,list2.next);
        }

        return mergeHead;
    }


    /**
     * 迭代法合并
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge2(ListNode list1,ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode mergeHead = null;

        //找到合并后链表的头结点
        if(list1.val <= list2.val) {
            mergeHead = list1;
            list1 = list1.next;
        }else{
            mergeHead = list2;
            list2 = list2.next;
        }

        ListNode pNode = mergeHead;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                pNode.next = list1;
                list1 = list1.next;
            }else{
                pNode.next = list2;
                list2 = list2.next;
            }

            //go on
            pNode = pNode.next;
        }

        if(list1 != null){
            pNode.next = list1;
        }

        if(list2 != null){
            pNode.next = list2;
        }

        return mergeHead;
    }


    /**
     * 尾插法创建一个链表
     * @param arr
     * @return
     */
    public static ListNode createList(int[] arr){
        ListNode head = null,last = null;

        for (int i = 0; i < arr.length; i++) {
            ListNode listNode = new ListNode(arr[i]);
            if(i==0){
                head = listNode;
                last = listNode;
            }else{
                last.next = listNode;
                last  = listNode;
            }
        }

        return head;
    }


    @Test
    public void testCreateList(){
        int[] arr = {1,3,5,7};
        ListNode head = createList(arr);

        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }


    @Test
    public void testMerge(){
        ListNode head1 = createList(new int[]{1,3,5,7});
        ListNode head2 = createList(new int[]{2,3,4,6,8});

        ListNode mergeList = Merge(head1, head2);

        int[] mergeArr = {1,2,3,3,4,5,6,7};
        int i = 0;
        while(mergeList.next!= null){
            System.out.println(mergeList.val);

            Assert.assertEquals(mergeArr[i],mergeList.val);
            i++;

            mergeList = mergeList.next;
        }

    }


    @Test
    public void testMerge2(){
        ListNode head1 = createList(new int[]{1,3,5,7});
        ListNode head2 = createList(new int[]{2,3,4,6,8});

        ListNode mergeList = Merge2(head1, head2);

        int[] mergeArr = {1,2,3,3,4,5,6,7};
        int i = 0;
        while(mergeList.next!= null){
            System.out.println(mergeList.val);

            Assert.assertEquals(mergeArr[i],mergeList.val);
            i++;

            mergeList = mergeList.next;
        }

    }
}
