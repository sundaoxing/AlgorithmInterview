package com.leetcode.dynamicp;
/*
    有N件物品和一个容量为C的背包。第i件物品的重量是W[i]，价值是V[i]。
    求解将哪些物品装入背包可使价值总和最大。

    示例：背包容量为 3
    编号：0，1，2
    重量：1，2，3
    价值：3，5，6
    放入背包中：[0,1]->8
               [1]  ->5
               [2]  ->6     最大价值为8，放入0号和1号物品
 */
public class BackPack {
    public int backPack01(int [] w , int [] v,int c){
        int n = w.length;
        return backPack01(w,v,n-1,c);
    }

    /**
     * 如何将上诉问题：装入背包的最大价值总和-转化成下列的树形结构问题？
     *  假设法：本质上还是穷举法
     *    对于[0,n-1]个物品,装入容量为c的背包来说：
     *      不考虑第n-1位商品：
     *          则背包最大价值总和max=[0,n-2]个物品装入容量c的背包的最大价值总和
     *      考虑第n-1位商品：
     *          则背包最大价值总和max=max(不考虑n-1位物品的最大价值，[0,n-2]个物品装入容量c-w[n-1]的背包的最大价值总和)
     *      ....
     *    逐步递推：直到没有物品或者背包容量小于当前物品的重量
     *       其包最大价值总和max=0
     *递归法：-》类树形结构
     *                       价值  3，5，6
     *                       重量  1，2，3
     *                           [0，1，2]c=3------->用0，1，2号物品填充容量为c的背包，获得最大价值
     *                    不考虑2/          \考虑2
     *                   [0,1]c=3           v[2]+[0,1],c=0
     *            不考虑1/   \考虑1
     *             [0]c=3    v[1]+[0],c=1      ----》[0]的最大价值会有计算重复
     *      不考虑0/  \考虑0
     *       0,c=3    3,c=2
     * 宏观语义：用[0,index]个物品填充容量为c的背包的最大价值
     *
     * 递归思想：
     *      递归方法：int backPack01(int[] w,int[] v ,int index, int c)
     *      递归终止条件：
     *          1.没有物品了:index<0
     *          2.容量不够了：c<=0
     *          对应的最大价值=0
     *      递归公式：
     *           backPack01(w,v,index-1,c)：
     *              不考虑第index位物品：最大价值=[0,index-1]个物品填充容量为c的背包的最大价值
     *           backPack01(w,v,index-1,c-w[index])：
     *              考虑第index位物品：最大价值=max(不考虑第index位物品,v[index]+用[0,index-1]个物品填充容量为c-w[index]的背包的最大价值
     * @param w
     * @param v
     * @param index
     * @param c
     * @return
     */
    private int backPack01(int[] w,int[] v ,int index, int c) {
        if(index < 0 || c <=0){//递归终止条件
            return 0;
        }
        //不考虑第index个物品，用[0,index-1]个物品填充容量为c的背包，获得最大价值
        int max = backPack01(w,v,index-1,c);
        if(c>= w[index]){//背包容量要能装得下第index个物品
            //考虑第index个物品，此时背包容量要减小了
            max= Math.max(max,v[index]+backPack01(w,v,index-1,c-w[index]));
        }
        return max;
    }

    private int [][] memo;
    public int backPack01_better(int [] w , int [] v,int c){
        int n = w.length;
        memo = new int[n][c+1];//n物品行，c容量列
        return backPack01_better(w,v,n-1,c);
    }

    /**
     * 记忆化搜索--》将递归法中重复分割的部分进行保存，只计算一次
     *    自上而下：先解决n规模的问题，在解决n-1规模的问题，最后解决1规模的问题
     *           思想：使用额外的空间保存用[0,index]个物品填充容量为c的背包的最大价值
     *                 下次使用时，先判断用[0,index]个物品填充容量为c的背包的最大价值是否已被计算好
     *                 若被计算好，直接返回该值，否则，在计算
     *    实现：使用数组memo[index][c]保存用[0,index]个物品填充容量为c的背包的最大价值
     * @param w
     * @param v
     * @param index
     * @param c
     * @return
     */
    private int backPack01_better(int[] w,int[] v ,int index, int c) {
        if(index < 0 || c <=0){
            return 0;
        }
        if(memo[index][c] == 0){//保存重复部分
            int max = backPack01(w,v,index-1,c);
            if(c>= w[index]){
                max= Math.max(max,v[index]+backPack01(w,v,index-1,c-w[index]));
            }
            memo[index][c] = max;
        }
        return memo[index][c];
    }

