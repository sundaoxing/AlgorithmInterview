package com.leetcode.dynamicp;

       /*       爬楼梯---本质上还是斐波那契数列
       假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
       每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢
       注意：给定 n 是一个正整数。
       示例：
    输入： 2                          输入： 3
    输出： 2                          输出： 3
    解释： 有两种方法可以爬到楼顶。     解释： 有三种方法可以爬到楼顶。
    1.  1 阶 + 1 阶                   1.  1 阶 + 1 阶 + 1 阶
    2.  2 阶                          2.  1 阶 + 2 阶
                                      3.  2 阶 + 1 阶
       */
public class ClimbStairs {
    private int []memo;

    public int climbStairs(int n) {
        memo = new int[n+1];
//        return calcWays(n);
        return calcWays_dy(n);
    }

    private int calcWays(int n) {
       if(n == 1){
           return 1;
       }
       if(n == 2){
           return 2;
       }
       return calcWays(n-1)+calcWays(n-2);
    }

    private int calcWays_dy(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(memo[n] == 0){
            memo[n] = calcWays_dy(n-1) +calcWays_dy(n-2);
        }
       return memo[n];
    }

   public int climbStairs_dy(int n) {
       memo = new int[n+1];
       memo[0] =1;
       memo[1] =1;
       for(int i=2;i<=n;i++){
           memo[i]=memo[i-1]+memo[i-2];
       }
       return memo[n];
   }
}
