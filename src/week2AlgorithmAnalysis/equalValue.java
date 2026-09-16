package week2AlgorithmAnalysis;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
public class equalValue {
    // Tính tổ hợp chập r của n
    public int combi(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        }
        return combi(n - 1, r - 1) + combi(n - 1, r);
    }
    public int eVal(ArrayList<Integer> arr) {
        HashMap<Integer, Integer> countingNum = new HashMap<>();
        int res = 0;
        for(int i = 0; i <arr.size(); i++){
            if(countingNum.containsKey(arr.get(i))){
                countingNum.put(arr.get(i), countingNum.get(arr.get(i)) + 1);
            } else {
                countingNum.put(arr.get(i), 1);
            }
        }
        for (HashMap.Entry<Integer, Integer> entry : countingNum.entrySet()) {
            if(entry.getValue() > 1){
                //neu tan suat lon hon 1 thi tinh to hop cua chung
                int n = entry.getValue();
                res += combi(n, 2);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        equalValue ev = new equalValue();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(1);
        arr.add(2);
        arr.add(1);
        System.out.println(ev.eVal(arr)); // Output: 4
    }
}
