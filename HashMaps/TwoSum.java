import java.util.HashMap;
public class TwoSum {
    public static void main ( String args[]){
        long[] nums = {2,7,9,17,0,3,4};
        HashMap<Long, Integer> hm = new HashMap<>();
        long target = 6;
        long count = 0; 
        for ( int i = 0 ; i < nums.length; i++){
            long curr = target - nums[i];
            if ( hm.containsKey(curr) && hm.get(curr) != i){
                count++;
            }
            hm.put(nums[i], i);

        }
        System.out.println(count);
    }
}
