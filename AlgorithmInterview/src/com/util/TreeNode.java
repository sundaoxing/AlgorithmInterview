package com.util;

public class TreeNode implements Comparable<TreeNode>{
     public  int val;
     public TreeNode left;
     public TreeNode right;
     public TreeNode(int x) { val = x; }

     @Override
     public int compareTo(TreeNode o) {
          return val-o.val;
     }
}
