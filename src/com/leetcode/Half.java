package com.leetcode;

/**
 * @author wangyu@mvtech.com.cn
 * @date: 2020-06-17 16:56
 *
 * <p>
 *     二分
 */
public class Half {



    public static void main(String[] args) {
        int[] in=new int[]{1,2,3,4,9,9,20,22,30,31};
        final int i = binarySerach(in, 9);
        System.out.println(i);
    }

    public static int binarySerach(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == key) {
                return mid;
            }
            else if (array[mid] < key) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        if (right >= 0 && array[right] == key) {
            return right;
        }

        return -1;
    }
}
