package com.leetcode;

import com.util.Util;

import java.util.ArrayList;

/*
         题目（283）：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
        同时保持非零元素的相对顺序。
        示例:
            输入: [0,1,0,3,12]
            输出: [1,3,12,0,0]
 */
public class MoveZeroes {
    /**
     * 方法一：借助集合ArrayList
     *      1.将nums数组中所有不为0的数按照遍历顺序依次存入ArrayList集合中
     *      2.遍历ArrayList集合，将集合中数依次存入nums数组中
     *      3.将nums数组中后面所有数统一赋值为0
     *  时间复杂度：O(n)
     *  空间复杂度：O(n)
     * @param nums      待移动数组
     */
    public void moveZeroes(int [] nums){
        ArrayList<Integer> temp = new ArrayList<>(nums.length);
        for(int i=0; i<nums.length;i++){
            if(nums[i] !=0){
                temp.add(nums[i]);
            }
        }
        for(int i = 0;i<temp.size();i++){
            nums[i]=temp.get(i);
        }
        for(int i= temp.size();i<nums.length;i++){
            nums[i]=0;
        }
    }

    /**
     * 方法二：借助临时变量k
     *      1.临时变量k：表示[0,k)非0区间的右边界索引
     *      2.遍历nums数组，遍历索引为i
     *          当前元素==0：i++：跳过，到下一个元素
     *          当前元素!=0：将当前元素赋值到k索引的位置，k++:非0区间增大
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums      待移动数组
     */
    public void moveZeroes_better(int [] nums){
        int k=0;//nums数组中，[0,k)区间元素均为非0元素
        for(int i=0;i<nums.length;i++){
            if(nums[i] !=0){
                nums[k]=nums[i];
                k++;
            }
        }
        for(int j=k;j<nums.length;j++){
            nums[j]=0;
        }
    }

    /**
     * 方法三：在方法二上优化：使用交换Swap(),不需要最后再统一赋值0
     *      1.临时变量k：表示[0,k)非0区间的右边界索引
     *      2.遍历nums数组，遍历索引为i
     *          当前元素==0：i++：跳过，到下一个元素
     *          当前元素!=0：将当前元素与k索引元素交换，k++:非0区间增大
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums      待移动数组
     */
    public void moveZeroes_best(int [] nums){
        int k=0;//nums数组中，[0,k)区间元素均为非0元素
        for(int i=0;i<nums.length;i++){
            if(nums[i] !=0){
                if(i!=k){//只有当i!=k才交换元素：自己和自己不需要交换
                     Util.swap(nums,i,k);
                }
                k++;
            }
        }
    }
}
