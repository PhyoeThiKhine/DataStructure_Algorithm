package code;

import java.util.StringTokenizer;

public class MyShuntingYard_65011466 {
    private static int order(String c){ //defining operator precedence
        return switch (c) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            case "^" -> 3;
            default -> 0;
        };
    }

    public static String infixToPostfix(String infixString){
        MyQueueL_65011466 queue = new MyQueueL_65011466();
        MyStackA_String_65011466 stack = new MyStackA_String_65011466();
        String resultPostfixString = "";
        StringTokenizer st = new StringTokenizer(infixString);
        while(st.hasMoreTokens()) {
            String t = st.nextToken();
            if (MyRPN_65011466.isNumeric(t))
                queue.enqueue(t);
            else if (t.equals("("))
                stack.push((t));
            else if (t.equals(")")){
                while (!stack.isEmpty() && !stack.peek().equals("(")){
                    queue.enqueue((stack.pop()));
                }
                stack.pop();  //discard "("
            }
            else {
                while (!stack.isEmpty() && order(t) <= order(stack.peek())) { 
                    queue.enqueue(stack.pop());
                }
                stack.push(t); // Push the current operator onto the stack
            }      
        }
        while(!stack.isEmpty()){
            if(stack.peek() == "(")
                return "Invalid";
            queue.enqueue(stack.pop());
        }
        resultPostfixString = queue.dumpToString();
        return resultPostfixString;
    }

    /*public static void main(String[] args) {
        String infixStr = "( 4 + 2 ) / 3 * ( 8 - 5 )";
        System.out.println(infixStr);
        String postfixStr = infixToPostfix(infixStr);
        System.out.println(postfixStr);
    }*/

}
