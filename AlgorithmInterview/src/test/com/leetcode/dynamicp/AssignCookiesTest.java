package test.com.leetcode.dynamicp;

import com.leetcode.dynamicp.AssignCookies;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* AssignCookies Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 23, 2019</pre>
* @version 1.0 
*/ 
public class AssignCookiesTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: findContentChildren(int[] g, int[] s)
    *
    */
    @Test
    public void testFindContentChildren() throws Exception {
        AssignCookies ac = new AssignCookies();
        int []g = {1,2,3};
        int []s = {1,1};
        int result = ac.findContentChildren(g,s);
        System.out.println(result);
    }


} 
