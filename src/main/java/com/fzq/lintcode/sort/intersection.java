package com.fzq.lintcode.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: lintcode-inter
 * @description: 两个数组的交集（一种是使用map 记录形式进行获取  一种是可以直接利用集合的api进行获取）
 * @author: fuzq
 * @create: 2019-05-06 16:54
 **/
public class intersection {
    /**
     * 利用集合实现
     *
     * @param nums1
     * @param nums2
     * @return int[]
     * @author fuzq
     * @date 2019/5/6 17:44
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        list.retainAll(list2);
        list = new ArrayList<>(new TreeSet<>(list));
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 利用map实现
     *
     * @param nums1
     * @param nums2
     * @return int[]
     * @author fuzq
     * @date 2019/5/6 17:44
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        // 将 nums1 出现的数值及频次放入映射中
        for (int num : nums1) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, ++count);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            // 获取映射中该数值出现的频次
            Integer count = map.get(num);
            if (count != null && count != 0) {
                list.add(num);
                // 注意每次匹配后，该数值的频次需要减 1（nums1 和 nums2 匹配的数值的频次要相同）
                map.put(num, --count);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
