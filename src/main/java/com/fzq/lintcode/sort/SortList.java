package com.fzq.lintcode.sort;

/**
 * @program: lintcode-inter
 * @description: 快速排序 链表
 * @author: fuzq
 * @create: 2019-05-07 11:32
 **/
public class SortList {
    /**
     * 快速排序思路 解决这个问题 时间复杂度为O(n log n) 但是这个没有尾部指针 比较麻烦
     * 这个需要系统解决
     *
     * @param head
     * @return com.fzq.lintcode.sort.SortList.ListNode
     * @author fuzq
     * @date 2019/5/7 11:40
     */
    public static ListNode sortList(ListNode head) {
        // 归并排序
        if (head == null || head.next == null) {
            return head;
        }
        // 使用快慢指针查找中间结点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next.next;
            // 让slow少走一步，结点数目均匀
            if (fast == null) {
                break;
            }
            slow = slow.next;
        }
        ListNode right = slow.next;
        // 注意断链
        slow.next = null;

        ListNode left = sortList(head);
        right = sortList(right);
        return mergeTwoLists(left, right);

    }

    // 递归实现链表排序
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = null;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            res = l1;
            l1.next = mergeTwoLists(l1.next, l2);
        } else {
            res = l2;
            l2.next = mergeTwoLists(l1, l2.next);
        }
        return res;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static void main(String[] args) {
        int[] num = {2, 1, 3};
        ListNode head = new ListNode(4);
        ListNode temp = head;
        for (int i = 0; i < num.length; i++) {
            temp.next = new ListNode(num[i]);
            temp = temp.next;
        }
        System.out.println(sortList(head));
    }
}
