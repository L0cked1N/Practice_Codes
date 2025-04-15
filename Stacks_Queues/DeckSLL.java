

class ListNode {
    int data;
    ListNode next;
    ListNode prev;
    ListNode(int val){
        this.data = val;
        this.next = null;
        this.prev = null;
    }
}
public class DeckSLL {
    public static ListNode head;
    public static ListNode tail = head;

    private static int size = 0;//initially the queue will be empty. this int will keep record of the size
    public static boolean isEmpty(ListNode head){
        if (head == null){
            return true;
        }

        if ( size == -1){
            return true;
        }

        return false;
    }

    public static int getFirst(ListNode head){
        if ( head == null){
            throw new NullPointerException("Empty Deque");
        }
        return head.data;
    }

    public static int getLast(ListNode tail){
        if ( tail == null){
            throw new NullPointerException("Empty Deque");
        }
        return tail.data;
    }

    public static void addFirst ( ListNode head, int val){
        size++;
        ListNode newnode = new ListNode(val);
        newnode.next = head;
        head.prev = newnode;
        head = newnode;
    }
    
    public static void addLast( ListNode tail, int val){
        size++;
        ListNode newnode = new ListNode(val);
        newnode.prev = tail;
        tail.next = newnode;
        tail = newnode;
    }

    public static int removeFirst( ListNode head){
        size--;
        ListNode dummy = head;
        head = head.next;
        head.prev = null;
        dummy.next = null;
        return dummy.data;
    }

    public static int removeLast ( ListNode tail){
        size--;
        return size;
    }

    
    
}
