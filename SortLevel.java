import java.util.*;

public class SortLevel {

    private static void change(int indexFirst, int indexSecond, int[] array) {
        int value = array[indexFirst];
        array[indexFirst] = array[indexSecond];
        array[indexSecond] = value;
    }

    public static void SelectionSortStep(int array[], int i) {
        if (i >= array.length) {
            return;
        }
        int min = i;
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] < array[min]) {
                min = j;
            }
        }
        if (min != i) {
            change(i, min, array);
        }
    }

    public static boolean BubbleSortStep(int array[]) {
        boolean isSorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                isSorted = false;
                change(i + 1, i, array);
            }
        }
        return isSorted;
    }

    public static ArrayList<Integer> KnuthSequence(int array_size) {
        ArrayList<Integer> listResult = new ArrayList<>();
        int n = 1;
        if (array_size == 0) {
            return listResult;
        }
        do {
            listResult.add(n);
            n = 3 * n + 1;
        } while (n < array_size);
        Collections.reverse(listResult);
        return listResult;
    }

    public static void InsertionSortStep(int[] array, int step, int i) {
        // Loop 1. Get all numbers using step
        for (int j = i + step; j < array.length; j += step) {
            /* Loop 2. For each number, look for a place to insert.
            To do this, we sequentially compare the numbers.*/
            for (int k = i; k < j; k += step) {
                if (array[j] < array[k]) {
                    /*Place found. Index insert = k.
                    Now you need to shift all elements to the right by 1
                    and insert the element to a new location.*/

                    //We will save the old value and insert it into a new place in the next iteration.
                    int valuePrev = array[k];
                    int valueNext = array[k + step];
                    for (int l = k + step; l <= j; l += step) {
                        valueNext = array[l];
                        array[l] = valuePrev;
                        valuePrev = valueNext;
                    }
                    array[k] = valueNext;
                    break;
                }
                break;
            }
        }
    }

    
    public static int ArrayChunk(int[] array, int left, int right) {
        int indexPivot;
        while (true) {
            indexPivot = (left + right) / 2;
            int pivot = array[indexPivot];
            int i1 = left;
            int i2 = right;
            while (true) {
                while (array[i1] < pivot) {
                    i1++;
                }
                while (array[i2] > pivot) {
                    i2--;
                }
                if (i1 == i2 - 1 && array[i1] > array[i2]) {
                    change(i1, i2, array);
                    break;
                }
                if (i1 == i2 || (array[i1] > array[i2] && i1 == i2 - 1)) {
                    return indexPivot;
                }
                if (i1 == indexPivot) {
                    indexPivot = i2;
                } else {
                    if (i2 == indexPivot) {
                        indexPivot = i1;
                    }
                }
                change(i1, i2, array);
            }
        }
    }

    public static int ArrayChunk(int[] M) {
        return ArrayChunk(M, 0, M.length - 1);
    }
    
    public static void QuickSort(int[] array, int left, int right) {
        int index = ArrayChunk(array, left, right);
        if (left < index - 1)
            QuickSort(array, left, index - 1);
        if (index + 1 < right)
            QuickSort(array, index + 1, right);
    }
    
    public static void QuickSortTailOptimization(int[] array, int left, int right) {
        while (left < right) {
            int indexPivot = ArrayChunk(array, left, right);
            if (indexPivot - left < right - indexPivot) {
                QuickSortTailOptimization(array, left, indexPivot - 1);
                left = indexPivot + 1;
            } else {
                QuickSortTailOptimization(array, indexPivot + 1, right);
                right = indexPivot - 1;
            }
        }
    }
    
     public static ArrayList<Integer> KthOrderStatisticsStep(int[] Array, int L, int R, int k) {
        ArrayList<Integer> listResult = new ArrayList<>();
        int n = (L + R) / 2;
        if (n < k) {
            L = n + 1;
        }
        if (n > k) {
            R = n - 1;
        }
        listResult.add(L);
        listResult.add(R);
        return listResult;
    }
}

