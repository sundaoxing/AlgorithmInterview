package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
        题目（209）：给定一个含有 n 个正整数的数组和一个正整数 s ，
        找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
        如果不存在符合条件的连续子数组，返回 0。
        示例：
            输入: s = 7, nums = [2,3,1,2,4,3]
            输出: 2
            解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class MinSubArrayLen {
    /**
     * 双索引法（移动窗口）
     *   数组             [2,3,1,2,4,3,3,5,2,7]
     *                    | |
     *   索引：           i j
     *      滑动窗口：[i,j]
     *      移动规则：
     *          1.若sum[i,j] >=s     则找到满足条件的子数组，保存子数组长度，i++，看看是否有更短的子数组
     *          2.若sum[i,j] <s      则当前子数组的元素和小于s，需要j++，增大子数组
     * 时间复杂度：O(k*log(k)) k:结果集result的长度
     * 空间复杂度：O(k)
     * @param s         目标和
     * @param nums      数组
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int i=0;
        int j=-1;//初始滑动窗口无效[i,j]:闭区间
        ArrayList<Integer> result = new ArrayList<>();
        while(i< nums.length && j<nums.length){
            int sum = this.sumArray(nums,i,j);
            if(sum >= s){
                result.add(j-i+1);//j-i+1：滑动窗口长度
                i++;
            }else {
                j++;
            }
        }
        Collections.sort(result);//对结果集排序（升序）
        return result.get(0);
    }

    /**
     * 求和：对数组nums从下标索引i到j，累加求和
     * @param nums      待求和数组
     * @param i         起始索引
     * @param j         结束索引
     * @return
     */
    private int sumArray(int[] nums, int i, int j) {
        int sum=0;
        for(int k=i;k<=j;k++){
            sum+=nums[k];
        }
        return sum;
    }

    /**
     * 双索引法（移动窗口）
     *   数组             [2,3,1,2,4,3,3,5,2,7]
     *                    | |
     *   索引：           i j
     *       滑动窗口：[i,j]
     *      移动规则：
     *          1.若sum[i,j] >=s     则找到满足条件的子数组，子数组和需要更新，i++，看看是否有更短的子数组
     *          2.若sum[i,j] <s      则当前子数组的元素和小于s，需要j++，增大子数组
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param s         目标和
     * @param nums      数组
     * @return
     */
    public int minSubArrayLen_better(int s, int[] nums) {
        int i=0;
        int j=-1;//初始滑动窗口无效[i,j]:闭区间
        int sum=0;//滑动窗口所有元素的和
        int result = nums.length+1;//初始滑动窗口的长度：保存的是滑动窗口长度的最小值
        while(i<nums.length){
            if(sum < s && j+1 <nums.length){//j+1：防止数组索引越界
                j++;
                sum+=nums[j];//累加：增大子数组
            }else{
                sum-=nums[i];//更新子数组的和，看看有没有更短的子数组
                i++;
            }
            //与上面else{}，不可合并，因为这里只是单纯判断sum和s的大小关系，
            // 以维持滑动窗口的最小长度，不涉及到索引j的越界
            if(sum >=s){
                result = Math.min(result,j-i+1);
            }
        }
        if(result == nums.length+1){
            return 0;
        }
        return result;
    }

}
