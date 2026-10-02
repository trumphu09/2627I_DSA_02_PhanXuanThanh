package week4sort;
import java.util.Arrays;
import java.util.Scanner;

public class Insertion {
    public static <T extends Comparable<T>> void sort(T[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            // Duyệt ngược từ i về 0, so sánh và đổi chỗ nếu phần tử đứng trước lớn hơn phần tử đứng sau
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    private static <T> void exch(T[] a, int j, int i) {
        T swap = a[j];
        a[j] = a[i];
        a[i] = swap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Nhập các phần tử cách nhau bởi dấu cách (VD: E A S Y Q U E S T I O N):");
        String input = scanner.nextLine();
        
        // Tự động tách chuỗi nhập vào thành một mảng các chữ cái (String)
        String[] arr = input.trim().split("\\s+");
        
        // Gọi hàm sắp xếp (Generics tự động hiểu đây là mảng String)
        sort(arr);
        
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(arr));
        
        scanner.close(); 
    }
}