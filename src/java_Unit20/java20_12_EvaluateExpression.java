package java_Unit20;

import java.util.Stack;

public class java20_12_EvaluateExpression {
    public static void main(String[] args) {

        // ��鴫�ݵĲ������� Check number of arguments passed
        if (args.length != 1) {
            System.out.println(
                    "Usage: java EvaluateExpression \"expression\"");
            System.exit(1);
        }
        try {
            System.out.println(evaluateExpression(args[0]));
        } catch (Exception ex) {
            System.out.println("������ Wrong expression: " + args[0]);
        }
    }

    /**
     * �������ʽ Evaluate an expression
     */
    public static int evaluateExpression(String expression) {
        // ������������ջ�Դ洢������ Create operandStack to store operands
        Stack<Integer> operandStack = new Stack<>();
        // �����������ջ�Դ洢�����
        Stack<Character> operatorStack = new Stack<>();
        // �ڣ�������+��-��/��*��Χ����ո� insert blanks around (, ), +, -, /, and *
        expression = insertBlanks(expression);
        // ��ȡ������������� Extract operands and operators
        String[] tokens = expression.split(" ");
        // �׶�1��ɨ������ Phase 1: Scan tokens
        for (String token : tokens) {
            // �հ� Blank space
            if (token.length() == 0) {
                // ����whileѭ������ȡ��һ����� Back to the while loop to extract the next token
                continue;
            } else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                // ���������ջ�Ķ�����������+��-��*��/  Process all +, -, *, / in the top of the operator stack
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '+' ||
                                operatorStack.peek() == '-' ||
                                operatorStack.peek() == '*' ||
                                operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }
                // ��+��-����������������ջ  Push the + or - operator into the operator stack
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                // ���������ջ�Ķ�����������*��/  Process all *, / in the top of the operator stack
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '*' ||
                                operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }
                // ��*��/����������������ջ Push the * or / operator into the operator stack
                operatorStack.push(token.charAt(0));
            } else if (token.trim().charAt(0) == '(') {
                // ��'��'�ѵ�  Push '(' to stack
                operatorStack.push('(');
            } else if (token.trim().charAt(0) == ')') {
                // �����ջ�е������������ֱ������'��'  Process all the operators in the stack until seeing '('
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.pop(); // Pop the '(' symbol from the stack
            } else {
                // ɨ��Ĳ�����  An operand scanned
                // ��������ѹ���ջ  Push an operand to the stack
                operandStack.push(new Integer(token));
            }
        }
        // �׶�2�������ջ������ʣ��������  Phase 2: Process all the remaining operators in the stack
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }
        // ���ؽ��  Return the result
        return operandStack.pop();
    }

    /**
     * ����һ�����������operatorStack�л�ȡһ���������������Ӧ���ڲ�����ջ�еĲ�����
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

