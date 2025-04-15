import java.util.LinkedList;
import java.util.Scanner;
public class RotateList {
    
    public static void reversal ( LinkedList<Integer> arr, int k){
        int n = arr.size();
        k = k % n;
        if (k == 0 ){
            //no rotation needed
            return;
        }

        for ( int i = 0 ; i < k ; i++){
            int temp = arr.removeFirst();
            arr.addLast(temp);
        }
    }
    public static void main (String arg[]){
        Scanner s = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        int n = s.nextInt();
        for ( int i = 0 ; i < n ; i ++){
            list.add(s.nextInt());
        }

        int k = s.nextInt();
        reversal(list, k);

        System.out.println(list);

        s.close();

    }
}