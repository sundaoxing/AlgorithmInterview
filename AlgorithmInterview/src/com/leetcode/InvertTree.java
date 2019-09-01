package com.leetcode;

import com.util.TreeNode;

/*
        题目（226）：翻转一棵二叉树。
        示例：
        输入：

             4
           /   \
          2     7
         / \   / \
        1   3 6   9
                    输出：
                         4
                       /   \
                      7     2
                     / \   / \
                    9   6 3   1
 */
public class InvertTree {
    /**
     * 宏观语义：翻转以node为根节点的树，最后在返回新树的根节点
     *          翻转：交换node节点的左右子树
     * 递归思想：
     *      递归方法：TreeNode invertTree(TreeNode node)
     *      递归终止条件：递归到叶子节点的左右节点：即node==null
     *           null仍然是一棵树，只是翻转后仍是null
     *      递归公式：
     *           invertTree(node.left);
     *           invertTree(node.right);
     * 时间复杂度：O(log(k))
     * 空间复杂度：O(1)
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root== null){
            return null;
        }
        /*
            虽然按照递归宏观语义，要返回新树的根节点
            但在这里，其实根节点没变，只是左右子树变了
         */
        invertTree(root.left);
        invertTree(root.right);
        if(root.left ==null && root.right ==null){
            return root;
        }
        Swap(root);//翻转
        return root;
    }

    public TreeNode invertTree_better(TreeNode root) {
        invert(root);
        return root;
    }

    /**
     * 对上一版的修订版，递归宏观语义更加明确
     * 宏观语义：翻转以node为根节点的树
     *          翻转：交换node节点的左右子树
     * 递归思想：
     *      递归方法：TreeNode invertTree(TreeNode node)
     *      递归终止条件：递归到叶子节点的左右节点：即node==null
     *           null仍然是一棵树，只是翻转后仍是null
     *      递归公式：
     *           invertTree(node.left);
     *           invertTree(node.right);
     * 时间复杂度：O(log(k))
     * 空间复杂度：O(1)
     * @param node
     */
    private void invert(TreeNode node) {
        if(node== null){
            return;
        }
        invertTree(node.left);
        invertTree(node.right);
        if(node.left ==null && node.right ==null){
            return;
        }
        Swap(node);
    }

    /**
     * 交换node节点的左右子树
     * @param node
     */
    private void Swap(TreeNode node) {
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = right;
        node.right=left;
    }
}
