package week4sort;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * Lớp Result triển khai toàn bộ thuật toán Insertion Sort (Part 2).
 * Thuật toán mở rộng nguyên lý từ Part 1 bằng cách lặp qua từng phần tử từ chỉ mục 1 đến n-1,
 * đưa phần tử hiện tại về đúng vị trí trong mảng con đã sắp xếp [0 .. i-1],
 * và in trạng thái toàn bộ mảng sau mỗi lần hoàn tất một vị trí i.
 */
class Result {

    /**
     * Sắp xếp danh sách bằng thuật toán Insertion Sort và in trạng thái sau mỗi vòng lặp i.
     * 
     * Bất biến vòng lặp (Loop Invariant):
     * Tại cuối mỗi lần lặp với chỉ số i, mảng con từ arr[0] đến arr[i] luôn được sắp xếp theo thứ tự tăng dần.
     * 
     * @param n   Kích thước danh sách
     * @param arr Danh sách các số nguyên cần sắp xếp
     * 
     * Độ phức tạp thời gian (Time Complexity): 
     *   - Tốt nhất (Best Case): O(N) khi mảng đã sắp xếp sẵn (mỗi bước chỉ tốn 1 phép so sánh).
     *   - Xấu nhất (Worst Case): O(N^2) khi mảng sắp xếp ngược chiều hoàn toàn.
     * Độ phức tạp không gian (Space Complexity): O(1) do thao tác trực tiếp tại chỗ (in-place).
     */
    public static void insertionSort2(int n, List<Integer> arr) {
        // Mảng có 1 phần tử (index 0) coi như đã được sắp xếp sẵn.
        // Duyệt từng phần tử từ index 1 đến n - 1 để chèn vào mảng con [0 .. i - 1].
        for (int i = 1; i < n; i++) {
            insertIntoSorted(arr, i);
            printList(arr); // In toàn bộ mảng sau khi chèn xong phần tử tại vị trí i
        }
    }

    /**
     * Thủ tục hỗ trợ (tái sử dụng từ logic bài Insertion Sort Part 1):
     * Đưa phần tử tại chỉ mục idx vào đúng vị trí trong đoạn đã sắp xếp arr[0 .. idx-1].
     * 
     * @param arr Danh sách dữ liệu
     * @param idx Chỉ mục của phần tử cần chèn
     */
    private static void insertIntoSorted(List<Integer> arr, int idx) {
        int target = arr.get(idx);
        int j = idx - 1;

        // Dịch chuyển các phần tử lớn hơn target sang phải một vị trí
        while (j >= 0 && arr.get(j) > target) {
            arr.set(j + 1, arr.get(j));
            j--;
        }

        // Đặt target vào vị trí hợp lệ đầu tiên tìm được
        arr.set(j + 1, target);
    }

    /**
     * Hàm tiện ích xuất toàn bộ danh sách ra luồng chuẩn (stdout).
     * Các số cách nhau bởi đúng một khoảng trắng và xuống dòng ở cuối.
     */
    public static void printList(List<Integer> arr) {
        for (int j = 0; j < arr.size(); j++) {
            System.out.print(arr.get(j) + (j == arr.size() - 1 ? "" : " "));
        }
        System.out.println();
    }
}

/**
 * Lớp Solution xử lý luồng I/O chuẩn từ HackerRank, đồng thời tích hợp sẵn 
 * bộ Test Harness tự động để kiểm thử độc lập ngoại tuyến.
 */
public class bai5insertionsort {

    /**
     * Sinh ca kiểm thử ngẫu nhiên có kích thước n trong đoạn [minVal, maxVal].
     */
    public static List<Integer> generateRandomTestCase(int n, int minVal, int maxVal) {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(rand.nextInt(maxVal - minVal + 1) + minVal);
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        // Kiểm tra nếu có dữ liệu truyền vào từ stdin (dùng khi nộp bài trên HackerRank)
        if (System.in.available() > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine().trim());
            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

            Result.insertionSort2(n, arr);
            bufferedReader.close();
            return;
        }

        // Chế độ Local: Chạy trực tiếp các ca kiểm thử biên (Edge Cases & Stress Test)
        System.out.println("==========================================");
        System.out.println("BỘ TEST 1: Mẫu HackerRank (n = 6)");
        System.out.println("==========================================");
        List<Integer> test1 = new ArrayList<>(Arrays.asList(1, 4, 3, 5, 6, 2));
        System.out.println("Đầu vào: " + test1);
        System.out.println("Quá trình sắp xếp:");
        Result.insertionSort2(test1.size(), test1);

        System.out.println("\n==========================================");
        System.out.println("BỘ TEST 2: Trường hợp xấu nhất (Mảng giảm dần O(N^2))");
        System.out.println("==========================================");
        List<Integer> test2 = new ArrayList<>(Arrays.asList(9, 7, 5, 3, 1));
        System.out.println("Đầu vào: " + test2);
        System.out.println("Quá trình sắp xếp:");
        Result.insertionSort2(test2.size(), test2);

        System.out.println("\n==========================================");
        System.out.println("BỘ TEST 3: Trường hợp tốt nhất (Mảng đã sắp xếp sẵn O(N))");
        System.out.println("==========================================");
        List<Integer> test3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Đầu vào: " + test3);
        System.out.println("Quá trình sắp xếp:");
        Result.insertionSort2(test3.size(), test3);

        System.out.println("\n==========================================");
        System.out.println("BỘ TEST 4: Sinh ngẫu nhiên tự động (n = 7, [10, 99])");
        System.out.println("==========================================");
        List<Integer> randomTest = generateRandomTestCase(7, 10, 99);
        System.out.println("Đầu vào: " + randomTest);
        System.out.println("Quá trình sắp xếp:");
        Result.insertionSort2(randomTest.size(), randomTest);
    }
}
