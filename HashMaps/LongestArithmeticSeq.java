import java.util.HashMap;
class LongestArithmeticSeq {
    public static int longestArithSeqLength(int[] nums) {
        if (nums.length < 2) return nums.length; // If the array has less than 2 elements, return its length
        
        int maxLength = 1; // At least the smallest subsequence is of length 1
        // dp will store the longest length for each difference at each index
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
        
        // Initialize dp array where each element is a HashMap
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();
        }
        
        // Iterate through each pair of elements in the array
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];  // Calculate the common difference
                
                // If a subsequence with this difference exists, extend it; otherwise, start a new subsequence of length 2
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                
                // Update the maximum subsequence length found
                maxLength = Math.max(maxLength, dp[i].get(diff));
            }
        }
        
        return maxLength;
    }
    public static void main(String[] args) {
        int[] nums = {3,6,9,12};
        System.out.println(longestArithSeqLength(nums));
    }
}

