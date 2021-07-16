package medium._0152_Maximum_Product_Subarray.round_2;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.maxProduct(new int[] {2,3,-2,4})); // 6
//        System.out.println(s.maxProduct(new int[] {-2,0,-1})); // 0
//        System.out.println(s.maxProduct(new int[] {1,-4,5,-2,-1})); // 40
//        System.out.println(s.maxProduct(new int[] {1,-4,5,2,-1,3,-4,2})); // 240
//        System.out.println(s.maxProduct(new int[] {-1,-1,0})); // 1
//        System.out.println(s.maxProduct(new int[] {0,-2,-3})); // 6
        System.out.println(s.maxProduct(new int[] {-1,-2,-9,-6})); // 108
    }

    /*  Dynamic Programming
        Time complexity: O(n)
        Space complexity: O(1)
     */
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int maxSoFar = 1;
        int minSoFar = 1;

        for (int num : nums) {
            int tempMax = maxSoFar;
            maxSoFar = Math.max(num, Math.max(num * maxSoFar, num * minSoFar));
            minSoFar = Math.min(num, Math.min(num * tempMax, num * minSoFar));

            if (maxSoFar > maxProduct) {
                maxProduct = maxSoFar;
            }
        }

        return maxProduct;
    }

//    /*  Two way traversal
//        Time complexity: O(n)
//        Space complexity: O(1)
//     */
//    public int maxProduct(int[] nums) {
//        int maxProduct = Integer.MIN_VALUE;
//        int product;
//
//        product = 1;
//        for (int num : nums) {
//            product *= num;
//            if (product > maxProduct) {
//                maxProduct = product;
//            }
//            if (num == 0) {
//                product = 1;
//            }
//        }
//
//        product = 1;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            product *= nums[i];
//            if (product > maxProduct) {
//                maxProduct = product;
//            }
//            if (nums[i] == 0) {
//                product = 1;
//            }
//        }
//
//        return maxProduct;
//    }

//    /*  Try with every subarray (only two nested loop is needed)
//        Time complexity: O(n^2)
//        Space complexity: O(1)
//     */
//    public int maxProduct(int[] nums) {
//        int maxProduct = Integer.MIN_VALUE;
//
//        for (int i = 0; i < nums.length; i++) {
//            int product = 1;
//
//            for (int j = i; j < nums.length; j++) {
//                product *= nums[j];
//                if (product > maxProduct) {
//                    maxProduct = product;
//                }
//            }
//        }
//
//        return maxProduct;
//    }

//    /*  Save partial work using a list
//        Time complexity: O(n^2)
//        Space complexity: O(n)
//     */
//    public int maxProduct(int[] nums) {
//        int maxProduct = Integer.MIN_VALUE;
//        for (int num : nums) {
//            if (num > maxProduct) {
//                maxProduct = num;
//            }
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            boolean addedNum = false;
//            if (i == 0 || nums[i - 1] <= 0) {
//                list.add(nums[i]);
//                addedNum = true;
//            }
//            if (nums[i] <= 0) {
//                for (int num : list) {
//                    if (num > maxProduct) {
//                        maxProduct = num;
//                    }
//                }
//            }
//            for (int j = 0; j < list.size() - (addedNum ? 1 : 0); j++) {
//                list.set(j, list.get(j) * nums[i]);
//            }
//        }
//        for (int num : list) {
//            if (num > maxProduct) {
//                maxProduct = num;
//            }
//        }
//        return maxProduct;
//    }

//    /*  Try with every subarray
//        Time complexity: O(n^3)
//        Space complexity: O(1)
//     */
//    public int maxProduct(int[] nums) {
//        int n = nums.length;
//        int len = 1;
//        int maxProduct = Integer.MIN_VALUE;
//
//        while (len <= n) {
//            for (int i = 0; i <= n - len; i++) {
//                int product = 1;
//                for (int j = i; j < i + len; j++) {
//                    product *= nums[j];
//                }
//                if (product > maxProduct) {
//                    maxProduct = product;
//                }
//            }
//            len++;
//        }
//
//        return maxProduct;
//    }
}
