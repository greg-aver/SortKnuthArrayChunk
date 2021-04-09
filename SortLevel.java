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

    public static int ArrayChunk(int[] M) {
        int indexPivot;
        label1:
        {
            indexPivot = M.length / 2;
            int pivot = M[indexPivot];
            int i1 = 0;
            int i2 = M.length - 1;
            while (true) {
                while (M[i1] < pivot) {
                    i1++;
                }
                while (M[i2] > pivot) {
                    i2--;
                }
                if (i1 == i2 - 1 && M[i1] > M[i2]) {
                    change(i1, i2, M);
                    break label1;
                }
                if (i1 == i2 || (M[i1] > M[i2] && i1 == i2 - 1)) {
                    return indexPivot;
                }
                if (i1 == indexPivot) {
                    indexPivot = i2;
                }
                if (i2 == indexPivot) {
                    indexPivot = i1;
                }
                change(i1, i2, M);
            }
        }
        return indexPivot;
    }

    public static int ArrayChunk(int[] M, int i1, int i2) {
        int indexPivot = ((i2 - i1 + 1) / 2) + i1;
        int pivot = M[indexPivot];
        while (i1 < i2 && !(i1 == i2 - 1 && M[i1] < M[i2])) {
            while (M[i1] < pivot) {
                i1++;
            }
            while (M[i2] > pivot) {
                i2--;
            }
            if (M[i1] > M[i2]) {
                change(i1, i2, M);
                i1++;
                i2--;
            }
        }
        return indexPivot;
    }

    public static void QuickSort(int[] array, int left, int right) {
        if (left >= right || left < 0 || right >= array.length) {
            return;
        }
        int indexPivot = ArrayChunk(array, left, right);
        QuickSort(array, left, indexPivot - 1);
        QuickSort(array, indexPivot + 1, right);
    }
}






