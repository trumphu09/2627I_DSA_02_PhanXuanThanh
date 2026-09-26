package week2AlgorithmAnalysis;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
public class LocalMinimunofArray {
    public int localmin(ArrayList<Integer> arr){
        int mid = arr.size()/2;
        if( arr.get(mid) < arr.get(mid - 1) && arr.get(mid) < arr.get(mid + 1) ){
            return arr.get(mid);
        }else if(arr.get(mid) > arr.get(mid - 1)){
            return localmin(new ArrayList<>(arr.subList(0, mid)));
        }else if (arr.get(mid) > arr.get(mid + 1)){
            return localmin(new ArrayList<>(arr.subList(mid + 1, arr.size())));
        }else{
            return -1;
        }
    }
    public static void main(String[] args){ 
        
        LocalMinimunofArray lma = new LocalMinimunofArray();
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5));
        int localMin = lma.localmin(arr);
        if(localMin != -1){
            System.out.println("Local minimum is: " + localMin);
        }else{
            System.out.println("No local minimum found.");
        }
    }
}
