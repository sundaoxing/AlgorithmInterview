package com.leetcode;

import java.util.HashMap;

/*
   题目（454）：给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，
        使得 A[i] + B[j] + C[k] + D[l] = 0。为了使问题简单化，所有的 A, B, C, D
        具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
   例如:
        输入:
        A = [ 1, 2]，B = [-2,-1]，C = [-1, 2]，D = [ 0, 2]
        输出:2
        解释:
        两个元组如下:
        1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
        2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class FourSumCount {
    /**
     * 查找法：利用hash表的高效查找特性
     *      思想：1.两个for循环将A+B数组的组合结果存储在hash表中，构造查找表，键key相同则value值+1
     *           2.两个for循环依次遍历C+D数组的组合，在其中查找C[k] + D[l] = -（A[i]+B[j]）
     *           3.将满足条件的结果累加
     * 时间复杂度：O(n*n)->n为数组的大小
     * 空间复杂度：O(k)->k为hash表的大小
     * @param A     数组
     * @param B     数组
     * @param C     数组
     * @param D     数组
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(map.containsKey(A[i]+B[j])){
                    map.put(A[i]+B[j],map.get(A[i]+B[j])+1);
                }else {
                    map.put(A[i]+B[j],1);
                }
            }
        }
        int res=0;
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                if(map.containsKey(0-C[i]-D[j])){
                    res+=map.get(0-C[i]-D[j]);
                }
            }
        }
        return res;
    }
}
