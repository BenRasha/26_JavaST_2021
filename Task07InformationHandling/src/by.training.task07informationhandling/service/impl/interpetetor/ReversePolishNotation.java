import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class ReversePolishNotation {

    private static final int NOT_PRIORITY = 5;
    private static final int SHIFTS_PRIORITY = 4;
    private static final int AND_PRIORITY = 3;
    private static final int XOR_PRIORITY = 2;
    private static final int OR_PRIORITY = 1;
    private static final String OPERATORS = "~&|^";
    private static final String BRACKETS = "()";
    private static final String SHIFT_RIGHT = ">>";
    private static final String SHIFT_RIGHT_WITH_ZEROS = ">>>";
    private static final String SHIFT_LEFT = "<<";

    private ArrayDeque<String> stack = new ArrayDeque<>();

    private boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    private boolean isOpenBracket(String token) {
        return "(".equals(token);
    }

    private boolean isCloseBracket(String token) {
        return ")".equals(token);
    }

    private boolean isOperator(String token) {
        return OPERATORS.contains(token) || SHIFT_RIGHT.contains(token) || SHIFT_RIGHT_WITH_ZEROS.contains(token)
                || SHIFT_LEFT.contains(token);
    }

    private int getPrecedence(String token) {
        if ("~".equals(token)) {
            return NOT_PRIORITY;
        } else if (">>".equals(token) || ">>>".equals(token) || "<<".equals(token)) {
            return SHIFTS_PRIORITY;
        } else if ("&".equals(token)) {
            return AND_PRIORITY;
        } else if ("^".equals(token)) {
            return XOR_PRIORITY;
        } else if ("|".equals(token)) {
            return OR_PRIORITY;
        }
        return 0;
    }

    public String getPolishNotation(String expression) {
        StringBuilder result = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(expression, SHIFT_LEFT + SHIFT_RIGHT + OPERATORS + BRACKETS, true);
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            if (token.equals(">") || token.equals("<")) {
                token += stringTokenizer.nextToken();
            }
            if (isNumber(token)) {
                result.append(token).append(" ");
            }
            if (isOpenBracket(token)) {
                stack.push(token);
            }
            if (isOperator(token)) {
                if (stack.isEmpty()) {
                    stack.push(token);
                } else {
                    if (getPrecedence(stack.getFirst()) < getPrecedence(token)) {
                        stack.push(token);
                    } else if (getPrecedence(stack.getFirst()) >= getPrecedence(token)) {
                        result.append(stack.pollFirst()).append(" ");
                        stack.push(token);
                    }
                }
            }
            if (isCloseBracket(token)) {
                stack.push(token);
                do {
                    result.append(stack.pop()).append(" ");
                } while (!isOpenBracket(stack.getFirst()));
                result.append(stack.pop()).append(" ");
            }
        }
        if (!stack.isEmpty()) {
            do {
                result.append(stack.pop()).append(" ");
            } while (!stack.isEmpty());
        }
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '(' || result.charAt(i) == ')') {
                result.deleteCharAt(i);
            }
        }
        return result.toString().replaceAll("(\\s){2,}", " ").trim();
    }

}
