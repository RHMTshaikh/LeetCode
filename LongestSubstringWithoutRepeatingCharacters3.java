/*
 * 3. Longest Substring Without Repeating Characters
Medium
Topics
Companies
Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

public class LongestSubstringWithoutRepeatingCharacters3{
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters3 s = new LongestSubstringWithoutRepeatingCharacters3();
        // System.out.println(s.lengthOfLongestSubstring("aab"));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length ==0) return 0;
        if (length ==1) return 1;

        boolean[] indexes = new boolean[length];
        for (int i = 0; i < length-1 && indexes[i] == false; i++) {
            char c = s.charAt(i);
            boolean found = false;
            for (int j = i+1; j < length; j++) {
                if (s.charAt(j) == c ) {
                    found = true;
                    indexes[j] = true;
                }
            }
            if(found) indexes[i] = true;
        }

        int max_len=1;
        int first_index=-1, second_index=0;
        while (second_index < length-1 && !indexes[second_index] ) {
            second_index++;
        }
        int len;
        while (second_index < length) {
            len = second_index - first_index;
            if (len > max_len) max_len = len;

            first_index = second_index;
            second_index++;

            while (second_index < length && !indexes[second_index]) {
                second_index++;
            }
        }

        len = second_index - first_index;
        if (len > max_len) {
            max_len = len;
        }
        return max_len;
    }
}