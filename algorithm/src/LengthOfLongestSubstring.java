import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
//         if("".equals(s))
//             return 0;
        int len = 0;
        int start = 0;
        int end = 0;
        Set set = new HashSet();
        while(start < s.length() && end < s.length()){
            if(set.contains(s.charAt(end))){
                set.remove(s.charAt(start++));
            }
            else{
                set.add(s.charAt(end++));
                len = Math.max(len,end - start);
            }

        }
        return len;
    }

    public static void main(String[] args){
        System.out.println("len is : " + lengthOfLongestSubstring(""));
    }
}
