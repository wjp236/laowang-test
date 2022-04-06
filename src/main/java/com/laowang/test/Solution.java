package com.laowang.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public boolean isPalindrome(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        //1. filter out number & char;
        //2. reverse and compare
        String filtersS = s.replaceAll("[^A-Za-z0-9]", "");
        String reverseS = new StringBuilder(filtersS).reverse().toString();

        return reverseS.equalsIgnoreCase(filtersS);
    }

    public void moveZeroes(int[] nums) {
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }

    public int maxArea(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int heigth = Math.min(nums[i], nums[j]);
                int longth = j - i;
                int area = heigth * longth;
                max = Math.max(area, max);
            }
        }
        return max;
    }

    public int maxArea1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int max = 0;
        for (int i = 0, j = nums.length - 1; i < j;) {
            int longth = j - i;
            int height = Math.min(nums[i], nums[j]);
            int area = longth * height;
            max = Math.max(area, max);
            if (nums[i] < nums[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        int f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right &&  nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {git
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
        }
        return res;
    }

    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode next = curNode.next;

            curNode.next = preNode;
            preNode = curNode;

            curNode = next;


        }
        return preNode;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();



//
//        for (int t : solution.twoSum(new int[]{2, 7, 11, 15},9))  {
//            System.out.println(t);
//        }

////移动回文串
//        String s = "A man, a plan, a canal: Panama";
//        System.out.println(solution.isPalindrome(s));
//        String s1 = "race a car";
//        System.out.println(solution.isPalindrome(s1));

////移动0
//        int[] nums = {0,1,0,3,12};
//        solution.moveZeroes(nums);
//        for (int t : nums) {
//            System.out.println(t);
//        }

        ////最大容器
//        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        System.out.println(solution.maxArea1(nums));


//        System.out.println(solution.climbStairs(5));
    }
}
