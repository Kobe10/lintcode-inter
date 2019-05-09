package com.fzq.lintcode.sort;

import java.util.Arrays;

/**
 * @program: lintcode-inter
 * @description: H指数
 * @author: fuzq
 * @create: 2019-05-09 10:12
 **/
public class HIndex {
    /*

     */

    /**
     * 功能描述
     * 思路：
     * 1、首先看到h个元素大于等于某个值，N-h个元素小于等于某个值，自然而然的想到将数组排序；
     * 2、将数组排序之后，对于给定的某个i，我们知道有citations.length - i篇论文的引用数 ≥ citations[i]，i篇     论文的引用数 ≤ citations[i]；
     * 3、不妨设h = citations.length - i，即至多有h篇论文分别引用了至少citation[i]次，其余citations.length - h篇
     * 论文的引用数不多于citation[i]次。
     * 既然如此，只要citation[i] ≥ h，就满足题意。
     *
     * @param citations
     * @return int
     * @author fuzq
     * @date 2019/5/9 11:12
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (h <= citations[i]) {
                return h;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
