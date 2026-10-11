package week5mergesort;
import java.util.Scanner;

public class Solutionbai6 {

    // Hàm gọi đệ quy Quicksort
    static void quickSort(int[] ar, int low, int high) {
        if (low < high) {
            int pi = partitionLomuto(ar, low, high);
            
            // In ra toàn bộ mảng sau mỗi lần partition thành công
            printArray(ar);
            
            // Sắp xếp các phần tử trước và sau chốt
            quickSort(ar, low, pi - 1);
            quickSort(ar, pi + 1, high);
        }
    }

    // Cài đặt Lomuto Partitioning theo mã giả trong tài liệu
    static int partitionLomuto(int[] ar, int low, int high) {
        int pivot = ar[high]; // Chọn phần tử cuối cùng làm chốt
        int i = low; // Vị trí để swap
        
        for (int j = low; j < high; j++) {
            if (ar[j] <= pivot) {
                swap(ar, i, j);
                i++;
            }
        }
        // Đưa chốt về đúng vị trí
        swap(ar, i, high);
        return i;
    }

    static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        // Khởi tạo 5 test case
        int[][] testCases = {
            {4, 5, 3, 7, 2},          // Test case 1: Mảng ngẫu nhiên
            {1, 2, 3, 4, 5},          // Test case 2: Mảng đã sắp xếp
            {9, 7, 5, 3, 1},          // Test case 3: Mảng sắp xếp ngược
            {4, 2, 4, 5, 2, 4},       // Test case 4: Mảng có phần tử trùng lặp
            {-3, 5, -1, 0, 8}         // Test case 5: Mảng có số âm
        };

        // Chạy qua từng test case
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("=== Test case " + (i + 1) + " ===");
            
            int[] ar = testCases[i].clone(); 
            
            System.out.print("Mảng ban đầu: ");
            printArray(ar);
            
            System.out.println("Quá trình sắp xếp:");
            quickSort(ar, 0, ar.length - 1);
            System.out.println();
        }
    }
}