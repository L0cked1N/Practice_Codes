public class MaxDiff {
    public static void main(String[] args) {
        int nums[] = {12, 5, 9, 20, 17, 3, 8, 15, 11, 6};

        //first we find the max min 
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for ( int num : nums){
            if ( num < min) min = num;
            if (num > max) max = num;
        }
        //bucket sort 
        int bucketsize = (max-min)/(nums.length-1) + 1;
        int bucketcount = (max-min)/bucketsize + 1;
        
        int low[] = new int[bucketcount];
        int high[] = new int[bucketcount];
        
        //intializing the empty buckets 
        for ( int i = 0 ; i < bucketcount; i++){
            
            low[i] = Integer.MAX_VALUE;
            high[i] = Integer.MIN_VALUE;

        }

        //now putting the values
        for ( int num : nums){

            int bucketindex = (num - min)/bucketsize;

            low[bucketindex] = Math.min(low[bucketindex], num);
            high[bucketindex] = Math.max(high[bucketindex], num);

        }
        //now calculating the difference and keeping the biggest difference 
        int maxdiff = 0;
        int prevmax = min;
        for (int i = 0 ; i < bucketcount ;i++){
            if ( low[i] == Integer.MAX_VALUE && high[i] == Integer.MIN_VALUE)continue;
            maxdiff = Math.max(maxdiff, low[i] - prevmax);
            prevmax = high[i];
        }


        System.out.println(maxdiff);
    }
}
