package test.com.leetcode; 

import com.leetcode.HasPathSum;
import com.util.TreeNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* HasPathSum Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 15, 2019</pre>
* @version 1.0 
*/ 
public class HasPathSumTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: hasPathSum(TreeNode root, int sum)
    *
    */
    @Test
    public void testHasPathSum() throws Exception {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right=new TreeNode(8);
        root.left.left = new TreeNode(11);

        root.right.left = new TreeNode(13);
        root.right.right=new TreeNode(4);

        root.left.left.left=new TreeNode(7);
        root.left.left.right=new TreeNode(2);

        HasPathSum hp = new HasPathSum();
        int sum =22;
        boolean result =hp.hasPathSum(root,sum);
        System.out.println(result);
    }


    @Test
    public void testPathSum() throws Exception {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right=new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.right.right=new TreeNode(11);

        root.left.left.left=new TreeNode(3);
        root.left.left.right=new TreeNode(-2);

        root.left.right.right= new TreeNode(1);

        HasPathSum hp = new HasPathSum();
        int sum =8;
        int result =hp.pathSum(root,sum);
        System.out.println(result);
    }


} 
