import java.util.*;

public class Calculator {

    private static final String SEPARATOR = " ";
    private static final String OPERATORS = "~&|^";
    private static final String SHIFT_RIGHT = ">>";
    private static final String SHIFT_RIGHT_WITH_ZEROS = ">>>";
    private static final String SHIFT_LEFT = "<<";
    private List<AbstractMathExpression> expressionList;

    public Calculator(String expression) {
        expressionList = new ArrayList<>();
        parse(expression);
    }

    private boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    private boolean isOperator(String token) {
        return OPERATORS.contains(token) || SHIFT_RIGHT.contains(token) || SHIFT_RIGHT_WITH_ZEROS.contains(token)
                || SHIFT_LEFT.contains(token);
    }

    private void parse(String expression) {
        StringTokenizer stringTokenizer = new StringTokenizer(expression, SEPARATOR, false);
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            if (isNumber(token)) {
                expressionList.add(new NonTerminalExpression(Integer.parseInt(token)));
            }else if (isOperator(token)) {
                switch (token) {
                    case "~" :
                        expressionList.add(new TerminalExpressionNot());
                        break;
                    case "&" :
                        expressionList.add(new TerminalExpressionAnd());
                        break;
                    case "|" :
                        expressionList.add(new TerminalExpressionOr());
                        break;
                    case "^" :
                        expressionList.add(new TerminalExpressionXOr());
                        break;
                    case ">>" :
                        expressionList.add(new TerminalExpressionShiftRight());
                        break;
                    case ">>>" :
                        expressionList.add(new TerminalExpressionShiftRightWithZeros());
                        break;
                    case "<<" :
                        expressionList.add(new TerminalExpressionShiftLeft());
                        break;
                }
            }
        }
    }

    public int calculate() {
        Context context = new Context();
        for (AbstractMathExpression mathExpression : expressionList) {
            mathExpression.interpret(context);
        }
        return context.pop();
    }

}
