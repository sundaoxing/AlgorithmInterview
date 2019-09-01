package com.leetcode;

import com.util.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

/*
    题目（279）：给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）
                使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
    示例：
        输入: n = 12
        输出: 3
        解释: 12 = 4 + 4 + 4.

        输入: n = 13
        输出: 2
        解释: 13 = 4 + 9.
 */
public class NumSquares {
    /**
     * 建模：将问题抽象成图论问题：最短路径（BFS广度优先遍历）
     *  借助队列QUEUE，实现广度优先遍历：先进先出
     *  1.从n到0，每个数字表示一个节点
     *  2.如果两个数字x和y相差一个完全平方数，则连接一条边
     *  3.由上得到一个无权图
     *  问题转化：求这个无权图中节点n（正整数）到节点0的最短路径（完全平方数个数）
     *                        4
     *                    1/    |
     *                   3      |4
     *                1 /       |
     *               2————1———— 0
     *                  1    1
     *       4 = 4              12=4+4+4
     *       4 = 1+1+1+1        12=9+1+1+1
     *  QUEUE队列：构建一个无权图：广度优先遍历：垂直走，而不是水平走
     *  12，0：
     *        11，1：
     *              10，2：
     *                    9，3
     *                    6，3
     *                    1，3
     *              7，2：
     *                    6，3
     *                    3，3
     *                    1，3
     *              2，2：
     *                    1，3
     *        8，1：
     *              7，2：
     *                    6，3
     *                    3，3
     *                    1，3
     *              4，2：
     *                    3，3
     *                    0，3
     *        3，1：
     *              2，2
     *
     *
     * 时间复杂度：O(k*m)
     * 空间复杂度：O(n+k)
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if(n<=0){
            return 0;
        }
        /*
            处理图中节点冗余推入队列中：
                使用[n+1]的数组（从0到n个节点），有没有被访问过
         */
        boolean[] visited=new boolean[n+1];
        //Pair类：存储图中节点信息：节点值：n到该节点的路径长
        Queue<Pair<Integer,Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(n,0));//初始化
        visited[n]=true;
        while(!queue.isEmpty()){
            Pair<Integer,Integer> pair = queue.poll();
            int num = pair.k;
            int step = pair.v;
            for(int i=1;;i++){
                int a =num - i*i;//num是由各个完全平方数相加的到，一个一个减去后，为0，即可找到路径
                if(a <0){//代表此节点没有路径
                    break;
                }
                if(a ==0){//找到了到达0节点的路径
                    return step+1;//路径步数+1，即是n到达0节点的路径长度
                }
                if(!visited[a]){//该节点没有被访问过，才推入队列
                    queue.offer(new Pair<>(a,step+1));
                    visited[a]=true;
                }
            }
        }
        throw new RuntimeException("非法参数");
    }
}