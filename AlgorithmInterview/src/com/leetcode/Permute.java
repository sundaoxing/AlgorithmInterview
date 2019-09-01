package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    题目（46）：给定一个没有重复数字的序列，返回其所有可能的全排列。
    示例：
        输入: [1,2,3]
        输出:
        [
          [1,2,3],
          [1,3,2],
          [2,1,3],
          [2,3,1],
          [3,1,2],
          [3,2,1]
        ]
 */
public class Permute {
    List<List<Integer>> lists;
    boolean [] used;//标记数组，used[i]标记nums[i]元素是否被使用过

    /**
     * 全排列A（n，n）：递归法：回溯思想；遍历每一种可能
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        lists = new ArrayList<>();
        if(nums == null || nums.length ==0){
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        used = new boolean [nums.length];
        findCombination(nums,0,list);//初始值：数组[1,2,3]，当前数字1，组合为空
        return lists;
    }

    /** 类树形结构：
     *                          nums[1,2,3]
     *              1/               2|              3\
     *         nums[2,3]         nums[1,3]           nums[1,2]
     *     2/         3\       1/         3\       1/        2\
     *nums[3]     nums[2]  nums[3]     nums[1]  nums[2]     nums[1]
     *    3|         2|        3|         1|        |2         2|
     *   1,2,3      1,3,2     2,1,3     2,3,1     3,1,2       3,2,1
     *
     *   nums[2,3]实际上还是nums[1,2,3]，因为使用了user[boolean]标记数组
     *   在逻辑上将当前元素从数组中删除，防止数字重复排列
     *
     *nums[1,2,3] :
     *    1           nums[2,3] :
     *                              nums[3] ->    1,2,3
     *                              nums[2] ->    1,3,2
     *    2          nums[1,3] :
     *                              nums[3] ->    2,1,3
     *                              nums[1] ->    2,3,1
     *    3           nums[1,2] :
     *                              nums[2] ->    3,1,2
     *                              nums[1] ->    3,2,1
     * 宏观语义：寻找数字的排列list
     *          list:当前数字，和上一个数字...到第一个数字List集合
     *          组合：数字的全排列
     * 递归思想：
     *      递归方法：void findCombination(int[] nums, int index, List<Integer> list)
     *      递归终止条件：递归到nums的最后数字的下一次：即i == nums.length
     *          此时，list中为当前数字，和上一个数字...到第一个数字，的一种排列
     *      递归公式：
     *          findCombination(nums,index+1,list);
     *           i+1：数字迭代，遍历nums数组的元素
     *           list：当前数字，和上一个数字...到第一个数字，的一种排列
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(k)
     * @param nums          数字数组
     * @param index         当前数字索引
     * @param list          index个数字的排列
     */
    private void findCombination(int[] nums, int index, List<Integer> list){
        if(index == nums.length){//此时nums数组遍历完，找到一种排列方式
            /*
                注意：：：不能写为lists.add(list)
                因为：java中引用类型，传递的都是地址值（指向数据保存的内存地址）
                下面会list.remove(list.size()-1);删除数组尾部数字，
                也会把相应的引用置空，导致lists里保存的数据为空
             */
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            /*
                全排列需要去重，不让它自己与自己重复排列
                所以需要判断nums[i]是否在list集合中
                若循环遍历一遍太耗时
                所以使用used[i]表示nums[i]是否被使用
             */
            if(!used[i]){
                list.add(nums[i]);
                used[i]=true;//标记为已使用
                //递归本身就有回溯的作用，但其他变量也可能要恢复到上一步
                findCombination(nums,index+1,list);
                /*
                    回溯：把当前这一步操作撤销
                    1.剔除当前元素，此时，当前元素就是list的尾元素
                    2.当前元素要重新可以被使用，标记为未使用
                 */
                list.remove(list.size()-1);
                used[i]=false;
            }
        }
        return;
    }
}
