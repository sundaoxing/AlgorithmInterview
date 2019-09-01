package test.com.leetcode; 

import com.leetcode.ValidParentheses;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* ValidParentheses Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 9, 2019</pre>
* @version 1.0 
*/ 
public class ValidParenthesesTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: isValid(String s)
    *
    */
    @Test
    public void testIsValid() throws Exception {
        String s = "(){}[()]";
        ValidParentheses vp = new ValidParentheses();
        boolean result =vp.isValid(s);
        System.out.println(result);
    }


} 
