package test.com.leetcode; 

import com.leetcode.MinSubArrayLen;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* MinSubArrayLen Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 1, 2019</pre>
* @version 1.0 
*/ 
public class MinSubArrayLenTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: minSubArrayLen(int s, int[] nums)
    *
    */
    @Test
    public void testMinSubArrayLen() throws Exception {
        int [] nums = {2,3,1,2,4,3};
        MinSubArrayLen ms = new MinSubArrayLen();
        int count =ms.minSubArrayLen(7,nums);
        System.out.print(count);
    }

    @Test
    public void testMinSubArrayLen_better() throws Exception {
        int [] nums = {2,3,1,2,4,3};
        MinSubArrayLen ms = new MinSubArrayLen();
        int count =ms.minSubArrayLen_better(7,nums);
        System.out.print(count);
    }


} 
