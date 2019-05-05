package com.huowolf;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author huowolf
 * @date 2019/5/3
 * @description 分行从上往下打印出二叉树的每个节点，同层节点从左至右打印。每一层打印到一行。
 * 算法思想：遍历时记录下最右边节点，关键就是确定最右节点的位置（需要认真领悟这种思想）
 */
public class PrintTreeInline {

    public void PrintTreeInline(TreeNode root){

        if(root == null){
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode last = root;       //当前层的最右节点
        TreeNode nextLast = root;   //下一层的最右节点
        while(!queue.isEmpty()){

            TreeNode node = queue.poll();
            System.out.print(node.val+" ");

            if(node.left != null){
                queue.offer(node.left);
                nextLast = node.left;

            }
            if(node.right != null){
                queue.offer(node.right);
                nextLast = node.right;
            }

            //如果当前输出节点是最右节点，那么换行
            if(node == last){
                System.out.println();
                last = nextLast;
            }


        }


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
        TreeNode pNode8 = new TreeNode(12);

        TreeUtil.connectNode(pNode1,pNode2,pNode3);
        TreeUtil.connectNode(pNode2,pNode4,pNode5);
        TreeUtil.connectNode(pNode3,pNode6,pNode7);
        TreeUtil.connectNode(pNode6,pNode8,null);

        PrintTreeInline(pNode1);
    }
}
