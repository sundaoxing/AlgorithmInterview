package test.com.leetcode; 

import com.leetcode.NQueens;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

/** 
* NQueens Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 22, 2019</pre>
* @version 1.0 
*/ 
public class NQueensTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: solveNQueens(int n)
    *
    */
    @Test
    public void testSolveNQueens() throws Exception {
        int n=4;
        NQueens nq= new NQueens();
        List<List<String>> lists = nq.solveNQueens(n);
        for(List<String> list : lists){
            for(String s:list){
                System.out.println(s);
            }
            System.out.println("---------");
        }
    }
} 
