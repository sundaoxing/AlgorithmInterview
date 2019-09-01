package test.com.leetcode; 

import com.leetcode.BinaryTreePaths;
import com.util.TreeNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* BinaryTreePaths Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 15, 2019</pre>
* @version 1.0 
*/ 
public class BinaryTreePathsTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: binaryTreePaths(TreeNode root)
    *
    */
    @Test
    public void testBinaryTreePaths() throws Exception {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right=new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right=new TreeNode(9);
        BinaryTreePaths bt = new BinaryTreePaths();
        List<String> list =bt.binaryTreePaths(root);
        for(String s :list){
            System.out.println(s);
        }
    }


} 
