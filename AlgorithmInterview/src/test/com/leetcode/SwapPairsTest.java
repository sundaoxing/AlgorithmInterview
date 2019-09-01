package test.com.leetcode; 

import com.leetcode.SwapPairs;
import com.util.ListNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* SwapPairs Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 8, 2019</pre>
* @version 1.0 
*/ 
public class SwapPairsTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: swapPairs(ListNode head)
    *
    */
    @Test
    public void testSwapPairs() throws Exception {
        SwapPairs sp  = new SwapPairs();
        ListNode ln = new ListNode();
        int [] arr = {1,2,3,4,5};
        ListNode head =ln.getLists(arr);
        ListNode newHead = sp.swapPairs(head);
        ln.print(newHead);
    }


} 
