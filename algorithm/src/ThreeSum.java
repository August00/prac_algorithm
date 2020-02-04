import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<3)
            return res;
        Arrays.sort(nums);//快排
        for(int i=0;i<nums.length-2;i++)
        {
            if(nums[i]>0) //当前数大于0，说明其后面的均大于0，则不可能有和等于0的情况了
                return res;
            if(i>0 && nums[i] == nums[i-1]) //去重
                continue;
            int left = i+1;
            int right = nums.length-1;
            //在left,right范围内找到是否有两数之和等于当前数的相反数,即三数之和等于0
            List<List<Integer>> towList = twoSum(nums,left,right,-nums[i]);
            for (List<Integer> j : towList) {
                List<Integer> subList = new ArrayList<>();
                subList.add(nums[i]);
                subList.addAll(j);
                res.add(subList);
            }
        }
        return res;
    }


    public static List<List<Integer>> twoSum(int[] nums,int start, int end,int target)
    {
        List<List<Integer>> res = new ArrayList<>();
        int left = start;
        int right = end;
        if(right-left+1<2) //如果nums的长度小于2，则无法求两数之和
            return res;
        while(left < right)
        {
            int sum = nums[left]+nums[right];
            if(sum==target) {
                List<Integer> subList = new ArrayList<>();
                subList.add(nums[left]);
                subList.add(nums[right]);
                res.add(subList);
                while(left<right && nums[left]==nums[left+1])//去重
                    left++;
                while(left<right && nums[right] == nums[right-1])//去重
                    right--;
                left++;//范围缩小，准备寻找下一组
                right--;
            }else if(sum<target) {
                left++;
            } else if(sum>target) {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] arr = {2,3,6, 7, 11, 15};
        int[] arr3 = {-1, 0, 1, 2, -1, -4};
        System.out.println("two res is : \n" + twoSum(arr, 0,3,9));
        System.out.println("three res is : \n" + threeSum(arr3));
    }
}
