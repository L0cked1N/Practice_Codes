import java.util.LinkedList;
import java.util.Iterator;
public class Traversal {

    static int middleE(LinkedList <Integer> arr){ 
        int count = 0 ;
        Iterator<Integer> it = arr.iterator();
        while ( it.hasNext()){
            it.next();
            count++;
        }
        Iterator <Integer> it2 = arr.iterator();
        count = count/2;
        while (count > 0 ){
            it2.next();
            count--; 
        }
        return it2.next();
    }
    public static void main(String args[]){
        LinkedList<Integer> arr = new LinkedList<>();
        arr.add(1);arr.add(2);arr.add(3);arr.add(4);arr.add(5);
        int mid = middleE(arr);
        System.out.println(mid);
    }
}
