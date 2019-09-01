package com.leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
        题目（349）：给定两个数组，编写一个函数来计算它们的交集。
        说明：
            1.输出结果中的每个元素一定是唯一的。
            2.我们可以不考虑输出结果的顺序。
        示例 1:
            输入: nums1 = [1,2,2,1], nums2 = [2,2]
            输出: [2]
 */
public class Intersection {
    /**
     * 利用Set集合的去重性，交集没有重复元素
     * @param nums1     数组
     * @param nums2     数组
     * @return
     */
    public Set<Integer> intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        for(int i=0 ;i< nums1.length;i++){
            s.add(nums1[i]);
        }
        Set<Integer> s1 = new HashSet<>();
        for(int i=0 ;i< nums2.length;i++){
           if(s.contains(nums2[i])){
               s1.add(nums2[i]);
           }
        }
        return s1;
    }

    /**
     * 利用Map保存重复元素
     *      给定两个数组，编写一个函数来计算它们的交集。交集可以有重复元素
     * @param nums1     数组
     * @param nums2     数组
     * @return
     */
    public ArrayList<Integer> intersection_map(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ;i< nums1.length;i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i])+1);
            }else{
                map.put(nums1[i],1);
            }
        }
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0 ;i< nums2.length;i++){
            if(map.containsKey(nums2[i])){
                a.add(nums2[i]);
                map.put(nums1[i],map.get(nums1[i])-1);
            }
        }
        return a;
    }
}
