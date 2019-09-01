package test.com.leetcode.dynamicp; 

import com.leetcode.dynamicp.BackPack;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* BackPack Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 13, 2019</pre>
* @version 1.0 
*/ 
public class BackPackTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: backPack01(int [] w, int [] v, int c)
    *
    */
    @Test
    public void testBackPack01() throws Exception {
        BackPack bp = new BackPack();
        int [] w = {1,2,3};
        int [] v = {3,5,6};
        int c = 3;
        int max =bp.backPack01(w,v,c);
        System.out.println(max);
    }

    @Test
    public void testBackPack01_better() throws Exception {
        BackPack bp = new BackPack();
        int [] w = {1,2,3};
        int [] v = {3,5,6};
        int c = 3;
        int max =bp.backPack01_better(w,v,c);
        System.out.println(max);
    }

    @Test
    public void testBackPack01_best() throws Exception {
        BackPack bp = new BackPack();
        int [] w = {1,2,3};
        int [] v = {3,5,6};
        int c = 3;
        int max =bp.backPack01_best(w,v,c);
        System.out.println(max);
    }

    @Test
    public void testBackPack01_optimization() throws Exception {
        BackPack bp = new BackPack();
        int [] w = {1,2,3};
        int [] v = {3,5,6};
        int c = 3;
        int max =bp.backPack01_optimization(w,v,c);
        System.out.println(max);
    }

    @Test
    public void testBackPack01_optimization_best() throws Exception {
        BackPack bp = new BackPack();
        int [] w = {1,2,3};
        int [] v = {3,5,6};
        int c = 3;
        int max =bp.backPack01_optimization_best(w,v,c);
        System.out.println(max);
    }
} 
