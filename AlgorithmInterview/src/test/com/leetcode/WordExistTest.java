package test.com.leetcode;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import com.leetcode.WordExist;

/** 
* WordExist Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 20, 2019</pre>
* @version 1.0 
*/ 
public class WordExistTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: exist(char[][] board, String word)
    *
    */
    @Test
    public void testExist() throws Exception {
        char [][] board= {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
                };
        String word = "ABCCED";
        WordExist we = new WordExist();
        boolean result = we.exist(board,word);
        System.out.println(result);
    }
} 
