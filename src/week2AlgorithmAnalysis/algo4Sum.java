package week2AlgorithmAnalysis;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class algo4Sum {
    //*thuật toán cho bài tổng 4 số
    //  chạy 2 vòng lặp phía ngoài để cố định 2 số đầu tiên 
    // sau đó 1 vòng lặp trong để tìm 2 số còn lại bằng 2 con trỏ left và right 
    // bỏ qua các trường hợp trùng lặp và xét các điều kiện không thỏa để thoát vòng lặp sớm*/\
    public int fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicates
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++; // skip duplicates
                        while (left < right && nums[right] == nums[right - 1]) right--; // skip duplicates
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res.size();
    }
    public static void main(String[] args) {
        algo4Sum solution = new algo4Sum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(solution.fourSum(nums, target)); // Output: 3
    }

}
