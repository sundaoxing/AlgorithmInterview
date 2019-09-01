package test.com.leetcode.dynamicp; 

import com.leetcode.dynamicp.LongestIncreasingSubsequence;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* LongestIncreasingSubsequence Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 17, 2019</pre>
* @version 1.0 
*/ 
public class LongestIncreasingSubsequenceTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

    /**
    *
    * Method: lengthOfLIS(int[] nums)
    *
    */
    @Test
    public void testLengthOfLIS() throws Exception {
        int [] nums = {1,3,6,7,9,4,10,5,6};
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        int max =l.lengthOfLIS(nums);
        System.out.println(max);
    }

    @Test
    public void testLengthOfLIS_better() throws Exception {
        int [] nums = {1,3,6,7,9,4,10,5,6};
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        int max =l.lengthOfLIS_better(nums);
        System.out.println(max);
    }

    @Test
    public void testLengthOfLIS_best() throws Exception {
        int [] nums = {1,3,6,7,9,4,10,5,6};
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        int max =l.lengthOfLIS_best(nums);
        System.out.println(max);
    }

} 
