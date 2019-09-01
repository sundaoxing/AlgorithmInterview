package com.leetcode;

import com.util.Pair;

import java.util.*;

/*
        题目（347）：给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
        示例：
            输入: nums = [1,1,1,2,2,3], k = 2
            输出: [1,2]

            输入: nums = [1], k = 1
            输出: [1]
 */
public class TopKFrequent {
    /**
     * 优先队列的使用：PriorityQueue：底层是最小堆
     *  思想： 1.统计数组中每个元素的频率map<元素，频率>
     *        2.遍历map，将map中的k个元素直接存入优先队列
     *        3.余下的map：
     *                  若当前元素的频率>优先队列的队首（最小堆的队头：频率最小值），则队首出队，该元素入队
     * 时间复杂度：O(nlog(k))
     * 空间复杂度：O(m+k+k)
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        //统计数组中每个元素的频率map<元素，频率>
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        //Pair<Integer,Integer>：<频率，元素>，在优先队列中按照频率的大小排列
        PriorityQueue<Pair<Integer,Integer>>queue = new PriorityQueue<>(k);
        for(Integer key : map.keySet()){
            if(queue.size() == k){
                //当前元素的频率>优先队列的队首的频率
                if(map.get(key) > queue.peek().k){
                    queue.poll();
                    queue.offer(new Pair<>(map.get(key),key));
                }
            }else{
                queue.offer(new Pair<>(map.get(key),key));
            }
        }
        //此时优先队列中的元素就是频率前 k 高的元素
        while(!queue.isEmpty()){
            list.add(queue.poll().v);
        }
        return list;
    }
}

