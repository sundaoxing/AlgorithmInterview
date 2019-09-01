package com.leetcode;
/*
     题目（209）：给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
     示例 1:
        输入: "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     示例 2：
        输入: "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     示例 3:
        输入: "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {
    /**
     * 双索引法（滑动窗口）
     *    字符串数组     [a，b，c，a，b，c，b，b]
     *                  ||
     *    索引          ij
     *    滑动窗口：[i,j]
     *    滑动规则：
     *          1.若s[j]在[i,j]滑动窗口中不重复   则：记录当前s[j]字符已经存在
     *          2.若s[j]在[i,j]滑动窗口中重复     则：找到当前重复字符的索引，使滑动窗口的左边界i
     *                                              直接跨过该索引：i=repeatIndex+1
     *            最后：j++：滑动窗口增大
     *    如何判断s[j]在[i,j]滑动窗口中是否重复：
     *          类似hash表的思想，设置一个包含ASCII的数组，其数组索引 == ASCII字符的数值
     *          当前数组索引表示的值为1，则代表字符已存在，为0，则表明字符不存在
     * 时间复杂度：O(n)
     * 空间复杂度：O(256)
     * @param s     给顶字符串
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;//初始滑动窗口，默认包含第一个字符[i,j]
        int []freq = new int[256];//ASCII字符Hash表，索引：是否重复
        int longest = 0;//最长不重复子串的长度
        while(j< s.length()){
            if(freq[s.charAt(j)] == 0 ){
                freq[s.charAt(j)] = 1;
            }
            else{
                int repeatIndex = s.indexOf(s.charAt(j),i);
                i=repeatIndex+1;//滑动窗口跳过重复字符
            }
            longest = Math.max(longest,j-i+1);//更新滑动窗口记录的最长不重复子串的长度
            j++;
        }
        return longest;
    }

    /**
     * 双索引法（滑动窗口）
     *    字符串数组     [a，b，c，a，b，c，b，b]
     *                   |     |
     *    索引           i     j
     *    滑动窗口：[i,j]
     *    滑动规则：
     *          1.若s[j+1]在[i,j]滑动窗口中不重复   则：记录当前s[j+1]字符已经存在，j++：滑动窗口增大
     *          2.若s[j+1]在[i,j]滑动窗口中重复     则：删除当前s[i]字符存在记录，i++：滑动窗口缩减
     *    如何判断s[j]在[i,j]滑动窗口中是否重复：
     *          类似hash表的思想，设置一个包含ASCII的数组，其数组索引 == ASCII字符的数值
     *          当前数组索引表示的值为1，则代表字符已存在，为0，则表明字符不存在
     *  时间复杂度：O(n)
     *  空间复杂度：O(256)
     * @param s     给顶字符串
     * @return
     */
    public int lengthOfLongestSubstring_better(String s) {
        int i=0;
        int j=-1;//初始滑动窗口，默认为空[i,j]
        int []freq = new int[256];
        int longest =0;
        while(i<s.length()){
            if(j+1 < s.length() && freq[s.charAt(j+1)] ==0){//注意j+1不能越界
                j++;
                freq[s.charAt(j)] =1;
            }else{
                freq[s.charAt(i)] =0;
                i++;
            }
            longest = Math.max(longest,j-i+1);
        }
        return longest;
    }

}
