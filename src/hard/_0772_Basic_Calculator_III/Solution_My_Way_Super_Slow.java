package hard._0772_Basic_Calculator_III;

/*  https://leetcode.com/problems/basic-calculator-iii/
    Time complexity: O(n^3)
        findInnermostParentheses takes O(n) time
        getValue takes O(n^2) time
        => removeParentheses takes O(n^3) time
    Space complexity: O(n^3)
        findInnermostParentheses takes O(n) space
        getValue takes O(n^2) space
        => removeParentheses takes O(n^3) space
 */
public class Solution_My_Way_Super_Slow {
    public int calculate(String s) {
        String expression = removeSpace(s);
        String noParentheses = removeParentheses(expression);
        String value = getValue(noParentheses);
        return Integer.parseInt(value);
    }

    private String removeParentheses(String s) {
        String expression = s;

        int left = expression.indexOf('(');
        int right;

        while (left != -1) {
            int[] indices = findInnermostParentheses(expression);
            left = indices[0];
            right = indices[1];

            String value = getValue(expression.substring(left + 1, right));
            expression = expression.substring(0, left) + value + expression.substring(right + 1);

            left = expression.indexOf('(');
        }

        return expression;
    }

    private int[] findInnermostParentheses(String s) {
        int prevLeft = s.indexOf('(');
        int currLeft = s.indexOf('(', prevLeft + 1);
        int right = s.indexOf(')');

        while (currLeft != -1) {
            if (right < currLeft && prevLeft < right) {
                break;
            }

            prevLeft = currLeft;
            currLeft = s.indexOf('(', prevLeft + 1);
        }

        return new int[] { prevLeft, right};
    }

    private String getValue(String s) {
        String expression = s;

        /* Caculate * and / first */
        int multiply = expression.indexOf('*');
        int division = expression.indexOf('/');
        while (multiply != -1 || division != -1) {
            int[] results;

            if (multiply == -1) {
                results = calculateValue(expression, division);
            } else if (division == -1) {
                results = calculateValue(expression, multiply);
            } else {
                results = calculateValue(expression, Math.min(multiply, division));
            }

            int value = results[0];
            int op1Start = results[1];
            int op2End = results[2];
            expression = expression.substring(0, op1Start) + value + expression.substring(op2End);

            multiply = expression.indexOf('*');
            division = expression.indexOf('/');
        }

        /* Caculate + and - then */
        int addition = expression.indexOf('+');
        int subtraction = expression.indexOf('-');
        int nextSubtraction = expression.indexOf('-', subtraction + 1);
        if (subtraction == 0 && nextSubtraction != -1) {
            subtraction = nextSubtraction;
        } else if (subtraction == 0) {
            subtraction = -1;
        }

        while (addition != -1 || subtraction != -1) {
            int[] results;

            if (addition == -1) {
                results = calculateValue(expression, subtraction);
            } else if (subtraction == -1) {
                results = calculateValue(expression, addition);
            } else {
                results = calculateValue(expression, Math.min(addition, subtraction));
            }

            int value = results[0];
            int op1Start = results[1];
            int op2End = results[2];
            expression = expression.substring(0, op1Start) + value + expression.substring(op2End);

            addition = expression.indexOf('+');
            subtraction = expression.indexOf('-');
            nextSubtraction = expression.indexOf('-', subtraction + 1);
            if (subtraction == 0 && nextSubtraction != -1) {
                subtraction = nextSubtraction;
            } else if (subtraction == 0) {
                subtraction = -1;
            }
        }

        return expression;
    }

    private int[] calculateValue(String s, int index) {
        char[] chars = s.toCharArray();

        int op1Start = 0, op2End = s.length();
        char operator = chars[index];
        char next = chars[index + 1];
        int op2Start;

        for (int i = index - 1; i >= 0; i--) {
            if (!Character.isDigit(chars[i]) && i != 0) {
                op1Start = i + 1;

                break;
            }
        }

        if (next == '-') {
            op2Start = index + 2;
        } else {
            op2Start = index + 1;
        }

        for (int i = op2Start; i < s.length(); i++) {
            if (!Character.isDigit(chars[i])) {
                op2End = i;
                break;
            }
        }

        long operand1 = Long.parseLong(s.substring(op1Start, index));
        long operand2 = Long.parseLong(s.substring(index + 1, op2End));
        long value = switch (operator) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> operand1 / operand2;
            default -> 0;
        };

        return new int[] { (int) value, op1Start, op2End };
    }

    private String removeSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
