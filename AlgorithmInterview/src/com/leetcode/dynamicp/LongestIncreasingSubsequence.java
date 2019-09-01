package com.leetcode.dynamicp;
/*
    题目（300）：
        给定一个无序的整数数组，找到其中最长上升子序列的长度。
    示例：
        输入: [10,9,2,5,3,7,101,18]
        输出: 4
        解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
    说明：
        可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
        你算法的时间复杂度应该为 O(n2)
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        /*
        遍历nums数组中每一个元素，获取以每个元素为结尾的最长上升子序列的长度
         */
        for(int i=nums.length-1; i>=0;i--){
            max=Math.max(max,lengthOfLIS(nums,i));
        }
        return max;
    }

    /**
     * 如何将上诉问题：无序的整数数组中，以第nums[i]为结尾的最长上升子序列的长度-转化成下列的树形结构问题？
     *  假设法：本质上还是穷举法
     *     假设以第nums[i]为结尾：
     *         从头遍历nums数组
     *         判断nums[j] 是否< nums[i]
     *            是：则说明nums[j]是以第nums[i]为结尾的最长上升子序列中一员
     *                然后以第nums[j]为结尾：继续迭代
     *                .....
     *                直到j==0,此时数组只有一个元素，其最长上升子序列的长度为1，就是他自己
     *            否：继续遍历nums数组的下一个元素
     *
     *递归法：-》类树形结构
     *                       [10,9,2,5]----->以5为结尾的最长上升子序列的长度：2
     *                  10/      9|      2\
     *                  跳过     跳过      [10,9,2]----->以2为结尾的最长上升子序列的长度
     *                                   10/   9\
     *                                 跳过    跳过
     *                                 此时，以2为结尾的最长上升子序列的长度为：1
     *
     * 宏观语义：无序的整数数组nums中，以第nums[i]为结尾的最长上升子序列的长度
     *          最长：每次获得长度都要进行比较，取最大
     *          上升：nums[0,i]中，必须满足nums[j]<nums[i]
     *          连续：
     * 递归思想：
     *      递归方法：int lengthOfLIS(int[] nums, int i)
     *      递归终止条件：递归到i==0,此时，数组只有一个元素
     *          其最长上升子序列的长度为1，就是他自己
     *      递归公式：
     *           lengthOfLIS(nums,j)
     *           j：比nums[i]小的元素索引
     * 时间复杂度：O(i*j)
     * 空间复杂度：O(n)
     * @param nums
     * @param i
     * @return
     */
    private int lengthOfLIS(int[] nums, int i) {
        if(i == 0){//递归终止条件
            return 1;
        }
        int max = 1;
        for(int j=0;j<=i;j++){
            if(nums[j]<nums[i]){
                max =Math.max(max,1+lengthOfLIS(nums,j));
            }
        }
        return max;
    }

    /**
     * 记忆化搜索--》将递归法中重复分割的部分进行保存，只计算一次
     *    自上而下：先解决n规模的问题，在解决n-1规模的问题，最后解决1规模的问题
     *           思想：使用额外的空间保存以第nums[i]为结尾的最长上升子序列的长度
     *                 下次使用时，先判断以第nums[i]为结尾的最长上升子序列长度是否已被计算好
     *                 若被计算好，直接返回该值，否则，在计算
     *    实现：使用数组memo[i]保存以第nums[i]为结尾的最长上升子序列的长度
     */
    private int [] memo;
    public int lengthOfLIS_better(int[] nums) {
        memo = new int[nums.length];//初始化memo数组元素都是0
        int max = 0;
        for(int i=nums.length-1; i>=0;i--){
            max=Math.max(max,lengthOfLIS_better(nums,i));
        }
        return max;
    }

    private int lengthOfLIS_better(int[] nums, int i) {
        if(i == 0){
            return 1;
        }
        if(memo[i] ==0){
            int max = 1;
            for(int j=0;j<=i;j++){
                if(nums[j]<nums[i]){
                    max =Math.max(max,1+lengthOfLIS_better(nums,j));
                }
            }
            memo[i] = max;
        }

        return memo[i];
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
     *   状态：f(i):以第nums[i]为结尾的最长上升子序列的长度
     *        对应计算机中表示：memo[i]：以第nums[i]为结尾的最长上升子序列的长度
     *   状态转移方程：递推公式
     *        f(i) =        max     (f(i),1+f(j))
     *               nums[j]<nums[i]
     *        对应计算机中表示：
     *        memo[i]=       max     (memo[i],1+memo[j])
     *               nums[j]<nums[i]
     *   初始状态：nums数组中以nums[i]开始并结尾的最长上升子序列的长度为：1
     *             每个元素的最长上升子序列就是它本身，长度为1
     *        f(i)=1--->memo[i]=1
     * @param nums
     * @return
     */
    public int lengthOfLIS_best(int[] nums) {
        memo = new int[nums.length];
        for(int i=0;i<memo.length;i++){
            memo[i]=1;
        }
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    memo[i] = Math.max(memo[i],1+memo[j]);
                }
            }
        }
        //比较memo中的最大值，就是无序的整数数组中最长上升子序列的长度
        int max =0;
        for(int i=0;i<memo.length;i++){
            if(memo[i] >max){
                max=memo[i];
            }
        }
        return max;
    }
}
