package test.com.leetcode; 

import com.leetcode.LengthOfLongestSubstring;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* LengthOfLongestSubstring Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 2, 2019</pre>
* @version 1.0 
*/ 
public class LengthOfLongestSubstringTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: lengthOfLongestSubstring(String s)
    *
    */
    @Test
    public void testLengthOfLongestSubstring() throws Exception {
        String s = "abcabcbb";
        String s1 = "pwwkew";
        String s2 = "bbbbb";
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        int r =l.lengthOfLongestSubstring(s);
        System.out.println(r);
    }

    @Test
    public void testLengthOfLongestSubstring_better() throws Exception {
        String s = "abcabcbb";
        String s1 = "pwwkew";
        String s2 = "bbbbb";
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        int r =l.lengthOfLongestSubstring_better(s);
        System.out.println(r);
    }


} 
