/*
239. Sliding Window Maximum
Hard
Topics
Companies
Hint
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */

public class SlidingWindowMaximum239{
    public static void main(String[] args) {
        SlidingWindowMaximum239 s = new SlidingWindowMaximum239();
        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        for (int i : s.maxSlidingWindow(nums, 5)) {
            System.out.print(i+" ");
        }
    }
    
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }
        int[] max = new int[len-k+1];
        if (k ==1) {
            return nums;
        }
        int index_max=0;

        for (int i = 1; i < k; i++) {
            if (nums[index_max] <= nums[i]) {
                index_max = i;
            }
        }
        max[0] = nums[index_max];
        
        for (int i = 0; i < len-k; i++) {
            if (index_max == i) {
                if (nums[index_max] <= nums[i+k]) {
                    index_max = i+k;
                    max[i+1] = nums[index_max];                    
                } else {
                    index_max = i+1;
                    for (int j = i+1; j < i+k; j++) {
                        if (nums[index_max] <= nums[j+1]) {
                            index_max = j+1;
                        }
                    }
                    max[i+1] = nums[index_max];                    
                }
            } else {
                if (nums[i+k] >= nums[index_max]) {
                    index_max = i+k;
                }
                max[i+1] = nums[index_max];                    
            }
        }
        return max;
    }
}