package com.huowolf;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author huowolf
 * @date 2019/5/5
 * @description
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 解题要点：只有前序遍历是最先访问到根节点的。
 * 当前节点访问完，递归函数会自动回到父节点。
 * 所以要在递归函数退出(栈帧出栈)之前，删除掉当前节点。
 *
 *
 */
public class FindPath {

    ArrayList<ArrayList<Integer>> listAll= new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        //参考牛客网的最优实现
        //让target-root.val 返回上一个函数栈时，上一个函数栈中的target是一个没减之前的。

        if(root == null){
            return listAll;
        }

        list.add(root.val);
        target -= root.val;

        if(target == 0 && root.left == null && root.right == null){
            listAll.add(new ArrayList<>(list));
        }

        FindPath(root.left,target);
        FindPath(root.right,target);

        list.remove(list.size()-1);

        return listAll;
    }


    @Test
    public void test(){
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);

        TreeUtil.connectNode(node1,node2,node3);
        TreeUtil.connectNode(node2,node4,node5);

        ArrayList<ArrayList<Integer>> list = FindPath(node1, 22);

        Assert.assertEquals(2,list.size());

        for (ArrayList<Integer> item : list) {
            System.out.println(item);
        }
    }
}
