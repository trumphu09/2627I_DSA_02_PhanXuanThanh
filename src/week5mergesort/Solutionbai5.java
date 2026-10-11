package week5mergesort;
import java.util.ArrayList;
import java.util.Scanner;

public class Solutionbai5 {

    static void partition(int[] ar) {
        int pivot = ar[0];
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        
        equal.add(pivot);

        // Phân loại các phần tử
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] < pivot) {
                left.add(ar[i]);
            } else if (ar[i] > pivot) {
                right.add(ar[i]);
            } else {
                equal.add(ar[i]);
            }
        }

        // Gộp lại vào mảng ban đầu
        int index = 0;
        for (int num : left) ar[index++] = num;
        for (int num : equal) ar[index++] = num;
        for (int num : right) ar[index++] = num;

        // In kết quả sau khi phân chia
        printArray(ar);
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
            
            // Clone mảng để không làm thay đổi dữ liệu gốc của test case
            int[] ar = testCases[i].clone(); 
            
            System.out.print("Mảng ban đầu: ");
            printArray(ar);
            
            System.out.print("Kết quả Partition: ");
            partition(ar);
            System.out.println();
        }
    }
}