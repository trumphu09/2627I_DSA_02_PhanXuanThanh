package week2AlgorithmAnalysis;

import java.util.Arrays;

public class ClosestPair {
    //*Closest pair. 
    // Viết một chương trình nhận input là một mảng a[] gồm N giá trị double, 
    // tìm một cặp gần nhất (closest pair) - là hai giá trị có hiệu không vượt quá hiệu của cặp số bất kì khác trong mảng. 
    // Hiệu ở đây tính bằng giá trị tuyệt đối. Thuật toán cần có thời gian chạy NlogN trong trường hợp tồi nhất. */

    //*Sắp xếp mảng rồi duyệt các phần tử cạnh nhau */
    public double closestPair(double[] a) {
        if (a == null || a.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }
        
        // Bước 1: Sắp xếp mảng -> Độ phức tạp O(N log N)
        Arrays.sort(a);
        
        // Bước 2: Duyệt các phần tử cạnh nhau để tìm hiệu nhỏ nhất -> Độ phức tạp O(N)
        double minDiff = Math.abs(a[1] - a[0]);
        for (int i = 2; i < a.length; i++) {
            double currentDiff = Math.abs(a[i] - a[i - 1]);
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
            }
        }
        
        return minDiff;
    }

    public static void main(String[] args) {
        ClosestPair cp = new ClosestPair();
        double[] a = {1.0, 3.5, 2.1, 4.8, 2.9};
        System.out.println(cp.closestPair(a));
    }
}
