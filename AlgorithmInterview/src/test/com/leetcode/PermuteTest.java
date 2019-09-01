package test.com.leetcode; 

import com.leetcode.Permute;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* Permute Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 18, 2019</pre>
* @version 1.0 
*/ 
public class PermuteTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: permute(int[] nums)
    *
    */
    @Test
    public void testPermute() throws Exception {
        int [] nums = {1,2,3};
        Permute p = new Permute();
        List<List<Integer>> lists =p.permute(nums);
        for(List list : lists){
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
    }
} 
