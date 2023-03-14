package mergeSort;

public class MergeSort {
    // Merges two sub arrays of arr[].
    // First sub-array is arr[l..m]
    // Second sub-array is arr[m+1..r]
    void merge(int[] arr, int startIndex, int middleIndex, int endIndex)
    {
        // Find sizes of two sub-arrays to be merged
        int leftArraySize = middleIndex - startIndex + 1;
        int rightArraySize = endIndex - middleIndex;

        /* Create temp arrays */
        int[] L = new int[leftArraySize];
        int[] R = new int[rightArraySize];

        /*Copy data to temp arrays*/
        for (int i = 0; i < leftArraySize; ++i)
            L[i] = arr[startIndex + i];
        for (int j = 0; j < rightArraySize; ++j)
            R[j] = arr[middleIndex + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of merged sub-array array
        int k = startIndex;
        while (i < leftArraySize && j < rightArraySize) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < leftArraySize) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < rightArraySize) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int[] arr, int startIndex, int endIndex)
    {
        if (startIndex < endIndex) {
            // Find the middle point
            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            // Sort first and second halves
            sort(arr, startIndex, middleIndex);
            sort(arr, middleIndex + 1, endIndex);

            // Merge the sorted halves
            merge(arr, startIndex, middleIndex, endIndex);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] arr = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
