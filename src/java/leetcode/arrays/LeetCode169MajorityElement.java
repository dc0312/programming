package leetcode.arrays;

public class LeetCode169MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Result : " + majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int maj = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count==0){
                maj = nums[i];
                count++;
            }else if(maj != nums[i]){
                count--;
            }else if(maj == nums[i]) {
                count++;
            }
        }
        return maj;
    }
}
