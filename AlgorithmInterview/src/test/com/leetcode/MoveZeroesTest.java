package test.com.leetcode; 

import com.leetcode.MoveZeroes;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* MoveZeroes Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 30, 2019</pre>
* @version 1.0 
*/ 
public class MoveZeroesTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: moveZeroes(int [] nums)
    *
    */
    @Test
    public void testMoveZeroes() throws Exception {
        int [] nums = {0,1,0,3,12};
        MoveZeroes mz = new MoveZeroes();
        mz.moveZeroes(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }

    @Test
    public void testMoveZeroes_better() throws Exception {
        int [] nums = {0,1,0,3,12};
        MoveZeroes mz = new MoveZeroes();
        mz.moveZeroes_better(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }

    @Test
    public void testMoveZeroes_best() throws Exception {
        int [] nums = {0,1,0,3,12};
        MoveZeroes mz = new MoveZeroes();
        mz.moveZeroes_best(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
} 
