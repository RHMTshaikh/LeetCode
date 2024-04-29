/*
 * 3. Longest Substring Without Repeating Characters
Medium
Topics
Companies
Given a string s, find the s.length() of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the s.length() of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the s.length() of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the s.length() of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.s.length() <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3{
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters3 s = new LongestSubstringWithoutRepeatingCharacters3();
        System.out.println(s.lengthOfLongestSubstring("bhu"));
    }
// }

// class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() ==0) return 0;
        if (s.length() ==1) return 1;
        if (s.length() ==2) {
            if (s.charAt(0) == s.charAt(1)) {
                return 1;
            }else{
                return 2;
            }
        }
        Set<Character> charSet = new HashSet<>();
        int i=0;
        int j=1;
        int max_len=1;
        charSet.add(s.charAt(i));
        while (j < s.length()) {
            if (charSet.contains(s.charAt(j))) {
                if (j-i > max_len) {
                    max_len = j-i;
                }
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        i = k+1;
                        break;
                    }
                    charSet.remove(s.charAt(k));
                }
            } else {
                charSet.add(s.charAt(j));
            }
            j++;
        }
        if (i>0 ) {
            if (s.charAt(j-1) != s.charAt(i-1)) {
                if (j-i > max_len) {
                    max_len = j-i;
                }
            }
        }else{
            max_len = j-i;
        }
        return max_len;
    }
}