import java.util.ArrayList;
import java.util.List;

public class SortByRev {
    public static void main(String[] args) {
        int nums[] = {3,2,4,1};
        List<Integer> output = new ArrayList<>();
        int max = nums.length;
        while ( unsorted(nums)){
            int index = 0;
            for ( int i = 0 ; i < nums.length;i++){
                if ( i == nums.length-1 && max == nums[i]){
                    max--;
                }
                if (nums[i] == max){
                    break;
                }
                
            }
            output.add(max);
            reverse( nums, max-1);
        }
        System.out.println(output);
    }
    public static boolean unsorted(int[] nums){
        for ( int i = 0; i < nums.length-1; i++){
            if ( nums[i] > nums[i+1])return true;
        }
        return false;
    }
    public static void reverse ( int[] nums, int index){
        for ( int i = 0; i < index/2 ; i++){
            int temp = nums[i];
            nums[i] = nums[index-i];
            nums[index-i] = temp;
        }
    }
}
