package com.leetcode;

import java.util.HashMap;

/*
    题目（447）：给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，
        其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
        找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
    示例:
        输入:
        [[0,0],[1,0],[2,0]]
        输出:2
        解释:
        两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 */
public class NumberOfBoomerangs {
    /**
     * 查找法：灵活选择键值
     *                  hash表存储：         距离 ：个数（满足这个距离的点的个数）
     *                  point j       1距离    1 ：1   组合：0
     *              /
     *      point i ——  point k,m     2距离    2 ：2   组合：2X1=2
     *              \
     *                  point l,z,x   3距离    3 ：3   组合：3X2X1=6
     *  时间复杂度：O(n*n)->n=points.length
     * 空间复杂度：O(n*k)->hash表的大小
     * @param points    n个点的二维数组
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {
        int res =0;
        for(int i=0;i<points.length;i++){
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(i!= j){
                    int dist = dis(points[i],points[j]);
                    if(map.containsKey(dist)){
                        map.put(dist,map.get(dist)+1);
                    }else{
                        map.put(dist,1);
                    }
                }

            }
            for(Integer value :map.values()){
                res+= value*(value-1);
            }
        }
        return res;
    }

    /**
     * 求两个坐标间距离的平方：平方相等，则距离也相等
     * @param point     点
     * @param point1    点
     * @return
     */
    private int dis(int[] point, int[] point1) {
        return (point[0]-point1[0])*(point[0]-point1[0])+
                (point[1]-point1[1])*(point[1]-point1[1]);
    }
}
