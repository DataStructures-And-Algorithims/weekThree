package quickSorts;


// Shuffling needed to guarantee performance
public class PivotFirstElement {
    int partition(int[] arr, int firstIndex, int lastIndex)
    {
        // First element as pivot
        int pivot = arr[firstIndex];
        int k = lastIndex;
        for (int i = lastIndex; i > firstIndex; i--) {
            if (arr[i] > pivot)
                swap(arr, i, k--);
        }
        swap(arr, firstIndex, k);
        // As we got pivot element index is end
        // now pivot element is at its sorted position
        // return pivot element index (end)
        return k;
    }

    // Function to swap two elements
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void quickSort(int[] arr, int firstIndex, int lastIndex)
    {
        if (firstIndex < lastIndex) {
            int pivotWhenSorted = partition(arr, firstIndex, lastIndex);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, firstIndex, pivotWhenSorted - 1);
            quickSort(arr, pivotWhenSorted + 1, lastIndex);
        }
    }

    /* Function to print an array */
    void printArray(int[] arr, int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] arr = { 7, 6, 10, 5, 9, 2, 1, 15, 7 };
        int n = arr.length;

        PivotFirstElement ob = new PivotFirstElement();
        ob.quickSort(arr, 0, n - 1);

        System.out.println("Sorted array");
        ob.printArray(arr, n);
    }
}