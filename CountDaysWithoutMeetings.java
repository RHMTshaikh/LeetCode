/*
 * 3169. Count Days Without Meetings
Medium
Topics
Companies
Hint
You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).

Return the count of days when the employee is available for work but no meetings are scheduled.

Note: The meetings may overlap.

 

Example 1:

Input: days = 10, meetings = [[5,7],[1,3],[9,10]]

Output: 2

Explanation:

There is no meeting scheduled on the 4th and 8th days.

Example 2:

Input: days = 5, meetings = [[2,4],[1,3]]

Output: 1

Explanation:

There is no meeting scheduled on the 5th day.

Example 3:

Input: days = 6, meetings = [[1,6]]

Output: 0

Explanation:

Meetings are scheduled for all working days.

 

Constraints:

1 <= days <= 109
1 <= meetings.length <= 105
meetings[i].length == 2
1 <= meetings[i][0] <= meetings[i][1] <= days
 */

import java.util.Arrays;

public class CountDaysWithoutMeetings{
    public static void main(String[] args) {
        CountDaysWithoutMeetings s = new CountDaysWithoutMeetings();
        int[][] meetings = {{2,3},{1,2},{2,3},{2,4},{1,2},{1,3}};
        int days = 100001;
        System.out.println(s.countDays(days, meetings));
    }
// }
// class Solution {
    public int countDays(int days, int[][] meetings) {
        meetings = quickSort(meetings, 0, meetings.length-1);
        for (int[] arr : meetings) {
            System.out.println(" "+Arrays.toString(arr));
        }
        int offDays = -1;
        offDays += meetings[0][0];
        int right = meetings[0][1];
        for (int i = 1; i < meetings.length; i++) {
            if (right < meetings[i][0]) {
                offDays += meetings[i][0]-right-1;
                right = meetings[i][1];
            } else{
                right = Math.max(right, meetings[i][1]);
            }
        }
        offDays += days-right;
        return offDays;
    }


    public static int[][] quickSort(int[][] arr, int low, int high){
        if(low<high){
            int p_index = partition(arr,low,high);

            quickSort(arr, low, p_index-1);
            quickSort(arr, p_index+1, high);
        }
        return arr;
    }
    public static int partition(int[][] arr, int low, int high){
        int[] pivot = arr[high]; // rightmost element is always the pivot
        int i = low -1;
        for(int j = low; j<high; j++){
            if(arr[j][0] < pivot[0]){
                i++;
                int[] temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[high] = arr[i + 1];
        arr[i + 1] = pivot;

        return i + 1;
    }


    public static int[][] mergeSort(int[][] array, int s, int e){
        if (s == e) {
            return new int[][]{array[s]};
        }
        int mid = s+(e-s)/2;
        return mergeSortedArray(mergeSort(array, s, mid), mergeSort(array, mid+1, e));
    }
    public static int[][] mergeSortedArray(int[][] arr1, int[][] arr2){
        int[][] arr3 = new int[arr1.length+arr2.length][];
        int pointer1=0, pointer2=0, pointer3=0;
        while(pointer1 < arr1.length && pointer2 < arr2.length){
            if (arr1[pointer1][0] < arr2[pointer2][0]) {
                arr3[pointer3++] = arr1[pointer1++];
            } else {
                arr3[pointer3++] =arr2[pointer2++];
            }
        }
        while (pointer1 < arr1.length) {
            arr3[pointer3++]=arr1[pointer1++];
        }
        while (pointer2 < arr2.length) {
            arr3[pointer3++]=arr2[pointer2++];
        }
        return arr3;
    }
}