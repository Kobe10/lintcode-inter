package com.fzq.lintcode.sort;

/**
 * @Description: 颜色分类
 * @Author: FuZq
 * @CreateDate: 2019/5/7 9:05
 * @Version: 1.0
 */
public class SortColors {
    /**
     * 颜色排序
     * 解决方案：先迭代一次获取对应的0,1,2出现的次数 然后再迭代一次 通过次数来往数组里面塞对应的0,1,2的值 2n实现
     *
     * @param nums 数组
     * @return void
     * @author fuzq
     * @date 2019/5/7 9:06
     */
    public static void sortColors(int[] nums) {
        //第一次遍历 获取0,1,2元素个数
        int numZero = 0;
        int numOne = 0;
        int numTwo = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0 == nums[i]) {
                numZero++;
            }
            if (1 == nums[i]) {
                numOne++;
            }
            if (2 == nums[i]) {
                numTwo++;
            }
        }
        //遍历一遍 重新赋值
        for (int i = 0; i < nums.length; i++) {
            if (i < numZero) {
                nums[i] = 0;
            }
            if (i >= numZero && i < numOne + numZero) {
                nums[i] = 1;
            }
            if (i >= numOne + numZero) {
                nums[i] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 0, 2, 1, 1, 0};
        sortColors(a);
    }
}
