package test.com.leetcode; 

import com.leetcode.BinaryTreeTraversal;
import com.leetcode.InvertTree;
import com.util.TreeNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* InvertTree Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 14, 2019</pre>
* @version 1.0 
*/ 
public class InvertTreeTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: invertTree(TreeNode root)
    *
    */
    @Test
    public void testInvertTree() throws Exception {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right=new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right=new TreeNode(9);
        InvertTree it= new InvertTree();
        TreeNode node =it.invertTree(root);
        BinaryTreeTraversal bt = new BinaryTreeTraversal();
        List<Integer> list =bt.levelorder(node);
        for(Integer i:list){
            System.out.print(i+" ");
        }
    }


    @Test
    public void testInvertTree_better() throws Exception {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right=new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right=new TreeNode(9);
        InvertTree it= new InvertTree();
        TreeNode node =it.invertTree_better(root);
        BinaryTreeTraversal bt = new BinaryTreeTraversal();
        List<Integer> list =bt.levelorder(node);
        for(Integer i:list){
            System.out.print(i+" ");
        }
    }
} 
