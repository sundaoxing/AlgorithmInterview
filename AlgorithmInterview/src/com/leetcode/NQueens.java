package com.leetcode;

import java.util.ArrayList;
import java.util.List;
/*
        题目（51）：n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，
                   并且使皇后彼此之间不能相互攻击。
        说明：给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
              每一种解法包含一个明确的 n 皇后问题的棋子放置方案，
              该方案中 'Q' 和 '.' 分别代表了皇后和空位。
        示例：
            输入: 4
            输出: [
             [".Q..",  // 解法 1          ["..Q.",  // 解法 2
              "...Q",                     "Q...",
              "Q...",                     "...Q",
              "..Q."],                    ".Q.."]
                                                            ]
           解释: 4 皇后问题存在两个不同的解法。
 */
public class NQueens {
    List<List<String>> lists;

    /*
        辅助数组：快速判断横，竖，对角线方向是否同时出现2个皇后
        竖方向：列方向：col[]-> col[i]：表示i列已经被占用了
       0,0   0,1   0,2   0,3     因为行是由index控制，列有for循环i控制
       1,0   1,1   1,2   1,3     所以只需考虑列即可
       2,0   2,1   2,2   2,3     同列的下标索引是相同的，所以用一个
       3,0   3,1   3,2   3,3     boolean数组即可表示

       横方向：行方向，由index控制，每行只有一个皇后

       对角线：这个/方向 ：有7条=》对角线个数 = 2*n-1个
       0,0   0,1   0,2   0,3        在同一条对角线上，横纵坐标相加都相等
       1,0   1,1   1,2   1,3        2,0=1,1=0,2 = 2
       2,0   2,1   2,2   2,3        所以，使用index+i即可
       3,0   3,1   3,2   3,3     dia1[index+i]:表示第i条对角线被占用了

       对角线：这个\方向 ：有7条=》对角线个数 = 2*n-1个
       0,0   0,1   0,2   0,3     在同一条对角线上，横纵坐标之差都相等
       1,0   1,1   1,2   1,3     1,0=2,1=3,2 = 1所以，使用index-i即可
       2,0   2,1   2,2   2,3     但是这里会有负数，所以加上一个偏移量n-1，从0开始
       3,0   3,1   3,2   3,3     dia1[index-i+n-1]:表示第i条对角线被占用了
     */
    boolean [] col,dia1,dia2;

    /**
     * 回溯法：
     *              n皇后：
     *       皇后摆放规则：1.n个皇后摆放在nXn的棋盘（二维矩阵）中
     *                    2.横，竖，对角线方向均不能同时出现2个皇后
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        lists = new ArrayList<>();
        if(n<1){
            return lists;
        }
        col = new boolean[n];
        dia1 = new boolean[2*n-1];
        dia2 = new boolean[2*n-1];
        List<Integer> list = new ArrayList<>();
        findNextQueen(0,n,list);//初始：第0行开始
        return lists;
    }

    /**
     *              类树形结构：寻找下一行中皇后所在的列索引
     *    列n                从0行开始，寻找皇后
     *行n  Q  。 。 。             0/Q              1|   2|   3\
     *     。 。 。 。          从1行开始，寻找皇后
     *     。 。 。 。  0/  1|        2|Q           3\
     *     。 。 。 。          从2行开始，寻找皇后
     *                    0/  1|    2|   3\ 此时没有皇后适合的位置，回到上一步
     宏观语义：寻找第index行中皇后所在的列索引
     * 递归思想：
     *      递归方法：void findNextQueen(int index,int n, List<Integer> list)
     *      递归终止条件：递归到最后一行，即index == n
     *                  此时nXn棋盘已走完，找到一个n皇后的列索引集合
     *                  可以返回去寻找新的皇后的位置了
     *      递归公式：
     *          void findNextQueen(index+1,n,list);
     *          index+1：下一行
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(k)
     * @param index         当前行
     * @param n             n皇后
     * @param list          n皇后的列索引的集合
     */
    private void findNextQueen(int index,int n, List<Integer> list) {
        if(index ==n){//找到了n皇后的一个解
            lists.add(generateBoard(n,list));
            return;
        }
        //在index行中，寻找皇后所在列的索引
        for(int i=0;i<n;i++){
            if(!col[i] && !dia1[index+i] && !dia2[index-i+n-1]){
                list.add(i);//找到一个皇后所在列的索引
                col[i]=true;
                dia1[index+i]=true;
                dia2[index-i+n-1]=true;
                findNextQueen(index+1,n,list);//到下一行中继续寻找皇后
                /*
                  回溯思想：
                     将当前所在位还原，回到上一步
                 */
                col[i]=false;
                dia1[index+i]=false;
                dia2[index-i+n-1]=false;
                list.remove(list.size()-1);
            }
        }
        return;

    }

    /**
     * 格式化n皇后的一个解：根据list集合中存储的皇后所在的列生成解字符串
     *      遍历list集合中存储的皇后所在的列
     *          生成n列"."字符串，将皇后所在列的字符串改为"Q"
     * @param n
     * @param list
     * @return
     */
    private List<String> generateBoard(int n, List<Integer> list) {
        List<String> sList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            StringBuilder s = new StringBuilder();
            int queen = list.get(i);
            for(int j=0;j<n;j++){
                if(j == queen){
                    s.append("Q");
                }else{
                    s.append(".");
                }
            }
            sList.add(s.toString());
        }
        return sList;
    }
}
