package test.com.leetcode; 

import com.leetcode.Intersection;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.Set;

/** 
* Intersection Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 2, 2019</pre>
* @version 1.0 
*/ 
public class IntersectionTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: intersection(int[] nums1, int[] nums2)
    *
    */
    @Test
    public void testIntersection() throws Exception {
        int [] nums1 = {1,2,2,1};
        int [] nums2 = {2,2};
        Intersection in = new Intersection();
        Set<Integer> set =in.intersection(nums1,nums2);
        for(Integer i : set){
            System.out.print(i+" ");
        }
    }

    @Test
    public void testIntersection_map() throws Exception {
        int [] nums1 = {1,2,2,1};
        int [] nums2 = {2,2};
        Intersection in = new Intersection();
        ArrayList<Integer> res =in.intersection_map(nums1,nums2);
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
    }
} 
