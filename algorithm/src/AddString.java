//415.https://leetcode-cn.com/problems/add-strings/

public class AddString {

    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int maxLen = 0;
        if(num1.length()-num2.length()>0)
        {
            maxLen = num1.length()-1;
            for(int i = num1.length()-num2.length(); i > 0; --i){
                num2 = "0"+ num2;
            }
        }else {
            maxLen = num2.length()-1;
            for(int i = num2.length()-num1.length(); i > 0; --i){
                num1 = "0"+ num1;
            }
        }
        int[] sum = new int[maxLen+2];
        for(int i = maxLen; i >= 0; --i)
        {
            int subRes = num1.charAt(i)-'0'+num2.charAt(i)-'0';
            sum[i] = (sum[i+1]+subRes)/10;
            sum[i+1] = (sum[i+1]+subRes)%10;
        }
        for(int i=0;i<maxLen+2;i++)
        {
            if(i==0 && sum[i]==0)
                continue;
            res.append(sum[i]);
        }
        return res.toString();
    }

    public static void main(String[] args){
        System.out.println("res is : " + addStrings("57953","47"));
    }
}
