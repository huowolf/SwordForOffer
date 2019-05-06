package com.huowolf;

import org.junit.Test;

/**
 * @author huowolf
 * @date 2019/5/5
 * @description
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 */
public class RandomListClone {



    public RandomListNode Clone(RandomListNode pHead){

        if(pHead == null){
            return null;
        }

        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        RandomListNode currentNode = pHead;

        while (currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);

            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;

            currentNode = nextNode;
        }

        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        currentNode = pHead;
        while (currentNode != null){

            RandomListNode cloneNode = currentNode.next;
            if(currentNode.random != null){
                cloneNode.random = currentNode.random.next;
            }

            currentNode = cloneNode.next;
        }


        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        RandomListNode cloneHead = pHead.next;

        while (currentNode != null){
            RandomListNode cloneNode = currentNode.next;
            //原链表
            currentNode.next = cloneNode.next;
            //复制后的链表
            if(cloneNode.next != null){
                cloneNode.next = cloneNode.next.next;
            }

            //原链表下一个位置是间隔一个节点
            currentNode = currentNode.next;
        }
        return cloneHead;

    }


    @Test
    public void test(){
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);

        node1.next = node2;
        node1.random = node3;

        node2.next = node3;
        node2.random = node5;

        node3.next = node4;

        node4.next = node5;
        node4.random = node2;

        RandomListNode cloneList = Clone(node1);

        RandomListNode pNode = cloneList;
        while(pNode != null){
            System.out.println("当前节点是："+pNode.label);
            if(pNode.random != null){
                System.out.println("当前节点的下一个随机节点的值："+pNode.random.label);
            }

            pNode = pNode.next;
        }
    }
}
