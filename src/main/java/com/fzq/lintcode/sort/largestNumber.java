package com.fzq.lintcode.sort;

/**
 * @Description: 最大数
 * @Author: FuZq
 * @CreateDate: 2019/5/7 13:34
 * @Version: 1.0
 */
public class largestNumber {
    /**
     * 最大数 这里主要是考察自定义排序的功能 那么只需要搞定排序就行 这里的排序需要比较两个数加起来的字符串大小 是两个数加起来进行比较
     * 注意:这里还需要对 0进行特殊操作 去0操作 特例{0,0} 如果第一个数是0  那么直接返回0即可
     *
     * @param nums
     * @return java.lang.String
     * @author fuzq
     * @date 2019/5/7 11:50
     */
    public static String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        //这里可以使用List的sort排序
        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (((str[i] + str[j]).compareTo(str[j] + str[i])) < 0) {
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
        int count = str.length;
        //如果第一个数为0  那么直接返回0
        if ("0".equals(str[0])) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            stringBuilder.append(str[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] a = {0, 0};
        System.out.println(largestNumber(a));
    }
}
