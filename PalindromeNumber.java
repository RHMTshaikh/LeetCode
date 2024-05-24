/*9. Palindrome Number
Easy
Topics
Companies
Hint
Given an integer x, return true if x is a 
palindrome
, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1 */

public class PalindromeNumber {
    
}
class Solution {
    public boolean isPalindrome(int x) {
        if (x<0) {
            return false;
        }
        if (x/10 == 0) {
            return true;
        }
        int y=0, z=x;
        while (z != 0) {
            y*=10;
            y+=(z%10);
            z/=10;
        }
        return x==y;
    }
}
