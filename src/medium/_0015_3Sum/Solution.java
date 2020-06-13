package medium._0015_3Sum;

import java.util.*;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Set<List<Integer>> tempResult = new HashSet<>();
        Map<Integer, List<Integer[][]>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(nums[j])) {
                    List<Integer[][]> list = map.get(nums[j]);

                    for (int k = 0; k < list.size(); k++) {
                        Integer[][] pairs = list.get(k);

                        if (j != pairs[0][1] && j != pairs[1][1]) {
                            Integer[] arrResult = new Integer[] {
                                nums[j], pairs[0][0], pairs[1][0]
                            };
                            Arrays.sort(arrResult);
                            tempResult.add(Arrays.asList(arrResult));

                            list.remove(k);
                        }
                    }

                    if (list.size() == 0) {
                        map.remove(nums[j]);
                    }
                } // else {
                    int complement = 0 - nums[i] - nums[j];
                    Integer[][] pairs = {{nums[i], i}, {nums[j], j}};

                    if (map.containsKey(complement)) {
                        map.get(complement).add(pairs);
                    } else {
                        List<Integer[][]> list = new ArrayList<>();
                        list.add(pairs);
                        map.put(complement, list);
                    }
                // }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.addAll(tempResult);

        return result;
    }
}
