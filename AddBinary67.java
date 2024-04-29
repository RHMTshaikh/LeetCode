/*
 * 67. Add Binary
Easy
Topics
Companies
Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinary67{
    public static void main(String[] args) {
        AddBinary67 z = new AddBinary67();
        // System.out.println(z.addBinary("111", "111"));
    }
}

class Solution{
    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int sum=0;
        int a_index = a.length()-1;
        int b_index = b.length()-1;
        int commonLength = a_index < b_index ? a_index+1 : b_index+1;
    
        for (int i = 0; i < commonLength; i++) {
            sum += a.charAt(a_index--) - '0';
            sum += b.charAt(b_index--) - '0';
            s.insert(0, sum%2);
            sum = sum/2;
        }
        if (a_index < b_index) {
            while (b_index >= 0) {
                sum += b.charAt(b_index--) - '0';
                s.insert(0, sum%2);
                sum = sum/2;
            }
        }else{
            while (a_index >= 0 ) {
                sum += a.charAt(a_index--) - '0';
                s.insert(0, sum%2);
                sum = sum/2;
            }
        }
        if (sum ==1) {
            s.insert(0, '1');
        }
        return s.toString();
    }
}

// class Solution {
//     public String addBinary(String a, String b) {
//         StringBuilder s = new StringBuilder();
//         int sum=0;
//         int a_index = a.length()-1;
//         int b_index = b.length()-1;

//         while (sum ==1 || a_index >= 0 || b_index >= 0) {
//             if (a_index >= 0) {
//                 sum += a.charAt(a_index--) - '0';
//             }
//             if (b_index >= 0) {
//                 sum += b.charAt(b_index--) - '0';
//             }
//             s.insert(0, sum%2);
//             sum = sum/2;
//         }
//         return s.toString();
//     }
// }