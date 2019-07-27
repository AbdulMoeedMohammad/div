import java.util.Arrays;


public class MergeSort{

    
    public static int[] mergeSort(int[] arr){

        if (arr.length <= 1){
            return arr;
        }

        else{

            int [] left = Arrays.copyOfRange(arr, 0, arr.length/2);
            int [] right = Arrays.copyOfRange(arr, arr.length/2, arr.length);

            left = mergeSort(left);
            right = mergeSort(right);

            return mergeArrays(left, right);
        }
    }


    public static int[] mergeArrays(int[] a, int[] b){

        int[] merged_arr = new int[a.length+b.length];
        int counter = 0;

        while (a.length>0 && b.length>0){
            if (a[0]>b[0]){
                merged_arr[counter] = b[0];
                b = removeElementArray(b, 0);
            }
    
            else{
                merged_arr[counter] = a[0];
                a = removeElementArray(a, 0);
            }
            counter++;
        }

        while(a.length>0){
            merged_arr[counter] = a[0];
            a = removeElementArray(a, 0);
            counter++;
        }

        while(b.length>0){
            merged_arr[counter] = b[0];
            b = removeElementArray(b, 0);
            counter++;
        }

    return merged_arr;       

    }

    public static int[] removeElementArray(int[] arr, int index){

        int[] new_arr = new int[arr.length-1];

        int i = 0;
        int j = 0;

        while(i<arr.length-1){
            if (i == index){
                j++;
            }
            new_arr[i] = arr[j];
            i++; 
            j++;
        }
        return new_arr;
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
        int[] sorted_arr = mergeSort(arr);
        System.out.println("Sorted: "+Arrays.toString(sorted_arr));
        boolean sorted = true;
        for (int i=0; i<arr.length-1; i++){
            if (sorted_arr[i]>sorted_arr[i+1]){
                sorted = false;
            }
        }
        System.out.println("Correct sorted: "+sorted+"\n");
    }

}

