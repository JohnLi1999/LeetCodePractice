package hard._0010_Regular_Expression_Matching;

import java.util.ArrayDeque;
import java.util.Deque;

/*  https://leetcode.com/problems/regular-expression-matching/
    Time complexity: O(n!)
        removeUnnecessary takes O(n) time
        isMatch and match takes O(n!) time
    Space complexity: O(n^n)
        In the worst case, there can be n * n cases in the expression.
        So the stack need to store all possible conditions
 */
public class Solution_My_Way_Super_Slow_and_Complicated {
    private String s;
    private String p;
    private int sLen;
    private int pLen;
    private char[] sChars;
    private char[] pChars;
    private final Deque<int[]> stack = new ArrayDeque<>();

    public boolean isMatch(String s, String p) {
        sLen = s.length();
        pLen = p.length();
        if (sLen == 0 && pLen == 0 || p.equals(".*")) {
            return true;
        }

        this.s = s;
        this.p = removeUnnecessary(p);
        pLen = this.p.length();
        sLen = this.s.length();
        sChars = this.s.toCharArray();
        pChars = this.p.toCharArray();

        if (match(0, 0)) {
            return true;
        } else {
            while (!stack.isEmpty()) {
                int [] results = stack.peek();

                if (results.length == 2) {
                    int i = results[0];
                    int j = results[1];
                    int nextIndex = s.indexOf(this.p.charAt(j), i + 1);

                    if (nextIndex == -1) {
                        stack.pop();
                    } else {
                        results[0] = nextIndex;
                        if (match(nextIndex, j)) {
                            return true;
                        }
                    }
                } else {
                    int iInit = results[0];
                    int jNext = results[1];
                    int currCount = results[2];
                    int maxCount = results[3];
                    if (currCount == maxCount) {
                        stack.pop();
                    } else {
                        currCount += 1;
                        results[2] = currCount;
                        if (match(iInit + currCount, jNext)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean match(int i, int j) {
        while (i < sLen && j < pLen) {
            char sCurr = sChars[i];
            char pCurr = pChars[j];

            if (sCurr == pCurr) {
                if (j == pLen - 1) {
                    return i == sLen - 1;
                }

                char pNext = pChars[j + 1];

                if (pNext != '*') {
                    i++;
                    j++;
                    continue;
                }

                // Case for pNext == '*'

                // aaa* and aaa*b
                if (j >= pLen - 3) {
                    while (i < sLen - 1) {
                        if (sChars[i] == sChars[i + 1]) {
                            i++;
                        } else {
                            break;
                        }
                    }

                    if (p.indexOf(pCurr, j + 1) == -1) {
                        i++;
                    }
                    j += 2;

                    continue;
                }

                int count = i;
                while (count < sLen - 1) {
                    if (sChars[count] == sChars[count + 1]) {
                        count++;
                    } else {
                        break;
                    }
                }
                count = count + 1 - i;

                // For all x*
                stack.add(new int[] {i, j + 2, 0, count});
                i += 0;
                j += 2;
            } else {
                if (j == pLen - 1 && pCurr != '.') {
                    return false;
                }
                if (j == pLen - 1 && pCurr == '.') {
                    return i == sLen - 1;
                }

                char pNext = pChars[j + 1];

                if (pCurr != '.' && pNext == '*') {
                    j += 2;
                    continue;
                }
                if (pCurr != '.') {
                    return false;
                }

                if (pNext != '*') {
                    i++;
                    j++;
                    continue;
                }

                // Cases for pCurr = '.' && pNext == '*'

                if (j + 1 == pLen - 1) {
                    return true;
                }

                int pKey = pChars[j + 2];
                if (pKey != '.') {
                    int index = s.indexOf(pKey, i);
                    if (index == -1) {
                        return false;
                    } else {
                        stack.push(new int[] {i, j + 2});
                        i = index;
                        j = j + 2;
                        continue;
                    }
                }

                // pKey == '.'
                stack.add(new int[] {i, j + 2, 0, sLen - i});
                i += 0;
                j += 2;
            }
        }

        if (i == sLen && j == pLen) {
            return true;
        }

        if (j == pLen) {
            return false;
        }

        if (i == sLen) {
            while (j < pLen) {
                if (j + 1 == pLen) {
                    return false;
                }

                j = j + 1;
                if (pChars[j] == '*') {
                    j = j + 1;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public String removeUnnecessary(String p) {
        String updated = p;

        int index = updated.indexOf(".*");
        while (index != -1) {
            int prevCount = 0;
            int afterCount = 0;

            /* Remove prev unnecessary */
            int prev = index - 1;
            while (prev > 0) {
                if (updated.charAt(prev) == '*') {
                    prev -= 2;
                } else if (updated.charAt(prev) == '.') {
                    prevCount += 1;
                    prev -= 1;
                } else {
                    break;
                }
            }

            /* Remove after unnecessary */
            int after = index + 2;
            while (after < updated.length()) {
                if (after == updated.length() - 1) {
                    if (updated.charAt(after) == '.') {
                        after += 1;
                        afterCount += 1;
                    }
                    break;
                }

                if (updated.charAt(after) == '.') {
                    if (updated.charAt(after + 1) == '*') {
                        after += 2;
                    } else {
                        after += 1;
                        afterCount += 1;
                    }
                } else {
                    after = after + 1;
                    if (updated.charAt(after) == '*') {
                        after += 1;
                    } else {
                        after -= 1;
                        break;
                    }
                }
            }

            StringBuilder prevDot = new StringBuilder();
            for (int i = 0; i < prevCount; i++) {
                prevDot.append('.');
            }

            StringBuilder afterDot = new StringBuilder();
            for (int i = 0; i < afterCount; i++) {
                afterDot.append('.');
            }

            updated = updated.substring(0, prev + 1) + prevDot.toString() + "##" + afterDot.toString() + updated.substring(after);
            index = updated.indexOf(".*");
        }

        return updated.replace("##", ".*");
    }
}
