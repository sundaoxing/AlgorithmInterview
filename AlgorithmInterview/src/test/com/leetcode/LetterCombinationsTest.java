package test.com.leetcode; 

import com.leetcode.LetterCombinations;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* LetterCombinations Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 17, 2019</pre>
* @version 1.0 
*/ 
public class LetterCombinationsTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: letterCombinations(String digits)
    *
    */
    @Test
    public void testLetterCombinations() throws Exception {
        String digits = "23";
        LetterCombinations lc = new LetterCombinations();
        List<String> list=lc.letterCombinations(digits);
        for(String s :list){
            System.out.print(s+" , ");
        }
    }
} 
