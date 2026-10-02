package week4sort;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

import java.util.Arrays;

public class h_index {

    public static int computeHIndex(int[] citations) {
        int[] sorted = citations.clone();
        Arrays.sort(sorted);
        int n = sorted.length;

        // Duyệt i ngược từ n về 1: lấy trường hợp đúng đầu tiên
        for (int i = n; i >= 1; i--) {
            if (sorted[n - i] >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] testInputs = {
            {3, 10, 3, 5, 7, 8},      // Test 1: Đề bài cho
            {1, 2, 3, 3, 3, 5, 9},    // Test 2: Ví dụ của bạn
            {0, 0, 0, 0},             // Test 3: Không có trích dẫn nào
            {100},                    // Test 4: 1 bài trích dẫn rất cao
            {0},                      // Test 5: 1 bài 0 trích dẫn
            {25, 8, 5, 3, 3},         // Test 6: Mảng giảm dần
            {1, 1, 1, 1, 1},          // Test 7: Mọi bài trích dẫn bằng 1
            {10, 10, 10, 10, 10},     // Test 8: Mọi bài trích dẫn đều >= N
            {0, 1, 3, 5, 6},          // Test 9: Case kinh điển trên LeetCode
            {4, 4, 0, 0}              // Test 10: 2 bài cao, 2 bài 0
        };

        int[] expectedOutputs = {4, 3, 0, 1, 0, 3, 1, 5, 3, 2};

        for (int i = 0; i < testInputs.length; i++) {
            int actual = computeHIndex(testInputs[i]);
            String status = (actual == expectedOutputs[i]) ? "PASSED" : "FAILED";
            System.out.printf("Test %02d: Input=%s | Output=%d | Expected=%d -> %s%n",
                    (i + 1),
                    Arrays.toString(testInputs[i]),
                    actual,
                    expectedOutputs[i],
                    status
            );
        }
    }
}