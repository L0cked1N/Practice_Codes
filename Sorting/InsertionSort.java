public class InsertionSort {
    public static void main (String args[]){
        int nums[] = {4,3,2,1};
        int counter = 0;
        for ( int i = 1; i < nums.length;i++){
            int dummy = nums[i];
            int insert =0;
            for ( int j = i-1 ; j >=0 ; j--){
                
                if ( dummy < nums[j]){
                    nums[j+1] = nums[j];
                    counter++;
                }

                else if (dummy > nums[j]){
                    insert = j+1;
                    break;
                }
            }
            nums[insert] = dummy;
        }
        System.out.println(counter);
        for ( int num : nums)System.out.print(num+" ");
    }
}
