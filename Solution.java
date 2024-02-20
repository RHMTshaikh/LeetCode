public class Solution {
    public static void main(String[] args) {
        int[] nums = {2};
        int val = 3;

        System.out.println("val = "+ val);
        System.out.println("k = "+removeElement(nums, val));
        System.out.print("arr = ");
        for (int i : nums) {
            System.out.print(i+" ");
        }
    }
    
    public static int removeElement(int[] nums, int val){
        int i=0, j=nums.length-1;
        while(i < j) {
            while (nums[i]!=val) {
                i++;
            }
            while (nums[j]==val) {
                j--;
            }
            if(i<j ){
                nums[i]=nums[j];
                nums[j]=val;
            }
        }
        return i;
    }

}
