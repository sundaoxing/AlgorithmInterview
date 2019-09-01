package test.com.leetcode; 

import com.leetcode.Combine;
import com.leetcode.Permute;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* Combine Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 19, 2019</pre>
* @version 1.0 
*/ 
public class CombineTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: combine(int n, int k)
    *
    */
    @Test
    public void testCombine() throws Exception {
        int n = 4;
        int k=2;
        Combine c = new Combine();
        List<List<Integer>> lists = c.combine(n,k);
        for(List list : lists){
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
    }
} 
