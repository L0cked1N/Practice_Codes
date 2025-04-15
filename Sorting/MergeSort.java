public class MergeSort {
    public static int mergesort ( int[] nums, int left, int right){
        int count = 0;
        //terminating condition 

        if ( left < right ){
            int mid = (left + right )/2;

            count += mergesort(nums, left, mid);
            count += mergesort(nums, mid +1, right);

            count += merge(nums, left,mid, right);
        }
        return count ;

    }
    public static int merge ( int[] arr , int left , int mid, int right){
        int count =0;
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        // Merge the temp arrays

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
                count += (n1-i);
            }
            k++;
        }

        // Copy remaining elements of L[]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[]
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        return count;
    }


    public static void main (String args[]){
        int nums[] = { 3,15,12,7};
        System.out.println(mergesort(nums, 0, nums.length-1));

        for ( int num : nums )System.out.print(num + " ");

    }
}
