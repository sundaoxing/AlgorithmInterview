package test.com.leetcode; 

import com.leetcode.BinaryTreeTraversal;
import com.util.TreeNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* BinaryTreeTraversal Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 9, 2019</pre>
* @version 1.0 
*/ 
public class BinaryTreeTraversalTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: preorderTraversal(TreeNode root)
    *
    */
    @Test
    public void testPreorder() throws Exception {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right=new TreeNode(2);
        BinaryTreeTraversal bt = new BinaryTreeTraversal();
        List<Integer> list =bt.preorder(root);
        for(Integer i: list){
            System.out.print(i+" ");
        }
    }

    @Test
    public void testPreorder_better() throws Exception {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right=new TreeNode(2);
        BinaryTreeTraversal bt = new BinaryTreeTraversal();
        List<Integer> list =bt.preorder_better(root);
        for(Integer i: list){
            System.out.print(i+" ");
        }
    }

    @Test
    public void testInorder_better() throws Exception {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right=new TreeNode(2);
        BinaryTreeTraversal bt = new BinaryTreeTraversal();
        List<Integer> list =bt.inorder_better(root);
        for(Integer i: list){
            System.out.print(i+" ");
        }
    }

    @Test
    public void testLevelOrder() throws Exception {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right=new TreeNode(2);
        BinaryTreeTraversal bt = new BinaryTreeTraversal();
        List<Integer> list =bt.levelorder(root);
        for(Integer i: list){
            System.out.print(i+" ");
        }
    }

    @Test
    public void testLevelOrder_better() throws Exception {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right=new TreeNode(3);
        BinaryTreeTraversal bt = new BinaryTreeTraversal();
        List<List<Integer>> list =bt.levelorder_better(root);
    }

} 
