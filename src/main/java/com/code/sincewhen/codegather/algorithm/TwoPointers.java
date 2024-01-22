package com.code.sincewhen.codegather.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class TwoPointers {

    public static void main(String[] args) {
        TwoPointers twoPointers = new TwoPointers();

        //System.out.println(twoPointers.isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(twoPointers.isPalindrome("race a car"));

        //System.out.println(twoPointers.isSubsequence("ace","abcde"));

        //System.out.println(Arrays.toString(twoPointers.twoSum(new int[]{2,7,11,15},9)));

        //System.out.println(twoPointers.maxArea(new int[]{5,10,15,4,8}));

        System.out.println(twoPointers.threeSum(new int[]{0,0,0}));
        System.out.println(twoPointers.threeSum(new int[]{-1,0,1,2,-1,-4}));


    }

    /**
     * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
     *
     * 字母和数字都属于字母数字字符。
     *
     * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(rightChar)) {
                right --;
                continue;
            }
            if (Character.isLetterOrDigit(leftChar) && Character.isLetterOrDigit(rightChar)) {
                if (Character.toUpperCase(leftChar) != Character.toUpperCase(rightChar)) {
                    return false;
                }
            }
            left ++ ;
            right -- ;
        }
        return true;
    }

    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     *
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int i , j ;
        for (i = 0 , j = 0; i < s.length() && j < t.length(); ) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    /**
     * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。
     * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
     *
     * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
     *
     * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
            if (numbers[left] + numbers[right] == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (numbers[left] + numbers[right] > target) {
                right --;
            } else {
                left ++;
            }
        }
        return result;
    }

    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     *
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 返回容器可以储存的最大水量
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (area > max) {
                max = area;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     *
     * 你返回所有和为 0 且不重复的三元组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        Arrays.sort(nums);
        int cout=nums.length-2;
        int y=0;
        for (int i = 0; i < cout; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            y=i+1;
            for (int j = nums.length-1; j >y; ) {
                if (j<nums.length-1&&nums[j]==nums[j+1]){
                    j--;
                    continue;
                }
                if(nums[i]+nums[j]+nums[y]==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[y]);
                    lists.add(list);
                    j--;
                    y++;
                }
                if (nums[i]+nums[j]+nums[y]>0){
                    j--;
                }
                if (nums[i]+nums[j]+nums[y]<0){
                    y++;
                }
            }
        }
        return lists;
    }

}
