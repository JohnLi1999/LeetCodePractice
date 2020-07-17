package easy._0231_Power_of_Two;

import org.junit.jupiter.api.Test;

import static easy._0231_Power_of_Two.Solution.*;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void test1() {
        assertTrue(isPowerOfTwo_Turn_off_the_Rightmost_1_Bit(1));
        assertTrue(isPowerOfTwo_Get_the_Rightmost_1_Bit(1));
        assertTrue(isPowerOfTwo_Simple_Way(1));
    }

    @Test
    void test2() {
        assertTrue(isPowerOfTwo_Turn_off_the_Rightmost_1_Bit(16));
        assertTrue(isPowerOfTwo_Get_the_Rightmost_1_Bit(16));
        assertTrue(isPowerOfTwo_Simple_Way(16));
    }

    @Test
    void test3() {
        assertFalse(isPowerOfTwo_Turn_off_the_Rightmost_1_Bit(218));
        assertFalse(isPowerOfTwo_Get_the_Rightmost_1_Bit(218));
        assertFalse(isPowerOfTwo_Simple_Way(218));
    }

    @Test
    void test4() {
        assertFalse(isPowerOfTwo_Turn_off_the_Rightmost_1_Bit(0));
        assertFalse(isPowerOfTwo_Get_the_Rightmost_1_Bit(0));
        assertFalse(isPowerOfTwo_Simple_Way(0));
    }

    @Test
    void test5() {
        assertFalse(isPowerOfTwo_Turn_off_the_Rightmost_1_Bit(Integer.MIN_VALUE));
        assertFalse(isPowerOfTwo_Get_the_Rightmost_1_Bit(Integer.MIN_VALUE));
        assertFalse(isPowerOfTwo_Simple_Way(Integer.MIN_VALUE));
    }
}