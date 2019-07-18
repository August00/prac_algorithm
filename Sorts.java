package prac_algorithm;

/*
* explain:This class is realize some classic sort algorithms.
* date:2019-07-18
* author:wangjue
* */

public class Sorts {

    public Sorts(){}

    private void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //直接插入排序O(n^2),思路:在前面的有序数组中插入新的元素,插完仍为有序数组,默认初始有序数组为第一个元素
    public void insertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            for(int j = i;j>0;j--){
                if(arr[j-1]>arr[j])
                    swap(j-1,j,arr);
            }
        }
    }

    //选择排序O(n^2),思路:每次从待排序的数组中选出最小/大的放到有序数组的最后
    public void selectSort(int[] arr) {
        for(int i =0;i<arr.length-1;i++){
            //min记录当前扫描到的最小的元素的下标
            int min = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            //扫完一轮 min记录了最小值的下标,将该值位置交换到有序数组的最后
            swap(i,min,arr);
        }
    }

    //冒泡排序O(n^2),思路:从第一个开始前后两个数两两对比,一直把最大/最小的那个数像挤泡泡一样挤到最后（有序数组的最前端）
    public void bubbleSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1])
                    swap(j,j+1,arr);
            }
        }
    }

    //找到基准点的位置（下标）
    private int getMid(int l,int r,int[] arr){
        int temp = arr[l];
        int left=l;
        int right=r;
        while(left<right){
            while(temp<arr[right]&&left<right)
                right--;
            if(left<right) {
                swap(left, right, arr);
                left++;
            }
            while(temp>arr[left]&&left<right)
                left++;
            if(left<right) {
                swap(left, right, arr);
                right--;
            }
        }
        arr[left] = temp;
        return right;
    }

    //快速选择排序O(nlogn),思路:找一个基准点k,轮一遍,把比基准点k大的放右边,小的放左边,左右再分别递归如此
    //l是左标,r是右标,把[l,r]位置的数进行一次快排.
    public void quickSort(int l, int r, int[] arr){
        if(r<=l)
            return;
        int mid = getMid(l,r,arr);
        quickSort(l,mid-1,arr);
        quickSort(mid+1,r,arr);
    }


    //堆排序,思路:一棵完全二叉树,父节点始终大于左右节点
    //将以第i个元素为顶点的子树堆化
    private void heapify(int i,int size,int[] nums){
        int parent = i;
        int leftchild = parent * 2 + 1;
        int rightchild = parent * 2 + 2;
        int maxchild = leftchild;//存放当前的最大子节点
        while (leftchild <=size&&parent>=0) {
            if (rightchild <= size
                    && nums[rightchild] > nums[leftchild]) {
                maxchild = rightchild;
            }
            if (nums[maxchild] > nums[parent]) {
                swap(maxchild, parent, nums);
                heapify(maxchild, size,nums);
            }
            break;
        }
    }

    //只对前size个元素进行堆化
    public void heapSort(int size,int[] nums){
        for(int i=(size-1)/2;i>=0;i--){
            heapify(i,size,nums);
        }

    }

    public void maxheap(int[] arr){
        //构建初始大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            heapify(i,arr.length-1,arr);
        }
//        heapSort(arr.length-1,arr);
        //然后就开始交换第一位和末尾的元素,对新的堆顶元素开始进行下沉操作
        for(int i=arr.length-1;i>0;i--){
            swap(0,i,arr);
            heapify(0,i-1,arr);
        }
    }

    public static void main(String[] args){
//        int[] arr = {9,10,7,-8,2,8,5,6,1};
        int[] arr = {5,2,3,1};
        Sorts sorts = new Sorts();

        sorts.maxheap(arr);

        for(int i =0;i<arr.length;i++)
            System.out.print(arr[i]+",");
    }
}
