import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.example.xueyin.springbootdemo.demos.web.SortUtil;

public class SortUtilTest {

    @Test
    public void testBubbleSort() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};

        SortUtil.bubbleSort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testBubbleSortWithEmptyArray() {
        int[] arr = {};
        int[] expected = {};

        SortUtil.bubbleSort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testBubbleSortWithSingleElement() {
        int[] arr = {1};
        int[] expected = {1};

        SortUtil.bubbleSort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSort() {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        int[] expected = {3, 9, 10, 27, 38, 43, 82};

        SortUtil.mergeSort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortWithEmptyArray() {
        int[] arr = {};
        int[] expected = {};

        SortUtil.mergeSort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortWithSingleElement() {
        int[] arr = {1};
        int[] expected = {1};

        SortUtil.mergeSort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortWithNullArray() {
        int[] arr = null;

        SortUtil.mergeSort(arr);

        assertNull(arr);
    }

    @Test
    public void testSortWithBubbleSort() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};

        SortUtil.sort(arr, 1);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortWithMergeSort() {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        int[] expected = {3, 9, 10, 27, 38, 43, 82};

        SortUtil.sort(arr, 2);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortWithDuplicateElements() {
        int[] arr = {5, 2, 8, 5, 2, 6, 9, 3, 5};
        int[] expected = {2, 2, 3, 5, 5, 5, 6, 8, 9};

        SortUtil.sort(arr, 1); // Test with bubble sort
        assertArrayEquals(expected, arr.clone());

        int[] arr2 = {5, 2, 8, 5, 2, 6, 9, 3, 5};
        SortUtil.sort(arr2, 2); // Test with merge sort
        assertArrayEquals(expected, arr2);
    }

    @Test
    public void testSortWithNegativeNumbers() {
        int[] arr = {-5, 12, -3, 0, -8, 9, -1};
        int[] expected = {-8, -5, -3, -1, 0, 9, 12};

        SortUtil.sort(arr, 1); // Test with bubble sort
        assertArrayEquals(expected, arr.clone());

        int[] arr2 = {-5, 12, -3, 0, -8, 9, -1};
        SortUtil.sort(arr2, 2); // Test with merge sort
        assertArrayEquals(expected, arr2);
    }
}
