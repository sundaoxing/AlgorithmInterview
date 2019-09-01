package test.com.leetcode; 

import com.leetcode.RemoveElements;
import com.util.ListNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* RemoveElements Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 7, 2019</pre>
* @version 1.0 
*/ 
public class RemoveElementsTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: removeElements(ListNode head, int val)
    *
    */
    @Test
    public void testRemoveElements() throws Exception {
        RemoveElements re = new RemoveElements();
        ListNode ln = new ListNode();
        int [] arr = {6,1,2,6,3,4,5,6};
        ListNode head =re.removeElements(ln.getLists(arr),6);
        ln.print(head);
    }

    @Test
    public void testRemoveElements_better() throws Exception {
        RemoveElements re = new RemoveElements();
        ListNode ln = new ListNode();
        int [] arr = {6,6,1,2,6,3,4,5,6};
        ListNode head =re.removeElements_better(ln.getLists(arr),6);
        ln.print(head);
    }


} 
