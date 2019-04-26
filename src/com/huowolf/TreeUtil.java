package com.huowolf;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author huowolf
 * @date 2019/4/25
 * @description
 */
public class TreeUtil {

    /**
     * 连接父节点和左右节点
     * @param rootNode
     * @param leftNode
     * @param rightNode
     */
    public static void connectNode(TreeNode rootNode,TreeNode leftNode,TreeNode rightNode){
        if(rootNode != null){
            rootNode.left = leftNode;
            rootNode.right = rightNode;
        }
    }


    /**
     * 层次遍历二叉树
     * @param root
     */
    public static void levelPrintTree(TreeNode root){
        if(root == null){
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.printf(node.val+" ");

            if(node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null){
                queue.offer(node.right);
            }
        }


    }


    @Test
    public void testPrintTree(){
        TreeNode pNode1 = new TreeNode(8);
        TreeNode pNode2 = new TreeNode(6);
        TreeNode pNode3 = new TreeNode(10);
        TreeNode pNode4 = new TreeNode(5);
        TreeNode pNode5 = new TreeNode(7);
        TreeNode pNode6 = new TreeNode(9);
        TreeNode pNode7 = new TreeNode(11);

        connectNode(pNode1,pNode2,pNode3);
        connectNode(pNode2,pNode4,pNode5);
        connectNode(pNode3,pNode6,pNode7);

        levelPrintTree(pNode1);
    }
}
