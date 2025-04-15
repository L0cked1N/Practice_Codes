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
    
    public int pop() {
        if (stack1.isEmpty()) {
            throw new EmptyStackException();
        }
        int n = stack1.pop();
        if ( !minstack.isEmpty() && n == minstack.peek()){
            minstack.pop();
        }
        return n;
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
    
        public boolean isEmpty() {
            if (stack1.isEmpty())return true;
            return false;
        }
    }    
    public class MinQueue {
        
        private MinStack enqueueStack;
        private MinStack dequeueStack;
        public MinQueue(){
            enqueueStack = new MinStack();
            dequeueStack = new MinStack();
        }
    
        public void enqueue (int x){
            enqueueStack.push(x);
            
            
        }
    
        public void dequeue (){
            //we build an empty dequeue stack 
            while ( !enqueueStack.isEmpty()){
                dequeueStack.push(enqueueStack.pop());
            }

            dequeueStack.pop();
        }

        public int front (){
            return dequeueStack.top();
        }

        
        
}
     

