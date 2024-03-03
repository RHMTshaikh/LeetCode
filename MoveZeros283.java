/*
 * 283. Move Zeroes
Easy
Topics
Companies
Hint
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 */
public class MoveZeros283 {
    
}

class Solution {
    public void moveZeroes(int[] nums) {
        // 0 0 1 2 3 0 0 0 4 5 6 7 8 9 10 0 0
        int first =0, second=0;
        while (first < nums.length && nums[first] != 0) {
            first++;
        }
        second = first;
        while (second < nums.length && nums[second] == 0) {
            second++;
        }
        while (second != nums.length) {
            while( second < nums.length && nums[second] != 0 ){
                nums[first++] = nums[second++];
            }
            while (second < nums.length && nums[second] == 0) {
                second++;
            }
        }
        while (first != nums.length) {
            nums[first++] = 0;
        }
    }
}