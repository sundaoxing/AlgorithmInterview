package com.leetcode.dynamicp;

import java.util.Arrays;
import java.util.Comparator;

/*
    题目（435）给定一个区间的集合，找到需要移除区间的最小数量
    使剩余区间互不重叠。
注意:
    可以认为区间的终点总是大于它的起点。
    区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
    示例：
    输入: [ [1,2], [2,3], [3,4], [1,3] ]
    输出: 1
    解释: 移除 [1,3] 后，剩下的区间没有重叠。

    输入: [ [1,2], [1,2], [1,2] ]
    输出: 2
    解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 */
public class NonOverlappingIntervals {
    /**
     * 动态规划法：类似最长上升子序列
     *      将原问题拆解成若干子问题，同时保存子问题的答案，
     *            使每个子问题只求解一次，最终得到原问题的解
     *   自下而上：先解决1规模的问题，在解决2规模的问题，最后解决n规模的问题
     *                       记忆化搜索：自上而下
     *                      /           |
     *              重叠子问题           |
     *   递归问题->                      |
     *              最优子结构           |
     *                      \           |
     *                       动态规划：自下而上
     *
     *   状态：f(i):以第intervals[0,...i]个区间能构成的最长不重叠区间序列的长度
     *        对应计算机中表示：memo[i]：以第intervals[0,...i]个区间能构成的最长不重叠区间序列的长度
     *   状态转移方程：递推公式
     *        f(i) =        max     (f(i),1+f(j))
     *    intervals[i].start >=intervals[j].end（不重叠）
     *        对应计算机中表示：
     *        memo[i]=       max     (memo[i],1+memo[j])
     *    intervals[i].start >=intervals[j].end（不重叠）
     *   初始状态：intervals区间中以intervals[i]开始并结尾的最长不重叠区间序列长度为：1
     *             每个区间的最长不重叠区间序列就是它本身，长度为1
     *        f(i)=1--->memo[i]=1
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length ==0){
            return 0;
        }
        /*
        为什么要排序？按序扫描后可以很方便判断区间之间是否重叠
            不连续的区间序列-》区间组合
        对区间进行排序：
            排序规则：[a,b] | [c,d]
            若区间起始点：a!=c     则比较区间起始点点：a和c的大小，将小的排在前面
            若区间起始点：a==c     则比较区间终止点：b和d的大小，将小的排在前面
            排序前：[ [1,2], [2,3], [3,4], [1,3] ]
            排序后：[ [1,2], [1,3], [2,3], [3,4] ]
         */
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0]<o2[0]?-1:1;
                }
                return o1[o1.length-1]<o2[o2.length-1]?-1:1;
            }
        });
        //存储第intervals[0,...i]个区间能构成的最长不重叠区间序列的长度
        int [] memo = new int[intervals.length];
        for(int i=0;i<memo.length;i++){//初始化
            memo[i]= 1;
        }
        for(int i=1;i<intervals.length;i++){
            for(int j=0;j<i;j++){
                //把区间小的放在前面，当前区间起始点>=区间终止点
                if(intervals[i][0] >=intervals[j][intervals[j].length-1]){
                    memo[i] =Math.max(memo[i],1+memo[j]);
                }
            }
        }
        //获取最长不重叠区间序列
        int res =0;
        for(int i=0;i<memo.length;i++){
            if(memo[i] >res){
                res = memo[i];
            }
        }
        return intervals.length-res;//要删除的区间个数
    }

    /**
     * 贪心法：
     *  按照区间的结尾排序
     *  每次选择区间结尾最小的，且和前一个区间不重叠的区间
     *  依次递推：
     *  直至没有区间
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals_better(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        /*
        排序规则：[a,b] | [c,d]
            若区间终止点：b!=d     则比较区间终止点：b和d的大小，将小的排在前面
            若区间起始点：b==d     则比较区间起始点：a和c的大小，将小的排在前面
            排序前：[ [1,2], [2,3], [3,4], [1,3] ]
            排序后：[ [1,2], [1,3], [2,3], [3,4] ]
         */
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[o1.length-1] != o2[o2.length-1]){
                    return o1[o1.length-1] < o2[o2.length-1]?-1:1;
                }
                return o1[0] < o2[0]?-1:1;
            }
        });

        /*
        仍然借鉴于最长上升公共子序列的思想：
            因为已经排好序了，从第一个区间开始找不重叠区间
            所以只需要做一次遍历即可
         */
        int res=1;//初始每个区间的最长不重叠区间序列就是它本身，长度为1
        int pre =0;//不重叠区间索引，初始考虑第0个区间
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] >= intervals[pre][intervals[pre].length-1]){
                res++;//考虑pre区间
                pre=i;//递推
            }
        }
        return intervals.length-res;
    }
}
