package com.leetcode;

import com.util.TreeNode;

/*
    题目（235）：给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    示例：
         示例：root = [10,5，-3,3,2，null，11,3，-2，null，1]
               10
             /   \
            5    -3
           /  \     \
          3    2    11
         / \    \
        3 -2    1
                        p=5,q=-3：则p,q公共祖先为10
                        p=5,q=2：则p,q公共祖先为5
 */
public class LowestCommonAncestor {
    /**
     * 分类讨论：讨论依据：p，q在，以node为根节点的二叉搜索树中，位置的分布
     *      1.p,q分别在node节点的左右两侧
     *          则：最近公共祖先为node节点
     *      2.p就是node节点 | q就是node节点
     *          则：最近公共祖先为node节点
     *      3.p，q都在node节点的左侧：说明p，q的最近公共祖先在node节点的左孩子中，到左孩子中继续寻找
     *          则：到左孩子中继续寻找
     *      4.p，q都在node节点的右侧：说明p，q的最近公共祖先在node节点的右孩子中，到右孩子中继续寻找
     *          则：到右孩子中继续寻找
     *
     * 宏观语义：返回以node为根节点的树中p，q节点的最近公共祖先节点
     *
     * 递归思想：
     *      递归方法：TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
     *      递归终止条件：递归到叶子节点的左右节点：即node==null
     *           null仍然是一棵树，只是不存在p，q节点的最近公共祖先节点
     *      递归公式：
     *          return lowestCommonAncestor(root.left,p,q);
     *          return lowestCommonAncestor(root.right,p,q);
     * 时间复杂度：O(log(k))
     * 空间复杂度：O(1)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null){
            return null;
        }
        /*
            除了下面两种情况，其他的情况最近公共祖先节点都是node节点
            所以可以直接合并
        if(root.val == p.val || root.val == q.val
                ||((root.val>p.val) && (root.val<q.val))
                ||((root.val<p.val) && (root.val>q.val))){
            return root;
        }
         */
        if(p.val < root.val && q.val < root.val){//左侧
            return lowestCommonAncestor(root.left,p,q);
        }
        if(p.val > root.val && q.val > root.val){//右侧
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
