import java.util.LinkedList;
import java.util.Scanner;
public class KsortedList {

    // now we need a method to iterate thru the linked lists since they are sorted and find the minimum value and remove it from the linked list and add it to our new linked list

    public static LinkedList<Integer> sortedmerger(LinkedList<Integer>[] arr, int n) {
        LinkedList<Integer> Sorted = new LinkedList<>();
        boolean hasMoreElements = true;
    
        while (hasMoreElements) {
            hasMoreElements = false;
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;
    
            for (int j = 0; j < n; j++) {
                if (!arr[j].isEmpty()) {
                    hasMoreElements = true; // At least one list has more elements
                    if (arr[j].getFirst() < minValue) {
                        minValue = arr[j].getFirst();
                        minIndex = j;
                    }
                }
            }
    
            if (minIndex != -1) {
                Sorted.add(minValue);
                arr[minIndex].removeFirst();
            }
        }
    
        return Sorted;
    }

    // initializing an empty node at all points of array so we can add nodes to that
    public static LinkedList<Integer>[] createLinkedListArray(int n) {
        // Create an array of LinkedList of size n
        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] linkedListArray = new LinkedList[n];

        // Initialize each index with an empty LinkedList
        for (int i = 0; i < n; i++) {
            linkedListArray[i] = new LinkedList<>();
        }

        return linkedListArray;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);

        int n = s.nextInt();// this is the number of linked lists needed
        //input ka initialization
        LinkedList<Integer>[] input = createLinkedListArray(n);

        // our input is feed into this
        int k = 0; // we will use this to keep track of the total nodes entered

        for ( int i = 0; i < n; i ++)
        {
            System.out.println("this is your "+i+"th linked list. please enter the sorted linked list length and the the values");
            int len = s.nextInt();
            for ( int j = 0 ; j < len; j ++){
                input[i].add(s.nextInt());
                k++;
            }
        }

        // printing block of the linked list

        System.out.println("The linked lists are:");
        for (int i = 0; i < n; i++) {
            System.out.print("Linked List " + (i + 1) + ": ");
            for (Integer value : input[i]) {
                System.out.print(value + " ");
            }
            System.out.println(); // Move to the next line after printing each linked list
        }

        System.out.println("total nodes are :"+k);

        LinkedList<Integer> sol = sortedmerger(input, n);
        System.out.println("the sorted single array is : ");
        System.out.println(sol);
        s.close();    

    }
}
