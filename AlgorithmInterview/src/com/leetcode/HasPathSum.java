package com.leetcode;

import com.util.TreeNode;

/*
    题目（112）：给定一个二叉树和一个目标和，
    判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
    说明: 叶子节点是指没有子节点的节点。
    示例:
        给定如下二叉树，以及目标和 sum = 22，
                      5
                     / \
                    4   8
                   /   / \
                  11  13  4
                 /  \      \
                7    2      1
        返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class HasPathSum {
    /**
     * 宏观语义：判断，以node为根节点的树中，根节点到叶子节点的路径和是否==sum
     *          路径和：左子树中，根节点到叶子节点的路径和是否==sum-node.val
     *          或者：  右子树中，根节点到叶子节点的路径和是否==sum-node.val
     * 递归思想：
     *      递归方法：boolean hasPathSum(TreeNode node, int sum)
     *      递归终止条件：
     *          1.递归到叶子节点：node！=null，node.left ==null && node.right ==null
     *              判断此时的sum==0是否成立，返回判断值
     *          2.递归到叶子节点的左右节点：即node==null
     *              null仍然是一棵树，但已经不满组sum==0，返回false
     *      递归公式：
     *           hasPathSum(node.left,sum-node.val)
     *           hasPathSum(node.right,sum-node.val)
     * 时间复杂度：O(log(k))
     * 空间复杂度：O(1)
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        /*
            注意：所求是，根节点到叶子节点的路径，导致
                1       -->sum=1 此时有路径和==sum，但不满足是
              /   \                     根节点到叶子节点的路径
            2     null
         */
        if(root.left ==null && root.right ==null){
            return root.val == sum;
        }
//        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
        //判断左子树中是否存在该条路径
        if(hasPathSum(root.left,sum-root.val)){
            return true;
        }
        //判断右子树中是否存在该条路径
        if(hasPathSum(root.right,sum-root.val)){
            return true;
        }
        //左右子树都不存在，直径二返回false
        return false;
    }

/*
    题目（437）：给定一个二叉树，它的每个结点都存放着一个整数值。找出路径
                和等于给定数值的路径总数。路径不需要从根节点开始，也不需
                要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
    示例：root = [10,5，-3,3,2，null，11,3，-2，null，1]，sum = 8
              10
             / \
            5    -3
           /  \     \
          3    2    11
         / \    \
        3 -2    1
          和等于8的路径有：
                        1. 5  - > 3
                        2. 5  - > 2  - > 1
                        3. -3  - > 11
 */

    /**
     *嵌套递归：
     * 宏观语义：返回，以node为根节点的树中，路径和==sum，的路径个数
     *
     * 递归思想：
     *      递归方法：int pathSum(TreeNode root, int sum)
     *      递归终止条件：递归到叶子节点的左右节点：即node==null
     *           null仍然是一棵树，但是没有了路径，返回0
     *      递归公式：
     *          res+=pathSum(root.left,sum);
     *          res+=pathSum(root.right,sum);
     * 时间复杂度：O(log(n)*log(k))
     * 空间复杂度：O(1)
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        //到以root为根节点的二叉树中寻找路径和==sum的路径个数
        int res = findPath(root,sum);
        //到以root.left为根节点的二叉树中寻找路径和==sum的路径个数
        res+=pathSum(root.left,sum);
        //到以root.right为根节点的二叉树中寻找路径和==sum的路径个数
        res+=pathSum(root.right,sum);
        return res;//返回总的路径个数
    }

    /**
     * 宏观语义：返回，以node为根节点的树中，node到叶子节点的路径和==sum，的路径个数
     *          路径和==sum：左子树中，node到叶子节点的路径和是否==sum-node.val
     *          或者： 右子树中，node到叶子节点的路径和是否==sum-node.val
     * 递归思想：
     *      递归方法： int findPath(TreeNode node, int sum)
     *      递归终止条件：路径不需要从根节点开始，也不需要在叶子节点结束
     *          1.递归到叶子节点的左右孩子节点：即node==null
     *              null仍然是一棵树，但已经不满足sum==0，即没有了路径，返回0
     *          2.node!=null,满足node.val =sum，即找了一条路径
     *      递归公式：
     *           res+=findPath(node.left,sum-node.val);
     *           res+=findPath(node.right,sum-node.val);
     * 时间复杂度：O(log(k))
     * 空间复杂度：O(1)
     * @param node
     * @param sum
     * @return
     */
    private int findPath(TreeNode node, int sum) {
        if(node ==null){//没有路径
            return 0;
        }
        int res =0;
        if(node.val == sum){//找到一条路径
            res++;
        }
        //到左孩子中找，默认当前节点在路径中
        res+=findPath(node.left,sum-node.val);
        //到右孩子中找，默认当前节点在路径中
        res+=findPath(node.right,sum-node.val);
        return res;//返回路径个数
    }
}
