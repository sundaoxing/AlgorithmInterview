package test.com.leetcode; 

import com.leetcode.NumSquares;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* NumSquares Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 12, 2019</pre>
* @version 1.0 
*/ 
public class NumSquaresTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: numSquares(int n)
    *
    */
    @Test
    public void testNumSquares() throws Exception {
        int n=12;
        NumSquares ns = new NumSquares();
        int result =ns.numSquares(n);
    }


} 
