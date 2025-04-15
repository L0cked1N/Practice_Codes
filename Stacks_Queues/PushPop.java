import java.util.Stack;
public class PushPop {
    public static boolean possible (int[] pushed , int []popped){
        Stack<Integer> stack1 = new Stack<>();
        int j = 0;//this will be out counter for popped arr;
        int i = 0;
        
        for ( ; j < pushed.length;j++ ){
            stack1.push(pushed[j]);
            while (!stack1.isEmpty() && stack1.peek()== popped[i]){
                i++;
                stack1.pop();
            }
        }
        for (;i < popped.length;i++){
            if(!stack1.isEmpty() && stack1.peek() == popped[i]){
                stack1.pop();
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] pu = {2,1,0};
        int[] po = {1,2,0};
        System.out.println(possible(pu, po));
    }
}
