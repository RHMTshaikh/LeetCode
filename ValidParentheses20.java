/*
20. Valid Parentheses
Easy
Topics
Companies
Hint
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */

import java.util.Stack;

public class ValidParentheses20 {
    public static void main(String[] args) {
        ValidParentheses20 a = new ValidParentheses20();
        System.out.println((int)'(');//40
        System.out.println((int)')');//41
        System.out.println((int)'[');//91
        System.out.println((int)']');//93
        System.out.println((int)'{');//123
        System.out.println((int)'}');//125
    }
}

class Solution {
    public boolean isValid(String s) {
        if (s.length() < 2 || s.length()%2 == 1) return false;     

        if (!(s.charAt(0) == 40 || s.charAt(0) == 91 || s.charAt(0) == 123)) {
            return false;
        }
        
        Stack<Character> stk = new Stack<>();

        for (char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '['){
                stk.push(c);
            } else{
                if (stk.isEmpty()) {
                    return false;
                }
                char top = stk.pop();
                if ((c == ']' && top != '[') || (c == '}' && top != '{') || (c == ')' && top != '(')) {
                    return false; // Mismatched brackets
                }            
            }
        }
        return stk.isEmpty();
    }
}