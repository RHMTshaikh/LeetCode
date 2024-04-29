/*485. Max Consecutive Ones
Easy
Topics
Companies
Hint
Given a binary array nums, return the maximum number of consecutive 1's in the array.

 

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.*/

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
// }


// class Solution {
    static public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length ==1 ) {
            return nums[0]==1 ? 1 : 0;
        }
        int maxOnesCout =0;
        int j;
        for (int i = 0; i < nums.length; i++) {
            j=i;
            while (j<nums.length && nums[j] == 1) {
                j++;
            }
            if (maxOnesCout < j-i) {
                maxOnesCout = j-i;
            }
            i=j;
        }
        
        return maxOnesCout;
    }
}