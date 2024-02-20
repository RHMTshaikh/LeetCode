/*
2149. Rearrange Array Elements by Sign
Medium
Topics
Companies
Hint
You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should rearrange the elements of nums such that the modified array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

 

Example 1:

Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.  
Example 2:

Input: nums = [-1,1]
Output: [1,-1]
Explanation:
1 is the only positive integer and -1 the only negative integer in nums.
So nums is rearranged to [1,-1].
 

Constraints:

2 <= nums.length <= 2 * 105
nums.length is even
1 <= |nums[i]| <= 105
nums consists of equal number of positive and negative integers.
*/

public class RearrangeArrayElementsbySign2149 {
    Solution s =  new Solution();
}
class Solution {
    public int[] rearrangeArray(int[] a) {
        int n=a.length;
        int []ans=new int[n];
       int posIndex=0,negIndex=1;
       for(int i=0;i<n;i++){
           if(a[i]>0){
               ans[posIndex]=a[i];
               posIndex+=2;
           }
           else{
               ans[negIndex]=a[i];
               negIndex+=2;
           }
       }
       return ans;

    }
}
// class Solution {
//     public int[] rearrangeArray(int[] nums) {
//         int len = nums.length;
//         int[] result = new int[len];
//         int pos_pointer=0;
//         int neg_pointer=0;

//         if (nums[pos_pointer] < 0) {
//             pos_pointer++;
//             while (nums[pos_pointer] < 0) {
//                 pos_pointer++;
//             }
//         } else{
//             neg_pointer++;
//             while (nums[neg_pointer] > 0) {
//                 neg_pointer++;
//             }
//         }

//         for (int i = 0; i < len; ) {
//             result[i++]= nums[pos_pointer++];
            
//             while (pos_pointer < len && nums[pos_pointer] < 0) {
//                 pos_pointer++;
//             }
            
//             result[i++]= nums[neg_pointer++];

//             while (neg_pointer < len && nums[neg_pointer] > 0 ) {
//                 neg_pointer++;
//             }
//         }
//         return result;
//     }
// }
