public class BeautifulArray {
    public static void main(String[] args) {
        int nums[] = {7,15,12,3};
        int count = 0;

        int last = nums.length-1;
        while (last > 0){
            int index = 0;
            int max = nums[0];
            for ( int i = 0 ; i <= last ; i++){
                if( max < nums[i]) {
                    max = nums[i];
                    index = i;
                }
            }
            if( nums[last]!= nums[index]){
                count++;
                int temp = nums[last];
                nums[last] = nums[index];
                nums[index] = temp;
                
            }
            

            last--;
        }
        System.out.println(count);
        for(int num : nums)System.out.print(num + " ");
        
    }
}
