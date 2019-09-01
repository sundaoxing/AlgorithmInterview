package com.leetcode.dynamicp;
/*
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，
能够偷窃到的最高金额。

示例：
输入: [1,2,3,1]                      输入: [2,7,9,3,1]
输出: 4                              输出: 12
解释: 偷窃 1 号房屋 (金额 = 1)        解释: 偷窃 1 号房屋 (金额 = 2)
     然后偷窃 3 号房屋 (金额 = 3)          偷窃 3 号房屋 (金额 = 9)
    偷窃到的最高金额 = 1 + 3 = 4          接着偷窃 5 号房屋 (金额 = 1)
                                        偷窃到的最高金额 = 2 + 9 + 1 = 12
 */
public class HouseRobber {

    public int rob(int[] nums) {
        return rob(nums,0);
    }

    /**
     * 如何将上诉问题：偷窃到的最高金额-转化成下列的树形结构问题？
     *  假设法：本质上还是穷举法
     *         假设先偷取第0房间，然后在从[2,n-1]房间中偷取最高金额
     *              然后在对[2,n-1]进行穷举，这样就可以继续迭代下去
     *         假设先偷取第1房间，然后在从[3,n-1]房间中偷取最高金额
     *         ...
     *
     *递归法：-》类树形结构
     *              金额  1，2，3，1
     *                  [0，1，2，3]-----------------》偷取4个房间，获得最高金额
     *          0/      1|      2\      3\
     *      [2，3]     [3，3]   [4，3]    [5,3]---依次偷取第0，1，2，3号房间的金额
     *    2/   3\       3|        |        |
     *  [4,3]  [5,3]   [5,3]      0        0------此时已没有了房间，所以偷取金额为0
     *   |       |       |
     *   0       0      0
     *
     *  偷取[0,n-1]个房间的最大金额 == 第0号房间的金额+[2,n-1]个房间的最大金额
     *  偷取[2,n-1]个房间的最大金额 == 第2号房间的金额+[4,n-1]个房间的最大金额
     *  ...
     *  偷取[n-1,n-1]个房间的最大金额 == 第n-1号房间的金额+[n+1,n-1]个房间的最大金额
     *  因要偷取相邻的房间会触发报警，所以要偷取隔一个房间
     *
     * 宏观语义：偷取[start,nums.length-1]个房间的最大金额
     *
     * 递归思想：
     *      递归方法：int rob(int[] nums, int start)
     *      递归终止条件：递归到start >= nums.length,此时没有房间了，金额为0
     *      递归公式：
     *           int rob(nums,start+2)
     *           start+2：间隔一个房间在偷取
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    private int rob(int[] nums, int start) {
        if(start >= nums.length){//递归的终止条件
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i=start;i<nums.length;i++){
            max= Math.max(max,nums[start]+rob(nums,start+2));
        }
        return max;
    }

    private int [] memo;
    public int rob_better(int[] nums) {
        memo = new int[nums.length];
        return rob(nums,0);
    }

    /**
     * 记忆化搜索--》将递归法中重复分割的部分进行保存，只计算一次
     *    自上而下：先解决n规模的问题，在解决n-1规模的问题，最后解决1规模的问题
     *           思想：使用额外的空间保存[start,nums.length-1]的最大金额
     *                 下次使用时，先判断[start,nums.length-1]的最大金额是否已被计算好
     *                 若被计算好，直接返回该值，否则，在计算
     *    实现：使用数组memo[n]保存[start,nums.length-1]的最大金额
     * @param nums
     * @param start
     * @return
     */
    private int rob_better(int[] nums, int start) {
        if(start >= nums.length){
            return 0;
        }
        if(memo[start] == 0){
            int max = Integer.MIN_VALUE;
            for(int i=start;i<nums.length;i++){
                max= Math.max(max,nums[start]+rob(nums,start+2));
            }
            memo[start] = max;
        }
        return memo[start];
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
     *  memo就代表这递归法中的宏观语义
     *  memo[i] == [i,nums.length-1]个房间的最大金额
     *
     *   状态：f(0):[0,nums.length-1]个房间的最大金额
     *        对应计算机中表示：memo[0]：[0,nums.length-1]个房间的最大金额
     *   状态转移方程：递推公式
     *        f(0) = max{v[0]+f(2),v[1]+f(3),...v[n-2]+f(n),v[n-1]+f(n+1)=0}
     *        对应计算机中表示：memo[0]=max{v[0]+memo[2],v[1]+memo[3],...v[n-2]+memo[n],v[n-1]+memo[n+1]=0}
     *   初始状态：最后一个房子的最大金额就是该房子的金额
     *        f(n-1)=nums[n-1]--->memo[n-1]=nums[n-1]
     * @param nums
     * @return
     */
    public int rob_best(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        memo[n-1] = nums[n-1];//1规模的问题，根据上面的分析，[n-1,n-1]个房间的最大金额的就是nums[n-1]
        for(int i = n-2;i>=0;i--){//从下到上
            for(int j=i;j<nums.length;j++){//依次求解[i,n-1]个房间的最大金额
                memo[i]= Math.max(memo[i],nums[j]+(j+2<n?memo[j+2]:0));
            }
        }
        return memo[0];
    }
}
