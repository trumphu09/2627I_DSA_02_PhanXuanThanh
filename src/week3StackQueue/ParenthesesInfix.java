package week3StackQueue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;

public class ParenthesesInfix {
    public static void main(String[] args) {
        Stack<String> vals = new Stack<String>();

        // Đọc lần lượt từng token từ luồng nhập chuẩn (StdIn)
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

            if (s.equals(")")) {
                // Khi gặp dấu đóng ngoặc, lấy ra 3 phần tử ở đỉnh stack 
                String right = vals.pop();
                String op = vals.pop();
                String left = vals.pop();

                // Tạo lại biểu thức con có đủ dấu ngoặc
                String subExpr = "( " + left + " " + op + " " + right + " )";

                // Đẩy kết quả ngược trở lại stack
                vals.push(subExpr);
            } else {
                // Nếu là số, toán tử hoặc các ký tự khác thì đẩy vào stack
                vals.push(s);
            }
        }

        // In ra biểu thức hoàn chỉnh cuối cùng nằm trong stack
        if (!vals.isEmpty()) {
            StdOut.println(vals.pop());
        }
    }
}