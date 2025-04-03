public class KeyIndexedSort {
    private static final int R = 256;  // Extended ASCII characters (0-255)
    private static final int CUTOFF = 15;  // Optional insertion sort cutoff

    // Non-instantiable class
    public KeyIndexedSort() { }

    /**
     * Sorts strings by their d-th character using key-indexed counting sort
     * @param a Array to sort
     * @param d Character position to sort by (0-indexed)
     */
    public static void sortByPosition(String[] a, int d) {
        int n = a.length;
        if (n <= 1) return;

        String[] aux = new String[n];
        int[] count = new int[R + 2]; 

        // 1. Compute frequency counts
        for (int i = 0; i < n; i++) {
            int c = charAt(a[i], d) + 1;
            count[c]++;
        }
        // 2. Transform counts to indices
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r]; 
        }
        // 3. Distribute to auxiliary array
        for (int i = 0; i < n; i++) {
            int c = charAt(a[i], d);
            aux[count[c]++] = a[i];
        }
        // 4. Copy back to original array
        for (int i = 0; i < n; i++) {
            a[i] = aux[i];
        }

    }

    // Get d-th character or -1 if out of bounds
    private static int charAt(String s, int d) {
        return d < s.length() ? s.charAt(d) : -1;
    }

    /**
     * Checks if array is sorted by d-th character
     * @param a Array to check
     * @param d Character position to verify
     * @return True if sorted, false otherwise
     */
    public static boolean isSorted(String[] a, int d) {
        for (int i = 1; i < a.length; i++) {
            int current = charAt(a[i], d);
            int previous = charAt(a[i-1], d);
            if (current < previous) return false;
        }
        return true;
    }

    // Example usage
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "kiwi", "grape", "pear"};
        
        // Sort by 2nd character (index 1)
        sortByPosition(words, 1);
        
        for (String word : words) {
            System.out.println(word);
        }
        
        System.out.println("Sorted correctly: " + isSorted(words, 1));
    }
}
