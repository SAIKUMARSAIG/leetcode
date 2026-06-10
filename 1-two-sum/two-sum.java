import java.util.*;
class Solution {
    // public int[] twoSum(int[] nums, int target) {
    //     boolean flag=false;
    //     for(int i=0;i<nums.length;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             if((nums[i]+nums[j])==target){
    //                 return new int[]{i,j};
    //             }
    //         }
    //     }
    //     return nums;
    // }

    public static int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        int n = nums.length;
        if (n==1){
            return nums;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            int num = nums[i];
            int diff = target - num;
            if (map.containsKey(diff)){
                res[0] = map.get(diff);
                res[1] = i;
                return res;
            }
            map.put(num,i);
        }

        return nums;
    }

}