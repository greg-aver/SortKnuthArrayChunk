import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class SortLevelTest {

    @Test
    void selectionSortStep() {
        int[] array = new int[]{5, 40, 70, 7};
        SortLevel.SelectionSortStep(array, 1);
        assertThat(array, is(new int[]{5, 7, 70, 40}));
    }

    @Test
    void bubbleSortStep() {
        int[] array = new int[]{4, 3, 1, 2};
        assertThat(SortLevel.BubbleSortStep(array), is(false));
        assertThat(array, is(new int[]{3, 1, 2, 4}));
        assertThat(SortLevel.BubbleSortStep(array), is(false));
        assertThat(array, is(new int[]{1, 2, 3, 4}));
        assertThat(SortLevel.BubbleSortStep(array), is(true));
        assertThat(array, is(new int[]{1, 2, 3, 4}));
    }

    @Test
    void insertionSortStep() {
        int[] array = new int[]{1, 6, 5, 4, 3, 2, 7};
        SortLevel.InsertionSortStep(array, 3, 1);
        assertThat(array, is(new int[]{1, 3, 5, 4, 6, 2, 7}));
    }


    @Test
    void insertionSortStep_1() {
        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
        SortLevel.InsertionSortStep(array, 3, 0);
        assertThat(array, is(new int[]{1, 6, 5, 4, 3, 2, 7}));
    }

    @Test
    void insertionSortStep_2() {
        int[] array = new int[]{1, 3, 5, 4, 6, 2, 7};
        SortLevel.InsertionSortStep(array, 3, 2);
        assertThat(array, is(new int[]{1, 3, 2, 4, 6, 5, 7}));
    }

    @Test
    void knuthSequence_length15() {
        assertThat(SortLevel.KnuthSequence(15), is(List.of(13, 4, 1)));
    }

    @Test
    void knuthSequence_length15_45() {
        assertThat(SortLevel.KnuthSequence(45), is(List.of(40, 13, 4, 1)));
    }

    @Test
    void knuthSequence_length15_200() {
        assertThat(SortLevel.KnuthSequence(200), is(List.of(121, 40, 13, 4, 1)));
    }

    @Test
    void knuthSequence_length15_370() {
        assertThat(SortLevel.KnuthSequence(370), is(List.of(364, 121, 40, 13, 4, 1)));
    }

    @Test
    void knuthSequence_length1() {
        assertThat(SortLevel.KnuthSequence(1), is(List.of(1)));
    }

    @Test
    void arrayChunk() {
        int[] array = new int[]{7, 5, 6, 4, 3, 1, 2};
        assertThat(SortLevel.ArrayChunk(array), is(3));
        assertThat(SortLevel.ArrayChunk(new int[] {7, 5, 6, 4, 3, 1, 2}, 0, 6), is(3));
        assertThat(array, is(new int[]{2, 1, 3, 4, 6, 5, 7}));
    }

    @Test
    void arrayChunk_3Element() {
        int[] array = new int[]{6,5,7};
        assertThat(SortLevel.ArrayChunk(new int[] {6,5,7}, 0, 2), is(1));
        assertThat(SortLevel.ArrayChunk(array), is(1));
    }

    @Test
    void quickSort_7Elements() {
        int[] array = new int[]{7, 5, 6, 4, 3, 1, 2};
        SortLevel.QuickSort(array, 0, array.length - 1);
        assertThat(array, is(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    @Test
    void quickSort_5Elements() {
        int[] array = new int[]{5, 4, 3, 1, 2};
        SortLevel.QuickSort(array, 0, array.length - 1);
        assertThat(array, is(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void arrayChunk_array312() {
        int[] array = new int[]{3,1,2};
        assertThat(SortLevel.ArrayChunk(array), is(1));
        assertThat(array, is(new int[]{1,2,3}));
    }

    @Test
    void arrayChunk_array657() {
        int[] array = new int[]{6, 5, 7};
        assertThat(SortLevel.ArrayChunk(array), is(1));
        assertThat(SortLevel.ArrayChunk(new int[]{6, 5, 7}, 0, 2), is(1));
        assertThat(array, is(new int[]{5, 6, 7}));
    }
}
