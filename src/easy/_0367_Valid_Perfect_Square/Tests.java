package easy._0367_Valid_Perfect_Square;

import org.junit.jupiter.api.Test;

import static easy._0367_Valid_Perfect_Square.Solution.isPerfectSquare;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void test1() {
        assertTrue(isPerfectSquare(16));
    }

    @Test
    void test2() {
        assertFalse(isPerfectSquare(14));
    }

    @Test
    void test3() {
        assertFalse(isPerfectSquare(5));
    }
}