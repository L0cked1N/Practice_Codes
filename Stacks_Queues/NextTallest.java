import java.util.Stack;
class ListNode {
    int val;
    ListNode next = null;
    ListNode (int data){
        this.val = data;
        this.next = null;
    }
}
public class NextTallest {
    
    public static int[] tallest ( int [] arr){
        int[] sol = new int[arr.length];
        Stack<Integer> input = new Stack<>();
        for ( int i = 0 ; i < arr.length ; i++){
            input.push(arr[i]);
        }

        

        return sol;
    }
    public static void main (String args[]){
        int[] arr = {6, 1, 3,2,4,5,2,8};
        System.out.println(tallest(arr));
    }
}
// arrays se karna hai specified nhi hai ki we have to use stacks only 

