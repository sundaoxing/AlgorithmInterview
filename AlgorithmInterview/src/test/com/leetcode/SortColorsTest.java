package test.com.leetcode; 

import com.leetcode.SortColors;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* SortColors Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 30, 2019</pre>
* @version 1.0 
*/ 
public class SortColorsTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: sortColors(int[] nums)
    *
    */
    @Test
    public void testSortColors() throws Exception {
        int [] nums = {2,0,2,1,1,0,2,2,1};
        SortColors sc = new SortColors();
        sc.sortColors(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }

    @Test
    public void testSortColors_better() throws Exception {
        int [] nums = {2,0,2,1,1,0,2,2,1,0};
        SortColors sc = new SortColors();
        sc.sortColors_better(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }


} 
