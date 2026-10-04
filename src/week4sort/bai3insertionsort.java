package week4sort;

import java.util.*;

/**
 * Lớp InsertionSortOne mô phỏng cơ chế dịch chuyển (shift) và chèn (insert)
 * của thuật toán Insertion Sort, kèm bộ sinh dữ liệu kiểm thử tự động (Test Generator).
 */
public class bai3insertionsort {

    /**
     * Thực hiện chèn phần tử cuối cùng vào danh sách đã sắp xếp cục bộ.
     * In ra mảng sau mỗi lần dịch chuyển hoặc chèn.
     *
     * @param n   Kích thước danh sách
     * @param arr Danh sách n phần tử, trong đó n-1 phần tử đầu đã có thứ tự tăng dần
     */
    public static void insertionSort1(int n, List<Integer> arr) {
        int target = arr.get(n - 1);
        int i = n - 2;

        // Dịch chuyển các phần tử lớn hơn target sang phải
        while (i >= 0 && arr.get(i) > target) {
            arr.set(i + 1, arr.get(i));
            printList(arr);
            i--;
        }

        // Chèn target vào vị trí hợp lệ
        arr.set(i + 1, target);
        printList(arr);
    }

    /**
     * Xuất danh sách ra stdout theo định dạng các số cách nhau bởi dấu cách.
     */
    private static void printList(List<Integer> arr) {
        for (int j = 0; j < arr.size(); j++) {
            System.out.print(arr.get(j) + (j == arr.size() - 1 ? "" : " "));
        }
        System.out.println();
    }

    /**
     * Sinh tự động mảng test hợp lệ cho bài toán:
     * - (n - 1) phần tử đầu tiên được sinh ngẫu nhiên và sắp xếp tăng dần.
     * - Phần tử cuối cùng là một giá trị bất kỳ trong khoảng [minVal, maxVal].
     */
    public static List<Integer> generateTestCase(int n, int minVal, int maxVal) {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();

        // 1. Sinh (n - 1) phần tử ngẫu nhiên
        for (int i = 0; i < n - 1; i++) {
            list.add(rand.nextInt(maxVal - minVal + 1) + minVal);
        }

        // Sắp xếp (n - 1) phần tử đầu tiên
        Collections.sort(list);

        // 2. Thêm phần tử cuối cùng (target chưa sắp xếp)
        list.add(rand.nextInt(maxVal - minVal + 1) + minVal);

        return list;
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("BỘ TEST 1: Sample Test Case (Từ đề bài)");
        System.out.println("==========================================");
        List<Integer> test1 = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 3));
        System.out.println("Đầu vào: " + test1);
        System.out.println("Quá trình dịch chuyển và chèn:");
        insertionSort1(test1.size(), test1);

        System.out.println("\n==========================================");
        System.out.println("BỘ TEST 2: Trường hợp xấu nhất (Target nhỏ nhất - chèn về index 0)");
        System.out.println("==========================================");
        List<Integer> test2 = new ArrayList<>(Arrays.asList(3, 5, 7, 9, 1));
        System.out.println("Đầu vào: " + test2);
        System.out.println("Quá trình dịch chuyển và chèn:");
        insertionSort1(test2.size(), test2);

        System.out.println("\n==========================================");
        System.out.println("BỘ TEST 3: Trường hợp tốt nhất (Target lớn nhất - giữ nguyên vị trí)");
        System.out.println("==========================================");
        List<Integer> test3 = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        System.out.println("Đầu vào: " + test3);
        System.out.println("Quá trình dịch chuyển và chèn:");
        insertionSort1(test3.size(), test3);

        System.out.println("\n==========================================");
        System.out.println("BỘ TEST 4: Sinh ngẫu nhiên tự động (N = 6, giá trị từ 10 đến 99)");
        System.out.println("==========================================");
        List<Integer> randomTest = generateTestCase(6, 10, 99);
        System.out.println("Đầu vào ngẫu nhiên: " + randomTest);
        System.out.println("Quá trình dịch chuyển và chèn:");
        insertionSort1(randomTest.size(), randomTest);
    }
}