package week3StackQueue;

import java.util.Stack;
import java.util.Queue; // (Tùy chọn nếu bạn dùng thư viện của sách Algorithms 4th)
// import edu.princeton.cs.algs4.Queue; // (Tùy chọn nếu bạn dùng thư viện của sách Algorithms 4th)

public class reverseQueue {

    public void reverse(Queue<String> q) {
        // Đưa stack vào bên trong hàm để tránh bị lưu trạng thái cũ giữa các lần gọi
        Stack<String> stack = new Stack<String>();
        
        // Bước 1: Chuyển toàn bộ phần tử từ Queue sang Stack (đảo ngược thứ tự)
        while (!q.isEmpty()) {
            stack.push(q.poll()); // Nếu dùng java.util.Queue chuẩn thì đổi thành q.poll()
        }
        
        // Bước 2: Chuyển ngược lại từ Stack về Queue
        while (!stack.isEmpty()) {
            q.offer(stack.pop()); // Nếu dùng java.util.Queue chuẩn thì đổi thành q.offer(stack.pop())
        }
    }

    public static void main(String[] args) {
        // Tạo một Queue và thêm các phần tử vào
        Queue<String> queue = new java.util.LinkedList<>(); // Sử dụng LinkedList làm Queue
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        queue.offer("D");

        System.out.println("Queue ban đầu: " + queue);

        // Tạo đối tượng reverseQueue và gọi phương thức reverse
        reverseQueue rq = new reverseQueue();
        rq.reverse(queue);

        System.out.println("Queue sau khi đảo ngược: " + queue);
    }
    // ban đầu queue lấy các phần từ từ đầu đến cuối A B C D 
    // sau đó được đưa vào stack ABCD sau đó lấy ra đưa vào queue theo thứ tự pop của stack D C B A
}