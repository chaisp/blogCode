package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class solution1 {
    /**
     * 请实现一个函数，把字符串中的每个空格替换成"%20"。
     * 
     * 你可以假定输入字符串的长度最大是 1000。
     * 
     * 注意输出字符串的长度可能大于 1000。
     */

    public static String replaceSpaces(StringBuffer str) {
        StringBuilder build = new StringBuilder();
        int j = str.capacity();
        for (int i = 0; i < str.capacity() - 1; i++) {
            if (str.charAt(i) == ' ') {
                build.append("%20");
            } else {
                build.append(str.charAt(i));
            }
        }
        return build.toString();
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // 使用map存储
        Map<Integer, Integer> map = new HashMap<>();
        // 存储中中序遍历中数字的index
        for (int i = 0; i < inorder.length - 1; i++) {
            map.put(inorder[i], i);
        }

        return null;
    }

    public TreeNode dfs(Map<Integer, Integer> map, int[] pre, int[] in, int pl, int pr, int il, int ir) {

        if (pl > pr) {
            return null;
        }
        // 获取前序遍历第一个数，在中序遍历的位置
        int k = map.get(pre[pl]);
        TreeNode root = new TreeNode(in[k]);

        root.left = dfs(map, pre, in, pl + 1, pl + k, il, il + k);
        root.right = dfs(map, pre, in, pl + k + 1, pr, il + k + 1, ir);
        return root;
    }

    public static void main(String[] args) {
        solution1.replaceSpaces(new StringBuffer("We are happy."));
        List<Integer> list = new ArrayList<Integer>();
        Stack<Integer> s1 = new Stack<Integer>();
    }
}
