package com.fzq.lintcode.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过删除字母匹配到字典里最长单词
 */
public class FindLongestWord {
    /**
     * 思路  维护一个字符串 这个字符串是最长且是字典序最小的串  每次找到合适的字符串就和当前这个进行比较  合适就替换即可
     *
     * @param s
     * @param d
     * @return
     */
    public static String findLongestWord(String s, List<String> d) {
        String maxStr = "";
        for (int i = 0; i < d.size(); i++) {
            int l1 = maxStr.length();
            int l2 = d.get(i).length();
            if (l2 < l1 || (l1 == l2 && maxStr.compareTo(d.get(i)) < 0)) {
                continue;
            }
            if (isCorrect(s, d.get(i))) {
                maxStr = d.get(i);
            }
        }
        return maxStr;
    }

    public static boolean isCorrect(String test, String str) {
        int i = 0;
        int j = 0;
        while (i < test.length() && j < str.length()) {
            if (test.charAt(i) == str.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == str.length();
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> strings = new ArrayList<>();
        strings.add("ale");
        strings.add("apple");
        strings.add("monkey");
        strings.add("plea");

        System.out.println(findLongestWord(s, strings));
    }
}
