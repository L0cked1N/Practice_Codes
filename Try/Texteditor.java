import java.util.Scanner;

public class Texteditor 
{
    class Node 
    {
        String file;// this is my reference and will call it a filename
        String data;// this will have my data stored
        Node next;
        Node prev;
        public Node ( String file){
            this.file = file;
            this.data = null;
            this.next = null;
            this.prev = null;
        }
    }

    // we get a string text added to the head node of the 
    public static void Write(Node head ,String text, int cursor){
        if ( head.data == null){
            head.data = "";
        }
        for (int i = 0 ; i < cursor; i++){
            head = head.next;
            if ( head.next == null){
                break;
            }
        }
        for ( int i = 0 ; i < text.length(); i ++)
        {
            head.data +=text.charAt(i);
        }
    }

    public static void main(String[] args) 
    {   
        Scanner s = new Scanner (System.in);
        Texteditor editor = new Texteditor();
        System.out.println("Enter the filename");

        String filename = s.nextLine();
        Node head = editor.new Node(filename);

        System.out.println("Enter the text and the position at which the cursor is ");
        int cursorposn = s.nextInt();
        String text = s.nextLine();
        Write(head,text, cursorposn);

        System.out.println("Printing the linked list data");
        
        //System.out.println(head.data);
        s.close();
    }

}
