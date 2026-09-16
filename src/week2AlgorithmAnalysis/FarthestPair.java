package week2AlgorithmAnalysis;

public class FarthestPair {
    //*. Farthest pair. Viết một chương trình nhận input là một mảng a[] gồm N giá trị double, 
    // tìm một cặp xa nhất (Farthest pair) - là hai giá trị có hiệu không nhỏ hơn hiệu của cặp số bất kì khác trong mảng. 
    // Hiệu ở đây tính bằng giá trị tuyệt đối. 
    // Thuật toán cần có thời gian chạy tuyến tính trong trường hợp tồi nhất. */
    
    //* duyệt mảng và lấy 2 số đầu làm mốc 
    // nếu có số nào nhỏ hơn số bé thì thay 
    // số nào lớn hơn số lớn thì thay */
    public double farthestPair(double[] a) {
        if (a == null || a.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }
        
        double min = a[0];
        double max = a[0];
        
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            } else if (a[i] > max) {
                max = a[i];
            }
        }
        
        return Math.abs(max - min);
    }   
    public static void main(String[] args) {
        FarthestPair fp = new FarthestPair();
        double[] a = {1.0, 3.5, 2.1, 4.8, 2.9};
        System.out.println(fp.farthestPair(a)); // Output sẽ tìm ra cặp (1.0, 4.8) hoặc tương đương có hiệu lớn nhất
    }
}
