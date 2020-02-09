import java.util.Stack;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class LeetcodeTest {
    //https://leetcode-cn.com/problems/valid-parentheses/submissions/  id=20
    public static boolean isValid(String s) {
        Stack stack = new Stack();
        for(int i=0; i<s.length();i++){
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(' )
                stack.push(s.charAt(i));
            else{
                if(stack.empty())
                    return false;
                if(s.charAt(i) == '}' && !stack.peek().equals('{'))
                    return false;
                if(s.charAt(i) == ']' && !stack.peek().equals('['))
                    return false;
                if(s.charAt(i) == ')' && !stack.peek().equals('('))
                    return false;
                stack.pop();
            }
        }
        if(!stack.empty())
            return false;
        return true;
    }

    //https://leetcode-cn.com/problems/reverse-integer/  id=7
    public static int reverse(int x){
        if(x ==0)
            return 0;
        StringBuilder str = new StringBuilder();

        int subBit = Math.abs(x/10);
        int res = Math.abs(x%10);
        //请注意，如果参数等于Integer.MIN_VALUE的值，则最负数为int值，结果是相同的值，即为负数。
        //所以Math.abs(x)%10，在当x为-2的31次方的时候，即MIN_VALUE,即-2147483648，其结果仍为负值
        while(subBit !=0 || res !=0){
            str.append(res);
            res = subBit%10;
            subBit = subBit/10;
        }

        if(Long.parseLong(str.toString())>MAX_VALUE || Long.parseLong(str.toString())<MIN_VALUE)
            return 0;

        res = Integer.parseInt(str.toString());
        if(x<0)
            res = -res;
        return res;
    }


    public static void main(String[] args){
        System.out.println(reverse(-2147483648));
        System.out.println(reverse(-2147483641));
    }
}
