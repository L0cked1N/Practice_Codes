import java.util.Scanner;
public class GridwithARROWS {

    static boolean pathway ( char[][] arr){
        int n = arr.length;
        int i = 0 ;
        int cr = 0 ; // for tracking the position for row
        int cc = 0 ;// for col
        
        
        while (i < n*n){
            if (cr == n-1 && cc == n-1){
                return true;
            }

            if (cr < 0 || cr >= n || cc < 0 || cc >= n || arr[cr][cc] == 'I') {
                return false;
            }

            switch (arr[cr][cc]) {
                case 'U':
                    System.out.println(cr+","+cc);
                    arr[cr][cc]= 'I';
                    cr--;
                    break;
                case 'D':
                    System.out.println(cr+","+cc);
                    arr[cr][cc]= 'I';
                    cr++;
                    break;
                case 'L':
                    System.out.println(cr+","+cc);
                    arr[cr][cc]= 'I';
                    cc--;
                    break;
                case 'R':
                    System.out.println(cr+","+cc);
                    arr[cr][cc]= 'I';
                    cc++;
                    break;
                case 'I':  
                    System.out.println(cr+","+cc); 
                    // basically is for if we are stuck in the loop 
                    return false;
            }

            i++;// on every iteration we have to run it only max possible is n*n
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // size of the arr = n*n
        int n = s.nextInt();

        char[][] grid = new char[n][n];

        for ( int i = 0 ; i < n ; i ++){
            for( int j = 0 ; j < n ; j++){
                grid[i][j] = s.next().charAt(0);
            }
        }

        // printing the gird that was in the input
        System.out.println("Your input");
        for ( int i = 0 ; i < n ; i ++){
            for( int j = 0 ; j < n ; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println(" ");
        }
        System.out.println("We have found a exit?"+ pathway(grid));
        s.close();
    }
    
}
