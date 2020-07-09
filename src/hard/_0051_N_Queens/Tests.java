package hard._0051_N_Queens;

import org.junit.jupiter.api.Test;

import java.util.*;

import static hard._0051_N_Queens.Solution.solveNQueens;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void test1() {
        int n = 4;
        List<List<String>> expectedResult = List.of(
                List.of(
                        ".Q..",
                        "...Q",
                        "Q...",
                        "..Q."
                ),
                List.of(
                        "..Q.",
                        "Q...",
                        "...Q",
                        ".Q.."
                )
        );
        assertEquals(expectedResult, solveNQueens(n));
    }
}