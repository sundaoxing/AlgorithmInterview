package test.com.leetcode; 

import com.leetcode.TwoSum;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* TwoSum Tester.
* 
* @author <Authors name> 
* @since <pre>s三月 31, 2019</pre>
* @version 1.0 
*/ 
public class TwoSumTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: twoSum(int[] nums, int target)
    *
    */
    @Test
    public void testTwoSum() throws Exception {
        int [] nums={2, 7, 11, 15};
        TwoSum ts = new TwoSum();
        int [] result =ts.twoSum(nums,9);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }

    @Test
    public void testTwoSum_un() throws Exception {
        int [] nums={2, 7, 11, 15};
        TwoSum ts = new TwoSum();
        int [] result =ts.twoSum_un(nums,18);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }


} 
