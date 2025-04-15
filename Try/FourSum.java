import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> arr = new ArrayList<>();
        int n = nums.length;

        // Sort the array to facilitate duplicate handling
        Arrays.sort(nums);

        // Loop to select the first two numbers
        for (int a = 0; a < n - 3; a++) {
            // Skip duplicates for the first number
            if (a > 0 && nums[a] == nums[a - 1]) continue;

            for (int b = a + 1; b < n - 2; b++) {
                // Skip duplicates for the second number
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;

                int Rtarget = target - nums[a] - nums[b];
                HashMap<Integer, Integer> hm = new HashMap<>();

                // Loop to find pairs that sum to Rtarget
                for (int c = b + 1; c < n; c++) {
                    // Skip duplicates for the third number
                    if (c > b + 1 && nums[c] == nums[c - 1]) continue;

                    int val = Rtarget - nums[c];
                    if (hm.containsKey(val)) {
                        // Found a valid quadruplet
                        List<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(nums[a]);
                        quadruplet.add(nums[b]);
                        quadruplet.add(nums[c]);
                        quadruplet.add(val);
                        arr.add(quadruplet);
                    }
                    // Store the current number and its index in the HashMap
                    hm.put(nums[c], c);
                }
            }
        }

        // Remove duplicates from the result list
        List<List<Integer>> uniqueArr = new ArrayList<>();
        for (List<Integer> quad : arr) {
            if (!uniqueArr.contains(quad)) {
                uniqueArr.add(quad);
            }
        }

        return uniqueArr;
    }

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = fs.fourSum(nums, target);
        System.out.println(result);
    }
}