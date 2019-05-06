package com.fzq.lintcode.sort;


import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 有效的字母异位词
 * @Author: FuZq
 * @CreateDate: 2019/5/6 16:11
 * @Version: 1.0
 */
public class IsAnagram {
    /**
     * 功能描述 其实这一题就是字符串的逆序比较
     * ①：这里最容易想到的就是字符串数组接受 然后倒序 (这里可以缩短迭代的次数 只用O(n/2) 即可)
     * ②：利用栈的特点进行判断
     *
     * @param s
     * @param t
     * @return boolean
     * @author fuzq
     * @date 2019/5/6 16:11
     */
    public static boolean isAnagram1(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int length = s.length();
        if (length == 0) {
            return true;
        }
        char[] testChar = s.toCharArray();
        for (int i = 0; i < length; i++) {
            char frontChar = testChar[i];
            testChar[i] = testChar[length - i - 1];
            testChar[length - i - 1] = frontChar;
        }
        if (String.valueOf(testChar).equals(t)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断两个字符串的字符数量 字符种类是否是一致的
     * 时间复杂度 O(N)
     * 空间复杂度O(1)
     *
     * @param s
     * @param t
     * @return boolean
     * @author fuzq
     * @date 2019/5/6 16:42
     */
    public static boolean isAnagram2(String s, String t) {
        char[] testChar1 = s.toCharArray();
        char[] testChar2 = t.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < testChar1.length; i++) {
            if (charMap.get(testChar1[i]) != null) {
                int num = charMap.get(testChar1[i]);
                num++;
                charMap.put(testChar1[i], num);
            } else {
                charMap.put(testChar1[i], 1);
            }
        }

        for (int i = 0; i < testChar2.length; i++) {
            if (charMap.get(testChar2[i]) != null) {
                int num = charMap.get(testChar2[i]);
                num--;
                charMap.put(testChar2[i], num);
            } else {
                charMap.put(testChar2[i], 1);
            }
        }
        for (Map.Entry<Character, Integer> m : charMap.entrySet()) {
            if (m.getValue() != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "ab";
        System.out.println(isAnagram2(s1, s2));
    }
}