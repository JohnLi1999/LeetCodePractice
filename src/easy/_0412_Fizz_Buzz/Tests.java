package easy._0412_Fizz_Buzz;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static easy._0412_Fizz_Buzz.Solution.fizzBuzz;

class Tests {

    @Test
    void test1() {
        int input = 15;
        String[] expectedArr = new String[] {
            "1",
            "2",
            "Fizz",
            "4",
            "Buzz",
            "Fizz",
            "7",
            "8",
            "Fizz",
            "Buzz",
            "11",
            "Fizz",
            "13",
            "14",
            "FizzBuzz"
        };
        List<String> expectedResult = Arrays.asList(expectedArr);
        assertEquals(expectedResult, fizzBuzz(input));
    }
}