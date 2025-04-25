public class ThreeValues {
    public static void main ( String args[]){
        int nums[] = {0 , 0 , 2 , 1 ,1,2,2,1,1,1,0,0,1,1,1};
        
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while ( mid <= high){
            if ( nums[mid] == 0){
                //swap
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if (nums[mid] == 1)mid++;
            else {
                //swap 
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }

        for ( int num: nums)System.out.print (num+ ",");
    }
}
