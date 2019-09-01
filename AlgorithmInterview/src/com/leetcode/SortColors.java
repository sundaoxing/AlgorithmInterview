package com.leetcode;

import com.util.Util;

/*
         题目（75）：给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
        使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
        此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
            示例:
                输入: [2,0,2,1,1,0]
                输出: [0,0,1,1,2,2]
 */
public class SortColors {
    /**
     * 方法一：计数法
     *      1.遍历nums数组，统计0，1，2的个数，存入count数组中
     *      2.遍历nums数组，按照count数组中0，1，2的个数，依次将0，1，2存入nums数组
     * 时间复杂度：O(n)
     * 空间复杂度：O(k)：k:count数组的长度：分类个数
     * @param nums      待排列数组
     */
    public void sortColors(int[] nums) {
        int [] count = {0,0,0};
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;//注意：巧妙使用了数组的索引
        }
        for(int i=0;i<nums.length;i++){
            if(i<count[0]){
                nums[i]=0;
            }
            if(i>=count[0] && i<count[0]+count[1]){
                nums[i]=1;
            }
            if(i>=count[0]+count[1]){
                nums[i]=2;
            }
        }
    }

    /**
     * 方法二：利用快速排序的三路快排思想
     *            [0..zero]==1   [zero+1.....i]==1   [two.....len-1]==2
     *  待排列数组       [0......0,1...X......,2.........2]
     *   数组索引       0        |     |       |           length-1
     *                         zero   i      two
     *  zero:代表0元素[0......zero]区间的右边界
     *  two: 代表2元素[two.......2]区间的左边界
     *  i:   代表1元素[zero+1....i]区间的右边界
     *      交换规则：
     *             1.若：X ==1    则：i++即可（代表1元素区间增大）
     *             2.若：X ==0    则：交换索引为(zero+1,i)的元素，此时nums[zero+1]==1,还需i++。zero++（代表0元素区间增大）
     *             3.若：X ==2    则：交换索引为(i,two-1)的元素,two--（代表2元素区间增大）
     *  时间复杂度：O(n)
     *  空间复杂度：O(1)
     * @param nums      待排列数组
     */
    public void sortColors_better(int[] nums) {
        int zero = -1;//初始时[0..zero]无效：此时zero必须==-1
        int two = nums.length;//初始时[two.....len-1]无效，此时two必须==nums.length
        int i=0;//初始时从nums数组0索引出开始遍历
        while(i<two){
            if(nums[i] ==1){
                i++;
            }
            else if(nums[i] ==0){
                zero++;
                Util.swap(nums,zero,i);
                i++;
            }
           else if(nums[i] ==2){
                two--;
                Util.swap(nums,two,i);
            }
        }
    }
}
