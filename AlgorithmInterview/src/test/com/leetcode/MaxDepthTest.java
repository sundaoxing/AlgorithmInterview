package test.com.leetcode; 

import com.leetcode.MaxDepth;
import com.util.TreeNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* MaxDepth Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 14, 2019</pre>
* @version 1.0 
*/ 
public class MaxDepthTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: maxDepth(TreeNode root)
    *
    */
    @Test
    public void testMaxDepth() throws Exception {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right=new TreeNode(3);
        MaxDepth dp = new MaxDepth();
        int result =dp.maxDepth(root);
        System.out.println(result);
    }


} 
