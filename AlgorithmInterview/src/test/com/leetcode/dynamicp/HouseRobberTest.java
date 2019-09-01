package test.com.leetcode.dynamicp; 

import com.leetcode.dynamicp.HouseRobber;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* HouseRobber Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 11, 2019</pre>
* @version 1.0 
*/ 
public class HouseRobberTest { 


    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: rob(int[] nums)
     *
     */
    @Test
    public void testRob() throws Exception {
        HouseRobber hb = new HouseRobber();
        int [] nums = {1,2,3,1};
        int max =hb.rob(nums);
        System.out.println(max);
    }

    @Test
    public void testRob_better() throws Exception {
        HouseRobber hb = new HouseRobber();
        int [] nums = {1,2,3,1};
        int max =hb.rob_better(nums);
        System.out.println(max);
    }

    @Test
    public void testRob_best() throws Exception {
        HouseRobber hb = new HouseRobber();
        int [] nums = {1,2,3,1};
        int max =hb.rob_best(nums);
        System.out.println(max);
    }

} 
