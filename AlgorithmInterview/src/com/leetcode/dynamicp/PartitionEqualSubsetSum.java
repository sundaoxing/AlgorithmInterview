package com.leetcode.dynamicp;
/*
        给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，
        使得两个子集的元素和相等。
        注意:
        每个数组中的元素不会超过 100
        数组的大小不会超过 200
        示例：
    输入: [1, 5, 11, 5]
    输出: true
    解释: 数组可以分割成 [1, 5, 5] 和 [11].
 */
public class PartitionEqualSubsetSum {
    /**
     *是否可以将这个数组分割成两个子集，使得两个子集的元素和相等----->这个问题
     * 本质上还是在这个数组里选择i个元素，使其和为数组总和的一半
     * sum{nums[i],..nums[n-i]} = sum{nums[0],...nums[n-1]}/2
     * 即：在nums数组中选择i个物品，每个物品的重量为nums[i]的数值大小，
     * 将其完全填充到容量为sum/2的背包中-------转换成背包问题
     *
     * 是：可以完全填充到背包中
     * 否，填充不满背包/物品不够
     */
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];//数组元素总和
        }
        if(sum %2 !=0){//两个相等子集，则要求其总和必须可以2分
            return false;
        }
        return canPartition(nums,nums.length-1,sum/2);
    }

     /**
     * 如何将上诉问题：完全装入背包-转化成下列的树形结构问题？
     *  假设法：本质上还是穷举法
     *    对于[0,n-1]个物品,装入容量为c的背包来说：
     *      不考虑第n-1位数：
     *          若[0,n-2]个物品完全装满容量c的背包，则表示可以将数组分成两个和相等的子集
      *         否则，不可以
     *      考虑第n-1位商品：
     *          若[0,n-2]个物品完全装满容量c-w[n-1]的背包，则表示可以将数组分成两个和相等的子集
      *         否则，不可以
     *      ....
     *    逐步递推：直到没有物品或者背包容量小于当前物品的重量
     *       则表示不可以将数组分成两个和相等的子集
     *递归法：-》类树形结构
     *                       重量  1，5，11，5
     *                            [0，1，2，3]c=11------->用0，1，2号物品完全装满容量为c的背包
     *                    不考虑3/               \考虑3
     *                   [0,1,2]c=11              nums[3],c=6
     *            不考虑2/          \考虑2        不考虑2/\考虑2
     *          [0,1]c=11            nums[2],c=0     ....
     *   不考虑1/      \考虑1
     *   [0]c=11      nums[1],c=6       ------大量重复考虑计算
      不考虑0/ \考虑0  不考虑0/ \考虑0
        []空  nums[0],c=10
     * 宏观语义：用[0,index]个物品填充容量为c的背包的最大价值
     *
     * 递归思想：
     *      递归方法：int backPack01(int[] w,int[] v ,int index, int c)
     *      递归终止条件：
     *          1.没有物品了:index<0
     *          2.容量不够了：c<=0
     *          对应的最大价值=0
     *      递归公式：
     *           backPack01(w,v,index-1,c)：
     *              不考虑第index位物品：最大价值=[0,index-1]个物品填充容量为c的背包的最大价值
     *           backPack01(w,v,index-1,c-w[index])：
     *              考虑第index位物品：最大价值=max(不考虑第index位物品,v[index]+用[0,index-1]个物品填充容量为c-w[index]的背包的最大价值
     * @param nums
     * @param index
     * @param sum
     * @return
     */
    private boolean canPartition(int[] nums, int index,int sum) {
        if(sum ==0){
            return true;
        }
        if(sum <0 || index <0){
            return false;
        }
        return canPartition(nums,index-1,sum) || canPartition(nums,index-1,sum-nums[index]);
    }

    /**
     * 记忆化搜索--》将递归法中重复分割的部分进行保存，只计算一次
     *    自上而下：先解决n规模的问题，在解决n-1规模的问题，最后解决1规模的问题
     *           思想：使用额外的空间保存用[0,index]个物品填充容量为c的背包的最大价值
     *                 下次使用时，先判断用[0,index]个物品填充容量为c的背包的最大价值是否已被计算好
     *                 若被计算好，直接返回该值，否则，在计算
     *    实现：使用数组memo[index][c]保存用[0,index]个物品是否可以完全装满容量为c的背包
     *    memo[index][c] =0 : 表示没有计算
     *    memo[index][c] =1 : 表示可以装满
     *    memo[index][c] =-1 : 表示不能装满
     *
     *
     */
    private int [][] memo;
    public boolean canPartition_better(int [] nums){
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2 !=0){
            return false;
        }
        memo = new int[nums.length][sum+1];
        return canPartition_better(nums,nums.length-1,sum/2);
    }

    private boolean canPartition_better(int[] nums, int index, int sum) {
        if(sum == 0){
            return true;
        }
        if(sum <0 || index <0){
            return false;
        }

        if(memo[index][sum] ==0){
            boolean result = canPartition_better(nums, index-1, sum) || canPartition_better(nums, index-1, sum-nums[index]);
            if(result){
                memo[index][sum] =1;
            }else{
                memo[index][sum] =-1;
            }
        }
        return memo[index][sum]==1;
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
     *  memo[i][j]保存用[0,i]个物品是否可以装满容量为j的背包
     *
     *   状态：f(n-1,c):[0,n-1]个物品是否可以装满容量为c的背包
     *        对应计算机中表示：memo[n-1][c]：[0,n-1]个物品是否可以装满容量为c的背包
     *   状态转移方程：递推公式
     *        f(n-1,c) ={
     *           f(n-2,c)  ||
     *           f(n-2,c-w[n-1]))
     *        }
     *        对应计算机中表示：
     *        memo[n-1][c] = {
     *            memo[n-2][c]   ||
     *            memo[n-2][c-w[n-1]])
     *        }
     *   初始状态：用第0位物品是否完全装满容量为j的背包
     *        f(0)=v[0]--->memo[0][j]= j==nums[0]
     */
    private boolean [] memo_b;
    public boolean canPartition_best(int [] nums){
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2 !=0){
            return false;
        }
        int n = nums.length;
        int c = sum/2;
        memo_b = new boolean[c+1];
        for(int i=0;i<c+1;i++){
            memo_b[i] = (i == nums[0]);
        }
        for(int i=1;i<n;i++){
            for(int j=c;j>=nums[i];j--){
                memo_b[j] = memo_b[j] || memo_b[j-nums[i]];
            }
        }
        return memo_b[c];
    }
}
