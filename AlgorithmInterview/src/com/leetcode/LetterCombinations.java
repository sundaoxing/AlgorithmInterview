package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    题目（17）：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
               给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
        1：          2：abc       3：def
        4：ghi       5：jkl       6：mno
        7：pqrs      8：tuv       9：wxyz
    示例：
        输入："23"
        输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinations {
    final String [] numToChar = {""," ","abc","def","ghi","jkl",
            "mno","pqrs","tuv","wxyz"};
    List<String> list;

    /**
     * 数字映射到字符串的所有字符组合
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        list  = new ArrayList<>();
        if(digits.equals("")){
            return list;
        }
        findCombination(digits,0,"");//初始遍历第一个数字，组合为空
        return list;
    }

    /**回溯法：本质是暴力解法
     *      类树形结构：
     *                             2
     *           a/               b|              c\
     *            3                3               3
     *     d/    e|    f\   d/    e|    f\    d/  e|    f\
     *   ad     ae     af   bd    be     bf  cd   ce     cf
     *
     *  2: 循环遍历    a   ->   3：循环遍历  d       ->      ad
     *                                      e       ->      ae
     *                                      f       ->      af
     *
     *                b   ->   3：循环遍历  d       ->       bd
     *                                      e       ->      be
     *                                      f       ->      bf
     *
     *                c   ->   3：循环遍历  d       ->       cd
     *                                      e       ->      ce
     *                                      f       ->      cf
     * 宏观语义：寻找字符串s
     *          s:当前数字，和上一个数字...到第一个数字对应的字母的一种组合
     *          若上一个数字不存在，代表为""空字符串
     *          组合：数字对应的字母之间的 简单字符串顺序拼接
     * 递归思想：
     *      递归方法：void findCombination(String digits, int i, String s)
     *      递归终止条件：递归到digits的最后数字的下一次：即i == digits.length
     *          此时，s为当前数字，和上一个数字...到第一个数字，对应的字母的一种组合
     *      递归公式：
     *           findCombination(digits,i+1,s+letter.charAt(j));
     *           i+1：数字迭代，因为一个数字映射一个字母串
     *           s+letter.charAt(j)：当前数字，和上一个数字...到第一个数字，对应的字母的一种组合
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(k)
     * @param digits    数字字符串
     * @param i         当前数字索引
     * @param s         字母组合字符串
     */
    private void findCombination(String digits, int i, String s) {
        if(i == digits.length()){//此时没有新的数字
            list.add(s);//s：所有数字代表的字母的一种 组合
            return;
        }
        char num = digits.charAt(i);//数字
        String letter = numToChar[num-'0'];//数字对应的字母
        for(int j=0;j<letter.length();j++){//遍历每一个字母
            //递归结束，也就相当于回溯到了上一步
            findCombination(digits,i+1,s+letter.charAt(j));//下一个数字
        }
        return;
    }
}
