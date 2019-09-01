package test.com.array; 

import com.array.BinarySearch;
import com.util.Util;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* BinarySearch Tester. 
* 
* @author <Authors name> 
* @since <pre>3月 29, 2019</pre>
* @version 1.0 
*/ 
public class BinarySearchTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: binarySearch(T arr[], T target)
     */
    @Test
    public void testBinarySearch() throws Exception {
        int n = 1000000;
        Integer[] arr = Util.generateOrderArray(n);
        BinarySearch<Integer> bs = new BinarySearch<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            if (i != bs.binarySearch(arr, i)) {
                System.out.println("出错了");
                return;
            }
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime)/1000000000.0;
        System.out.println(time +"s");
    }
}

