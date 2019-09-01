package com.leetcode;

import java.util.TreeSet;

/*
        题目（220）：给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
                    使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，
                    并且 i 和 j 之间的差的绝对值最大为 ķ。
        示例：
            输入: nums = [1,2,3,1], k = 3, t = 0
            输出: true

            输入: nums = [1,5,9,1,5,9], k = 2, t = 3
            输出: false
 */
public class ContainsNearbyAlmostDuplicate {
    /**
     * 滑动窗口+查找表
     *  数组：        [1,2,3,1]
     *               | |     | |     nums[i]-nums[j]=0<=t；j-i=3<=k
     *   索引：      l i     j  l+k    i，j均在[l,l+k]
     *
     *   可以转化成： [  |    |     ||     ]
     *                  l    j   l+ki
     *   只要在[l，l+k]区间中找到nums[i]-t<nums[j]<nums[i]+t即可满足条件 |i-j|<=k
     *   这里就可以使用TreeSet，红黑树的有序性
     *    滑动规则：
     *          1.若查找区间[l,l+k]中存在nums[i],则满足条件，直接返回true
     *          2.若查找区间[l,l+k]中不存在nums[i]，则将nums[i]存入查找表
     *          3.维护查找区间[l,l+k]的长度，其长度超过k时，需要移首位元素，并且让窗口向前滑动
     * 时间复杂度：O(n*log(n))->n为数组的大小,log(n)为红黑树中查找的时间复杂度
      空间复杂度：O(k)->k为hash表的大小
     * @param nums      数组
     * @param k         索引之差最大值
     * @param t         数组元素之差最大值
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){//查找表条件
            //找到Tree中比nums[i]-t的值大，又比nums[i]+t的值小：即nums[i]-t<nums[j]<nums[i]+t
            //ceiling(i)方法：找到树中比元素i刚刚大的元素
            if(set.ceiling(((long)nums[i]-(long)t)) !=null &&
                    set.ceiling((long)nums[i]-(long)t) <= ((long)nums[i]+(long)t)){
                return true;
            }
            set.add((long)nums[i]);//滑动窗口扩大
            if(set.size() == k+1){
                set.remove((long)nums[i-k]);//维护滑动窗口的大小始终为k
            }
        }
        return false;
    }
}
