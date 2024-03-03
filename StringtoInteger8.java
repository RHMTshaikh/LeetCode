/*
8. String to Integer (atoi)
Medium
Topics
Companies
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
Note:

Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 

Example 1:

Input: s = "42"
Output: 42
Explanation: The underlined characters are what is read in, the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^
The parsed integer is 42.
Since 42 is in the range [-231, 231 - 1], the final result is 42.
Example 2:

Input: s = "   -42"
Output: -42
Explanation:
Step 1: "   -42" (leading whitespace is read and ignored)
            ^
Step 2: "   -42" ('-' is read, so the result should be negative)
             ^
Step 3: "   -42" ("42" is read in)
               ^
The parsed integer is -42.
Since -42 is in the range [-231, 231 - 1], the final result is -42.
Example 3:

Input: s = "4193 with words"
Output: 4193
Explanation:
Step 1: "4193 with words" (no characters read because there is no leading whitespace)
         ^
Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
             ^
The parsed integer is 4193.
Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
 

Constraints:

0 <= s.length <= 200
s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 */

import java.util.HashMap;
import java.util.Map;

public class StringtoInteger8 {
    public static void main(String[] args) {
        StringtoInteger8 a = new StringtoInteger8();
        
        System.out.println(a.myAtoi("-165541"));
    }
// }
// class Solution {
    public int myAtoi(String s) {
        boolean begin = true;
        char[] c = s.toCharArray();
        int p = 0;
        int res = 0;
        while (p < c.length && c[p] == ' ') {
            p ++;
        }
        int positive = 1;
        for (int i = p; i < c.length; i ++) {
            if (begin == true && c[i] == '-') {
                positive = -1;
            }
            else if (begin == true && c[i] == '+') {
                positive = 1;
            }
            else if (Character.isDigit(c[i])) {
                int temp = c[i] - '0';
                if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10&&temp>Integer.MAX_VALUE%10)){
                    return Integer.MAX_VALUE;
                }

                if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10&&-temp<Integer.MIN_VALUE%10)){
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + temp*positive;
                System.out.println(res);
            }else {
                break;
            }
            begin = false;
        }
        return res;
    }
}
// class Solution {
//     public int myAtoi(String s) {
        
//         int start=0;
//         int len = s.length();

//         if (len ==0) return 0;
        
//         if (!(s.charAt(start) == ' ' || s.charAt(start) == '-' || s.charAt(start) == '+' || Character.isDigit(s.charAt(start)))) {
//             return 0;
//         }
//         while (start < len) {
//             if (s.charAt(start) != ' ') {
//                 break;
//             }
//             start++;
//         }
//         if (start == len) {
//             return 0;
//         }
//         if (!(s.charAt(start) == '-' || s.charAt(start) == '+' || Character.isDigit(s.charAt(start)))) {
//             return 0;
//         }
        
//         boolean negative = false;
//         if (s.charAt(start) == '+') {
//             start++;
//         }
//         else if (s.charAt(start) == '-') {
//             start++;
//             negative = true;
//         }
        
//         if (start == len) {
//             return 0;
//         }
//         if (!Character.isDigit(s.charAt(start))) {
//             return 0;
//         }
        
//         int end = start;
//         while (end < len-1 ){
//             if (Character.isDigit(s.charAt(end+1))) {
//                 end++;
//             } else break;
//         }
        
//         while (start < end) {
//             if (s.charAt(start) != '0') {
//                 break;
//             }
//             start++;
//         }

        
//         int number=0;
//         if (start == end) { // number is all zeros 
//             number = s.charAt(start) -'0';
//             if (number ==0) {
//                 return 0;
//             }
//             if (negative) {
//                 number = -number;
//             }
//             return number;
//         }
//         if (end - start +1 < 10) {
//             while (start <= end) {
//                 number *=10;
//                 number += s.charAt(start) -'0';
//                 start++;
//             }
//             if (negative) {
//                 number = -number;
//             }
            
//         } else if(end - start +1 == 10) {
//             int numOfDigits=0;
//             while (numOfDigits < 9) { // equal to 9 digits 
//                 number *=10;
//                 number += s.charAt(start) -'0';
//                 numOfDigits++;
//                 start++;
//             }
//             if (number > 214748364) {
//                 if (negative) {
//                     return -2147483648;
//                 }
//                 return 2147483647;
                
//             }else if(number == 214748364){
//                 if (negative) {
//                     if (s.charAt(start) -'0' >= 8) {
//                         return -2147483648;
//                     }
//                     number *=10;
//                     number += s.charAt(start) -'0';
//                     number = - number;
//                     return number;
//                 } else {
//                     if (s.charAt(start) -'0' >= 7) {
//                         return 2147483647;
//                     }
//                     number *=10;
//                     number += s.charAt(start) -'0';
//                     return number;
//                 }
//             } else{
//                 number *=10;
//                 number += s.charAt(start) -'0';
//                 if (negative) {
//                     number = -number;
//                 }
//                 return number;
                
//             }
            
//         } else{
//             if (negative) {
//                 return -2147483648;
//             } else {
//                 return 2147483647;
//             }

//         }
        
//         return number;
//     }
// }


