package com.leetcode;

import java.util.Stack;

/*
        题目（20）：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
        有效字符串需满足：
            1.左括号必须用相同类型的右括号闭合。
            2.左括号必须以正确的顺序闭合。
            3.注意空字符串可被认为是有效字符串。
        示例：
            输入: "()"
            输出: true

            输入: "(]"
            输出: false
 */
public class ValidParentheses {
    /**
     * 利用Stack栈的特性：先进后出
     *      栈顶元素反映了在嵌套层次中，最近的需要匹配的元素
     *  字符串：    (       {       }       [       ]       )
     *             |
     *    索引：   i
     *
     * 栈Stack：   (       {
     *           入栈    入栈
     *     入栈规则：
     *            当s[i]为左括号(,{,[时,直接入栈
     *     判断匹配依据：
     *            当前s[i]为右括号),{,]时，栈顶元素为相匹配的左括号
     * 时间复杂度：O(n),n为字符串的长度
     *  空间复杂度：O(k),k为栈的大小
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) ==')' || s.charAt(i) =='}' ||s.charAt(i) ==']'){
                if(stack.empty()){
                    return false;
                }
                char c = s.charAt(i);
                char pop = stack.pop();
                char match;
                if(c == ')'){
                    match='(';
                }else if(c == '}'){
                    match='{';
                }else{
                    if(c !=']'){
                        return false;
                    }
                    match='[';
                }
                if(match != pop){
                    return false;
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }
}
