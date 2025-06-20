import org.javatuples.Quartet;
import org.junit.Test;
import org.junit.Assert;

@SuppressWarnings("rawtypes")
public class ArrayQ {

    /**
     * Problem: You are given an array of integers (arr) and a number (n).
     * Write a method which is returning true if arr contains k numbers adding
     * up to n and false otherwise.
     * @param arr - array of integers
     * @param n - number to verify if k elements in arr can sum up to it.
     * @param k - count of elements in arr to verify if they sum up to n.
     * @return true if there are k numbers in arr adding up to n, false otherwise.
     */
    public static boolean sumK(int[] arr, int n, int k) {
        return sumKHelper(arr, n, k, 0);
    }
    
    /**
     * Recursive helper for sumK(). Checks the element at index i in arr
     * is the last to sum up to n, and if not, it explores
     * the (two) options: either it is or it is not part of the elements in the sum.
     * @param arr - array of integers
     * @param n - number to verify if k elements in arr can sum up to it.
     * @param k - count of elements in arr to verify if they sum up to n.
     * @param i - current index in arr to analize
     * @return true if there are k numbers in arr adding up to n, false otherwise.
     */
    public static boolean sumKHelper(int[] arr, int n, int k, int i) {
        if (i >= arr.length) {
            return false;
        } else if (k == 1) {
            return (arr[i] == n)
                || sumKHelper(arr, n, k, i+1);
        } else {
            return sumKHelper(arr, n-arr[i], k-1, i+1)
                || sumKHelper(arr, n, i+1, k);
        }
    }
    
    /**
     * Tester for sumK
     */
    @Test
    public void testSumK() {
        /*
         * A test is a quartet (4 components):
         * - the array arr to be tested
         * - the number n standing for the value to check if k elements can sum-up to it
         * - the k elements expected to sum up to n
         * - the expected result: true if k numbers can be added to n, false otherwise.
         */
        Quartet[] tests = new Quartet[] {
                Quartet.with(new int[] {1, 2, 3}, 3, 1, true),
                Quartet.with(new int[] {4, 3, 2, 1}, 5, 2, true),
                Quartet.with(new int[] {4, 3, 2, 1}, 8, 2, false),
                Quartet.with(new int[] {4, 3, 2, 1}, 8, 3, true),
                Quartet.with(new int[] {4, 3, 2, 1}, 7, 2, true),
                Quartet.with(new int[] {4, 3, 2, 1}, 7, 3, true),
                Quartet.with(new int[] {4, 3, 2, 1}, 7, 4, false),
                Quartet.with(new int[] {4, 3, 2, 1}, 10, 4, true),
                Quartet.with(new int[] {4, 3, 2, 1}, 10, 5, false),
        };
        
        for(Quartet test : tests) {
            boolean result = sumK(
                    (int[])test.getValue0(),
                    (int)test.getValue1(),
                    (int)test.getValue2());
            Assert.assertEquals((boolean)test.getValue3(), result);
        }
    }
}

