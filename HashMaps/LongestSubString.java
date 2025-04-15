import java.util.HashMap;

public class LongestSubString{
    public static void main(String[] args) {
        String s = "aab";
        HashMap <Character,Integer> hm = new HashMap<>();
        char c ;
        int max = 0;
        for ( int i = 0 ; i < s.length(); i++){
            c = s.charAt(i);
            if (hm.containsKey(c)){
                int size = hm.size();
                if ( max < size)max = size;
                HashMap <Character, Integer> hmnew = new HashMap<>();
                hm = hmnew;
                hm.put(c, i);
            }
            hm.put(c, i);
        }
        if ( max == 0)max = hm.size();
        System.out.println(max);
    }
}