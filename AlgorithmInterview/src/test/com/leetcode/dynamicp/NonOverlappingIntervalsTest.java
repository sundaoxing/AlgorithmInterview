package test.com.leetcode.dynamicp; 

import com.leetcode.dynamicp.NonOverlappingIntervals;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* NonOverlappingIntervals Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 23, 2019</pre>
* @version 1.0 
*/ 
public class NonOverlappingIntervalsTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: eraseOverlapIntervals(int[][] intervals)
    *
    */
    @Test
    public void testEraseOverlapIntervals() throws Exception {
        NonOverlappingIntervals n = new NonOverlappingIntervals();
        int [][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int result =n.eraseOverlapIntervals(intervals);
        System.out.println(result);
    }

    @Test
    public void testEraseOverlapIntervals_better() throws Exception {
        NonOverlappingIntervals n = new NonOverlappingIntervals();
        int [][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int result =n.eraseOverlapIntervals_better(intervals);
        System.out.println(result);
    }

} 
