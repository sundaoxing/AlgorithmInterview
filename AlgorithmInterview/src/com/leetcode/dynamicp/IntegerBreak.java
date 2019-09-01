package com.leetcode.dynamicp;

/*
    给定一个正整数 n，将其拆分为至少两个正整数的和，
    并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
    示例
    输入: 2                       输入: 10
    输出: 1                       输出: 36
    解释: 2 = 1 + 1, 1 × 1 = 1。  解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 */
public class IntegerBreak {

    private int [] memo;

    /**
     * 如何将上诉问题：分割正整数n得到最大乘积-转化成下列的树形结构问题？
     *  假设法：本质上还是穷举法
     *         假设将n分割成 1+其他数--------n = 1 + n-1
     *              然后在对n-1进行穷举，这样就可以继续迭代下去
     *         假设将n分割成 2+其他数--------n = 2 + n-2
     *         ...
     *
     *递归法：-》类树形结构
     *                       4-----------------》对4进行分割，获得最大乘积
     *          1+3/      2+2|      3+1\
     *            3         2         1  ---一次对3，2，1进行分割，获得最大乘积
     *       1+2/  2+1\  1+1|         1是最小的正整数，不需分割
     *         2     1     1
     *      1+1|     1     1        在这里，存在了大量的重复分割，比如对2分割了两次
     *        1
     *
     *  分割n得到的乘积 == 分割n-1得到的最大乘积*1-------》n=1+n-1
     *  分割n得到的乘积 == 分割n-2得到的最大乘积*2-------》n=2+n-2
     *  ...
     *  分割n得到的乘积 == 分割1得到的最大乘积*n-1-------》n=n-1+1
     *  因要分割成至少两个正整数，所以最大值可能为i*（n-i）
     *
     *  所以最终分割n得到的最大乘积就是上面所有乘积中的最大值
     *
     * 宏观语义：分割n获得最大乘积
     *          分割n：将n转换成两个以上数字的和--》n=i+j+..+k
     * 递归思想：
     *      递归方法：int integerBreak(int n)
     *      递归终止条件：递归到n==1,此时n为1，不可再继续分割
     *      递归公式：
     *           int integerBreak(n-i)
     *           n-i：依次分割n
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        //递归的终止条件
        if(n == 1){
            return 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            max = max3(i*(n-i),i*integerBreak(n-i), max);
        }
        return max;
    }

    private int max3(int i, int j, int max) {
        return Math.max(i,Math.max(j,max));
    }

    /**
     * 记忆化搜索--》将递归法中重复分割的部分进行保存，只计算一次
     *    自上而下：先解决n规模的问题，在解决n-1规模的问题，最后解决1规模的问题
     *           思想：使用额外的空间保存每个分割得到的最大乘积
     *                 下次使用时，先判断分割得到的最大乘积是否已被计算好
     *                 若被计算好，直接返回该值，否则，在计算
     *    实现：使用数组memo[n]保存分割正整数n得到的最大乘积
     * @param n
     * @return
     */
    public int integerBreak_better(int n) {
        memo = new int[n+1];//初始化memo数组元素都是0
        return integerBreak_better_memo(n);
    }

    private int integerBreak_better_memo(int n) {
        if(n == 1){
            return 1;
        }
        if(memo[n] == 0){//如果是0，则代表没有计算正整数n的最大乘积
            int max = Integer.MIN_VALUE;
            for(int i=1;i<n;i++){
                max = max3(i*(n-i),i*integerBreak(n-i), max);
            }
            memo[n]=max;
        }
        return memo[n];
    }

    /**
     * 动态规划法：将原问题拆解成若干子问题，同时保存子问题的答案，
     *            使每个子问题只求解一次，最终得到原问题的解
     *   自下而上：先解决1规模的问题，在解决2规模的问题，最后解决n规模的问题
     *                       记忆化搜索：自上而下
     *                      /           |
     *              重叠子问题           |
     *   递归问题->                      |
     *              最优子结构           |
     *                      \           |
     *                       动态规划：自下而上
     *    memo就代表这递归法中的宏观语义
     *
     *   状态：f(n):分割正整数n得到的最大乘积
     *        对应计算机中表示：memo[n]：分割正整数n得到的最大乘积
     *   状态转移方程：递推公式
     *        f(n) = max(1*f(n-1),2*f(n-2),...i*f(n-i),...n-1*f(1))
     *        对应计算机中表示：memo[n]=max(1*memo[n-1],2*memo[n-2],...i*memo[n-i],...n-1*memo[1])
     *   初始状态：分割正整数1得到的最大乘积为1
     *        f(1)=1--->memo[1]=1
     * @param n
     * @return
     */
    public int integerBreakBest(int n) {
        memo = new int[n+1];
        memo[1] =1;//1规模的问题-》对应递归法的终止条件
        return integerBreak_best(n);
    }

    private int integerBreak_best(int n) {
        for(int i=2;i<=n;i++){//依次分割正整数n
            /*
                得到正整数n-i的最大乘积
             */
            for(int j=1;j<i;j++){
                memo[i] = max3(j*(i-j),j*memo[i-j],memo[i]);
           }
        }
        return memo[n];
    }
}
