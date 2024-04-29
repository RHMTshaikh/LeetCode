/*
33. Search in Rotated Sorted Array
Medium
Topics
Companies
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104 */


public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {
        SearchInRotatedSortedArray33 s = new SearchInRotatedSortedArray33();
        int[] nums = {6};
        System.out.println(s.search(nums, 6));
    }

     
// }

// class Solution {
    public int search(int[] nums, int target) {
        int left=0, right = nums.length-1;
        int k;
        if (left == right || nums[left] < nums[right]) {
            k = 0;
        }else{
            k = rotatedBy(nums, left, right);
        }
        
        return binarySearch(nums, target, left, right, k);
    }
    public int binarySearch(int[] nums, int target, int left, int right, int k){

        if (left <= right) {
            int mid = (left+right)/2;
            if (target == nums[(mid+k)%nums.length]) {
                return (mid+k)%nums.length;
            }
            else if(target < nums[(mid+k)%nums.length]){
                right = mid -1; 
                return binarySearch(nums, target, left, right, k);
            }else{
                left = mid +1; 
                return binarySearch(nums, target, left, right, k);
            }
        }
        return -1;
    }

    public int rotatedBy(int[] nums, int left, int right){
        if(left+1 == right && nums[left] > nums[right]){
            return right;
        }
        int mid = (left+right)/2;
        if (left < mid && nums[left] > nums[mid]) {
            return rotatedBy(nums, left, mid);
        }else{
            return rotatedBy(nums, mid, right);
        }
    }
}