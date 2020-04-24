package java_Unit20;

import java.util.Stack;

public class java20_12_EvaluateExpression {
    public static void main(String[] args) {

        // 检查传递的参数数量 Check number of arguments passed
        if (args.length != 1) {
            System.out.println(
                    "Usage: java EvaluateExpression \"expression\"");
            System.exit(1);
        }
        try {
            System.out.println(evaluateExpression(args[0]));
        } catch (Exception ex) {
            System.out.println("表达错误 Wrong expression: " + args[0]);
        }
    }

    /**
     * 评估表达式 Evaluate an expression
     */
    public static int evaluateExpression(String expression) {
        // 创建操作数堆栈以存储操作数 Create operandStack to store operands
        Stack<Integer> operandStack = new Stack<>();
        // 创建运算符堆栈以存储运算符
        Stack<Character> operatorStack = new Stack<>();
        // 在（，），+，-，/和*周围插入空格 insert blanks around (, ), +, -, /, and *
        expression = insertBlanks(expression);
        // 提取操作数和运算符 Extract operands and operators
        String[] tokens = expression.split(" ");
        // 阶段1：扫描令牌 Phase 1: Scan tokens
        for (String token : tokens) {
            // 空白 Blank space
            if (token.length() == 0) {
                // 返回while循环以提取下一个标记 Back to the while loop to extract the next token
                continue;
            } else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                // 在运算符堆栈的顶部处理所有+，-，*，/  Process all +, -, *, / in the top of the operator stack
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '+' ||
                                operatorStack.peek() == '-' ||
                                operatorStack.peek() == '*' ||
                                operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }
                // 将+或-运算符推入运算符堆栈  Push the + or - operator into the operator stack
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                // 在运算符堆栈的顶部处理所有*，/  Process all *, / in the top of the operator stack
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '*' ||
                                operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }
                // 将*或/运算符推入运算符堆栈 Push the * or / operator into the operator stack
                operatorStack.push(token.charAt(0));
            } else if (token.trim().charAt(0) == '(') {
                // 推'（'堆叠  Push '(' to stack
                operatorStack.push('(');
            } else if (token.trim().charAt(0) == ')') {
                // 处理堆栈中的所有运算符，直到看到'（'  Process all the operators in the stack until seeing '('
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.pop(); // Pop the '(' symbol from the stack
            } else {
                // 扫描的操作数  An operand scanned
                // 将操作数压入堆栈  Push an operand to the stack
                operandStack.push(new Integer(token));
            }
        }
        // 阶段2：处理堆栈中所有剩余的运算符  Phase 2: Process all the remaining operators in the stack
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }
        // 返回结果  Return the result
        return operandStack.pop();
    }

    /**
     * 处理一个运算符：从operatorStack中获取一个运算符，并将其应用于操作数栈中的操作数
     * Process one operator: Take an operator from operatorStack and
     * apply it on the operands in the operandStack
     */
    public static void processAnOperator(
            Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        if (op == '+') {
            operandStack.push(op2 + op1);
        } else if (op == '-') {
            operandStack.push(op2 - op1);
        } else if (op == '*') {
            operandStack.push(op2 * op1);
        } else if (op == '/') {
            operandStack.push(op2 / op1);
        }
    }

    public static String insertBlanks(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
                    s.charAt(i) == '+' || s.charAt(i) == '-' ||
                    s.charAt(i) == '*' || s.charAt(i) == '/') {
                result += " " + s.charAt(i) + " ";
            } else {
                result += s.charAt(i);
            }
        }
        return result;
    }
}

