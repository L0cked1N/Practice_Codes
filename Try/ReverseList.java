class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode ( int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while ( curr!= null){
            ListNode next_node = curr.next;
            curr.next = prev;
            curr = next_node;
        }
        return curr;
    }

    public static void main ( String args[]){
        
    }
}
