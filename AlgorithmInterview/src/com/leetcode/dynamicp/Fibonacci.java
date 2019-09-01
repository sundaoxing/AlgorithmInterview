package com.leetcode.dynamicp;

public class Fibonacci {
    int []memo;
    /*
        斐波那契数列：0   1   1    2   3   5   8....
        数学公式：    { 0                n=0;
                f(n)={ 1                n=1;
                     { f(n-1)+f(n-2)    n>=2;
     */
    public Fibonacci() {
    }
    public Fibonacci(int[] memo) {
        this.memo = memo;
    }

    /**
     * 递归法：斐波那契数列-》类树形结构
     *                          5-----------------》求第5个数f(5)= 5
     *                        /   \
     *                       4     3               每个节点都计算一次
     *                     / \    / \
     *                    3  2    2  1             存在了大量重复计算
     *                   /\ / \  /\                2节点计算3次
     *                  2 1 1 0 1 0
     *                 /\
     *                1 0
     * @param n
     * @return
     */
    public int fibonacci(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    /**
     * 记忆化搜索法：剔除重复计算，每个节点只计算一次
     *    自上而下：先解决n规模的问题，在解决n-1规模的问题，最后解决1规模的问题
     *           思想：使用额外的空间保存每个节点的值
     *                 下次使用时，先判断该节点值是否已被计算好
     *                 若被计算好，直接返回该值，否则，在计算
     *    实现：使用数组memo[n+1]保存从2节点开始，到n节点的值
     * @param n
     * @return
     */
    public int fibonacci_better(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        /*
            memo[n+1]初始值全为0（jvm会进行初始化）
            当其值 == 0 时，代表n节点没有被计算，先计算
            否则：直接返回n节点的值
         */
        if(memo[n] == 0){
            memo[n] = fibonacci_better(n-1)+fibonacci_better(n-2);
        }
        return memo[n];
    }

    /**
     * 动态规划法：将原问题拆解成若干子问题，同时保存子问题的答案，
     *            使每个子问题只求解一次，最终得到原问题的解
     *   自下而上：先解决1规模的问题，在解决2规模的问题，最后解决n规模的问题
     *                       记忆化搜索：自上而下
     *                      /
     *   递归问题->重叠子问题
     *                      \
     *                       动态规划：自下而上
     *
     *   状态：f(n):斐波那契数列中第n位的值
     *        对应计算机中表示：memo[n]：斐波那契数列中第n位的值
     *   状态转移方程：递推公式
     *        f(n) = f(n-1)+f(n-2)
     *        对应计算机中表示：memo[n]=memo[n-1]+memo[n-2]
     *   初始状态：
     *        f(0)=0--->memo[0]=0
     *        f(1)=1--->memo[1]=1
     * @param n
     * @return
     */
    public int fibonacci_best(int n){
        memo[0] =0;//1规模的问题-》对应递归法的终止条件
        memo[1] =1;
        /*
           计算memo[i],即第i个斐波那契数列的值
         */
        for(int i=2;i<=n;i++){
            memo[i] = memo[i-1]+memo[i-2];
        }
        return memo[n];
    }
}
