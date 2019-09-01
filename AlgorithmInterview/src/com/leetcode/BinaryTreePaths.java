package com.leetcode;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
    题目（257）：给定一个二叉树，返回所有从根节点到叶子节点的路径。
          说明: 叶子节点是指没有子节点的节点。
   示例:
        输入:
           1
         /   \
        2     3
         \
          5
                输出: ["1->2->5", "1->3"]
                解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class BinaryTreePaths {
    /**
     * 宏观语义：返回所有从node节点到叶子节点的路径
     *          路径：node.val->叶子节点
     * 递归思想：
     *      递归方法：List<String> binaryTreePaths(TreeNode node)
     *      递归终止条件：递归到叶子节点，即node.left==null && node.right==null
     *           叶子节点仍然是一棵树，只是路径是自身节点
     *      递归公式：
     *           List<String> leftList =binaryTreePaths(node.left);
     *           List<String> rightList =binaryTreePaths(node.right);
     * 时间复杂度：O(log(k))
     * 空间复杂度：O(1)
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        if(root.left ==null && root.right ==null){
            list.add(String.valueOf(root.val));
            return list;
        }
        //node节点的左子树的所有路径
        List<String> leftList =binaryTreePaths(root.left);
        //从node节点到叶子节点的路径有可能不止一条，所以需要循环遍历
        for(String s :leftList){
            list.add(root.val+"->"+s);
        }
        //node节点的右子树的所有路径
        List<String> rightList =binaryTreePaths(root.right);
        for(String s :rightList){
            list.add(root.val+"->"+s);
        }
        //返回node节点到叶子节点的所有路径
        return list;
    }
}
