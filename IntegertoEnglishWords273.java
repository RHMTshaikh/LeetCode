/*
273. Integer to English Words
Hard
Topics
Companies
Hint
Convert a non-negative integer num to its English words representation.

 

Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"
Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 

Constraints:

0 <= num <= 231 - 1
 */

public class IntegertoEnglishWords273 {
    public static void main(String[] args) {
        IntegertoEnglishWords273 a = new IntegertoEnglishWords273();

        // System.out.println(a.numberToWords(123));

    }
    
}

class Solution {
    public String numberToWords(int num) {
        StringBuilder words = new StringBuilder();
        int number = num;
        String[] billion = {"Billion ", "Million ","Thousand "};
        
        int place = 1_000_000_000;
        int placeVlaue = number/place;
        
        for (int index = 0; index < 3; index++) {
            if (placeVlaue != 0) {
                hundreden(words, placeVlaue);
                words.append(billion[index]);
            }  
            number = number%place;
            place /= 1000;
            placeVlaue = number/place;
        }
        hundreden(words, placeVlaue);
        if(words.length() >0) words.deleteCharAt(words.length()-1);
        else words.append("Zero");
        return words.toString();
    }

    String[] ones = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
    String[] teens = {"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    String[] tens = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    
    String hundreden(StringBuilder hundred, int placeVlaue){
        // StringBuilder hundred = new StringBuilder();
        int thirdDigit = placeVlaue/100;
        int secondDigit = (placeVlaue%100)/10;
        int firstDigit = (placeVlaue%10);
        
        hundred.append(ones[thirdDigit]);
        if(thirdDigit != 0) hundred.append("Hundred ");

        switch (secondDigit) {
            case 0:
                hundred.append(ones[firstDigit]);
                break;
            case 1:
                hundred.append(teens[firstDigit]);
                break;        
            default:
                hundred.append(tens[secondDigit]);
                hundred.append(ones[firstDigit]);
                break;
        }
        return hundred.toString();
    }
}
