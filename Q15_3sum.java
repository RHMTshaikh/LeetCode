import java.util.ArrayList;
import java.util.List;
public class Q15_3sum {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        // int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        for (List<Integer> list : threeSum(nums)) {
            for (Integer elements : list) {
                System.out.print(elements+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        int l = nums.length, c=0;
        for (int i = 0; i < l-2; i++) {
            for (int j = i+1; j < l-1; j++) {
                for (int k = j+1; k < l; k++) {
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> subList = new ArrayList<>();
                        subList.add(nums[i]);
                        subList.add(nums[j]);
                        subList.add(nums[k]);
                        if(!(isContains(listOfLists, subList))){
                            if(nums[i]==0 && nums[j]==0 && nums[k]==0) c=1;
                            System.out.println('a');
                            listOfLists.add(subList);
                        } else if(c==0 && nums[i]==0 && nums[j]==0 && nums[k]==0){
                            c=1;
                            System.out.println('b');
                            listOfLists.add(subList);
                        }
                    }
                }
            }
        }
        return listOfLists;
    }
    public static boolean isContains(List<List<Integer>> listOfLists, List<Integer> subList){
        for (int i = 0; i < listOfLists.size(); i++) {
            byte b =0;
            for (int j = 0; j < 3; j++) {
                if((listOfLists.get(i).contains(subList.get(j)))){
                    b++;
                } else{
                    j=4;
                }
            }
            if (b==3) return true;
        }
        return false;
    }
}
