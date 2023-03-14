package quickSorts;

public class ThreeWayQuickSort {
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sort(int[] arr, int firstIndex, int lastIndex) {
        if(lastIndex <= firstIndex) return;
        int lessThan = firstIndex, greaterThan = lastIndex;

        //pivot
        int pivot = arr[firstIndex];
        int i = firstIndex;

        // This block is equivalent to the partition method
        while(i <= greaterThan) {
            // If less than pivot exchange a[lessThan] and a[i] then increment both
            if(arr[i] < pivot) {
                swap(arr,lessThan++,i++);
            }
            // If greater than pivot exchange a[i] with a[greaterThan] and then decrement greaterThan, i stays at the same position
            else if(arr[i] > pivot) {
                swap(arr,i,greaterThan--);
            }
            // If equal just move increment i
            else {
                i++;
            }
        }
        // At this point lessThan has moved with i until everything to the left of the lessThan pointer is less than the pivot
        sort(arr,firstIndex,lessThan - 1);
        // At this point the greaterThan pointer has been decremented until everything to the right of it is greater than the pivot
        sort(arr,greaterThan + 1,lastIndex);
    }
    static void printArray(int[] arr, int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
    public static void main(String[] args)
    {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;

        sort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}
