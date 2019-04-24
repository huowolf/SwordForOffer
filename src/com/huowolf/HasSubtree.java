package com.huowolf;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huowolf
 * @date 2019/4/24
 * @description  输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：约定空树不是任意一个树的子结构）
 */
public class HasSubtree {


    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {

        boolean result = false;

        if(root1 != null && root2 != null){

            //递归的在树A中查找与树B根节点值一样的节点

            //如果找到
            if(root1.val == root2.val){
                result = DoesTree1HaveTree2(root1,root2);
            }


            if(!result){
                result = HasSubtree(root1.left,root2);
            }

            if(!result){
                result = HasSubtree(root1.right,root2);
            }
        }

        return result;
    }


    /**
     * 判断以第一步找到的根节点为根的子树是否和树B具有相同的结构
     * @param root1
     * @param root2
     * @return
     */
    private static boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {

        // 如果Tree2都遍历完了，都能对应的上，返回tree
        if(root2 == null){
            return true;
        }

        // 如果Tree2还没有遍历完，Tree1却遍历完了，返回false
        if(root1 == null){
            return false;
        }

        //如果其中有一个节点没有对应上，返回false
        if(root1.val != root2.val){
            return false;
        }

        //对左右子树也递归遍历
        return DoesTree1HaveTree2(root1.left,root2.left) && DoesTree1HaveTree2(root1.right,root2.right);
    }


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

    @Test
    public void test(){

        TreeNode pNodeA1 = new TreeNode(8);
        TreeNode pNodeA2 = new TreeNode(8);
        TreeNode pNodeA3 = new TreeNode(7);
        TreeNode pNodeA4 = new TreeNode(9);
        TreeNode pNodeA5 = new TreeNode(2);
        TreeNode pNodeA6 = new TreeNode(4);
        TreeNode pNodeA7 = new TreeNode(7);

        connectNode(pNodeA1,pNodeA2,pNodeA3);
        connectNode(pNodeA2,pNodeA4,pNodeA5);
        connectNode(pNodeA5,pNodeA6,pNodeA7);

        TreeNode pNodeB1 = new TreeNode(8);
        TreeNode pNodeB2 = new TreeNode(9);
        TreeNode pNodeB3 = new TreeNode(2);
        connectNode(pNodeB1,pNodeB2,pNodeB3);

        boolean result = HasSubtree(pNodeA1, pNodeB1);
        Assert.assertTrue(result);
    }
}
