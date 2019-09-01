package com.leetcode;

import com.util.Command;
import com.util.Pair;
import com.util.TreeNode;

import java.util.*;

/*
        二叉树的遍历：前序，中序，后序（非递归实现）
 */
public class BinaryTreeTraversal {
    /**
     二叉树的前序遍历：非递归实现
     *      思想：借助Stack栈实现根，左，右节点访问顺序
     *      初始：
     *            1      根节点入栈->     1       ->栈顶元素
     *      /         \
     *     2           3
     *  /    \      /    \
     *null  null  null  null
     *
     *      访问：根节点出栈：访问其节点值
     *           若根节点的右孩子不为空：则入栈     2  ->栈顶元素
     *           若根节点的左孩子不为空：则入栈     3
     * 时间复杂度：O(n)
     * 空间复杂度：O(n+k)
     * @param root      二叉树的根节点
     * @return
     */
    public List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.empty()){
            TreeNode node = s.pop();
            if(node.right !=null){
                s.push(node.right);
            }
            if(node.left !=null){
                s.push(node.left);
            }
            list.add(node.val);
        }
        return list;
    }

    /**
     * 二叉树的前序遍历：非递归实现，借助栈Stack模拟系统栈
     *          1      -> 根节点相关信息入栈->  |go,1|
     *      /       \         |go,1|:
     *     2         3               |print,1|     栈顶->根节点相关操作入栈
     *  /   \     /    \             |go,1-left|
     *null  null null  null          |go,1-right|
     *
     *    |print,1|：直接打印1的值，出栈
     *    |go,1-left|：
     *                |print,2|         栈顶->根节点左孩子相关操作入栈
     *                |go,2-left|：
     *                |go,2-right|：
     *   |go,1-right|：
     *                |print,3|         栈顶->根节点右孩子相关操作入栈
     *                |go,3-left|：
     *                |go,3-right|：
     * 时间复杂度：O(n)
     * 空间复杂度：O(n+k)
     * @param root
     * @return
     */
    public List<Integer> preorder_better(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go",root));
        while(!stack.empty()){
            Command c = stack.pop();
            if(c.s == "print"){
                list.add(c.node.val);
            }else{//入栈顺序与二叉树前序遍历顺序相反，因为栈Stack，先进后出
                if(c.node.right !=null){
                    stack.push(new Command("go",c.node.right));
                }
                if(c.node.left !=null){
                    stack.push(new Command("go",c.node.left));
                }
                stack.push(new Command("print",c.node));
            }
        }
        return list;
    }

    /**
     * 二叉树的中序遍历：非递归实现，借助栈Stack模拟系统栈
     *          1      -> 根节点相关信息入栈->  |go,1|
     *      /       \         |go,1|:
     *     2         3               |go,1-left|    栈顶->根节点相关操作入栈
     *  /   \     /    \             |print,1|
     *null  null null  null          |go,1-right|
     *
     *    |go,1-left|：
     *                 |go,2-left|：        栈顶->根节点左孩子相关操作入栈
     *                 |print,2|
     *                 |go,2-right|：
     *
     *   |print,1|：直接打印1的值，出栈
     *
     *   |go,1-right|：
     *                 |go,3-left|：        栈顶->根节点右孩子相关操作入栈
     *                 |print,3|
     *                 |go,3-right|：
     * 时间复杂度：O(n)
     * 空间复杂度：O(n+k)
     * @param root
     * @return
     */
    public List<Integer> inorder_better(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go",root));
        while(!stack.empty()){
            Command c = stack.pop();
            if(c.s == "print"){
                list.add(c.node.val);
            }else{
                if(c.node.right !=null){
                    stack.push(new Command("go",c.node.right));
                }
                stack.push(new Command("print",c.node));
                if(c.node.left !=null){
                    stack.push(new Command("go",c.node.left));
                }

            }
        }
        return list;
    }

    /**
     * 二叉树的后序遍历：非递归实现，借助栈Stack模拟系统栈
     *          1      -> 根节点相关信息入栈->  |go,1|
     *      /       \         |go,1|:
     *     2         3               |go,1-left|    栈顶->根节点相关操作入栈
     *  /   \     /    \             |go,1-right|
     *null  null null  null          |print,1|
     *
     *    |go,1-left|：
     *                 |go,2-left|：        栈顶->根节点左孩子相关操作入栈
     *                 |go,2-right|：
     *                 |print,2|
     *    |go,1-right|：
     *                 |go,3-left|：        栈顶->根节点左孩子相关操作入栈
     *                 |go,3-right|：
     *                 |print,3|
     *    |print,1|：直接打印1的值，出栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n+k)
     * @param root
     * @return
     */
    public List<Integer> postorder_better(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go",root));
        while(!stack.empty()){
            Command c = stack.pop();
            if(c.s == "print"){
                list.add(c.node.val);
            }else{
                stack.push(new Command("print",c.node));
                if(c.node.right !=null){
                    stack.push(new Command("go",c.node.right));
                }
                if(c.node.left !=null){
                    stack.push(new Command("go",c.node.left));
                }

            }
        }
        return list;
    }

    /**
     * 二叉树的层次遍历：借助队列（广度优先遍历）：先进先出
     *      改变二叉树节点的访问顺序
     *          1      -> 根节点相关信息入队列->  |1,0|（节点，层次）
     *      /       \
     *     2         3
     *  /   \     /    \
     *null  null null  null
     *
     * |1，0|(节点1)出队：
     *              |1.left,1|(节点2):
     *                                  |2.left,2|:
     *                                  |2.right,2|:
     *              |1.right,1|(节点3):
     *                                  |3.left,2|:
     *                                  |3.right,2|:
     * 时间复杂度：O(n)
     * 空间复杂度：O(n+k)
     * @param root
     * @return
     */
    public List<Integer> levelorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left !=null){
                queue.offer(node.left);
            }
            if(node.right !=null){
                queue.offer(node.right);
            }
        }
        return list;
    }

/*
    题目（102）：给定一个二叉树，返回其按层次遍历的节点值（即逐层地，从左到右访问所有节点）。
        例如:
        给定二叉树: [3,9,20,null,null,15,7],
            3
           / \
          9  20
            /  \
           15   7
        返回其层次遍历结果：
        [
          [3],
          [9,20],
          [15,7]
        ]
 */

    /**
     * 二叉树的层次遍历：借助队列Queue实现：先进先出
     *  整体思想与上面类似，只是在访问到该节点时，要保存该节点的层次
     *      Pair类：自定义k:v键值对，保存节点：层次信息
     *   List<List<Integer>> ：[
     *   list.get(0)->list     [3]         第0层->对应数组下标：从0开始
     *   list.get(1)->list     [9,20]      第1层                 1
     *   list.get(2)->list     [15,7]      第2层                 2
     *                          ]
     * 时间复杂度：O(n)
     * 空间复杂度：O(n+k)
     * @param root
     * @return
     */
    public List<List<Integer>> levelorder_better(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root ==null){
            return list;
        }
        Queue<Pair<TreeNode,Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(root,0));
        while(!queue.isEmpty()){
            Pair<TreeNode,Integer> pair=queue.poll();
            TreeNode node = pair.k;
            int level = pair.v;
            if(level == list.size()){//节点到了下一个层次
                list.add(new ArrayList<>());//需要构造一个新的节点层次数组
            }
            list.get(level).add(node.val);//当前层次数组添加节点
            if(node.left !=null){
                queue.offer(new Pair<>(node.left,level+1));
            }
            if(node.right !=null){
                queue.offer(new Pair<>(node.right,level+1));
            }
        }
        return list;
    }
}
