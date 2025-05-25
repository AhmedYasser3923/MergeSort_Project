package mergesort_project;
import java.util.Scanner;

public class MergeSort {
public static int ArrayLength;
public static int [] array;
//    public static void main(String[] args) {
//             Scanner in = new Scanner(System.in);
//        System.out.println("Enter Size Of Array");
//    	 ArrayLength = in.nextInt();
//    	 array = new int[ArrayLength];
//    	for(int i = 0; i < ArrayLength; i++) {
//    		System.out.println("Enter values of Array");
//    		array[i] = in.nextInt();
//    	}
//        System.out.println("Given Array");
//        printArray(array, 0, array.length);
//
//        mergeSort(array, 0, array.length - 1);
//
//        System.out.println("\nSorted array");
//        printArray(array, 0, array.length);
//    }
//    
   public static void mergeSort(int[] array, int start, int end) {
        if (end - start < 1) {
            return;
        }
        int mid = (start + end) / 2 + 1;
        System.out.println("Dividing array from index " + start + " to " + (mid - 1));
        mergeSort(array, start, mid - 1);
        System.out.println( "Dividing array from index " + mid + " to " + end);
        mergeSort(array, mid, end);
        System.out.println( "Merging arrays from index " + start + " to " + end);
        merge(array, start, mid, end);
    }

public static void merge(int[] array, int start, int mid, int end) {
        int[] left = new int[mid - start];
        int[] right = new int[end - mid + 1];

        System.arraycopy(array, start, left, 0, mid - start);
        System.arraycopy(array, mid, right, 0, end - mid + 1);

        int i = 0, j = 0, k = start;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }

        printArray(array, start, end + 1);
    }

    // Utility function to print an array
    public static void printArray(int[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}





 

    


