package easy._0191_Number_of_1_Bits;

import org.junit.jupiter.api.Test;

import static easy._0191_Number_of_1_Bits.Solution.hammingWeight_unsigned_right_shift;
import static easy._0191_Number_of_1_Bits.Solution.hammingWeight_Bit_Manipulation_Trick;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void test1() {
        int input = 0b00000000000000000000000000001011;
        assertEquals(3, hammingWeight_unsigned_right_shift(input));
        assertEquals(3, hammingWeight_Bit_Manipulation_Trick(input));
    }

    @Test
    void test2() {
        int input = 0b00000000000000000000000010000000;
        assertEquals(1, hammingWeight_unsigned_right_shift(input));
        assertEquals(1, hammingWeight_Bit_Manipulation_Trick(input));
    }

    @Test
    void test3() {
        int input = 0b11111111111111111111111111111101;
        assertEquals(31, hammingWeight_unsigned_right_shift(input));
        assertEquals(31, hammingWeight_Bit_Manipulation_Trick(input));
    }

    @Test
    void test4() {
        int input = 0b10000000000000000000000000000000;
        assertEquals(1, hammingWeight_unsigned_right_shift(input));
        assertEquals(1, hammingWeight_Bit_Manipulation_Trick(input));
    }
}