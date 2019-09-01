package test.com.leetcode; 

import com.leetcode.ContainsNearbyAlmostDuplicate;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* ContainsNearbyAlmostDuplicate Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 4, 2019</pre>
* @version 1.0 
*/ 
public class ContainsNearbyAlmostDuplicateTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: containsNearbyAlmostDuplicate(int[] nums, int k, int t)
    *
    */
    @Test
    public void testContainsNearbyAlmostDuplicate() throws Exception {
        int [] nums = {-2147483648,-2147483647};
        int k= 3;
        int t= 3;
        ContainsNearbyAlmostDuplicate cn = new ContainsNearbyAlmostDuplicate();
        boolean result =cn.containsNearbyAlmostDuplicate(nums,k,t);
        System.out.println(result);
    }


} 
