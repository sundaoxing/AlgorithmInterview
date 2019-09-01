package test.com.leetcode.dynamicp; 

import com.leetcode.dynamicp.PartitionEqualSubsetSum;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* PartitionEqualSubsetSum Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 21, 2019</pre>
* @version 1.0 
*/ 
public class PartitionEqualSubsetSumTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCanPartition() throws Exception {
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        int [] nums = {1,5,11,5};
        boolean result =p.canPartition(nums);
        System.out.println(result);
    }

    @Test
    public void testCanPartition_better() throws Exception {
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        int [] nums = {1,5,11,3};
        boolean result =p.canPartition_better(nums);
        System.out.println(result);
    }

    @Test
    public void testCanPartition_best() throws Exception {
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        int [] nums = {1,5,11,5};
        boolean result =p.canPartition_best(nums);
        System.out.println(result);
    }

} 
