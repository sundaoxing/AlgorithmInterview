package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
    题目（219）：给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
                使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
      示例：
        输入: nums = [1,2,3,1], k = 3
        输出: true

        输入: nums = [1,2,3,1,2,3], k = 2
        输出: false
 */
public class ContainsNearbyDuplicate {
    /**
     * 滑动窗口+查找表
     *   数组：        [1,2,3,1]
     *               | |     | |     nums [i] = nums [j]；j-i=3<=k
     *   索引：      l i     j  l+k    i，j均在[l,l+k]
     *
     *   可以转化成： [  |    |     ||     ]
     *                  l    j   l+ki
     *   只要在[l，l+k]区间中找到nums[j] == nums[i]即可满足条件 |i-j|<=3
     *    滑动规则：
     *          1.若查找区间[l,l+k]中存在nums[i],则满足条件，直接返回true
     *          2.若查找区间[l,l+k]中不存在nums[i]，则将nums[i]存入查找表
     *          3.维护查找区间[l,l+k]的长度，其长度超过k时，需要移首位元素，并且让窗口向前滑动
     *  时间复杂度：O(n)->n为数组的大小
     * 空间复杂度：O(k)->k为hash表的大小
     * @param nums      数组
     * @param k         索引之差最大值
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l=0;
        int r=k;
        //使用hashSet模拟查找表
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){//查找表条件
                return true;
            }else{
                set.add(nums[i]);//滑动窗口扩大
                if(i >= r){
                    set.remove(nums[l]);//维护滑动窗口的大小始终为k
                    l++;//窗口向前滑动
                    r++;
                }
            }
        }
        return false;
    }

    /**
     * 在上一方法中优化：不必关注滑动窗口的左右边界，只要保持其大小为k就可以
     * 时间复杂度：O(n)->n为数组的大小
     * 空间复杂度：O(k)->k为hash表的大小
     * @param nums      数组
     * @param k        索引之差最大值
     * @return
     */
    public boolean containsNearbyDuplicate_better(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){//查找表条件
                return true;
            }
            set.add(nums[i]);//滑动窗口扩大
            if(set.size() == k+1){
                set.remove(nums[i-k]);//维护滑动窗口的大小始终为k
            }
        }
        return false;
    }
}
