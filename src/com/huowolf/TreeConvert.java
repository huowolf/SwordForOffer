package com.huowolf;

import org.junit.Test;

/**
 * @author huowolf
 * @date 2019/5/6
 * @description 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 解题思路：二叉排序树中序遍历的结果就是排序的。
 * 所以需要在中序遍历时完成两个节点的互指。
 * 故需要定义一个指向前一个节点的指针。
 */
public class TreeConvert {

    //双向链表的头指针
    private TreeNode head = null;

    //将前一个节点定义为全局变量
    private TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {

        if(pRootOfTree == null){
            return null;
        }

        ConvertSub(pRootOfTree);

        return head;
    }

    private void ConvertSub(TreeNode cur) {
        if(cur == null){
            return;
        }

        //遍历左子树
        ConvertSub(cur.left);

        //访问到根
        //此时cur指向最左的节点
        if(head == null){
            head = cur;
            pre = cur;
        }else{
            pre.right = cur;    //前后互指
            cur.left = pre;

            pre = cur;
        }

        ConvertSub(cur.right);
    }


    @Test
    public void test(){
        TreeNode pNode1 = new TreeNode(10);
        TreeNode pNode2 = new TreeNode(6);
        TreeNode pNode3 = new TreeNode(14);
        TreeNode pNode4 = new TreeNode(4);
        TreeNode pNode5 = new TreeNode(8);
        TreeNode pNode6 = new TreeNode(12);
        TreeNode pNode7 = new TreeNode(16);

        TreeUtil.connectNode(pNode1,pNode2,pNode3);
        TreeUtil.connectNode(pNode2,pNode4,pNode5);
        TreeUtil.connectNode(pNode3,pNode6,pNode7);

        Convert(pNode1);

    }
}
