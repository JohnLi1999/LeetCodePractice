package hard._0269_Alien_Dictionary;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_My_Way_Super_Slow solution_my_way_super_slow = new Solution_My_Way_Super_Slow();
    Solution_Topological_Sort_BFS solution_topological_sort_bfs = new Solution_Topological_Sort_BFS();
    Solution_Topological_Sort_DFS solution_topological_sort_dfs = new Solution_Topological_Sort_DFS();

    @Nested
    class Topological_Sort_BFS {
        @Test
        void test1() {
            String[] words = {
                    "wrt", "wrf", "er", "ett", "rftt"
            };
            assertEquals("wertf", solution_topological_sort_bfs.alienOrder(words));
        }

        @Test
        void test2() {
            String[] words = {
                    "z", "x"
            };
            assertEquals("zx", solution_topological_sort_bfs.alienOrder(words));
        }

        @Test
        void test3() {
            String[] words = {
                    "z", "x", "z"
            };
            assertEquals("", solution_topological_sort_bfs.alienOrder(words));
        }

        @Test
        void test4() {
            String[] words = {
                    "w", "r", "t"
            };
            assertEquals("wrt", solution_topological_sort_bfs.alienOrder(words));
        }

        @Test
        void test5() {
            String[] words = {
                    "ab", "adc"
            };
            assertEquals("abcd", solution_topological_sort_bfs.alienOrder(words));
        }

        @Test
        void test6() {
            String[] words = {
                    "aac", "aabb", "aaba"
            };
            assertEquals("cba", solution_topological_sort_bfs.alienOrder(words));
        }

        @Test
        void test7() {
            String[] words = {
                    "ac", "ab", "zc", "zb"
            };
            assertEquals("aczb", solution_topological_sort_bfs.alienOrder(words));
        }

        @Test
        void test8() {
            String[] words = {
                    "aa", "abb", "aba"
            };
            assertEquals("", solution_topological_sort_bfs.alienOrder(words));
        }

        @Test
        void test9() {
            String[] words = {
                    "abc", "ab"
            };
            assertEquals("", solution_topological_sort_bfs.alienOrder(words));
        }

        @Test
        void test10() {
            String[] words = {
                    "z", "z"
            };
            assertEquals("z", solution_topological_sort_bfs.alienOrder(words));
        }

        @Test
        void test11() {
            String[] words = {
                    "ze", "yf", "xd", "wd", "vd", "ua", "tt", "sz", "rd",  "qd",
                    "pz", "op", "nw", "mt", "ln", "ko", "jm", "il",  "ho", "gk",
                    "fa", "ed", "dg", "ct", "bb", "ba"
            };
            assertEquals("zyxwvutsrqponmlkjihgfedcba", solution_topological_sort_bfs.alienOrder(words));
        }

        @Test
        void test12() {
            String[] words = {
                    "vlxpwiqbsg", "cpwqwqcd"
            };
            assertEquals("pqbsdvwgxilc", solution_topological_sort_bfs.alienOrder(words));
        }
    }

    @Nested
    class Topological_Sort_DFS {
        @Test
        void test1() {
            String[] words = {
                    "wrt", "wrf", "er", "ett", "rftt"
            };
            assertEquals("wertf", solution_topological_sort_dfs.alienOrder(words));
        }

        @Test
        void test2() {
            String[] words = {
                    "z", "x"
            };
            assertEquals("zx", solution_topological_sort_dfs.alienOrder(words));
        }

        @Test
        void test3() {
            String[] words = {
                    "z", "x", "z"
            };
            assertEquals("", solution_topological_sort_dfs.alienOrder(words));
        }

        @Test
        void test4() {
            String[] words = {
                    "w", "r", "t"
            };
            assertEquals("wrt", solution_topological_sort_dfs.alienOrder(words));
        }

        @Test
        void test5() {
            String[] words = {
                    "ab", "adc"
            };
            assertEquals("cbda", solution_topological_sort_dfs.alienOrder(words));
        }

        @Test
        void test6() {
            String[] words = {
                    "aac", "aabb", "aaba"
            };
            assertEquals("cba", solution_topological_sort_dfs.alienOrder(words));
        }

        @Test
        void test7() {
            String[] words = {
                    "ac", "ab", "zc", "zb"
            };
            assertEquals("cbaz", solution_topological_sort_dfs.alienOrder(words));
        }

        @Test
        void test8() {
            String[] words = {
                    "aa", "abb", "aba"
            };
            assertEquals("", solution_topological_sort_dfs.alienOrder(words));
        }

        @Test
        void test9() {
            String[] words = {
                    "abc", "ab"
            };
            assertEquals("", solution_topological_sort_dfs.alienOrder(words));
        }

        @Test
        void test10() {
            String[] words = {
                    "z", "z"
            };
            assertEquals("z", solution_topological_sort_dfs.alienOrder(words));
        }

        @Test
        void test11() {
            String[] words = {
                    "ze", "yf", "xd", "wd", "vd", "ua", "tt", "sz", "rd",  "qd",
                    "pz", "op", "nw", "mt", "ln", "ko", "jm", "il",  "ho", "gk",
                    "fa", "ed", "dg", "ct", "bb", "ba"
            };
            assertEquals("zyxwvutsrqponmlkjihgfedcba", solution_topological_sort_dfs.alienOrder(words));
        }

        @Test
        void test12() {
            String[] words = {
                    "vlxpwiqbsg", "cpwqwqcd"
            };
            assertEquals("lixgwvdcsbqp", solution_topological_sort_dfs.alienOrder(words));
        }
    }

    @Nested
    class My_Way {
        @Test
        void test1() {
            String[] words = {
                    "wrt", "wrf", "er", "ett", "rftt"
            };
            assertEquals("wertf", solution_my_way_super_slow.alienOrder(words));
        }

        @Test
        void test2() {
            String[] words = {
                    "z", "x"
            };
            assertEquals("zx", solution_my_way_super_slow.alienOrder(words));
        }

        @Test
        void test3() {
            String[] words = {
                    "z", "x", "z"
            };
            assertEquals("", solution_my_way_super_slow.alienOrder(words));
        }

        @Test
        void test4() {
            String[] words = {
                    "w", "r", "t"
            };
            assertEquals("wrt", solution_my_way_super_slow.alienOrder(words));
        }

        @Test
        void test5() {
            String[] words = {
                    "ab", "adc"
            };
            assertEquals("abdc", solution_my_way_super_slow.alienOrder(words));
        }

        @Test
        void test6() {
            String[] words = {
                    "aac", "aabb", "aaba"
            };
            assertEquals("cba", solution_my_way_super_slow.alienOrder(words));
        }

        @Test
        void test7() {
            String[] words = {
                    "ac", "ab", "zc", "zb"
            };
            assertEquals("azcb", solution_my_way_super_slow.alienOrder(words));
        }

        @Test
        void test8() {
            String[] words = {
                    "aa", "abb", "aba"
            };
            assertEquals("", solution_my_way_super_slow.alienOrder(words));
        }

        @Test
        void test9() {
            String[] words = {
                    "abc", "ab"
            };
            assertEquals("", solution_my_way_super_slow.alienOrder(words));
        }

        @Test
        void test10() {
            String[] words = {
                    "z", "z"
            };
            assertEquals("z", solution_my_way_super_slow.alienOrder(words));
        }

        @Test
        void test11() {
            String[] words = {
                    "ze", "yf", "xd", "wd", "vd", "ua", "tt", "sz", "rd",  "qd",
                    "pz", "op", "nw", "mt", "ln", "ko", "jm", "il",  "ho", "gk",
                    "fa", "ed", "dg", "ct", "bb", "ba"
            };
            assertEquals("zyxwvutsrqponmlkjihgfedcba", solution_my_way_super_slow.alienOrder(words));
        }

        @Test
        void test12() {
            String[] words = {
                    "vlxpwiqbsg", "cpwqwqcd"
            };
            assertEquals("vclpxwqibdsg", solution_my_way_super_slow.alienOrder(words));
        }
    }
}