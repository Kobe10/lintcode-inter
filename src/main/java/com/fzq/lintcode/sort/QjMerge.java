package com.fzq.lintcode.sort;

import org.apache.catalina.LifecycleState;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 区间合并  给出一个区间的集合，请合并所有重叠的区间。
 */
public class QjMerge {
    public static int[][] merge(int[][] intervals) {
        //排序
        List<List<Integer>> lists = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int row = intervals.length;

        for (int i = 0; i < row; i++) {
            List<Integer> temp = Arrays.stream(intervals[i]).boxed().collect(Collectors.toList());
            lists.add(temp);
        }
        //排序 按照start排序  小的start在前
        lists.sort(Comparator.comparingInt(o -> o.get(0)));
        //只比较end  如果前一个的end比后一个的start大  那就直接合并 修改start 和 end
        for (int i = 0; i < lists.size() - 1; i++) {
            List<Integer> a = lists.get(i);
            List<Integer> b = lists.get(i + 1);
            if (a.get(1) >= b.get(0)) {
                int end = Math.max(a.get(1), b.get(1));
                a.remove(1);
                lists.remove(i+1);
                a.add(1, end);
                i--;
            }
        }

        int[][] intervalss = new int[lists.size()][2];
        for (int i = 0; i < lists.size(); i++) {
            intervalss[i][0] = lists.get(i).stream().mapToInt(Integer::valueOf).toArray()[0];
            intervalss[i][1] = lists.get(i).stream().mapToInt(Integer::valueOf).toArray()[1];
        }
        return intervalss;
    }

    public static void main(String[] args) {
        int[][] intervalss = {{1, 4},{0, 2},{7, 9}};
        System.out.println(Arrays.deepToString(merge(intervalss)));
    }
}
