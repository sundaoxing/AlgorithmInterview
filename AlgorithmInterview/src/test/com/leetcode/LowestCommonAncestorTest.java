package test.com.leetcode; 

import com.leetcode.LowestCommonAncestor;
import com.util.TreeNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* LowestCommonAncestor Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 16, 2019</pre>
* @version 1.0 
*/ 
public class LowestCommonAncestorTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    *
    */
    @Test
    public void testLowestCommonAncestor() throws Exception {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right=new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right=new TreeNode(9);

        LowestCommonAncestor lca = new LowestCommonAncestor();
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(7);
        TreeNode ancestor= lca.lowestCommonAncestor(root,p,q);
        System.out.println(ancestor.val);
    }


} 
