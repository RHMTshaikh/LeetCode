/*
 * 11. Container With Most Water
Medium
Topics
Companies
Hint
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
 

Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
 */

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        ContainerWithMostWater11 s = new ContainerWithMostWater11();
        int[] height = {1,2,3,4,5,25,24,3,4};
        System.out.println(s.maxArea(height));
    } 
// }
// class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int left_height = height[i], right_height = height[j];
        int smaller_height = ((left_height > right_height) ? right_height : left_height);
        int max_water = (j-i)*smaller_height;
        
        while(i < j){
            if (left_height <= right_height) {
                while (height[++i] <= left_height && i < j){}
                if (height[i] > right_height) {
                    left_height = height[i];
                }
                
                if (max_water <= (j-i)*((height[i] > right_height) ? right_height : height[i])) {
                    left_height = height[i];
                    smaller_height = ((left_height > right_height) ? right_height : left_height);
                    max_water = (j-i)*smaller_height;
                }
                
            } else {
                while (height[--j] <= right_height && i < j){}
                if (height[j] > left_height) {
                    right_height = height[j];
                }
                
                if (max_water <= (j-i)*((height[j] > left_height) ? left_height : height[j])) { 
                    right_height = height[j];
                    smaller_height = ((left_height > right_height) ? right_height : left_height);
                    max_water = (j-i)*smaller_height;
                }
            } 
        }

        return max_water;
    }
}

class Solution {
    public int maxArea(int[] height) {
        int max=0;
        int left =0;
        int right = height.length-1;

        while(left<right){
            int minHeight = Math.min(height[left],height[right]);
            max=Math.max(max,(minHeight * (right-left)));

            while(left<right && height[left]<=minHeight){
                left++;
            }
            
            while(left<right && height[right]<=minHeight){
                right--;
            }
        }
        return max;
    }
}