package test.com.leetcode; 

import com.leetcode.ReverseList;
import com.util.ListNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* ReverseList Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 6, 2019</pre>
* @version 1.0 
*/
public class ReverseListTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: reverseList(ListNode head)
    *
    */
    @Test
    public void testReverseList() throws Exception {
      ReverseList rs = new ReverseList();
      ListNode ln = new ListNode();
      int [] arr = {1,2,3,4,5};
      ListNode head =rs.reverseList(ln.getLists(arr));
      ln.print(head);
    }


} 
