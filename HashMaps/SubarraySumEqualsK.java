import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0; // To count the number of subarrays
        int cumulativeSum = 0; // To keep track of the cumulative sum
        HashMap<Integer, Integer> sumMap = new HashMap<>(); // To store the frequency of cumulative sums
        
        // Initialize the map with the cumulative sum of 0
        sumMap.put(0, 1);

        // Iterate through the array
        for (int num : nums) {
            cumulativeSum += num; // Update the cumulative sum
            
            // Check if (cumulativeSum - k) exists in the map
            if (sumMap.containsKey(cumulativeSum - k)) {
                count += sumMap.get(cumulativeSum - k); // Increment count by the frequency of (cumulativeSum - k)
            }
            
            // Update the map with the current cumulative sum
            sumMap.put(cumulativeSum, sumMap.getOrDefault(cumulativeSum, 0) + 1);
        }

        return count; // Return the total count of subarrays
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        int[] nums1 = {3,1,4,9,5,14};
        int k1 = 14;
        System.out.println(solution.subarraySum(nums1, k1)); // Output: 2

        int[] nums2 = {1, 1, 1};
        int k2 = 2;
        System.out.println(solution.subarraySum(nums2, k2)); // Output: 2
    }
}