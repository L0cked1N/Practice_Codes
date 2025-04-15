/*
import java.util.Stack;

public class Decode {

    public static void decode(String str){

    }

    public static String encoded_string ( String str ){
        // this function is to be called till the iterator reaches the last pos
        
        String newstr = "";
        int leftidx = 0;
        int rightidx = 0;
        int n = 0;
        for ( int i = 0 ; i < str.length(); i++){
            if ( str.charAt(i) == '['){
                leftidx = i+1;
                n = (int)str.charAt(i-1) - '0';
                for ( int j = leftidx; j <str.length(); j++){
                    if (str.charAt(j)==']'){
                        rightidx=j-1;
                        break;
                    }
                }
            }
        }
        
        for ( int i = 0; i < n ; i++){
            newstr += str.substring(leftidx, rightidx+1);
        }

        return newstr;
    }
    public static void main ( String args[]){
        String s = "3[abc]2[mn]ef";
        s = encoded_string(s);
        System.out.println(s);

    }    
}
 */

 
// this is gpted solution 
import java.util.Stack;

public class Decode {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>(); // Stack to hold strings
        Stack<Integer> countStack = new Stack<>(); // Stack to hold repeat counts
        String currentStr = ""; // 
        int currentNum = 0; // 

        for (int i = 0; i < s.length(); i++) { //iterate the string
            char c = s.charAt(i); 

            if (Character.isDigit(c)) { // If the character is a digit
                currentNum = currentNum * 10 + (c - '0'); 
            } else if (c == '[') { // If the character is an opening bracket
                
                //push
                countStack.push(currentNum);
                stack.push(currentStr);
                
                // Reset
                currentStr = ""; 
                currentNum = 0; 
            } else if (c == ']') { // If the character is a closing bracket
                
                // Pop and built the new string using  the last string and number
                String lastStr = stack.pop();
                int num = countStack.pop();

                // Repeat the current string and append it to the last string
                String repeatedStr = "";
                for (int j = 0; j < num; j++) {
                    repeatedStr += currentStr;
                }
                currentStr = lastStr + repeatedStr; // Combine
            } else { // If the character is a letter
                currentStr += c; //build the curr string
            }
        }

        return currentStr;

    }

    public static void main(String[] args) {
        Decode decoder = new Decode();
        System.out.println(decoder.decodeString("3[a2[c]]")); // Output: "accaccacc"
        System.out.println(decoder.decodeString("2[abc]3[cd]ef")); // Output: "abcabccdcdcdef"
    }
}