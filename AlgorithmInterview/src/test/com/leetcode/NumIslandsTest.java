package test.com.leetcode; 

import com.leetcode.NumIslands;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* NumIslands Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 22, 2019</pre>
* @version 1.0 
*/ 
public class NumIslandsTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: numIslands(char[][] grid)
    *
    */
    @Test
    public void testNumIslands() throws Exception {
        char [][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };

        NumIslands ni = new NumIslands();
        int result =ni.numIslands(grid);
        System.out.println(result);
    }
} 
