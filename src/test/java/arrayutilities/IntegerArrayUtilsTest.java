package arrayutilities;

import numberutilities.OddEven;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Double.NaN;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class IntegerArrayUtilsTest {

    private Integer[] ints = new Integer[] {4,5,102,6,-7,12,-32,92,8};
    private Integer[] ints2 = new Integer[] {6,10,31};
    private double[] doubles = new double[] {1.0, 0.5, 3.6, 38.4, 17.3, 62.0, 9.0, 3.375, 0.0, 3.14159};
    private double[] doubles2 = new double[] {1.5, 2.6, 10.6, -32.4, 2.0, -5.23, -0.1, 5.73, 1.03, 95.1413};


    @Test
    public void test1SumOfArray() {
        Integer expected = 190;
        assertEquals(expected, IntegerArrayUtils.sumValuesOfArray(ints));
    }

    @Test
    public void test2SumOfArray() {
        Integer expected = 47;
        assertEquals(expected, IntegerArrayUtils.sumValuesOfArray(ints2));
    }

    @Test
    public void test1SumOfArrayDbl() {
        double expected = 138.31659000000002;
        assertEquals(expected, IntegerArrayUtils.sumDoublesOfArray(doubles), 0.00);
    }

    @Test
    public void test2SumOfArrayDbl() {
        double expected = 80.8713;
        assertEquals(expected, IntegerArrayUtils.sumDoublesOfArray(doubles2), 0.00);
    }

    @Test
    public void test1AverageOfArray() {
        Integer expAvg = 21;
        assertEquals(expAvg, IntegerArrayUtils.averageOfArray(ints));
    }

    @Test
    public void test2AverageOfArray() {
        Integer[] zeroArray = {};
        Integer expected = 0 ;
        assertEquals(expected, IntegerArrayUtils.averageOfArray(zeroArray));
    }

    @Test
    public void test1doubleAverageOfArray() {
        double expAvg = 13.831659000000002;
        assertEquals(expAvg, IntegerArrayUtils.doubleAverageOfArray(doubles), 0.00);
    }

    @Test
    public void test2doubleAverageOfArray() {
        double[] zero = {};
        assertEquals(NaN, IntegerArrayUtils.doubleAverageOfArray(zero), 0.00 );
    }

    @Test
    public void test1containsValue() {
        int val = 12;
        assertTrue(IntegerArrayUtils.containsValue(ints, val));
    }

    @Test
    public void test2ContainsValue() {
        int val = 0;
        assertFalse(IntegerArrayUtils.containsValue(ints, val));
    }

    @Test
    public void test1reverseArray() {
        Integer[] expected = {31, 10, 6};
        assertTrue(Arrays.equals(expected, IntegerArrayUtils.reverseArray(ints2)));
    }

    @Test
    public void test2reverseArray() {
        Integer[] expected = {1};
        assertTrue(Arrays.equals(expected, IntegerArrayUtils.reverseArray(expected)));
    }

    @Test
    public void test1OddsEvenOfArray() {
        int expectedEven = 7;
        int expectedOdd = 2;

        OddEven oe = IntegerArrayUtils.getOddEvensOfArray(ints);
        assertEquals(expectedEven, oe.getEvens());
        assertEquals(expectedOdd, oe.getOdds());
    }

    @Test
    public void test2OddsEvenOfArray() {
        int expectedEven = 2;
        int expectedOdd = 1;

        OddEven oe = IntegerArrayUtils.getOddEvensOfArray(ints2);
        assertEquals(expectedEven, oe.getEvens());
        assertEquals(expectedOdd, oe.getOdds());
    }

    @Test
    public void test1FindIndexOf() {
        Integer expected = 2;
        Integer valueToFind = 102;

        assertEquals(expected, IntegerArrayUtils.findIndexOf(ints, valueToFind));
    }

    @Test
    public void test2FindIndexOf() {

        Integer expected = -1;
        assertEquals(expected, IntegerArrayUtils.findIndexOf(ints2, 100));
    }

    @Test
    public void test1CopyArrayByIterator() {
        Integer[] intToCopy = new Integer[] {6,10,31};
        Integer[] copy = IntegerArrayUtils.copyArrayByInterator(intToCopy);

        assertTrue(Arrays.equals(intToCopy, copy));
    }

    @Test
    public void test2CopyArrayByIterator() {
        Integer[] intToCopy = new Integer[] {};
        Integer[] copy = IntegerArrayUtils.copyArrayByInterator(intToCopy);

        assertTrue(Arrays.equals(intToCopy, copy));
    }

    @Test
    public void test1CopyArrayByLoop() {
        Integer[] intToCopy = new Integer[] {};
        Integer[] copy = IntegerArrayUtils.copyArrayByLoop(intToCopy);

        assertTrue(Arrays.equals(intToCopy, copy));
    }

    @Test
    public void test2CopyArrayByLoop() {
        Integer[] intToCopy = new Integer[] {};
        Integer[] copy = IntegerArrayUtils.copyArrayByLoop(intToCopy);

        assertTrue(Arrays.equals(intToCopy, copy));
    }

    @Test
    public void test1removeElementFromArray() {
        Integer[] ints2remove6 = new Integer[] {10,31};
        Integer[] actual = IntegerArrayUtils.removeElementFromArray(ints2, 6);

        assertTrue(Arrays.equals(ints2remove6, actual));
    }

    @Test
    public void test2RemoveElementFromArray() {
        assertTrue(Arrays.equals(ints2, IntegerArrayUtils.removeElementFromArray(ints2, 0)));
    }

    @Test
    public void test1InsertIntoArrayAt() {
        int indexToInsert = 3;
        Integer valueToInsert = 10;

        Integer[] expected = {4,5,102,10, -7,12,-32,92,8};
        assertTrue(Arrays.equals(expected, IntegerArrayUtils.insertIntoArrayAt(ints, indexToInsert, valueToInsert)));
    }

    @Test
    public void test2InsertIntoArrayAt() {
        assertTrue(Arrays.equals(ints2, IntegerArrayUtils.insertIntoArrayAt(ints2, 100, 10)));
    }

    @Test
    public void test1findMaxMinOfArray() {
        int max = 31;
        int min = 6;

        assertEquals(max, IntegerArrayUtils.findMaxMinOfArray(ints2).getMax());
        assertEquals(min, IntegerArrayUtils.findMaxMinOfArray(ints2).getMin());
    }

    @Test
    public void test2findMaxMindOfArray() {
        Integer[] arr = {0, 0, 0, 0, 0};

        assertEquals(0, IntegerArrayUtils.findMaxMinOfArray(arr).getMax());
        assertEquals(0, IntegerArrayUtils.findMaxMinOfArray(arr).getMin());
    }

    @Test
    public void test1RemoveDupesFromArray() {
        Integer[] arr = {0, 0, 0, 0, 3, 3, 1, 1, 5};
        Integer[] exp = {0, 3, 1, 5};

        assertEquals(exp, IntegerArrayUtils.removeDupesFromArray(arr));
    }

    @Test
    public void test2RemoveDupesFromArray() {
        assertEquals(ints2, IntegerArrayUtils.removeDupesFromArray(ints2));
    }

    @Test
    public void test1find2ndLargestValueFromArray() {
        Integer expected = 10;
        assertEquals(expected, IntegerArrayUtils.find2ndLargestValueFromArray(ints2));
    }

    @Test
    public void test2Find2NdLargestValueFromArray() {
        Integer expected = -7;
        assertEquals(expected, IntegerArrayUtils.find2ndLargestValueFromArray(ints));
    }

    @Test
    public void testMakeMeAnArrayListFromArray() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(ints2));
        assertEquals(arrayList, IntegerArrayUtils.makeMeAnArrayListFromArray(ints2));
    }

    @Test
    public void test2MakeMeAnArrayListFromArray() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(ints));
        assertEquals(arrayList, IntegerArrayUtils.makeMeAnArrayListFromArray(ints));
    }

    @Test
    public void test1MakeMeAnArrayFromArrayList() {
        ArrayList<Integer> arrayList = IntegerArrayUtils.makeMeAnArrayListFromArray(ints);
        assertEquals(ints, IntegerArrayUtils.makeMeAnArrayFromArrayList(arrayList));
    }

    @Test
    public void test2MakeMeAnArrayFromArrayList() {
        ArrayList<Integer> arrayList = IntegerArrayUtils.makeMeAnArrayListFromArray(ints2);
        assertEquals(ints2, IntegerArrayUtils.makeMeAnArrayFromArrayList(arrayList));
    }

    @Test
    public void test1check2ArraysForEqual() {
        assertTrue(IntegerArrayUtils.check2ArraysForEqual(ints, ints));
    }

    @Test
    public void test2check2ArraysForEqual() {
        assertFalse(IntegerArrayUtils.check2ArraysForEqual(ints, ints2));
    }

    @Test
    public void test1AverageArrayWithoutMaxMin() {
        int expected = 10;
        assertEquals(expected, IntegerArrayUtils.averageArrayWithoutMaxMin(ints2));
    }

    @Test
    public void test2AverageArrayWithoutMaxMin() {
        int expected = 17;
        assertEquals(expected, IntegerArrayUtils.averageArrayWithoutMaxMin(ints));
    }

    @Test
    public void test1ArrayHas65and77() {
        assertFalse(IntegerArrayUtils.arrayHas65and77(ints2));
    }

    @Test
    public void test2ArrayHas65and77() {
        Integer[] arr = {65, 77};
        assertTrue(IntegerArrayUtils.arrayHas65and77(arr));
    }

    @Test
    public void test1theTotalOfTensIs30() {
        assertFalse(IntegerArrayUtils.theTotalOfTensIs30(ints));
    }

    @Test
    public void test2theTotalOfTensIs30() {
        Integer[] arr = {10, 10, 10};
        assertTrue(IntegerArrayUtils.theTotalOfTensIs30(arr));
    }

    @Test
    public void test1MakeMeACopyPlease() {
        Integer[] exp = IntegerArrayUtils.reverseArray(ints);
        assertEquals(exp, IntegerArrayUtils.makeMeACopyPlease(ints));
    }

    @Test
    public void test2MakeMeACopyPlease() {
        Integer[] exp = IntegerArrayUtils.reverseArray(ints2);
        assertEquals(exp, IntegerArrayUtils.makeMeACopyPlease(ints2));
    }

    @Test
    public void test1removeLastItemAndCopy() {
        Integer[] exp = {6, 10};
        assertEquals(exp, IntegerArrayUtils.removeLastItemAndCopy(ints2));
    }

    @Test
    public void test2RemoveLastItemAndCopy() {
        Integer[] exp = {4,5,102,6,-7,12,-32,92};
        assertEquals(exp, IntegerArrayUtils.removeLastItemAndCopy(ints));
    }

    @Test
    public void test1RemoveFirstItemAndCopy() {
        Integer[] exp = {10, 31};
        assertEquals(exp, IntegerArrayUtils.removeFirstItemAndCopy(ints2));
    }

    @Test
    public void test2RemoveFirstItemAndCopy() {
        Integer[] exp = {5,102,6,-7,12,-32,92,8};
        assertEquals(exp, IntegerArrayUtils.removeFirstItemAndCopy(ints));
    }

    @Test
    public void test1InsertAtStartAndCopy() {
        Integer[] exp = {1, 4, 5,102,6,-7,12,-32,92,8};
        Integer[] actual = IntegerArrayUtils.insertAtStartAndCopy(ints, 1);
        assertEquals(exp, actual);
    }

    @Test
    public void test2InsertAtStartAndCopy() {
        Integer[] exp = {5, 6, 10, 31};
        assertEquals(exp, IntegerArrayUtils.insertAtStartAndCopy(ints2,5));
    }

    @Test
    public void test1InsertAtEndAndCopy() {
        Integer[] exp = {4, 5,102,6,-7,12,-32,92,8, 1};
        assertEquals(exp, IntegerArrayUtils.insertAtEndAndCopy(ints, 1));
    }

    @Test
    public void test2InsertAtEndAndCopy() {
        Integer[] exp = {6, 10, 31, 5};
        assertEquals(exp, IntegerArrayUtils.insertAtEndAndCopy(ints2, 5));
    }

    @Test
    public void test1sortArrayIntoEvensThenOdds() {
        Integer[] exp = {6, 10, 31};
        assertEquals(exp, IntegerArrayUtils.sortArrayIntoEvensThenOdds(ints2));
    }

    @Test
    public void test2SortArrayIntoEvensThenodds() {
        Integer[] exp = {4, 102, 6, 12, -32, 92, 8, 5, -7};
        assertEquals(exp, IntegerArrayUtils.sortArrayIntoEvensThenOdds(ints));
    }
}
