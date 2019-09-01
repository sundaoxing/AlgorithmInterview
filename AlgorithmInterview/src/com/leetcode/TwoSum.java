package com.leetcode;

import java.util.HashMap;

/*
         题目（1）：给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
        函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
            示例:
                输入: numbers = [2, 7, 11, 15], target = 9
                输出: [1,2]
                解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class TwoSum {
    /**
     * 指针碰撞法
     *              nums[i]+nums[j] ? target
     *  有序数组        [2,7,11,15,14,23,41,55]
     *                  |                |
     *  碰撞指针（索引） i                j
     *      移动规则：
     *          1.若nums[i]+nums[j] == target    则找到这两个数，返回其索引
     *          2.若nums[i]+nums[j] > target     则j--:减少nums[i]+nums[j]的和
     *          3.若nums[i]+nums[j] < target     则i++:增大nums[i]+nums[j]的和
     * 时间复杂度：O(n)
     * 空间复杂度：O(k)->k为数组result长度
     * @param nums      有序数组
     * @param target    目标数
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int [] result ={0,0};
        int i=0;//初始指针在数组最左边界
        int j=nums.length-1;//初始指针在数组最右边界
        while(i<j){
            if(nums[i] +nums[j] == target){
                result[0]=i;
                result[1]=j;
                return result;
            }
            else if(nums[i] +nums[j] < target){
                i++;
            }
            else {//nums[i] +nums[j] > target
                j--;
            }
        }
        return result;
    }

    /**
     * 题目(1)：将有序数组改为无序数组
     *      无序数组：   [2, 7, 11, 15,3,2,6,7]
     *                          |
     *      索引：              i
     *      查找法：hash表中存储[0,i]的子数组
     *      每次都从hash表中查询target-nums[i]是否存在
     *          若存在，    则保存其索引
     *          若不存在，  则将其加入hash表中
     * 时间复杂度：O(n)
     * 空间复杂度：O(k)->k为数组result长度
     * @param nums          无序数组
     * @param target        目标值
     * @return
     */
    public int[] twoSum_un(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int [] result = {0,0};
        for(int i=0;i<nums.length;i++){
            int temp = target-nums[i];
            if(map.containsKey(temp)){
                result[0]=map.get(temp);
                result[1]=i;
                return result;
            }else{
                map.put(nums[i],i);
            }
        }
        return result;
    }
}
