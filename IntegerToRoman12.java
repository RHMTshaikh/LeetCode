/*
 * 12. Integer to Roman
Medium
Topics
Companies
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.

 

Example 1:

Input: num = 3
Output: "III"
Explanation: 3 is represented as 3 ones.
Example 2:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 3:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= num <= 3999
 */

public class IntegerToRoman12 {
    public static void main(String[] args) {
        IntegerToRoman12 aa =  new IntegerToRoman12();
       
        // System.out.println(aa.intToRoman(58));
    }
}
class Solution {
    public String intToRoman(int num) {
        int number = num;
        StringBuilder roman = new StringBuilder();
        int thousands = number/1000;
        for (int i = 0; i < thousands; i++) {
            // roman += "M";
            roman.append('M');
        }
        number = number%1000;
        int place = 100;

        while (place > 0) {
            // roman += forPlace(place, number);
            roman.append(forPlace(place, number));
            number = number%place;
            place /= 10;
        }
        return roman.toString();
    }

    char[] charecter = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
                     //  1,  5,   10,  50,  100, 500,  1000
    String forPlace(int place, int number){
        StringBuilder s = new StringBuilder();
        int index =0;
        int placeVlaue = number/place;
        while (place > 1) {
            place /=10;
            index +=2;
        }
        char one = charecter[index], five = charecter[index+1], ten = charecter[index+2];

        if(placeVlaue == 9){
            // s += one;
            // s += ten;
            s.append(one);
            s.append(ten);
            return s.toString();
        }
        if(placeVlaue == 4){
            // s += one;
            // s += five;
            s.append(one);
            s.append(five);
            return s.toString();
        }
        if (placeVlaue > 4) {
            // s += five;
            s.append(five);
            placeVlaue -= 5;
        }
        for (int i = 0; i < placeVlaue; i++) {
            // s += one;
            s.append(one);
        }
        return s.toString();
    }
}

