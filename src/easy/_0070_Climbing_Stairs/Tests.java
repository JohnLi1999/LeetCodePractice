package easy._0070_Climbing_Stairs;

import org.junit.jupiter.api.Test;

import static easy._0070_Climbing_Stairs.Solution.climbStairs_Dynamic_Programming;
import static easy._0070_Climbing_Stairs.Solution.climbStairs_DP_Fib;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void test1() {
        int stairs = 2;
        int ways = 2;
        assertEquals(ways, climbStairs_Dynamic_Programming(stairs));
        assertEquals(ways, climbStairs_DP_Fib(stairs));
    }

    @Test
    void test2() {
        int stairs = 3;
        int ways = 3;
        assertEquals(ways, climbStairs_Dynamic_Programming(stairs));
        assertEquals(ways, climbStairs_DP_Fib(stairs));
    }

    @Test
    void test3() {
        int stairs = 5;
        int ways = 8;
        assertEquals(ways, climbStairs_Dynamic_Programming(stairs));
        assertEquals(ways, climbStairs_DP_Fib(stairs));
    }
}