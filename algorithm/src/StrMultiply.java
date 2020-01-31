
class StrMultiply{
    public static String multiply(String num1, String num2) {

        if("0".equals(num1) || "0".equals(num2))
            return "0";
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        int[] res = new int[len1+len2+2];
        int multiBit = 0;
        for(int i = len1; i>-1;i--){
            multiBit = num1.charAt(i)-'0';
            for(int j = len2;j>-1;j--){
                int subRes = multiBit*(num2.charAt(j)-'0');
                //先处理以下判断是否有进位
                res[i+j] += (res[i+j+1]+subRes)/10;
                res[i+j+1] = (res[i+j+1]+subRes)%10;
            }
        }
        StringBuilder str = new StringBuilder();
        for(int i = 0; i< res.length; i++){
            if(i==0 && res[i]==0)
                continue;
            str.append(res[i]);
        }
        return str.toString();
    }
    public static void main(String args[]){
        System.out.println("multi res:"+multiply("123456789","987654321"));
        System.out.println((long)123456789*987654321);
    }
}