package com.fzq.lintcode.sort;

import java.util.*;

/**
 * @program: lintcode-inter
 * @description: 存在重复元素
 * @author: fuzq
 * @create: 2019-05-07 13:35
 **/
public class ContainsDuplicate {
    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * <p>
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     *
     * @param nums
     * @return boolean
     * @author fuzq
     * @date 2019/5/7 13:42
     */
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                int count = map.get(nums[i]);
                if (count >= 1) {
                    return true;
                } else {
                    count++;
                    map.put(nums[i], count);
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }

    /**
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
     *
     * @param nums
     * @param k
     * @return boolean
     * @author fuzq
     * @date 2019/5/7 13:42
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length && j <= i + k; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
     *
     * @param nums
     * @param k
     * @param t
     * @return boolean
     * @author fuzq
     * @date 2019/5/9 10:06
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length && j <= i + k; j++) {
                if (nums[i] - nums[j] < t) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int k = 1;
        int[] num = {1, 2, 3, 1, 2, 3};
        int[] num1 = {1, 2, 3, 4};
        int[] num2 = {1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(num2, k));
    }
}
