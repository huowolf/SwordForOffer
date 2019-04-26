package com.huowolf;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author huowolf
 * @date 2019/4/24
 * @description 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Mirror {

    /**
     * 递归实现
     * @param root
     */
    public void Mirror(TreeNode root) {

        //如果是空树，直接返回
        if (root == null){
            return;
        }

        //如果只有一个根节点，直接返回
        if (root.left == null && root.right == null){
            return;
        }

        //交换左右节点
        TreeNode nodeTemp = root.left;
        root.left = root.right;
        root.right = nodeTemp;

        //递归左子树
        if(root.left != null){
            Mirror(root.left);
        }

        //递归右子树
        if (root.right != null){
            Mirror(root.right);
        }
    }


    /**
     * 非递归实现
     * @param root
     */
    public void Mirror2(TreeNode root) {

        //如果是空树，直接返回
        if (root == null){
            return;
        }

        //如果只有一个根节点，直接返回
        if (root.left == null && root.right == null){
            return;
        }

        //层次遍历
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            //交换左右节点
            TreeNode nodeTemp = node.left;
            node.left = node.right;
            node.right = nodeTemp;

            if(node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null){
                queue.offer(node.right);
            }
        }

    }



    @Test
    public void testMirror(){
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

        Mirror(pNode1);

        TreeUtil.levelPrintTree(pNode1);
    }

    @Test
    public void testMirror2(){
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

        Mirror2(pNode1);

        TreeUtil.levelPrintTree(pNode1);
    }

}
