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
        Map<Integer, Set<Integer>> map = new HashMap<>();
        if (nums.length < 2) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                Set<Integer> count = map.get(nums[i]);
                count.add(i);

                map.put(nums[i], count);
            } else{
                Set<Integer> count = new HashSet<>();
                count.add(i);
                map.put(nums[i], count);
            }
        }

        //遍历map
        for (Map.Entry<Integer, Set<Integer>> m : map.entrySet()) {
            Set<Integer> set = m.getValue();
            if (set.size() < 2)
                continue;

            List<Integer> list =  new ArrayList<>(set);
            if (k == list.get(0) - list.get(list.size() - 1)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int k = 2;
        int[] num = {1,2,3,1,2,3};
        int[] num1 = {1, 2, 3, 4};
        int[] num2 = {1, 2, 3, 1};
        System.out.println(containsNearbyDuplicate(num, k));
    }
}
