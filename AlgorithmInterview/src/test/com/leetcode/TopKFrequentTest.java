package test.com.leetcode; 

import com.leetcode.TopKFrequent;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* TopKFrequent Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 13, 2019</pre>
* @version 1.0 
*/ 
public class TopKFrequentTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: topKFrequent(int[] nums, int k)
    *
    */
    @Test
    public void testTopKFrequent() throws Exception {
        int [] nums = {1,1,1,2,2,3};
        int k=2;
        TopKFrequent tf = new TopKFrequent();
        List<Integer> list =tf.topKFrequent(nums,k);
        for(Integer i: list){
            System.out.print(i+" ");
        }
    }


} 
