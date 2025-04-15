public class Loopchecker {
    class Node {
        int data; 
        int visit = 0 ;
        Node next;
        Node (int data){
            this.data = data;
        }
    }
    static boolean traversal(Node head){
        Node curr = head;

        while (curr.next != null){
            
            if ( curr.visit == 0 ){
                curr.visit = 1 ;// we update that we have visited this node 
            }
            else {
                return true;//that yes a loop exists
            }

            curr = curr.next;

        }
        return false;
    }
    public static void main(String[] args) {
        Loopchecker loopChecker = new Loopchecker();// we created a instance of the loop checker class here to call the class node in our code

        // Create nodes
        Node node1 = loopChecker.new Node(1);
        Node node2 = loopChecker.new Node(2);
        Node node3 = loopChecker.new Node(3);
        Node node4 = loopChecker.new Node(4);
        Node node5 = loopChecker.new Node(5);
        Node node6 = loopChecker.new Node(6);
        Node node7 = loopChecker.new Node(7);
        Node node8 = loopChecker.new Node(8);

        // Link nodes
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = null;
        // Create a loop: link node 8 back to node 4
        
        //node8.next = node4;
        boolean hasLoop = traversal(node1);
        System.out.println("Does the linked list have a loop? " + hasLoop);
        
    }
}
