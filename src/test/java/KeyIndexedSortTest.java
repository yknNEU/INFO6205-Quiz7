import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class KeyIndexedSortTest {

    @Test
    void testSortByPositionBasic() {
        String[] input = {"apple", "banana", "kiwi", "grape"};
        String[] expected = {"banana", "kiwi", "apple", "grape" };
        
        KeyIndexedSort.sortByPosition(input, 1);  // Static access
        assertArrayEquals(expected, input, "Should sort by second character");
        assertTrue(KeyIndexedSort.isSorted(input, 1), "Verify sorted state");
    }

    @Test
    void testEmptyArray() {
        String[] emptyArray = {};
        KeyIndexedSort.sortByPosition(emptyArray, 0);  // Static access
        assertEquals(0, emptyArray.length, "Empty array should remain unchanged");
    }

    @Test
    void testSingleElementArray() {
        String[] single = {"test"};
        String[] original = Arrays.copyOf(single, single.length);
        
        KeyIndexedSort.sortByPosition(single, 2);  // Static access
        assertArrayEquals(original, single, "Single element array should remain unchanged");
    }

    @Test
    void testEqualCharacters() {
        String[] input = {"apple", "apricot", "apex"};
        String[] expected = {"apple", "apricot", "apex"};
        
        KeyIndexedSort.sortByPosition(input, 1);  // Static access
        assertArrayEquals(expected, input, "Should maintain original order for equal characters");
    }


}