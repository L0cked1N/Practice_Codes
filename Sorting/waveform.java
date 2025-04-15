class waveform {
    public static void main ( String args[]){
        int nums[] = {10,5,6,3,2,20,100,80};
        for ( int i = 1; i < nums.length - 1; i++){
            if ( nums [ i -1 ] <= nums [i]){
                if ( nums [ i ] < nums[i+1]){
                    int temp = nums [ i];
                    nums[ i ] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
            else if (nums [ i -1 ] >= nums [ i]){
                if ( nums[ i ] > nums[i+1]){
                    int temp = nums [i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
        }

        for( int num : nums)System.err.print(num + " ");
    }
}