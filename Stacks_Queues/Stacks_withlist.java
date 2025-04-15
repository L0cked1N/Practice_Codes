public class Stacks_withlist{
    //global counter for number of push operations 
    public static int counter = -1;// will work as our index for push operations

    public static int[] incSpace(int[]arr){
        int n = arr.length;
        int[] newarr = new int[2*n];

        for ( int i = 0 ; i < n ; i++){
            newarr[i] = arr[i];
        }

        return newarr;

    }

    static int[] push(int[] arr,int data){
            int n = arr.length;
            if (n == counter + 1){
                //we will have to create an new arr with 2n space
                arr = incSpace(arr);
                counter++;
                arr[counter] = data;
            }
            else {
                counter++;
                arr[counter] = data;
            }
            return arr;
    }

    static int pop ( int[]arr){
        if ( counter == -1){
            return -1;
        }
        int k = arr[counter];
        arr[counter] = 0;
        counter--;
        return k;
    }

    static int top (int[] arr){ return arr[counter];}

    public static void main ( String args[]){
        int arr[] = new int[1];
        arr = push(arr,1);
        arr = push(arr, 2);
        arr = push(arr, 3);
        arr = push(arr, 4);
        arr = push(arr, 5);
        for ( int i = counter ; i > -1; i--){
            System.out.println(arr[i]);
        }
        int k = pop(arr);
        System.out.println("this is the popped node "+ k);
        for ( int i = counter ; i > -1; i--){
            System.out.println(arr[i]);
        }
    }
}