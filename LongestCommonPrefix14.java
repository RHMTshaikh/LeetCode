/*
14. Longest Common Prefix
Easy
Topics
Companies
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
 */

public class LongestCommonPrefix14 {
    
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==1) return strs[0];
        
        int minSize=200;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minSize) {
                minSize = strs[i].length();
            }
            if (minSize == 0) return "";
        }
        
        int i,j=1;
        outerloop:
        for (i = 0; i < minSize; i++) {
            for (j = 1; j < strs.length; j++) {
                if (strs[j-1].charAt(i) != strs[j].charAt(i)) {
                    break outerloop;
                }
            }
        }
        if (j != strs.length) {
            return strs[0].substring(0, i);
        }
        return strs[0].substring(0,minSize);
    }
}   
