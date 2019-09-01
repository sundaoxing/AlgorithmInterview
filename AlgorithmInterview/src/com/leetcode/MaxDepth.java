package com.leetcode;

import com.util.TreeNode;

/*
        题目（104）:给定一个二叉树，找出其最大深度。
        二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
        说明: 叶子节点是指没有子节点的节点。
        示例：
            给定二叉树 [3,9,20,null,null,15,7]，
            3
           / \
          9  20
            /  \
           15   7
        返回它的最大深度 3
 */
public class MaxDepth {
    /**
     * 宏观语义：返回以node为根节点的树的最大深度
     *          最大深度：左右子树深度的较大值+node节点的本身高度1
     * 递归思想：
     *      递归方法：int maxDepth(TreeNode node)
     *      递归终止条件：递归到叶子节点的左右节点：即node==null
     *           null仍然是一棵树，只是最大深度为0
     *      递归公式：
     *           maxLeft = maxDepth(node.left)
     *           maxRight = maxDepth(node.right)
     * 时间复杂度：O(log(k))
     * 空间复杂度：O(1)
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft,maxRight)+1;
    }
}
