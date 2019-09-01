package test.com.leetcode.dynamicp; 

import com.leetcode.dynamicp.Fibonacci;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Fibonacci Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 23, 2019</pre>
* @version 1.0 
*/ 
public class FibonacciTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: fibonacci(int n)
    *
    */
    @Test
    public void testFibonacci() throws Exception {
        Fibonacci f = new Fibonacci();
        long start = System.nanoTime();
        int result = f.fibonacci(40);
        long end = System.nanoTime();
        double time = (end-start)/1000000000.0;
        System.out.println(result +"用时："+ time +"s");
    }

    @Test
    public void testFibonacci_better() throws Exception {
        int []memo = new int[1000+1];
        Fibonacci f = new Fibonacci(memo);
        long start = System.nanoTime();
        int result = f.fibonacci_better(1000);
        long end = System.nanoTime();
        double time = (end-start)/1000000000.0;
        System.out.println(result +"用时："+ time +"s");
    }

    @Test
    public void testFibonacci_best() throws Exception {
        int []memo = new int[1000+1];
        Fibonacci f = new Fibonacci(memo);
        long start = System.nanoTime();
        int result = f.fibonacci_best(1000);
        long end = System.nanoTime();
        double time = (end-start)/1000000000.0;
        System.out.println(result +"用时："+ time +"s");
    }
} 
