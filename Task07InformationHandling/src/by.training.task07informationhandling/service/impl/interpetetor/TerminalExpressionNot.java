public class TerminalExpressionNot extends AbstractMathExpression {

    @Override
    public void interpret(Context context) {
        context.push(~ context.pop());
    }
}
