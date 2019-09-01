package test.com.leetcode.dynamicp; 

import com.leetcode.dynamicp.IntegerBreak;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* IntegerBreak Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 10, 2019</pre>
* @version 1.0 
*/ 
public class IntegerBreakTest { 

    @Test
    public void testIntegerBreak() throws Exception {
        IntegerBreak ib = new IntegerBreak();
        int max = ib.integerBreak(4);
        System.out.println(max);
    }

    @Test
    public void testIntegerBreak_better() throws Exception {
        IntegerBreak ib = new IntegerBreak();
        int max = ib.integerBreak_better(4);
        System.out.println(max);
    }

    @Test
    public void testIntegerBreak_best() throws Exception {
        IntegerBreak ib = new IntegerBreak();
        int max = ib.integerBreakBest(4);
        System.out.println(max);
    }
} 
