import java.util.Stack;
class MyQueue{
    private Stack <Integer> stack1;
    private Stack <Integer> stack2;
    
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        }
        public void enqueue(int x) {
            //adding element to the very end of the queue
            while ( stack1.isEmpty()){
                int top = stack1.pop();
                stack2.push(top);
            }
            stack1.push(x);
            while ( stack2.isEmpty()){
                int top = stack2.pop();
                stack1.push(top);
            }
        }
        public void dequeue() {
        // Your code here
            if (stack1.isEmpty()){System.out.println("Queue is empty.");}
            stack1.pop();
        }
        public int front (){
            if (stack1.isEmpty()){System.out.println("Queue is empty.");}
            return stack1.peek();
        }
        public boolean isEmpty(){
            return stack1.isEmpty();
        }
}
public class Q_wStacks {
    
}
