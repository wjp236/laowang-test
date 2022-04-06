package com.laowang.test;

public class TestSolution {
    public static void main(String[] args) {
        TestSolution solution = new TestSolution();

        int[] nums = {0,1,0,3,12};
        solution.moveZeroes1(nums);
        for (int t : nums) {
            System.out.println(t);
        }
    }

    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return ;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes1(int[] nums) {
        if (nums == null) {
            return ;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
              int temp = nums[i];
              nums[i] = nums[j];
              nums[j] = temp;
              j++;
            }
        }
    }

}