    /**
     * 动态规划法：将原问题拆解成若干子问题，同时保存子问题的答案，
     *            使每个子问题只求解一次，最终得到原问题的解
     *   自下而上：先解决1规模的问题，在解决2规模的问题，最后解决n规模的问题
     *                       记忆化搜索：自上而下
     *                      /           |
     *              重叠子问题           |
     *   递归问题->                      |
     *              最优子结构           |
     *                      \           |
     *                       动态规划：自下而上
     *  memo就代表这递归法中的宏观语义
     *  memo[i][j]保存用[0,i]个物品填充容量为j的背包的最大价值
     *
     *   状态：f(n-1,c):[0,n-1]个物品填充容量为c的背包的最大价值
     *        对应计算机中表示：memo[n-1][c]：[0,n-1]个物品填充容量为c的背包的最大价值
     *   状态转移方程：递推公式
     *        f(n-1,c) = max{
     *            f(n-2,c),
     *            max(f(n-2,c),v[n-1]+f(n-2,c-w[n-1]))
     *        }
     *        对应计算机中表示：
     *        memo[n-1][c] = max{
     *            memo[n-2][c],
     *            max(memo[n-2][c],v[n-1]+memo[n-2][c-w[n-1]])
     *        }
     *   初始状态：用第0位物品填充容量为j的背包的最大价值=v[0]
     *        f(0)=v[0]--->memo[0][j]= j>=w[0]? v[0] : 0
     *
     *   背包容量为 3                   c容量列：
     *   编号：0，1，2                   0   1   2   3
     *   重量：1，2，3    n物品行： 0    0   3   3   3（初始化这一行）
     *   价值：3，5，6             1    0   3   5   8
     *                            2    0   3   5   8
     * @param w
     * @param v
     * @param c
     * @return
     * 时间复杂度：O(n*C)
     * 空间复杂度：O(n*C)
     */
    public int backPack01_best(int [] w , int [] v,int c){
        int n = w.length;
        memo = new int[n][c+1];
        for(int i=0;i<c+1;i++){//初始化第0位物品
            memo[0][i]=(i>=w[0]?v[0]:0);
        }
        for(int i=1;i<n;i++){//考虑/不考虑第i位物品
            for(int j=0;j<c+1;j++){//放入容量为j的背包
                memo[i][j] = memo[i-1][j];//不考虑第i位物品
                if(j>= w[i]){//考虑第i位物品
                    memo[i][j] = Math.max(memo[i][j],v[i]+memo[i-1][j-w[i]]);
                }
            }
        }
        return memo[n-1][c];
    }

    /*
    优化：针对空间的优化
        使用两行memo来保存容量为j的背包的最大价值
        原因：每次只考虑一个物品，而这个物品依赖于上一个物品
              所以只需要两行就可以保存，考虑第3个物品时，可以覆盖第一个物品
        考虑第i个物品时：
            若i为偶数：则保存在1行
            若i为奇数：则保存在0行------->可以直接对2取余即可
     *   背包容量为 3                   c容量列：
     *   编号：0，1，2                   0   1   2   3
     *   重量：1，2，3    n物品行： 0    0   3   3   3（初始化这一行）第1个物品
     *                                 (0   3   5   8)             第3个物品
     *   价值：3，5，6             1    0   3   5   8               第2个物品
     * 时间复杂度：O(n*C)
     * 空间复杂度：O(C)
     */
    public int backPack01_optimization(int []w,int []v,int c){
        int n= w.length;
        memo = new int [2][c+1];
        for(int i=0;i<c+1;i++){
            memo[0][i] = (i>=w[0]?v[0]:0);
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<c+1;j++){
                memo[i%2][j] = memo[(i-1)%2][j];//不考虑第i位物品
                if(j>= w[i]){//考虑第i位物品
                    memo[i%2][j] = Math.max(memo[i%2][j],v[i]+memo[(i-1)%2][j-w[i]]);
                }
            }
        }
        return memo[(n-1)%2][c];
    }
    /*
    优化：针对空间的优化
        使用一行memo来保存容量为j的背包的最大价值
        原因：每次只考虑一个物品，而这个物品依赖于上一个物品，并且容量大的依赖于容量小的
              所以只需要一行就可以保存，考虑第2个物品时，可以直接从右到左覆盖第一个物品

     *   背包容量为 3                   c容量列：
     *   编号：0，1，2                   0   1   2   3
     *   重量：1，2，3    n物品行： 0    0   3   3   3（初始化这一行）第1个物品
     *   价值：3，5，6                  0   3   5   8               第2个物品
     * 时间复杂度：O(n*C)
     * 空间复杂度：O(C)
     */
    private int [] memo_best;
    public int backPack01_optimization_best(int []w,int []v,int c){
        int n= w.length;
        memo_best = new int[c+1];
        for(int i=0;i<c+1;i++){
            memo_best[i] = (i>=w[0]?v[0]:0);
        }
        for(int i=1;i<n;i++){
            for(int j=c;j>=w[i];j--){//从右到左依次修改
                memo_best[j] = Math.max(memo_best[j],v[i]+memo_best[j-w[i]]);
            }
        }
        return memo_best[c];
    }
}
