class ListNode {
    int val;
    ListNode next = null;
    ListNode (int data){
        this.val = data;
        this.next = null;
    }

}
public class Stacks {
    
    // push
    // adds an element in the stack and return the new stack header 

    static ListNode push(ListNode head, int data){
        if(head == null){
            ListNode newE = new ListNode(data);
            return newE;
        }
        ListNode newE = new ListNode(data);
        newE.next = head;
        head = newE;
        return head;
    }

    //pop
    // pops the last element and returns the new stack header
    // basically popping the last element that was inserted in the linked list is the head itself

    static ListNode pop(ListNode head){
        if ( head == null){
            throw new NullPointerException("Error");
        }
        ListNode newhead = head.next;
        head.next = null;
        return newhead;
    }
    //peek 
    // returns the int value of the last element that we put in

    static int peek(ListNode head){
        return head.val;
    }


    public static void main ( String args[]){
        ListNode stack = null;
        stack = push(stack,1);
        stack = push(stack,2);
        stack = push(stack,3);
        stack = pop(stack);
        System.out.println(peek(stack));
        stack = push(stack,4);
        stack = pop(stack);
        stack = pop(stack);
        System.out.println(peek(stack));

    }
}
