package com.fzq.lintcode.primary;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description: 斐波那契队列
 * @Author: FuZq
 * @CreateDate: 2019/5/6 14:57
 * @Version: 1.0
 */
public class FibonacciQueue {
    public static Map<Integer, Integer> numMap = new HashMap<>();

    /**
     * 获取某个数字
     * <p>
     * 这里使用的非递归算法：递归算法时间复杂度太高，会有超时情况出现 最后采用非递归算法
     * 空间复杂度 : o(1)
     * 时间复杂度:o(n)
     *
     * @param count 第几个
     * @return int
     * @author fuzq
     * @date 2019/5/6 14:58
     */
    private static int getNum(int count) {
        if (count == 1 || count == 2) {
            return count - 1;
        }
        int a = 0;
        int b = 1;
        int c = a;
        while (count > 2) {
            c = a + b;//从第三个数开始，斐波那契数等于前两个数的和；
            a = b;//将前一个数给到a，开始下一次求值
            b = c;//将斐波那契数给b，开始下一次求值
            count--;//每求一次，n都要减一
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        System.out.println(getNum(count));
    }
}
