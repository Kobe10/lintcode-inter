package com.fzq.lintcode.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 最接近原点的 K 个点
 */
public class KClosest {
    /**
     * 这题如果对数组按照对比排序的话 时间复杂度很高 O(N*N) 超出限制了
     * 换一种思路（最大堆） ：这题可以使用优先队列的形式  也是一个排序的过程 但是 只要是放满了K个  就不再去添加了  这样后面的时间就节省了 复杂度:O(nlogK)
     * @param points
     * @param K
     * @return
     */
    public static int[][] kClosest(int[][] points, int K) {
        //排序
        List<List<Integer>> lists = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int row = points.length;

        for (int i = 0; i < row; i++) {
            List<Integer> temp = Arrays.stream(points[i]).boxed().collect(Collectors.toList());
            lists.add(temp);
        }


        //排序 按照平方和进行排序
        lists.sort(Comparator.comparingInt(o -> (o.get(0) * o.get(0) + o.get(1) * o.get(1))));
        for (int i = 0; i < K; i++) {
            result.add(lists.get(i));
        }

        int[][] resultInt = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultInt[i][0] = result.get(i).stream().mapToInt(Integer::valueOf).toArray()[0];
            resultInt[i][1] = result.get(i).stream().mapToInt(Integer::valueOf).toArray()[1];
        }
        return resultInt;
    }

    /**
     * 最大堆
     * @param points
     * @param K
     * @return
     */
    public static int[][] kClosest1(int[][] points, int K) {
        int[] ints = new int[points.length];
        //计算出来每一个点距离原点的距离 不用排序
        for (int i = 0; i < points.length; i++) {
            ints[i]=points[i][0] * points[i][0] + points[i][1] * points[i][1];
        }
        //定义一个大顶堆  PriorityQueue默认是一个小顶堆 可以自己定义一个排序规则来实现优先级队列  流式
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> ints[b] - ints[a]);
        //获取最大的
        for (int i = 0; i < points.length; i++) {
            if (queue.size() < K) {
                //当前满足的放入队列
                queue.add(i);
            } else if (ints[queue.peek()] > ints[i]) {
                //如果满了 取出最大的进行比较 如果比取出的小  就剔除这个最大的   把最小的放进去
                queue.remove();
                queue.add(i);
            }
        }
        int[][] a = new int[K][];
        for (int i = 0; i < K; i++) {
            a[i] = points[queue.remove()];

        }
        return a;
    }

    public static void main(String[] args) {
        int[][] intervalss = {{3, 3}, {5, -1}, {-2, 4}};
        System.out.println(Arrays.deepToString(kClosest(intervalss, 2)));
    }
}
