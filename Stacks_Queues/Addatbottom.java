//using java framework
import java.util.Stack;
public class Addatbottom {
    //adding at bottom of a stack 

    public static Stack<Integer> atBottom(Stack <Integer> s , int val){
        if ( s.empty()){
            s.push(val);
            return s;
        }
        int top = s.pop();
        s = atBottom(s, val);
        s.push(top);
        return s;
    }

    public static void main (String args[]){
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        s = atBottom(s, 4);

        System.out.println(s);

    }
}
