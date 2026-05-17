class Solution {
    public static int alternatingSum(int[] nums) {
        int sum = 0;
        int n = nums.length;
        if(n==1){
            return nums[0];
        }

        for(int i = 0;i<n;){
            sum = sum + nums[i];
            if((i+1)<n){
                sum = sum - nums[i+1];
            }
            i=i+2;
        }

        return sum;
    }

}