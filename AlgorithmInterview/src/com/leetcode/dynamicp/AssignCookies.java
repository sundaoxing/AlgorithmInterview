package com.leetcode.dynamicp;

import java.util.Arrays;

/*
题目（445）：假设你是一位很棒的家长，想要给你的孩子们一些小饼干。
但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi
这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 
如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

注意：
你可以假设胃口值为正。一个小朋友最多只能拥有一块饼干。

示例 1:
输入: [1,2,3], [1,1]
输出: 1
解释:
你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
所以你应该输出1。
 */
public class AssignCookies {
    /**
     * 贪心算法：
     *  思想：只考虑当前状态下的最优解，逐步递推
     *
     *  将最大尺寸的饼干分给胃口最大的孩子
     *      若最大尺寸仍不够，则分给胃口第二大的孩子
     *      若最大尺寸够了，则将第二大尺寸分为胃口第二大的孩子，依次递推
     *  直至，没有孩子或者没有饼干
     *
     *  难点：分析是否可以使用贪心算法
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);//孩子胃口值，从小到大排序
        Arrays.sort(s);//饼干大小值，从小到大排序
        int gi= g.length-1;//初始孩子胃口：最大胃口
        int si = s.length-1;//初始饼干大小：最大饼干
        int result =0;//初始满足条件数
        while(gi >=0 && si >=0){
            if(s[si]>=g[gi]){//满足孩子胃口
                result++;
                gi--;//下一个孩子胃口
                si--;//下一个饼干大小
            }else{//不满足孩子胃口
                gi--;//下一个孩子胃口
            }
        }
        return result;
    }
}
