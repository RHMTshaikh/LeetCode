/*
 * 137. Single Number II
Medium
Topics
Companies
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
 

Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.
 */

import ZeeshanSir.Sorting;

public class SingleNimber11 {
    public static void main(String[] args) {
        SingleNimber11 s = new SingleNimber11();
        int[] arr = {4,4,4,2,2,2,-1};
        // int[] arr = {-2,-2,1,1,4,1,4,4,-4,-2};
        System.out.println(s.singleNumber(arr));
        // System.out.println(-3^(Integer.MIN_VALUE));
        for (int i : arr) {
            System.out.println(i);
        }
    }
    // }
    // class Solution{
        public int singleNumber(int[] nums){
        Sorting sort = new Sorting();
        nums = sort.mergeSort(nums, 0, nums.length-1);
        for (int i = 1; i < nums.length; i+=3) {
            if (nums[i-1] != nums[i]) {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}
// class Solution {
    // public int singleNumber(int[] nums) {
    //     int number=0;
    //     int count =0;
    //     int bit=1;
    //     for (int i = 1; i < 32; i++) {
    //         for (int j = 0; j < nums.length; j++) {
    //             if ((nums[j]&bit) > 0) {
    //                 count++;
    //             }
    //         }
    //         if (count%3 == 1) {
    //             number = number^bit;
    //         }
    //         bit = bit<<1;
    //         count =0;
    //     }
    //     for (int j = 0; j < nums.length; j++) {
    //         if ((nums[j]&Integer.MIN_VALUE) < 0) {
    //             count++;
    //         }
    //     }
    //     if (count%3 == 1) {
    //         number = number^bit;
    //     }
    //     return number;
    // }
// }