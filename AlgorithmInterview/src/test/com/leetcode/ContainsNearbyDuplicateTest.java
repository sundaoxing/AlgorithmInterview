package test.com.leetcode; 

import com.leetcode.ContainsNearbyDuplicate;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* ContainsNearbyDuplicate Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 4, 2019</pre>
* @version 1.0 
*/ 
public class ContainsNearbyDuplicateTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: containsNearbyDuplicate(int[] nums, int k)
    *
    */
    @Test
    public void testContainsNearbyDuplicate() throws Exception {
        int [] nums ={1,2,3,1,2,3};
        int k =2;
        ContainsNearbyDuplicate cn = new ContainsNearbyDuplicate();
        boolean result =cn.containsNearbyDuplicate(nums,k);
        System.out.println(result);
    }

    @Test
    public void testContainsNearbyDuplicate_better() throws Exception {
        int [] nums ={1,2,3,1};
        int k =3;
        ContainsNearbyDuplicate cn = new ContainsNearbyDuplicate();
        boolean result =cn.containsNearbyDuplicate_better(nums,k);
        System.out.println(result);
    }
} 
