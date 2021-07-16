package com.example.demo;

import org.assertj.core.util.Arrays;

class Solution {
    public static int duplicateInArray(int[] nums) {

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            int s = 0;
            for (int i = 0; i <= nums.length - 1; i++) {
                if (nums[i] >= l && nums[i] <= mid) {
                    s += 1;
                }
            }
            if (s >= mid - l + 1) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 7, 5, 9, 7, 9, 5, 1, 5, 6, 7 };
        int solution = Solution.duplicateInArray(nums);
        System.out.print(solution);
    }

}