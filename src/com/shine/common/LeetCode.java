package com.shine.common;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 力扣算法演算
 *
 * @author shineYu
 * @date 2019/10/8 9:46
 * @Copyright shine_yu@vip.163.com .
 */
public class LeetCode {

    /**
     * 349. 两个数组的交集
     */
    class Solution349 {
        public int[] intersection(int[] nums1, int[] nums2) {

            TreeSet<Integer> sets = new TreeSet();
            for (int i : nums1) {
                sets.add(i);
            }

            ArrayList<Integer> list = new ArrayList();
            for (int i : nums2) {
                if (sets.contains(i)) {
                    list.add(i);
                    sets.remove(i);
                }
            }

            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }

    /**
     * 1. 猜数字
     */
    class Solution1 {
        public int game(int[] guess, int[] answer) {
            int num = 0;
            for (int i = 0; i < guess.length; i++) {
                if (guess[i] == answer[i]) {
                    num++;
                }
            }
            return num;
        }
    }

    /**
     * 771. 宝石与石头
     */
    class Solution771 {
        public int numJewelsInStones(String J, String S) {
            return 1;
        }
    }

    /**
     * 862. 和至少为 K 的最短子数组
     * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
     * 如果没有和至少为 K 的非空子数组，返回 -1 。
     * 输入：A = [2,-1,2], K = 3
     * 输出：3
     */
    public static class Solution862 {
        public int shortestSubarray(int[] arrs, int K) {
            int count = 0;
            while (count < arrs.length) {
                int sum;
                count++;
                for (int i = 0; i < arrs.length; i++) {
                    sum = 0;
                    for (int j = i; j < count + i; j++) {
                        if (j == arrs.length) {
                            break;
                        }
                        sum += arrs[j];
                        if (sum >= K) {
                            return count;
                        }
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] A = {48,99,37,4,-31};
        Solution862 test = new Solution862();
        System.out.println(test.shortestSubarray(A, 140));
    }

}
