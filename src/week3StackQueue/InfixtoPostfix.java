package week3StackQueue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;

public class InfixtoPostfix {
    private static int precedence(String op) {
        if (op.equals("+") || op.equals("-")) return 1;
        if (op.equals("*") || op.equals("/")) return 2;
        return 0;
    }

    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        // Dùng một stack (hoặc queue) để lưu trữ kết quả trung gian thay vì in trực tiếp
        Stack<String> output = new Stack<String>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/") && !s.equals("(") && !s.equals(")")) {
                // Nếu là số, đẩy vào stack kết quả
                output.push(s);
            } 
            else if (s.equals("(")) {
                ops.push(s);
            } 
            else if (s.equals(")")) {
                while (!ops.isEmpty() && !ops.peek().equals("(")) {
                    output.push(ops.pop());
                }
                if (!ops.isEmpty()) ops.pop(); // Bỏ dấu mở ngoặc
            } 
            else {
                while (!ops.isEmpty() && !ops.peek().equals("(") && precedence(ops.peek()) >= precedence(s)) {
                    output.push(ops.pop());
                }
                ops.push(s);
            }
        }

        // Đưa nốt các toán tử còn lại trong stack vào output
        while (!ops.isEmpty()) {
            output.push(ops.pop());
        }

        // Đảo ngược lại stack output để in ra đúng thứ tự từ trái sang phải của biểu thức hậu tố
        Stack<String> finalResult = new Stack<String>();
        while (!output.isEmpty()) {
            finalResult.push(output.pop());
        }

        // In toàn bộ kết quả từ stack ra màn hình ở cuối chương trình
        while (!finalResult.isEmpty()) {
            StdOut.print(finalResult.pop() + " ");
        }
        StdOut.println();
    }
}