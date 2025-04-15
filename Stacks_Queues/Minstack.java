import java.util.EmptyStackException;
import java.util.Stack;
  
class MinStack {

    private Stack<Integer> stack1;
    private Stack<Integer> minstack; 

    public MinStack() {
        stack1 = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int val) {
        if ( minstack.isEmpty() || val <= minstack.peek() ){
            minstack.push(val);
        }
        stack1.push(val);
    }
    
    public void pop() {
        if (stack1.isEmpty()) {
            throw new EmptyStackException();
        }
        int n = stack1.pop();
        if ( !minstack.isEmpty() && n == minstack.peek()){
            minstack.pop();
        }

    }
    
    public int top() {
        if (stack1.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack1.peek();
    }
    
    public int getMin() {
        if( minstack.isEmpty()){
            throw new EmptyStackException();
        }
        return minstack.peek();
        
    }
}

public class Minstack {

    public static void main (String args[]){

    }  
}
