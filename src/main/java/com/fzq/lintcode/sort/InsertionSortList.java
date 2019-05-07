package com.fzq.lintcode.sort;

/**
 * @Description: 对链表进行插入排序
 * @Author: FuZq
 * @CreateDate: 2019/5/7 9:32
 * @Version: 1.0
 */
public class InsertionSortList {
    /**
     * 对链表进行插入排序
     * 解决方案: 利用三个指针 前驱指针 cur当前节点指针 辅助指针(记录已经比较过的区间)
     * @author fuzq
     * @date 2019/5/7 11:26
     * @param head
     * @return com.fzq.lintcode.sort.InsertionSortList.ListNode
     */
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;//pre指向已经有序的节点
        ListNode cur = head.next;//cur指向待排序的节点

        ListNode aux = new ListNode(-1);//辅助节点
        aux.next = head;

        while (cur != null) {
            if (cur.val < pre.val) {
                //先把cur节点从当前链表中删除，然后再把cur节点插入到合适位置
                pre.next = cur.next;

                //从前往后找到l2.val>cur.val,然后把cur节点插入到l1和l2之间
                ListNode l1 = aux;
                ListNode l2 = aux.next;
                while (cur.val > l2.val) {
                    l1 = l2;
                    l2 = l2.next;
                }
                //把cur节点插入到l1和l2之间
                l1.next = cur;
                cur.next = l2;//插入合适位置

                cur = pre.next;//指向下一个待处理节点

            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return aux.next;
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
        System.out.println(insertionSortList(head));
    }
}