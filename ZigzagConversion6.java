/*
 * 6. Zigzag Conversion
Medium
Topics
Companies
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */

public class ZigzagConversion6 {
    public static void main(String[] args) {
        ZigzagConversion6 z = new ZigzagConversion6();
        // System.out.println(z.convert("PAYPALISHIRING", 4));
        
    }
    
}

class Solution {
    public String convert(String s, int numRows) {
        int length = s.length();
        if (length <= numRows || numRows ==1) {
            return s;
        }
        
        char[] result = new char[length];
        int waveLength1 = 2*(numRows-1), waveLength2 =0;
        int index=0;
        int i=0;

        while (i < length && index < length) {
            result[index++] = s.charAt(i);
            i+=waveLength1;
        }

        waveLength1 -=2;
        waveLength2 +=2;

        for (i = 1; i < numRows-1 && i < length; i++) {
            
            while (i < length) {
                result[index++] = s.charAt(i);
                i+=waveLength1;
                if (i < length) {
                    result[index++] = s.charAt(i);
                } else {
                    break;
                }
                i+=waveLength2;
            }

            i=waveLength2/2;
            waveLength1-=2;
            waveLength2+=2;
        }
        while (i < length && index < length) {
            result[index++] = s.charAt(i);
            i+=waveLength2;
        }
        // return result.toString();// returns refrence
        return new String(result);
    }
}