import java.util.Scanner;
public class RangeQuery {
    public static void main(String args[]){
        Scanner s= new Scanner(System.in);
        int n = s.nextInt(); 

        long[] arr = new long[n];
        for( int i = 0 ; i < n ; i ++){
            arr[i] = s.nextLong();
        }

        int q = s.nextInt();
        for ( int i = 0 ; i < q ; i++){
            int l = s.nextInt();
            int r = s.nextInt();
            long min = minimum (arr,l,r);
            System.out.println("The minimum in the range is "+ min);
        }
        s.close();
        
    }    

    public static long minimum(long[]arr , int l , int r){
        long min = 0 ;// negative values keliye kaam hi nhi karta toh we have to set it to max value of a long integer
        for ( int i = l-1 ; i < r ; i++){
            if ( min >= arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
}
