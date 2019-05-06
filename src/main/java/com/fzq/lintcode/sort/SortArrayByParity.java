package com.fzq.lintcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 按奇偶排序数组
 * @Author: FuZq
 * @CreateDate: 2019/5/6 17:46
 * @Version: 1.0
 */
public class SortArrayByParity {
    public static int[] sortArrayByParityII(int[] A) {
        Arrays.sort(A);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        if (A.length < 2 || A.length > 20000) {
            return A;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                list1.add(A[i]);
            } else {
                list2.add(A[i]);
            }
        }

        for (int i = 0, flag = 0; i < A.length; i += 2, flag++) {
            A[i] = list1.get(flag);
            A[i + 1] = list2.get(flag);
        }
        return A;
    }

    public static void main(String[] args) {
        int[] a = {4, 7, 2, 5};
        System.out.println(sortArrayByParityII(a));
    }

}
