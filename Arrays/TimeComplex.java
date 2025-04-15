public class TimeComplex {
    public static int counter = 0;
    public static boolean foo ( int[]a , int[] b, int[] c ,int n){
        for (int i = 0 ; i < n ; i++){
            for ( int j = 0 ; j < n ; j++){
                if (a[i] == b[j]){
                    for (int k = 0 ; k < n ; k++){
                        if ( a[i] == c[k])return false;
                        counter++;
                    }
                }
            }
        }
        return true;
    }
    public static void main (String args[]){
        int [] a = {1,1,1}; 
        int [] b = {1,1,1};
        int [] c = {2,2,2};
        System.out.println(foo(a,b,c,3));
        System.out.println(counter);
    }
}
