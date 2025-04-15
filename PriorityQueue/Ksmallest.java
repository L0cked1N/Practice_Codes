import java.util.ArrayList;
import java.util.Arrays;
class MinHeap {
    private ArrayList<Integer> heap;
    /**
     * Constructor: Initializes an empty priority queue (max heap).
     * Time Complexity: O(1)
     */
    public MinHeap() {
        heap = new ArrayList<>();
    }

    /**
     * Inserts a new key into the heap
     * Time Complexity: O(log N)
     */
    public void insert(int key) {
        heap.add(key);
        heapifyup(heap.size()-1);
    }

    /**
     * Extracts and returns the maximum element
     * Time Complexity: O(log N)
     * @return the maximum value in the heap
     * @throws IllegalStateException if the heap is empty
     */
    public int extractMin() {
        if (heap.isEmpty()){
            throw new IllegalStateException("Heap is empty");
        }
        if ( heap.size() == 1){
            return heap.remove(0);
        }
        int min = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        heapifydown(0);
        return min;
    }

    /**
     * Returns the maximum element without removing it.
     * Time Complexity: O(1)
     * @return the maximum value in the heap
     * @throws IllegalStateException if the heap is empty
     */
    public int getMin() {
        if (heap.isEmpty()){
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    /**
     * it does not return the specific key value 
     * Deletes a specific key from the heap and maintains the heap property.
     * Time Complexity: O(N) (for searching) + O(log N) (for deletion)
     * @param key the key to delete
     * @throws IllegalArgumentException if the key is not found
     */
    public void delete(int key) {
        int index = heap.indexOf(key);
        if ( index == -1){
            throw new IllegalArgumentException("Key not found");
        }
        heap.set(index, heap.remove(heap.size()-1));
        heapifydown(index);
    }

    /**
     * Updates the value of a specific key and maintains the heap property.
     * Time Complexity: O(N) (for searching) + O(log N) (for updation)
     * @param oldKey the existing key in the heap
     * @param newKey the new value to update the key with
     * @throws IllegalArgumentException if the key is not found
     */
    public void updateKey(int oldKey, int newKey) {
        int index = heap.indexOf(oldKey);
        if ( index == -1){
            throw new IllegalArgumentException("Key not found");
        }
        heap.set(index, newKey);
        if ( newKey < oldKey){
            heapifyup(index);
        }else{
            heapifydown(index);
        }
    }

    /**
     * Builds a max heap from an unsorted array.
     * Time Complexity: O(N)
     * @param array an array of integers to build the heap from
     */
    public void buildHeap(int[] array) {
        heap.clear();
        for ( int num : array){
            heap.add(num);
        }
        for ( int i = heap.size()/2 - 1; i >= 0 ; i--){
            heapifydown(i);
        }
    }

    private void heapifyup(int index){
        while ( index>0){
            int parent = (index-1)/2;
            if ( heap.get(index) >= heap.get(parent)){
                break;
            }
            swap ( index, parent);
            index = parent;
        }
    }
    private void heapifydown(int index){
        int size = heap.size();
        while ( index < size){
            int left = index*2 +1;
            int right = index*2 +2;
            int smallest = index;
            if ( left < size && heap.get(left) < heap.get(smallest)){
                smallest = left;
            }
            if ( right < size && heap.get(right) < heap.get(smallest)){
                smallest = right;
            }
            if ( smallest == index){
                break;
            }
            swap (index, smallest);
            index = smallest ;

        }
    }

    private void swap ( int i, int j){
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j,temp);
    }
}

public class Ksmallest {
    public static ArrayList < Integer> ksorter(int[] arr, int k){
        ArrayList<Integer> output = new ArrayList<>();
        MinHeap heap = new MinHeap();
        heap.buildHeap(arr);
        if ( k > arr.length){
            throw new IllegalArgumentException("Wrong value of k");
        }
        for ( int i= 0 ; i < k ; i++){
            output.add(heap.extractMin());
        }
        return output;
    }
    public static void main (String args[]){
        int arr[] = {3, 4, 5, 2, 10};
        int k = 3;
        System.out.println(Arrays.toString(arr));
        System.out.println(ksorter(arr, k));
        
    }
}
