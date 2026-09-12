package week1;
import edu.princeton.cs.algs4.StdOut;
public class union_findbai1 {
    private int[] id; // Mảng lưu nhãn định danh của mỗi phần tử

    public union_findbai1(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i; // Ban đầu mỗi phần tử tự làm sếp của chính nó
        }
    }

    public int find(int p) {
        return id[p]; // Lấy trực tiếp nhãn trong O(1)
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        // Quét toàn bộ mảng: Đổi tất cả những đứa có nhãn pID thành qID
        for (int i = 0; i < id.length; i++) {
            if (id[i] == id[p]) {
                id[i] = id[q];
            }
        }
    }
    public static void main(String[] args) {
        union_findbai1 uf = new union_findbai1(10);
        uf.union(1, 2);
        uf.union(1, 3);
        StdOut.println(uf.connected(1, 3)); // true
        StdOut.println(uf.connected(2, 3)); // false
        StdOut.println(uf.find(2)); // 3 vì khi chạy 1 nối với 3 sau khi 1 nối với 2 theo thuật toán sai thì id 1 được đổi thành 3 nên quét đến vị trí 2 sẽ bỏ qua
    }

}
