import java.util.*;

public class SortLevel {

    private static void change(int indexFirst, int indexSecond, int[] array) {
        int value = array[indexFirst];
        array[indexFirst] = array[indexSecond];
        array[indexSecond] = value;
    }
    
    
    public static ArrayList<Integer> KnuthSequence(int array_size) {
        ArrayList<Integer> listResult = new ArrayList<>();
        int n = 1;
        while (n < array_size) {
            listResult.add(n);
            n = 3 * n + 1;
        }
        Collections.reverse(listResult);
        return listResult;
    }
    
    public static int ArrayChunk(int[] M) {
        int indexPivot = M.length /2;
        int pivot = M[indexPivot];
        int i1 = 0;
        int i2 = M.length - 1;
        while(i1 != i2 && !(i1 == i2 - 1 && M[i1] < M[i2])) {
            while (M[i1] < pivot && i1 <= indexPivot) {
                i1++;
            }
            while (M[i2] > pivot && i2 >= indexPivot) {
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
}
    
