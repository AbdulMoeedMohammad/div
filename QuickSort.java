import java.util.Arrays;
import java.util.Random;

public class QuickSort{

    
    public static void quickSort(int[] arr, int left, int right){

        if(left <= right){
            int index = partition(arr, left, right);

            quickSort(arr, left, index-1);
            quickSort(arr, index+1, right);
           
        }
    }


    public static int partition(int[] arr, int left, int right){

        int pivot = arr[right];
        int index = left;
        int tmp;

        for (int i=left; i<right; i++){
            if (arr[i] < pivot){
                tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
                index++;
            }
        }
        tmp = arr[index];
        arr[index] = arr[right];
        arr[right] = tmp;

        return index;
    }


  

    public static void main(String[] args){

        int[] array1 = {5,2,7,1,2,6,9,2};
        test(array1);

        int[] array2 = {};
        test(array2);

        int[] array3 = {1};
        test(array3);

        int[] array4 = {1,2,3,4,5,6,7,8};
        test(array4);

        int[] array5 = {6,5,4,3,2,1};
        test(array5);

        int[] array6 = {1,1,1,1,1,1};
        test(array6);

        int[] array7 = {-5,6,-2,4,0,1,-3,2,-4,-2,1,-10};
        test(array7);

    }


    public static void test(int[] arr){
        System.out.println("Unsorted: "+Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println("Sorted: "+Arrays.toString(arr));
        boolean sorted = true;
        for (int i=0; i<arr.length-1; i++){
            if (arr[i]>arr[i+1]){
                sorted = false;
            }
        }
        System.out.println("Correct sorted: "+sorted+"\n");
    }

}

