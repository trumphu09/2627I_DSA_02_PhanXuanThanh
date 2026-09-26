package week3StackQueue;

import java.util.Stack;

public class week3_tailop_25020397 {

    // Hàm trả về độ ưu tiên của các toán tử
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    // Hàm chuyển đổi biểu thức Trung tố (Infix) sang Hậu tố (Postfix)
    static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            // Bỏ qua khoảng trắng
            if (c == ' ') {
                continue;
            }

            // Nếu ký tự là toán hạng (chữ số hoặc chữ cái), thêm thẳng vào chuỗi kết quả
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } 
            // Nếu là dấu ngoặc mở '(', đẩy vào ngăn xếp
            else if (c == '(') {
                stack.push(c);
            } 
            // Nếu là dấu ngoặc đóng ')', lấy các toán tử trong ngăn xếp ra cho đến khi gặp '('
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Loại bỏ dấu '(' khỏi ngăn xếp
            } 
            // Nếu ký tự là toán tử (+, -, *, /)
            else {
                // Chừng nào toán tử ở đỉnh ngăn xếp có độ ưu tiên lớn hơn hoặc bằng toán tử hiện tại
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                // Đẩy toán tử hiện tại vào ngăn xếp
                stack.push(c);
            }
        }

        // Lấy tất cả các toán tử còn sót lại trong ngăn xếp thêm vào chuỗi kết quả
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Biểu thức ví dụ
        String expression = "8 + 4 * 3 - (6 / 2 + 5) * 2";
        
        System.out.println("Biểu thức Trung tố (Infix): " + expression);
        System.out.println("Biểu thức Hậu tố (Postfix): " + infixToPostfix(expression));
    }
}
