import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> Queue1;
    private Queue<Integer> Queue2;
    public MyStack() {
        Queue1 = new LinkedList<>();
        Queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        Queue1.add(x);
    }
    
    public int pop() {
        if ( !Queue1.isEmpty()){
            int i = Queue1.size();
            while ( i>1){
                int n = Queue1.remove();
                Queue2.add(n);
            }
            int out = Queue1.remove();
            while ( !Queue2.isEmpty()){
                Queue1.add(Queue2.remove());
            }
            return out;
        }
        
        else throw new EmptyStackException();
    }
    
    public int top() {
        if ( !Queue1.isEmpty()){
            int i = Queue1.size();
            while ( i>1){
                int n = Queue1.remove();
                Queue2.add(n);
            }
            int out = Queue1.poll();
            while ( !Queue2.isEmpty()){
                Queue1.add(Queue2.remove());
            }
            return out;
        }
        else throw new EmptyStackException();
    }
    
    public boolean empty() {
        return Queue1.isEmpty() && Queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */