package com.huowolf;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author huowolf
 * @date 2019/5/3
 * @description 从上往下打印出二叉树的每个节点，同层节点从左至右打印。（层次遍历）
 */
public class PrintFromTopToBottom {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        //牛客网的评测机要求此处返回一个空的list，而不是null
        if(root == null){
            return list;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);

            if(node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null){
                queue.offer(node.right);
            }
        }

        return list;
    }


    @Test
    public void test(){
        TreeNode pNode1 = new TreeNode(8);
        TreeNode pNode2 = new TreeNode(6);
        TreeNode pNode3 = new TreeNode(10);
        TreeNode pNode4 = new TreeNode(5);
        TreeNode pNode5 = new TreeNode(7);
        TreeNode pNode6 = new TreeNode(9);
        TreeNode pNode7 = new TreeNode(11);

        TreeUtil.connectNode(pNode1,pNode2,pNode3);
        TreeUtil.connectNode(pNode2,pNode4,pNode5);
        TreeUtil.connectNode(pNode3,pNode6,pNode7);

        ArrayList<Integer> list = PrintFromTopToBottom(pNode1);
        Integer[] result = list.toArray(new Integer[list.size()]);

        Integer[] arr = {8,6,10,5,7,9,11};
        Assert.assertArrayEquals(arr,result);

    }


    @Test
    public void test2(){
        TreeNode pNode1 = new TreeNode(1);
        ArrayList<Integer> list = PrintFromTopToBottom(pNode1);
        Integer[] result = list.toArray(new Integer[list.size()]);

        Integer[] arr = {1};
        Assert.assertArrayEquals(arr,result);
    }

    @Test
    public void test3(){
        TreeNode pNode1 = new TreeNode(1);
        TreeNode pNode2 = new TreeNode(2);
        TreeNode pNode3 = new TreeNode(3);

        TreeUtil.connectNode(pNode1,pNode2,null);
        TreeUtil.connectNode(pNode2,pNode3,null);

        ArrayList<Integer> list = PrintFromTopToBottom(pNode1);
        Integer[] result = list.toArray(new Integer[list.size()]);

        Integer[] arr = {1,2,3};
        Assert.assertArrayEquals(arr,result);
    }

    @Test
    public void test4(){
        TreeNode pNode1 = null;
        ArrayList<Integer> list = PrintFromTopToBottom(pNode1);

        Assert.assertEquals(0,list.size());
    }
}
