package week2AlgorithmAnalysis;

public class ThreeSumFaster {
    // đếm 3 số có tổng bằng target bằng 1 vòng lặp cố định 1 số và 2 con trỏ left và right
    public int threeSum(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    count++;
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
        return count;
    }

        public static void main(String[] args) {
        TwoSumFaster tsf = new TwoSumFaster();
        int[] nums = {1, 2, 3, 4, 5};
        int target = 9;
        System.out.println(tsf.twoSum(nums, target)); // Output: 1

        ThreeSumFaster tsf3 = new ThreeSumFaster();
        int[] nums3 = {1, 2, 3, 4, 5};
        int target3 = 9;
        System.out.println(tsf3.threeSum(nums3, target3)); // Output: 2
    }
}

class TwoSumFaster {
    // đếm 2 số có tổng bằng target bằng 2 con trỏ left và right
    public int twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                count++;
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
        return count;
    }
}
