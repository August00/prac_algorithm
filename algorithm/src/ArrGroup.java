
/*
* 数组分组
* eg.[1,2,3,4,5,6,7,8,9], 输入3
* 输出 [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
*
* */

import java.util.ArrayList;
import java.util.List;

public class ArrGroup {

    public int[][] group(int[] arr, int n) {
        int[][] temp = new int[arr.length/n+1][n];
        int count = 0;
        for(int i=0; i<temp.length&& count<arr.length;i++){
            for(int j =0; j<n && count<arr.length;j++,count++) {
                temp[i][j] = arr[count];
            }
        }
        return temp;
    }

    public List<List<Integer>> group2(int[] arr, int n) {
        List<List<Integer>> list = new ArrayList<>();
        int count = arr.length%n==0?arr.length/n:arr.length/n+1;

        for(int i = 0; i<count;i++){
            ArrayList<Integer> subList = new ArrayList<>();
            for(int j = i*n; j<n+i*n && j<arr.length;j++) {
                subList.add(arr[j]);
            }
            list.add(subList);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr  = {1,2,3,4,5,6,7,8,9};
        ArrGroup mian = new ArrGroup();
        List<List<Integer>> temp2 = mian.group2(arr,3);
        System.out.println(temp2);
    }
}

