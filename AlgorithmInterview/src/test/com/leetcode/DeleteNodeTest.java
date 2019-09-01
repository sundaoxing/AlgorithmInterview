package test.com.leetcode; 

import com.leetcode.DeleteNode;
import com.util.ListNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* DeleteNode Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 8, 2019</pre>
* @version 1.0 
*/ 
public class DeleteNodeTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: deleteNode(ListNode node)
    *
    */
    @Test
    public void testDeleteNode() throws Exception {
        DeleteNode dn = new DeleteNode();
        ListNode ln = new ListNode();
        int []arr = {4,5,1,9};
        ListNode head = ln.getLists(arr);
        dn.deleteNode(head.next);
        ln.print(head);
    }


} 
