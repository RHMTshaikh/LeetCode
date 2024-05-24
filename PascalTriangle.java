/*
118. Pascal's Triangle
Easy
Topics
Companies
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30
*/
import java.util.List;
import java.util.ArrayList;

public class PascalTriangle{
    public static void main(String[] args) {
        generate(6);
    }
// }
// class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(1));
        if (numRows == 1) {
            return triangle;
        }
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> lastRow = triangle.get(triangle.size()-1);
            List<Integer> newRow = new ArrayList<>();

            newRow.add(1);
            for (int j = 1; j < lastRow.size(); j++) {
                newRow.add(lastRow.get(j-1)+lastRow.get(j));
            }
            newRow.add(1);

            triangle.add(newRow);
           
        }
        System.out.println(triangle.toString());
        
        return triangle;
    }
}
