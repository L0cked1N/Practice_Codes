import java.util.Stack;

public class Drone {
    public static int[] Solve(String str){
        int X = 0;
        int Y = 0;
        int Z = 0;
        int distance = 0;
        Stack <Integer> ValStack = new Stack<>(); 
        Stack <Character> SignStack = new Stack<>();
        Stack <Character> CoordStack = new Stack<>();
        int val = 0;
        int counter = 0; //how many times do we have to use the digit or the value 
        for ( int i = 0 ; i < str.length(); i++){
            
            
            char c = str.charAt(i);
            if ( Character.isDigit(c)){
                int value = c - '0';
                val = val*10 +value;
            }
            if ( c == '('){
                ValStack.push(val);
                val = 0; //reset the value 
            }
            if ( c == '+' || c == '-'){
                SignStack.push(c);
            }
            if ( c == 'X' || c == 'Y' || c == 'Z'){
                CoordStack.push(c);
                counter++;
            }
            if ( c == ')'){
                int multiplier = ValStack.pop();
                for ( int j = 0 ; j < counter ; j++){
                    char coordinate = CoordStack.pop();
                    distance += multiplier;
                    if ( coordinate == 'X'){
                        char sign = SignStack.pop();
                        if ( sign == '+'){
                            X += multiplier;
                        }
                        else if (sign == '-'){
                            X -= multiplier;
                        }
                    }
                    else if ( coordinate == 'Y'){
                        char sign = SignStack.pop();
                        if ( sign == '+'){
                            Y += multiplier;
                        }
                        else if (sign == '-'){
                            Y -= multiplier;
                        }
                    }
                    else if ( coordinate == 'Z'){
                        char sign = SignStack.pop();
                        if ( sign == '+'){
                            Z += multiplier;
                        }
                        else if (sign == '-'){
                            Z -= multiplier;
                        }
                    }
                }
                counter = 0;
            }
        }

        return new int[]{X,Y,Z,distance};
    }
    public static void main(String[] args) {
        String newstr = "5(+X)10(-X)";
        int[] output = new int[4];
        output = Solve(newstr);
        for ( int i = 0 ; i < 4; i++){
            System.out.print(output[i] + " ");
        }
    }
}
