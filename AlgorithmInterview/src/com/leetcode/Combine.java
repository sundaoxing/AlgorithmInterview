package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    题目（77）：给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
    示例:
        输入: n = 4, k = 2
        输出:
        [
          [2,4],
          [3,4],
          [2,3],
          [1,2],
          [1,3],
          [1,4],
        ]
 */
public class Combine {
    List<List<Integer>> lists;

    /**
     * 组合C（n，k）：递归法：回溯思想；遍历每一种可能
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        lists = new ArrayList<>();
        if(n<=0 || k<=0 || k>n){
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        findCombination(n,k,1,list);//
        return lists;
    }

    /**
     * 类树形结构：
     *            [1,          2,             3,            4]取2个数
     *            1|          2|              3|           4|
     *      [2,3,4]取1个数   [3,4]取1个数    [4]取1个数     []取1个数
     *   2/   3|   4\      3/   4\          4|
     *  1,2  1,3   1,4    2,3    2,4        3,4
     *
     *   [1，2，3，4]组合：元素两两组合在一起，1，2和2，1是一样的
     *
     *  [1,2,3,4] :
     *    1           2,3,4     ->
     *                              1,2
     *                              1,3
     *                              1,4
     *    2           3,4       ->
     *                              2,3
     *                              2,4
     *    3           4         ->
     *                              3,4
     *    4           没有了
     *
     * 宏观语义：寻找数字的组合list
     *          list:当前数字，上一个数字...第一个数字（共k个数字）的一种组合
     * 递归思想：
     *      递归方法：void findCombination(int n, int k,int start, List<Integer> list)
     *      递归终止条件：递归到list中数字个数==k：即k == list.size
     *          此时，list中为当前数字，和上一个数字...到第一个数字（共k个数字），的一种组合
     *      递归公式：
     *           findCombination(n,k,i+1,list);
     *           i+1：数字迭代，遍历n元素
     *           list：当前数字，和上一个数字...到第一个数字（共k个数字），的一种组合
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(k)
     * @param n             整数n
     * @param k             整数k
     * @param start         下一次开始的元素
     * @param list          元素组合的list集合
     */
    private void findCombination(int n, int k,int start, List<Integer> list) {
        if(list.size() == k){//已经取到k个数字，返回当前数字组合
            lists.add(new ArrayList<>(list));
            return;
        }
        /*
            组合是依次向后递增选择，所以要从start开始
            上一个选择过后，就不能在选择了
         */
        for(int i=start;i<=n;i++){
            list.add(i);
            findCombination(n,k,i+1,list);
            /*
                回溯：撤销现在选择的这个数字
                list中移除刚选择的数字，回到上一步没选择之前
             */
            list.remove(list.size()-1);
        }
        return;
    }

    /*
        对上面进行优化：回溯法：剪枝
        对不必要的方法解，进行舍弃
     */
    private void findCombination_better(int n, int k,int start, List<Integer> list) {
        if(list.size() == k){//已经取到k个数字，返回当前数字组合
            lists.add(new ArrayList<>(list));
            return;
        }
        /*
            组合是依次向后递增选择，所以要从start开始
            上一个选择过后，就不能在选择了
            注意：在这里是从start到n[start,n]区间都遍历了，但是
            没有必要遍历到n，因为有的元素组合会在前面重复
            到这一步，已经找到了list.size个元素的一个组合
            还有k-list.size个空位，也就是从[i,n]中还需要选择k-list.size个元素
            n-i >= k-list.size =》 i <=   n-(k-list.size)+1
         */
        for(int i=start;i<=n-(k-list.size())+1;i++){
            list.add(i);
            findCombination(n,k,i+1,list);
            /*
                回溯：撤销现在选择的这个数字
                list中移除刚选择的数字，回到上一步没选择之前
             */
            list.remove(list.size()-1);
        }
        return;
    }
}
