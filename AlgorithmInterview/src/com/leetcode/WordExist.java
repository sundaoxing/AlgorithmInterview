package com.leetcode;
/*
    题目（79）:给定一个二维网格和一个单词，找出该单词是否存在于网格中。
    说明：单词必须按照字母顺序，通过相邻的单元格内的字母构成，
         其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
         同一个单元格内的字母不允许被重复使用。
    示例：
        board =
                [
                  ['A','B','C','E'],
                  ['S','F','C','S'],
                  ['A','D','E','E']
                ]

                给定 word = "ABCCED", 返回 true.
                给定 word = "SEE", 返回 true.
                给定 word = "ABCB", 返回 false.
 */
public class WordExist {
    /*
        辅助：
        位移二维数组：控制二维网格的移动
                    移动：是移动到上/下一行；移动到左/右一列
        访问数组：控制二维网格中字母不能重复使用
                    从二维网格坐标对应
     */
    //             上     右     下     左
    int [][] d = {{-1,0},{0,1},{1,0},{0,-1}};
    int m,n;
    boolean [][]visited;

    /**
     * 二维平面上的回溯：二维矩阵
     *      列n
     * 行m  A B C E              默认从（0，0）=》'A'开始寻找，匹配'ABCCED'
     *      S F C S
     *      A D E E
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length ==0){
            return false;
        }
        m= board.length;//行
        if(m<=0){
            return false;
        }
        n=board[0].length;//列
        visited = new boolean[m][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(find(board,word,0,i,j)){//初始值：从(0,0)'A'开始匹配'ABCCED'的第一个字母A
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *           类树形结构：匹配字符串"ABCCED"
     *      列n                      从（0，0）开始寻找ABCCED的"A"
     * 行m  A B C E          上/                  右|          下|  左\
     *      S F C S             从（0，1）开始寻找BCCED的"B"
     *      A D E E        上/                  右|           下|  左\
     *                          从（0，2）开始寻找CCED的"C"
     *               上/   右|                 下|                左\
     *                                从（1，2）开始寻找CED的"C"
     *                    上/   右|           下|                左\
     *                               从（2，2）开始寻找ED的"E"
     *              上/   右|  下|           左\
     *                              从（2，1）开始寻找D的"D"
     *
     * 宏观语义：判断单词的第index字母是否在二维网格的（startX，startY）位置上
     * 递归思想：
     *      递归方法：boolean find(char[][] board, String word, int index,int startX,int startY)
     *      递归终止条件：递归到单词word的最后一个字母：即index == word.length-1
     *                  此时，index中为当前单词的最后一个字母。
     *                  若该字母 == 当前二维网格的（startX，startY）位置上的字母，
     *                  则代表查找成功
     *      递归公式：
     *          find(board,word,index+1,newX,newY)
     *           index+1：单词中字母迭代，按照字母顺序查找
     *          （newX,newY）：二维网格中的坐标，下一个要查找的位置
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(k)
     * @param board             二维网格
     * @param word              带查找单词
     * @param index             当前单词的index个字母
     * @param startX            二维网格查找起始横坐标：二维矩阵的行
     * @param startY            二维网格查找起始纵坐标：二维矩阵的列
     * @return
     */
    private boolean find(char[][] board, String word, int index,int startX,int startY) {
        if(index == word.length()-1){
            return board[startX][startY] == word.charAt(index);
        }
        /*
        判断当前二维网格的（startX，startY）位置上字母是否为单词的第index字母
            若是：则以此位置为基准，先向上，在向右，在向下，最后向左，依次查找下一个字母
            若不：查找失败，从二维网格的下一个坐标从头开始查找
         */
        if(board[startX][startY] == word.charAt(index)){
            //二维网格中字母不能重复使用
            visited[startX][startY]=true;
            /*
                以（startX，startY）位置为基准，先向上，在向右，
                在向下，最后向左，依次查找下一个字母
             */
            for(int i=0;i<4;i++){
                int newX = startX+d[i][0];
                int newY = startY+d[i][1];
                if(inArea(newX,newY) && !visited[newX][newY]){
                    if(find(board,word,index+1,newX,newY)){
                        return true;
                    }
                }
            }
            //回溯：返回上一步执行
            visited[startX][startY]=false;
        }
        return false;
    }

    /**
     * 判断坐标（x，y）合法性：即是否在二维数组内，不越界
     * @param x
     * @param y
     * @return
     */
    private boolean inArea(int x, int y) {
        return x>=0 && x<m && y>=0 && y<n;
    }
}
