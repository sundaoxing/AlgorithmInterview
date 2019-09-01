package com.leetcode;
/*
    题目（200）：给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
    一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
    示例：
        输入:
            11110           11000
            11010           11000
            11000           00100
            00000           00011
       输出: 1          输出: 3
 */
public class NumIslands {
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
    boolean [][] visited;

    /**
     ** 二维平面上的深度优先遍历：二维矩阵
     *      列n
     * 行m  '1' '1' '1' '1' '0'    从(0,0)开始，依次从上右下左寻找=='1'的岛屿
     *      '1' '1' '0' '1' '0'
     *      '1' '1' '0' '0' '0'
     *      '0' '0' '0' '0' '0'
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length ==0){
            return 0;
        }
        m = grid.length;//行
        if(m<=0){
            return 0;
        }
        n=grid[0].length;//列
        visited = new boolean[m][n];
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    res++;
                    findIslands(grid,i,j);//初始：从(0,0)开始，依次从上右下左寻找=='1'的岛屿
                }
            }
        }
        return res;
    }

    /**
     * floodfill算法：深度优先遍历
     *              类树形结构：寻找所有相邻（上右下左）的'1'
     *      列n                              从（0,0）寻找'1'
     * 行m  '1' '1' '1' '1' '0'      上/          右|          下|  左\
     *      '1' '1' '0' '1' '0'             从（0,1）寻找'1'
     *      '1' '1' '0' '0' '0'     上/          右|          下|  左\
     *      '0' '0' '0' '0' '0'             从（0,2）寻找'1'
     *                              上/          右|          下|  左\
     *                                      从（0,3）寻找'1'
     *                            上/  右|       下|              左\
     *                                      从（1,3）寻找'1'
     *                            上/          右|          下|  左\  都不是'1'，则回到上一步 （递归）
     *
     *
     * 宏观语义：二维网格的（startX，startY）位置上是否为'1'
     * 递归思想：
     *      递归方法：void findIslands(char[][] grid, int startX, int startY)
     *      递归终止条件：递归到当前(startX，startY)位置的相邻没有'1'或者已访问过
     *                  此时岛屿已经形成，可以返回去寻找新的岛屿了
     *                  若当前二维网格的（startX，startY）位置上的字母=='1'
     *                  则继续寻找相邻岛屿
     *      递归公式：
     *          findIslands(grid,newX,newY);
     *          (newX,newY)：二维网格中的坐标，下一个要查找的位置
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(k)
     * @param grid          二维网格
     * @param startX        二维网格查找起始横坐标：二维矩阵的行
     * @param startY        二维网格查找起始纵坐标：二维矩阵的列
     */
    private void findIslands(char[][] grid, int startX, int startY) {
        visited[startX][startY] = true;
        /*
          以（startX，startY）位置为基准，先向上，在向右，
          在向下，最后向左，依次查找下一个'1'
        */
        for(int i=0;i<4;i++){
            int newX = startX +d[i][0];
            int newY = startY +d[i][1];
            if(inArea(newX,newY) && !visited[newX][newY]
                    && grid[newX][newY]=='1'){//继续寻找相邻的岛屿
                findIslands(grid,newX,newY);
            }
        }
        /*
            注意：在这里，其实隐含了回溯，以为递归本身就带有回溯性值
            只是在回溯过程中，我们没有还原一些其他的变量，就是简单的返回
         */
        return;
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
