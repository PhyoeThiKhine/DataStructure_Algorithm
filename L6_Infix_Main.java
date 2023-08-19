import code.MyQueueL_65011466;
import code.MyShuntingYard_65011466;
import code.MyRPN_65011466;

public class L6_Infix_Main {
    public static void main(String[] args) {
        demo1();
        String infixString = "( 4 + 2 ) / 3 * ( 8 - 5 ) ";  //expect 4 2 + 3 / 8 5 - *
        //if (args.length > 0)
            //infixString = args[0];
        computeInfix(infixString);
     
    }
    private static void demo1() {
        System.out.println("-----MyQueueL Tester-----");
        MyQueueL_65011466 queue = new MyQueueL_65011466();
        queue.enqueue("1");
        queue.enqueue("3");
        queue.enqueue("5");
        queue.enqueue("7");
        System.out.println(queue.dumpToString());
        System.out.println("Top " + queue.top());
        System.out.println("Last " + queue.getLast());
        System.out.println("Dequeue " + queue.dequeue());
        System.out.println("Dequeue " + queue.dequeue());
        System.out.println("Dequeue " + queue.dequeue());
        System.out.println("Dequeue " + queue.dequeue());
        queue.enqueue("9");
        System.out.println(queue);
        System.out.println("----MyQueueL Test End----");
    }
    public static void computeInfix(String infixString) {
        String postfixString = MyShuntingYard_65011466.infixToPostfix(infixString);
        System.out.println("Infixstring: " + infixString);
        System.out.println("Postfixstring: "+ postfixString);
        double ans = MyRPN_65011466.computeRPN(postfixString);
        System.out.println("Result is "+ans);
    }
}
